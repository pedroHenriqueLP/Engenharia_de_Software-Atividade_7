package classes;

import java.util.*;

public class Pessoa {

    public void requisitar_Vagas() {
        System.out.println("A vaga estava disponível e foi atribuida a ti."); // Por terminar.
    }

    public void atribuir_Veiculo(Scanner scanner) {
        System.out.println("Atribuindo veículo.");
        System.out.println("Por favor, insira as informações abaixo.");

        System.out.print("Placa: ");
        String placa = scanner.next();

        System.out.print("Cor: ");
        String cor = scanner.next();

        System.out.print("Marca: ");
        String marca = scanner.next();

        System.out.print("Modelo: ");
        String modelo = scanner.next();

        Veiculo novoVeiculo = new Veiculo(placa, cor, marca, modelo);
        this.adicionar_Veiculo(novoVeiculo);

        System.out.println("Veículo atribuído com sucesso: " + novoVeiculo.getPlaca());
    }

    private String nome;
    private String cpf;
    private int n_apartamento;
    private int qtd_veiculos;
    private String genero;

    private List<Veiculo> veiculos;

    public Pessoa(String nome, String cpf, int n_apartamento, int qtd_veiculos, String genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.n_apartamento = n_apartamento;
        this.qtd_veiculos = qtd_veiculos;
        this.genero = genero;
        this.veiculos = new ArrayList<>();
    }

    public void adicionar_Veiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getN_apartamento() {
        return n_apartamento;
    }

    public void setN_apartamento(int n_apartamento) {
        this.n_apartamento = n_apartamento;
    }

    public int getQtd_veiculos() {
        return qtd_veiculos;
    }

    public void setQtd_veiculos(int qtd_veiculos) {
        this.qtd_veiculos = qtd_veiculos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}