package com.example.Daraja.services;

import com.example.Daraja.config.MpesaConfiguration;
import com.example.Daraja.dtos.AccessTokenResponse;
import com.example.Daraja.utils.HelperUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Request;
import org.apache.coyote.Response;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Service;

import javax.security.auth.message.callback.PrivateKeyCallback;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.Daraja.utils.Constants.*;


@AllArgsConstructor
@Service
public class DarajaApiImpl implements DarajaApi{

    private final MpesaConfiguration mpesaConfiguration;
    private final HttpClient httpClient;
    private  final ObjectMapper objectMapper;


    @Override
    public AccessTokenResponse getAccessToken() {
        String encodeCredentials = HelperUtility.toBase64String(String.format("%s:%s",mpesaConfiguration.getConsumerKey(),
                mpesaConfiguration.getConsumerSecret()));

        try {
            HttpRequest httpRequest =  HttpRequest.newBuilder()
                    .uri(new URI("%s?grant_type=%s",mpesaConfiguration.getOauthEndpoint(),mpesaConfiguration.getGrantType()))
                    .GET()
                    .header(AUTHORIZATION_HEADER_STRING,String.format("%s %s", BASIC_AUTH_STRING,encodeCredentials))
                    .header(CACHE_CONTROL_HEADER,CACHE_CONTROL_HEADER_VALUE)
                    .build();


              HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

              if (httpResponse.statusCode() == 200){
                  return objectMapper.readValue(
                          httpResponse.body(),
                          AccessTokenResponse.class
                  );
              }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
