package Codigo;

import java.util.List;

public interface AlunoDAO {
    Aluno getAluno(String nome);
    List<Aluno> getAllAlunos();
    void addAluno(Aluno aluno);
    void updateAluno(Aluno aluno);
    void deleteAluno(Aluno aluno);
}