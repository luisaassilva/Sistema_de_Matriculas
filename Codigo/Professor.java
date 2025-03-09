package Codigo;

import java.util.List;

public class Professor {
    private String nome;
    private String senha;
    private List<Disciplina> disciplinas;

    public Professor(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void listarAlunosDisciplina(Disciplina disciplina) {
        System.out.println("Alunos matriculados em " + disciplina.getNome() + ":");
        for (Aluno aluno : disciplina.getAlunosMatriculados()) {
            System.out.println(aluno.getNome());
        }
    }
    
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
