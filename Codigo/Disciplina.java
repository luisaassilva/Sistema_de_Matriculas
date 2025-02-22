package Codigo;

public class Disciplina {
    private String nome;
    private String id;
    private Integer valor;
    private Professor professor;

    public Disciplina(String nome, String id, Integer valor) {
        this.nome = nome;
        this.id = id;
        this.valor = valor;
    }
    public Integer getValor() {
        return valor;
    }
    public void cadastrarProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }
}
