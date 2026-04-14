package com.tuconjuntoapp.framework.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public final class PasswordEncoderUtil {

    private PasswordEncoderUtil() {
    }

    public static String encode(String rawPassword) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(rawPassword.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException exception) {
            throw new IllegalStateException("No fue posible procesar la contrasena.", exception);
        }
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

    public static boolean looksEncoded(String passwordValue) {
        return passwordValue != null
                && passwordValue.length() == 44
                && passwordValue.matches("^[A-Za-z0-9+/=]+$");
    }
}
