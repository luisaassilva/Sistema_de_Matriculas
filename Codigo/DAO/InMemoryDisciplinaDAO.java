package Codigo;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDisciplinaDAO implements DisciplinaDAO {
    private List<Disciplina> disciplinas = new ArrayList<>();

    @Override
    public Disciplina getDisciplina(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    @Override
    public List<Disciplina> getAllDisciplinas() {
        return disciplinas;
    }

    @Override
    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

     @Override
    public void updateDisciplina(Disciplina disciplina) {
        disciplinas.removeIf(d -> d.getNome().equalsIgnoreCase(disciplina.getNome()));
        disciplinas.add(disciplina);
    }

    @Override
    public void deleteDisciplina(Disciplina disciplina) {
        disciplinas.removeIf(d -> d.getNome().equalsIgnoreCase(disciplina.getNome()));
    }
}