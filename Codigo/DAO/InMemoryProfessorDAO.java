package Codigo;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProfessorDAO implements ProfessorDAO {
    private List<Professor> professores = new ArrayList<>();

    @Override
    public Professor getProfessor(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    @Override
    public List<Professor> getAllProfessores() {
        return professores;
    }

    @Override
    public void addProfessor(Professor professor) {
        professores.add(professor);
    }

    @Override
    public void updateProfessor(Professor professor) {
        professores.removeIf(p -> p.getNome().equalsIgnoreCase(professor.getNome()));
        professores.add(professor);
    }

    @Override
    public void deleteProfessor(Professor professor) {
        professores.removeIf(p -> p.getNome().equalsIgnoreCase(professor.getNome()));
    }
}