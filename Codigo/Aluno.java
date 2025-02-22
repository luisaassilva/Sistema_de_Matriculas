import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String senha;
    private Integer mensalidade;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, String senha, Integer mensalidade) {
        this.nome = nome;
        this.senha = senha;
        this.mensalidade = mensalidade;
        this.disciplinas = new ArrayList<>();
    }
    public void setMensalidade(Integer mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Integer getMensalidade() {
        return mensalidade;
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public String getNome() {
        return nome;
    }
}
