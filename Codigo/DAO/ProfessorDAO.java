package Codigo;

import java.util.List;

public interface ProfessorDAO {
    Professor getProfessor(String nome);
    List<Professor> getAllProfessores();
    void addProfessor(Professor professor);
    void updateProfessor(Professor professor);
    void deleteProfessor(Professor professor);
}