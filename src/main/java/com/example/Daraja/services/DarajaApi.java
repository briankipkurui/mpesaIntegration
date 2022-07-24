package com.example.Daraja.services;

import com.example.Daraja.dtos.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public interface DarajaApi {
//    return daraja api access token

    AccessTokenResponse getAccessToken();
}
