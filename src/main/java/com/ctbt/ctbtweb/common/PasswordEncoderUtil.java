package com.ctbt.ctbtweb.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

public class PasswordEncoderUtil implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodePassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, encodePassword);
    }
}
