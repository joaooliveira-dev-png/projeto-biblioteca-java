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

    @Override
    public String toString() {
        return "Livros: " + livros.size() +
               " | Usuários: " + usuarios.size();
    }
    
    
}
