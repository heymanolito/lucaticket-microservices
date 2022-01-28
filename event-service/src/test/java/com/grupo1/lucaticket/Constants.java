package com.grupo1.lucaticket;

public class Constants {

    public static String BASE_URL = "http://localhost:8091";
    public static String EVENTS_ENDPOINT = "/events";
    public static String ID_EVENTS_ENDPOINT = EVENTS_ENDPOINT + "/{id}";
    public static String EVENTS_ADD_ENDPOINT = EVENTS_ENDPOINT + "/add";
    public static String EVENTS_BY_GENERO= EVENTS_ENDPOINT + "{genero}";
    public static String EVENTS_BY_NOMBRE= EVENTS_ENDPOINT + "{nombre}";
}
