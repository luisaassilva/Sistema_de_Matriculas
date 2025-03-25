package Codigo.Model;

import java.util.ArrayList;
import java.util.List;

public class Secretaria {
    private String nome;
    private String senha;
    private List<Disciplina> disciplinas;

    public Secretaria(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.disciplinas = new ArrayList<>();
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

    public void verificarDisciplinasAtivas() {
        for (Disciplina disciplina : disciplinas) {
            if (!disciplina.isAtiva()) {
                System.out.println("Disciplina " + disciplina.getNome() + " cancelada por falta de alunos.");
            }
        }
    }
    
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
