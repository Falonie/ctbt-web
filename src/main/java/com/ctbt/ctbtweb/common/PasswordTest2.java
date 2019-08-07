package com.ctbt.ctbtweb.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest2 {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassowrd = bCryptPasswordEncoder.encode("falonie");
        System.out.println("**********" + encodePassowrd + "*********");
        String encodePassowrd2 = bCryptPasswordEncoder.encode("falonie");
        System.out.println("**********" + encodePassowrd2 + "*********");
//        System.out.println(encodePassowrd.matches("falonie"));
//        System.out.println(encodePassowrd.matches("falonie2"));
        System.out.println(bCryptPasswordEncoder.matches("falonie", encodePassowrd));
    }
}
