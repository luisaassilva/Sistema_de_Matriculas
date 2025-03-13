package Codigo;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String id;
    private int valor;
    private Professor professor;
    private List<Aluno> alunosMatriculados;
    private static final int MIN_ALUNOS = 3;
    private static final int MAX_ALUNOS = 60;


    public Disciplina(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
        this.alunosMatriculados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public boolean matricularAluno(Aluno aluno) {
        if (alunosMatriculados.size() < MAX_ALUNOS) {
            alunosMatriculados.add(aluno);
            return true;
        }
        return false;
    }

    public void cancelarMatricula(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }

    public boolean isAtiva() {
        return alunosMatriculados.size() >= MIN_ALUNOS;
    }

    public int getValor() {
        return valor;
    }

    public void adicionarAluno(Aluno aluno) {
        if (alunosMatriculados.size() < 60) {
            alunosMatriculados.add(aluno);
        }
    }

    public void removerAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }
}
