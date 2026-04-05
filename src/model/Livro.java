package model;

import java.time.LocalDate;

public class Livro {
    private final String titulo;
    private final String autor;
    private final LocalDate dataPublicacao; 
    private boolean disponivel;

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
               " | Autor: " + autor +
               " | Data da Publicação: " + dataPublicacao +
               " | Disponível: " + disponivel;
    }
    
    
}
