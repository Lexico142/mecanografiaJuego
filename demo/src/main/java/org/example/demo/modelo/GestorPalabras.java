package org.example.demo.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GestorPalabras {
    public static String obtenerPalabraAleatoria() {
        String palabra = "teclado";
        try {
            URL url = new URL("https://random-word-api.herokuapp.com/word?number=1&lang=es");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String respuesta = br.readLine();
            br.close();

            if (respuesta != null) {
                palabra = respuesta.replace("[", "").replace("]", "").replace("\"", "");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión. Usando palabra por defecto.");
        }
        return palabra;
    }
}