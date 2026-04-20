package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    
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
    
    for(Livro livro : livros){
        System.out.println(livro);
    }
    }
    
    public void listarUsuarios() {
    if (usuarios.isEmpty()) {
        System.out.println("Nenhum usuário cadastrado.");
        return;
    }
     
    for(Usuario usuario : usuarios){
        System.out.println(usuario);
    }
    }
    
    public Livro buscarLivroPorTitulo(String titulo){
        for(Livro livro : livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
            return livro;
            }
        } return null;
    }
    
    public Usuario buscarUsuarioPorEmail(String email){
        for(Usuario usuario : usuarios){
            if(usuario.getEmail().equalsIgnoreCase(email)){
            return usuario;
            }
        }
        return null;
    }
    
    public void emprestarLivro(Livro livro, Usuario usuario){
        if(livro == null || usuario == null){
            throw new IllegalArgumentException("Livro e usuario não podem ser nulos");
        }
        if(!livro.isDisponivel()){
            throw new IllegalStateException("O livro já está emprestado. Aguarde a sua devolução");
        }
        
        Emprestimo e = new Emprestimo(usuario, livro, LocalDate.now());
        
        livro.setDisponivel(false);
        emprestimos.add(e);
    
        System.out.println("Empréstimo realizado com sucesso para o usuário: " + usuario.getNome());
    }
    
    public void devolverLivro(Livro livro){
      if(livro == null){
          throw new IllegalArgumentException("O livro não pode ser nulo");
      }
      
      for(Emprestimo e : emprestimos){
          if(e.getLivro().equals(livro) && e.getDataDevolucao() == null){
              
              e.devolver(LocalDate.now());
              livro.setDisponivel(true);
              
              System.out.println("Livro devolvido com sucesso!");
              return;
          }
          
          throw new IllegalStateException("Não existe empréstimo ativo para esse livro");
      }
    }
       
    public List<Livro> getLivros() {
    return livros;
    }
    
    public List<Usuario> getUsuarios() {
    return usuarios;
    }
}
