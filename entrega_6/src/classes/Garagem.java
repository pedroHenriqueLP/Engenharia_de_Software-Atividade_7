package classes;

public class Garagem {
    private boolean estado;
    private int qtd_vagas;
    private int qtd_vagas_ocupadas;

    public Garagem(boolean estado, int qtd_vagas, int qtd_vagas_ocupadas) {
        this.estado = estado;
        this.qtd_vagas = qtd_vagas;
        this.qtd_vagas_ocupadas = qtd_vagas_ocupadas;
    }

    public void interagir_Portao() {
        if (this.estado) {
            System.out.println("O portão foi fechado.\n");
            this.estado = false;
        } else {
            System.out.println("O portão foi aberto.\n");
            this.estado = true;
        }
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getQtd_vagas() {
        return qtd_vagas;
    }

    public void setQtd_vagas(int qtd_vagas) {
        this.qtd_vagas = qtd_vagas;
    }

    public int getQtd_vagas_ocupadas() {
        return qtd_vagas_ocupadas;
    }

    public void setQtd_vagas_ocupadas(int qtd_vagas_ocupadas) {
        this.qtd_vagas_ocupadas = qtd_vagas_ocupadas;
    }
}