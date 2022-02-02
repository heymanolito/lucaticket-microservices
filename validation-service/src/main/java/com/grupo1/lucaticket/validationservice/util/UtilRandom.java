package com.grupo1.lucaticket.validationservice.util;

public class UtilRandom {

    public static String validarCompra() {
        int aleatorio = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
        return switch (aleatorio) {
            case 1, 2, 3, 4, 5, 6, 7 -> "OK";
            case 8, 9, 10 -> "K.O. (malito)";
            default -> null;
        };
    }
}
