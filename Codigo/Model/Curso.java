package Codigo.Model;

public class Curso {
    private String nome;
    private Integer credito;

    public Curso(String nome, Integer credito) {
        this.nome = nome;
        this.credito = credito;
    }

    public String getNome() {
        return nome;
    }
}
