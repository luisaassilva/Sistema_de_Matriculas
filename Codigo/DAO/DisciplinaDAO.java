package Codigo;

import Codigo.Model.Disciplina;

import java.util.List;

public interface DisciplinaDAO {
    Disciplina getDisciplina(String nome);
    List<Disciplina> getAllDisciplinas();
    void addDisciplina(Disciplina disciplina);
    void updateDisciplina(Disciplina disciplina);
    void deleteDisciplina(Disciplina disciplina);
}