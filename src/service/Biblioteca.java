package service;

import java.util.ArrayList;
import java.util.List;
import model.Livro;
import model.Usuario;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    
    public void adicionarLivro(Livro livro) {
    livros.add(livro);
    }
    
    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void listarLivros() {
    if (livros.isEmpty()) {
        System.out.println("Nenhum livro cadastrado.");
        return;
    }

    for (int i = 0; i < livros.size(); i++) {
        System.out.println("[" + i + "] " + livros.get(i));
    }
    }
    
    public void listarUsuarios() {
    if (usuarios.isEmpty()) {
        System.out.println("Nenhum usuário cadastrado.");
        return;
    }

    for (int i = 0; i < usuarios.size(); i++) {
        System.out.println("[" + i + "] " + usuarios.get(i));
    }
    }
    
    public void emprestarLivro(Livro livro, Usuario usuario){
        if(livro == null || usuario == null){
            throw new IllegalArgumentException("Livro e usuario não podem ser nulos");
        }
        if(!livro.isDisponivel()){
            throw new IllegalStateException("O livro já está emprestado. Aguarde a sua devolução");
        } else {
            livro.setDisponivel(false);
            System.out.println(usuario + " seu emprestimo foi realizado com sucesso");
        }
    }
    
    public void devolverLivro(Livro livro){
       if(livro.isDisponivel()){
          throw new IllegalStateException("O livro já está disponível");
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
    
    public List<Livro> getLivros() {
    return livros;
    }
    
    public List<Usuario> getUsuarios() {
    return usuarios;
    }
}
