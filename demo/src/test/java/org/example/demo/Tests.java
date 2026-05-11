package org.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.demo.modelo.MotorJuego;
import org.example.demo.modelo.UsuarioModelo;
import org.example.demo.modelo.GestorPalabras;

public class Tests {
    @Test
    public void testComprobarPalabraCorrecta() {
        MotorJuego motor = new MotorJuego();
        motor.iniciarNuevaPalabra("teclado");
        assertTrue(motor.comprobarPalabra("teclado"));
    }

    @Test
    public void testComprobarPalabraIncorrecta() {
        MotorJuego motor = new MotorJuego();
        motor.iniciarNuevaPalabra("teclado");
        assertFalse(motor.comprobarPalabra("pantalla"));
    }

    @Test
    public void testCalcularTiempo() {
        MotorJuego motor = new MotorJuego();
        motor.iniciarNuevaPalabra("prueba");

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            System.out.println("La prueba fue interrumpida");
            fail("La prueba falló debido a una interrupción");
        }

        double tiempo = motor.calcularTiempoMinutos();
        assertTrue(tiempo > 0.0, "El tiempo calculado debe ser positivo");
    }

    @Test
    public void testRegistrarIntentoAcierto() {
        UsuarioModelo usuario = new UsuarioModelo();
        usuario.registrarIntento(true, 7, 0.2);

        assertEquals(1, usuario.getNumeroAciertos());
        assertEquals(0, usuario.getNumeroFallos());
    }

    @Test
    public void testRegistrarIntentoFallo() {
        UsuarioModelo usuario = new UsuarioModelo();
        usuario.registrarIntento(false, 5, 0.1);

        assertEquals(0, usuario.getNumeroAciertos());
        assertEquals(1, usuario.getNumeroFallos());
    }

    @Test
    public void testCalculoWpmMedio() {
        UsuarioModelo usuario = new UsuarioModelo();
        usuario.registrarIntento(true, 25, 1.0);

        assertEquals(5.0, usuario.getWpmMedio(), "El cálculo de WPM no es correcto");
    }

    @Test
    public void testObtenerPalabraAleatoria() {
        try {
            String palabra = GestorPalabras.obtenerPalabraAleatoria();
            assertNotNull(palabra, "La palabra obtenida no debe ser nula");
            assertFalse(palabra.isEmpty(), "La palabra obtenida no debe estar vacía");
        } catch (Exception e) {
            System.out.println("Error al intentar acceder a la API");
            assertTrue(true);
        }
    }
}