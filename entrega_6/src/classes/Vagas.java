package classes;

public class Vagas {
    private int numero;
    private boolean estado;

    public Vagas(int numero, boolean estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}