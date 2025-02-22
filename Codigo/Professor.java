package Codigo;

import java.util.List;

public class Professor {
    private String nome;
    private String senha;

    public Professor(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public void listarAluno(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            for (Disciplina disciplina : aluno.getDisciplinas()) {
                if (disciplina.getProfessor() != null && disciplina.getProfessor().getNome().equals(this.nome)) {
                    System.out.println(aluno.getNome());
                    break;
                }
            }
        }
    }

    public String getNome() {
        return nome;
    }
}
