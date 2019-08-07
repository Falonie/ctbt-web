package com.ctbt.ctbtweb.common;//package com.ctbt.ctbtweb.util;

public class PasswordTest {
    public static void main(String[] args) {
        PasswordEncoderUtil myPasswordEncoder = new PasswordEncoderUtil();
        String encodePassword = myPasswordEncoder.encode("falonie");
        System.out.println("***********" + encodePassword + "***********");
        String encodePassword2 = myPasswordEncoder.encode("falonie");
        System.out.println("***********" + encodePassword2 + "***********");
        System.out.println(encodePassword.length());
        System.out.println(encodePassword.matches("faloniee"));
        System.out.println(myPasswordEncoder.matches("falonie", encodePassword));
    }
}
