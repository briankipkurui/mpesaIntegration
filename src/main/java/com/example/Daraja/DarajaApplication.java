package com.example.Daraja;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@SpringBootApplication
public class DarajaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DarajaApplication.class, args);

	}

	@Bean
	public HttpClient getHttpClient(){
		return HttpClient.newBuilder().build();
	}
	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}



}
