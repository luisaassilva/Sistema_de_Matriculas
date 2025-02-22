package Codigo;

import java.util.List;

public class Secretaria {
    private String nome;
    private String senha;

    public Secretaria(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

      public void listarCursos(List<Curso> cursos) {
        System.out.println("Cursos:");
        for (Curso curso : cursos) {
            System.out.println(curso.getNome());
        }
    }

    public void listarProfessores(List<Professor> professores) {
        System.out.println("Professores:");
        for (Professor professor : professores) {
            System.out.println(professor.getNome());
        }
    }

    public void listarAlunos(List<Aluno> alunos) {
        System.out.println("Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }
}
