package Codigo;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String senha;
    private int mensalidade;
    private List<Disciplina> disciplinas;
    private static final int MAX_OBRIGATORIAS = 4;
    private static final int MAX_OPTATIVAS = 2;
    private List<Disciplina> disciplinasMatriculadas;

    public Aluno(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.disciplinas = new ArrayList<>();
        this.disciplinasMatriculadas = new ArrayList<>();
    }

    public boolean cadastrarDisciplina(Disciplina disciplina, boolean obrigatoria) {
        long obrigatoriasCount = disciplinas.stream().filter(d -> d instanceof Disciplina).count();
        if (obrigatoria && obrigatoriasCount >= MAX_OBRIGATORIAS) {
            return false;
        }
        if (!obrigatoria && (disciplinas.size() - obrigatoriasCount) >= MAX_OPTATIVAS) {
            return false;
        }
        disciplinas.add(disciplina);
        return true;
    }

    public void cancelarDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void matricularEmDisciplina(Disciplina disciplina) {
        if (disciplinasMatriculadas.size() < 6) {
            disciplinasMatriculadas.add(disciplina);
        }
    }

    public String getNome() {
        return nome;
    }
    
    public void setMensalidade(int valor) {
        this.mensalidade = valor;
    }
    
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    
}
