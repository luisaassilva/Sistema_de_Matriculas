package Codigo;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAlunoDAO implements AlunoDAO {
    private List<Aluno> alunos = new ArrayList<>();

    @Override
    public Aluno getAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    @Override
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public void updateAluno(Aluno aluno) {
        // Implementation for updating an existing aluno
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNome().equalsIgnoreCase(aluno.getNome())) {
                alunos.set(i, aluno); // Replace with the updated aluno
                return;
            }
        }
    }

    @Override
    public void deleteAluno(Aluno aluno) {
        alunos.removeIf(a -> a.getNome().equalsIgnoreCase(aluno.getNome()));
    }
}