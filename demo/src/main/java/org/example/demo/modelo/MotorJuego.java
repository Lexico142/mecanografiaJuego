package org.example.demo.modelo;

public class MotorJuego {
    private String palabraActual;
    private double tiempoInicio;

    public void iniciarNuevaPalabra(String palabra) {
        this.palabraActual = palabra;
        this.tiempoInicio = System.currentTimeMillis();
    }

    public boolean comprobarPalabra(String palabraEscrita) {
        return palabraActual.equalsIgnoreCase(palabraEscrita.trim());
    }

    public double calcularTiempoMinutos() {
        double tiempoFin = System.currentTimeMillis();
        double diferenciaMilisegundos = tiempoFin - tiempoInicio - 500;
        return diferenciaMilisegundos / 60000.0;
    }
}