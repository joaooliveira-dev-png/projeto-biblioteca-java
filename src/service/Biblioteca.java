package service;

import java.util.ArrayList;
import java.util.List;
import model.Livro;
import model.Usuario;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private boolean disponivel;
    
    public void adicionarLivro(Livro livro) {
    livros.add(livro);
    }
    
    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void emprestarLivro(Livro livro, Usuario usuario){
        if(!livro.isDisponivel()){
            System.out.println("O livro está indisponível no momento. Aguarde a sua devolução");
        } else {
            livro.setDisponivel(false);
            System.out.println(usuario + " seu emprestimo foi realizado com sucesso");
        }
    }
    
    public void devolverLivro(Livro livro){
       if(livro.isDisponivel()){
           System.out.println("Este livro já foi devolvido! Obrigado!");
       }else{
           livro.setDisponivel(true);
           System.out.println("Livro devolvido com sucesso");
       }
    }
    
    @Override
    public String toString() {
        return "Livros: " + livros.size() +
               " | Usuários: " + usuarios.size();
    }
    
    
}
