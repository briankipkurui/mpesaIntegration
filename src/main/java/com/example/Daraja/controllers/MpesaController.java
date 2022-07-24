package com.example.Daraja.controllers;

import com.example.Daraja.dtos.AccessTokenResponse;
import com.example.Daraja.services.DarajaApi;
import com.example.Daraja.services.DarajaApiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
@AllArgsConstructor
public class MpesaController {
  private final DarajaApi darajaApi;

   @GetMapping(path ="/token", produces = "application/json")
   public ResponseEntity<AccessTokenResponse> getAccessToken(){
       return ResponseEntity.ok(darajaApi.getAccessToken());
  }


  @GetMapping(produces = "application/json")
  public  String getSampleMessage(){
       return "sample is working";
  }


}
