package model;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo) {
        if(livro == null || usuario == null || dataEmprestimo == null){
            throw new IllegalArgumentException("Dados do empréstimo não podem ser nulos");
        }
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
        
        this.livro.setDisponivel(false);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    
    public void devolver(LocalDate dataDevolucao){
        if(this.dataDevolucao != null){
            throw new IllegalArgumentException("Este livro já foi devolvido");
        }
        
        this.dataDevolucao = dataDevolucao;
        this.livro.setDisponivel(true);
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario +
                " | Livro: " + livro +
                " | Empréstimo: " + dataEmprestimo +
                " | Devolução: " + dataDevolucao;
    }

    
}
