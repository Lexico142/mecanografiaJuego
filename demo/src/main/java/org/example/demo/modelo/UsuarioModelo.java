package org.example.demo.modelo;

public class UsuarioModelo {
    private int numeroAciertos = 0;
    private int numeroFallos = 0;
    private int caracteresTotalesCorrectos = 0;
    private double tiempoTotalMinutos = 0.0;

    public void registrarIntento(boolean acierto, int longitudPalabra, double tiempoMinutos) {
        if (acierto) {
            this.numeroAciertos++;
            this.caracteresTotalesCorrectos += longitudPalabra;
        } else {
            this.numeroFallos++;
        }
        this.tiempoTotalMinutos += tiempoMinutos;
    }

    public int getNumeroAciertos() { return numeroAciertos; }

    public int getNumeroFallos() { return numeroFallos; }

    public double getWpmMedio() {
        if (tiempoTotalMinutos == 0) return 0;
        double wpmReal = (caracteresTotalesCorrectos / 5.0) / tiempoTotalMinutos;
        return Math.round(wpmReal * 100.0) / 100.0;
    }
}