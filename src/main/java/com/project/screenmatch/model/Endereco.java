package com.project.screenmatch.model;

import org.springframework.beans.factory.annotation.Value;

public class Endereco {
    @Value("${API_ENDPOINT}")
    private static String ENDERECOBASE;

    private String pesquisaDoUsuario;
    @Value("${API_KEY}")
    private static String APIKEY;
    @Value("TEMPORADA")
    private String TEMPORADAENDPOINT;



    public static String montaEndereco(String pesquisaDoUsuario) {
        return ENDERECOBASE + pesquisaDoUsuario.replace(" " , "+").toLowerCase() + APIKEY;
    }
}
