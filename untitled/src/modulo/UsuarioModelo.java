package modulo;

public class UsuarioModelo {
    private String nombre;
    private int numeroAciertos;
    private float wpmMedio;

    public UsuarioModelo(int numeroAciertos, float wpmMedio, int numeroFallos, String nombre) {
        this.numeroAciertos = numeroAciertos;
        this.wpmMedio = wpmMedio;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setWpmMedio(float wpmMedio) {
        this.wpmMedio = wpmMedio;
    }

    public void setNumeroAciertos(int numeroAciertos) {
        this.numeroAciertos = numeroAciertos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroAciertos() {
        return numeroAciertos;
    }

    public float getWpmMedio() {
        return wpmMedio;
    }
}
