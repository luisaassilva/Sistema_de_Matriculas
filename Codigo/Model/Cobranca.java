package Codigo.Model;

public class Cobranca {
    public void atribuirMensalidade(Disciplina disciplina, Aluno aluno) {
        aluno.setMensalidade(disciplina.getValor());
    }
}
