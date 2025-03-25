package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaMatriculas {
    private static AlunoDAO alunoDAO = new InMemoryAlunoDAO();
    private static ProfessorDAO professorDAO = new InMemoryProfessorDAO();
    private static CursoDAO cursoDAO = new InMemoryCursoDAO();
    private static DisciplinaDAO disciplinaDAO = new InMemoryDisciplinaDAO();
    private static MatriculaService matriculaService = new MatriculaService(alunoDAO, professorDAO, cursoDAO, disciplinaDAO);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Matrículas");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Cadastrar Curso");
            System.out.println("4. Listar Cursos");
            System.out.println("5. Matricular Aluno");
            System.out.println("6. Cancelar Matrícula");
            System.out.println("7. Listar Disciplinas Ativas");
            System.out.println("8. Consultar Matrículas de uma Disciplina");
            System.out.println("9. Cadastrar Disciplina");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner);
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    cadastrarCurso(scanner);
                    break;
                case 4:
                    listarCursos();
                    break;
                case 5:
                    matricularAluno(scanner);
                    break;
                case 6:
                    cancelarMatricula(scanner);
                    break;
                case 7:
                    listarDisciplinasAtivas();
                    break;
                case 8:
                    consultarMatriculas(scanner);
                    break;
                case 9:
                    cadastrarDisciplina(scanner);
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 10);
    }

    private static void cadastrarAluno(Scanner scanner) {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        matriculaService.cadastrarAluno(nome, senha);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos() {
        List<Aluno> alunos = matriculaService.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Alunos cadastrados:");
            for (Aluno aluno : alunos) {
                System.out.println("- " + aluno.getNome());
            }
        }
    }

    private static void cadastrarCurso(Scanner scanner) {
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Créditos: ");
        int credito = scanner.nextInt();
        scanner.nextLine();
        matriculaService.cadastrarCurso(nome, credito);
        System.out.println("Curso cadastrado com sucesso!");
    }

    private static void listarCursos() {
        List<Curso> cursos = matriculaService.listarCursos();
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            System.out.println("Cursos cadastrados:");
            for (Curso curso : cursos) {
                System.out.println("- " + curso.getNome());
            }
        }
    }

    private static void cadastrarDisciplina(Scanner scanner) {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o valor da disciplina: ");
        int valor = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        matriculaService.cadastrarDisciplina(nome, valor);
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    private static void matricularAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();

        System.out.println("Digite os nomes das disciplinas para matricular (separadas por vírgula):");
        String disciplinasInput = scanner.nextLine();
        String[] nomesDisciplinas = disciplinasInput.split(",");
        List<String> disciplinasParaMatricular = new ArrayList<>();
        for (String nomeDisciplina : nomesDisciplinas) {
            disciplinasParaMatricular.add(nomeDisciplina.trim());
        }

        matriculaService.matricularAluno(nomeAluno, disciplinasParaMatricular);
    }

    private static void cancelarMatricula(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        System.out.print("Digite o nome da disciplina para cancelar: ");
        String nomeDisciplina = scanner.nextLine();
        matriculaService.cancelarMatricula(nomeAluno, nomeDisciplina);
    }

    private static void listarDisciplinasAtivas() {
        List<Disciplina> disciplinasAtivas = matriculaService.listarDisciplinasAtivas();
        if (disciplinasAtivas.isEmpty()) {
            System.out.println("Nenhuma disciplina ativa no momento.");
        } else {
            System.out.println("Disciplinas ativas:");
            for (Disciplina disciplina : disciplinasAtivas) {
                System.out.println("- " + disciplina.getNome());
            }
        }
    }

    private static void consultarMatriculas(Scanner scanner) {
        System.out.print("Digite o nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();
        List<Aluno> alunosMatriculados = matriculaService.consultarMatriculas(nomeDisciplina);

        if (alunosMatriculados == null || alunosMatriculados.isEmpty()) {
            System.out.println("Nenhum aluno matriculado nesta disciplina.");
        } else {
            System.out.println("Alunos matriculados na disciplina " + nomeDisciplina + ":");
            for (Aluno aluno : alunosMatriculados) {
                System.out.println("- " + aluno.getNome());
            }
        }
    }
}