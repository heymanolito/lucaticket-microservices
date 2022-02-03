package com.grupo1.lucaticket.util;

public class UsernameGeneratorUtil {

    public static String generateUsername(String email) {
        StringBuilder username = new StringBuilder();
        for ( int i = 0; i < email.length(); i++ ) {
            if ( email.charAt(i) == '@' ) {
                break;
            } else {
                username.append(email.charAt(i));
            }
        }
        return username.toString();
    }
}
