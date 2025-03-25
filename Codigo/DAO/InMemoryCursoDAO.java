package Codigo;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCursoDAO implements CursoDAO {
    private List<Curso> cursos = new ArrayList<>();

    @Override
    public Curso getCurso(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursos;
    }

    @Override
    public void addCurso(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public void updateCurso(Curso curso) {
        cursos.removeIf(c -> c.getNome().equalsIgnoreCase(curso.getNome()));
        cursos.add(curso);
    }

    @Override
    public void deleteCurso(Curso curso) {
        cursos.removeIf(c -> c.getNome().equalsIgnoreCase(curso.getNome()));
    }
}