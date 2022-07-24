package com.example.Daraja.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HelperUtility {

    public  static String toBase64String(String value){
        byte[] data = value.getBytes(StandardCharsets.UTF_8);
        return Base64.getEncoder().encodeToString(data);
    }
}
