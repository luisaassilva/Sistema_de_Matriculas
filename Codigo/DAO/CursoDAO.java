package Codigo;

import java.util.List;

public interface CursoDAO {
    Curso getCurso(String nome);
    List<Curso> getAllCursos();
    void addCurso(Curso curso);
    void updateCurso(Curso curso);
    void deleteCurso(Curso curso);
}