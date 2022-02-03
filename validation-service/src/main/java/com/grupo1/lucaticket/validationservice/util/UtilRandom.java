package com.grupo1.lucaticket.validationservice.util;

public class UtilRandom {

    public static String validarCompra() {
        int aleatorio = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
        return switch (aleatorio) {
            case 1, 2, 3, 4, 5, 6, 7 -> "La transaccion se ha realizado satisfactoriamente";
            case 8, 9, 10 -> "";
            default -> null;
        };
    }
    //Error: Saldo insuficiente en su cuenta
    //Error: La fecha de caducidad es incorrecta (dd/mm/aa )
    //Error: El numero de cuenta introducido no es valido
    public static String validarCompraAux(int n) {
       
        return switch (n) {
            case 1, 2, 3, 4, 5, 6, 7 -> "La transaccion se ha realizado satisfactoriamente";
            case 8-> "Error: Saldo insuficiente en su cuenta";
            case 9-> "Error: La fecha de caducidad es incorrecta (dd/mm/aa)";
            case 10-> "Error: El numero de cuenta introducido no es valido";
            default -> null;
        };
    }

}
