package org.example.demo.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.example.demo.modelo.GestorPalabras;
import org.example.demo.modelo.MotorJuego;
import org.example.demo.modelo.UsuarioModelo;

public class ControladorJuego {

    @FXML private Label labelPalabra;
    @FXML private TextField inputTexto;
    @FXML private Label labelEstadisticas;

    private MotorJuego motor;
    private UsuarioModelo usuario;

    @FXML
    public void initialize() {
        motor = new MotorJuego();
        usuario = new UsuarioModelo();

        cargarNuevaPalabra();

        inputTexto.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                procesarIntento();
            }
        });
    }

    private void cargarNuevaPalabra() {
        String nuevaPalabra = GestorPalabras.obtenerPalabraAleatoria();
        labelPalabra.setText(nuevaPalabra);
        motor.iniciarNuevaPalabra(nuevaPalabra);
    }

    private void procesarIntento() {
        String textoEscrito = inputTexto.getText();

        boolean acierto = motor.comprobarPalabra(textoEscrito);
        double tiempoMinutos = motor.calcularTiempoMinutos();

        int longitud = labelPalabra.getText().length();
        usuario.registrarIntento(acierto, longitud, tiempoMinutos);

        actualizarEstadisticas();
        inputTexto.clear();
        cargarNuevaPalabra();
    }

    private void actualizarEstadisticas() {
        String textoStats = "Aciertos: " + usuario.getNumeroAciertos() +   "|  Fallos: "  + usuario.getNumeroFallos() + "  |  WPM Medio: " + usuario.getWpmMedio();
        labelEstadisticas.setText(textoStats);
    }
}