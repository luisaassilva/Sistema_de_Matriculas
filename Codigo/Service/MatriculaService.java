package Codigo;

import java.util.List;

public class MatriculaService {
    private AlunoDAO alunoDAO;
    private ProfessorDAO professorDAO;
    private CursoDAO cursoDAO;
    private DisciplinaDAO disciplinaDAO;

    public MatriculaService(AlunoDAO alunoDAO, ProfessorDAO professorDAO, CursoDAO cursoDAO, DisciplinaDAO disciplinaDAO) {
        this.alunoDAO = alunoDAO;
        this.professorDAO = professorDAO;
        this.cursoDAO = cursoDAO;
        this.disciplinaDAO = disciplinaDAO;
    }

    public Aluno cadastrarAluno(String nome, String senha) {
        Aluno aluno = new Aluno(nome, senha);
        alunoDAO.addAluno(aluno);
        return aluno;
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.getAllAlunos();
    }

    public Curso cadastrarCurso(String nome, int credito) {
        Curso curso = new Curso(nome, credito);
        cursoDAO.addCurso(curso);
        return curso;
    }

     public List<Curso> listarCursos() {
        return cursoDAO.getAllCursos();
    }
    
    public Disciplina cadastrarDisciplina(String nome, int valor) {
        Disciplina disciplina = new Disciplina(nome, valor);
        disciplinaDAO.addDisciplina(disciplina);
        return disciplina;
    }

    public void matricularAluno(String nomeAluno, List<String> nomesDisciplinas) {
        Aluno aluno = alunoDAO.getAluno(nomeAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        for (String nomeDisciplina : nomesDisciplinas) {
            Disciplina disciplina = disciplinaDAO.getDisciplina(nomeDisciplina);
            if (disciplina == null) {
                System.out.println("Disciplina não encontrada: " + nomeDisciplina);
                continue;
            }

            if (disciplina.getAlunosMatriculados().size() >= 60) {
                System.out.println("Disciplina lotada: " + nomeDisciplina);
                continue;
            }

            aluno.matricularEmDisciplina(disciplina);
            disciplina.adicionarAluno(aluno);
            alunoDAO.updateAluno(aluno); // Update the aluno in the DAO
            disciplinaDAO.updateDisciplina(disciplina); // Update the disciplina in the DAO
        }
    }

    public void cancelarMatricula(String nomeAluno, String nomeDisciplina) {
        Aluno aluno = alunoDAO.getAluno(nomeAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        Disciplina disciplina = disciplinaDAO.getDisciplina(nomeDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        aluno.cancelarDisciplina(disciplina);
        disciplina.removerAluno(aluno);
        alunoDAO.updateAluno(aluno); // Update the aluno in the DAO
        disciplinaDAO.updateDisciplina(disciplina); // Update the disciplina in the DAO
        System.out.println("Matrícula cancelada com sucesso.");
    }

    public List<Disciplina> listarDisciplinasAtivas() {
        return disciplinaDAO.getAllDisciplinas().stream()
                .filter(d -> d.getAlunosMatriculados().size() >= 3)
                .toList();
    }

    public List<Aluno> consultarMatriculas(String nomeDisciplina) {
        Disciplina disciplina = disciplinaDAO.getDisciplina(nomeDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return null;
        }
        return disciplina.getAlunosMatriculados();
    }

    private Aluno buscarAluno(String nome) {
       return alunoDAO.getAluno(nome);
    }

    private Disciplina buscarDisciplina(String nome) {
        return disciplinaDAO.getDisciplina(nome);
    }
}