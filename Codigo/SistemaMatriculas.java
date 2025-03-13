package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class SistemaMatriculas {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();

    public static void main(String[] args) {
        carregarDados();
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
        alunos.add(new Aluno(nome, senha));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos() {
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
        cursos.add(new Curso(nome, credito));
        System.out.println("Curso cadastrado com sucesso!");
    }

    private static void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            System.out.println("Cursos cadastrados:");
            for (Curso curso : cursos) {
                System.out.println("- " + curso.getNome());
            }
        }
    }

    private static void carregarDados() {
        // Simulação de persistência - carregamento futuro
        System.out.println("[Simulação] Dados carregados.");
    }

    private static void salvarDados() {
        // Simulação de persistência - salvamento futuro
        System.out.println("[Simulação] Dados salvos.");
    }
    
    private static Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    private static Disciplina buscarDisciplina(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    private static void matricularAluno(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        Aluno aluno = buscarAluno(nomeAluno);
        
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        
        System.out.println("Escolha até 4 disciplinas obrigatórias e 2 optativas:");
        for (Disciplina disciplina : disciplinas) {
            System.out.println("- " + disciplina.getNome());
        }
        
        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o nome da disciplina: ");
            String nomeDisciplina = scanner.nextLine();
            Disciplina disciplina = buscarDisciplina(nomeDisciplina);
            
            if (disciplina == null) {
                System.out.println("Disciplina não encontrada.");
                continue;
            }
            
            if (disciplina.getAlunosMatriculados().size() >= 60) {
                System.out.println("Disciplina lotada.");
                continue;
            }
            
            aluno.matricularEmDisciplina(disciplina);
            disciplina.adicionarAluno(aluno);
        }
        
        notificarCobranca(aluno);
    }

    private static void cadastrarDisciplina(Scanner scanner) {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o valor da disciplina: ");
        int valor = scanner.nextInt();
        disciplinas.add(new Disciplina(nome, valor));
        System.out.println("Disciplina cadastrada com sucesso!");
    }
    
    private static void cancelarMatricula(Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        Aluno aluno = buscarAluno(nomeAluno);
        
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        
        System.out.println("Disciplinas matriculadas:");
        for (Disciplina disciplina : aluno.getDisciplinas()) {
            System.out.println("- " + disciplina.getNome());
        }
        
        System.out.print("Digite o nome da disciplina para cancelar: ");
        String nomeDisciplina = scanner.nextLine();
        Disciplina disciplina = buscarDisciplina(nomeDisciplina);
        
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }
        
        aluno.cancelarDisciplina(disciplina);
        disciplina.removerAluno(aluno);
        System.out.println("Matrícula cancelada com sucesso.");
    }
    
    private static void listarDisciplinasAtivas() {
        System.out.println("Disciplinas ativas no próximo semestre:");
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getAlunosMatriculados().size() >= 3) {
                System.out.println("- " + disciplina.getNome());
            }
        }
    }
    
    private static void consultarMatriculas(Scanner scanner) {
        System.out.print("Digite o nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();
        Disciplina disciplina = buscarDisciplina(nomeDisciplina);
        
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }
        
        System.out.println("Alunos matriculados na disciplina "+ disciplina.getNome() + ":");
        for (Aluno aluno : disciplina.getAlunosMatriculados()) {
            System.out.println("- " + aluno.getNome());
        }
    }
    
    private static void notificarCobranca(Aluno aluno) {
        System.out.println("Notificando sistema de cobranças para o aluno: " + aluno.getNome());
    }
    
    
    
}
