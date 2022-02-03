package com.grupo1.lucaticket.util;

public class PrecioUtil {

    public static Integer getPrecioRandom(Integer[] precio) {
        return (int) ((Math.random() * (precio[1] - precio[0])) + precio[0]);
    }
}
