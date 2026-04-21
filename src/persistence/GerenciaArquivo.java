package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;


public class GerenciaArquivo {
    File fileLivro = new File("livros.txt");
    File fileEmprestimo = new File("emprestimos.txt");
    File fileUsuario = new File("usuarios.txt");

    public void salvarLivro(List<Livro> livros){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLivro));
            
            for(Livro livro: livros){
                String linha = livro.getTitulo() + ";"
                        + livro.getAutor() + ";" 
                        + livro.getDataPublicacao() + ";" 
                        + livro.isDisponivel();
                
                writer.write(linha);
                writer.newLine();
            }
            
            writer.close();
            
        }catch(IOException erro){
            System.out.println(erro.getMessage());
        }
    }
    
    public List<Livro> carregarLivros(){
            List<Livro> livros = new ArrayList<>();
            
            if(!fileLivro.exists()){
                return livros;
            }
            
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileLivro));
            String linha = null;
            
            while((linha = reader.readLine()) != null){
                String[] partes = linha.split(";");
                
                String titulo = partes[0];
                String autor = partes[1];
                LocalDate data = LocalDate.parse(partes[2]);
                boolean disponivel = Boolean.parseBoolean(partes[3]);
                
                Livro livro = new Livro(titulo, autor, data);
                
                livro.setDisponivel(disponivel);
                
                livros.add(livro);
            }
            reader.close();
            
        }catch(Exception erro){
            System.out.println(erro.getMessage());
        }
        return livros;
    }
    
    public void salvarUsuario(List<Usuario> usuarios){
        try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileUsuario));

                for(Usuario usuario : usuarios){
                    String linha = usuario.getId() + ";" +
                            usuario.getNome() + ";" +
                            usuario.getEmail();

                    writer.write(linha);
                    writer.newLine();
                }
                writer.close();
                
            } catch(IOException erro){
            System.out.println(erro.getMessage());
        }
        
    }
    
    public List<Usuario> carregarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        if(!fileUsuario.exists()){
            return usuarios;
        }
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileUsuario));
            String linha = null;
            
            while((linha = reader.readLine()) != null){
                String[] partes = linha.split(";");
                
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String email = partes[2];
                
                Usuario usuario = new Usuario(id, nome, email);
                usuarios.add(usuario);
            }
            reader.close();
        }catch(Exception erro){
            System.out.println(erro.getMessage());
        }
        return usuarios;
    }
    
    public void salvarEmprestimo(List<Emprestimo> emprestimos){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileEmprestimo));
            
            for(Emprestimo emprestimo : emprestimos){
                String linha = emprestimo.getUsuario().getId() + ";" +
                        emprestimo.getLivro().getTitulo() + ";" +
                        emprestimo.getDataEmprestimo() + ";" +
                        emprestimo.getDataDevolucao();
                
                writer.write(linha);
                writer.newLine();
                
            }
            
            writer.close();
            
        }catch(IOException erro){
            System.out.println(erro.getMessage());
        }
    }

    public List<Emprestimo> carregarEmprestimo(List<Usuario> usuarios, List<Livro> livros){
        List<Emprestimo> emprestimos = new ArrayList<>();
        
        if(!fileEmprestimo.exists()){
            return emprestimos;
        }
        
        try{
             BufferedReader reader = new BufferedReader(new FileReader(fileEmprestimo));
             String linha = null;
             
             while((linha = reader.readLine()) != null){
                 String[] partes = linha.split(";");
                 
                 int idUsuario = Integer.parseInt(partes[0]);
                 String titulo = partes[1];
                 LocalDate dataEmprestimo = LocalDate.parse(partes[2]);
                 String dataDevolucao = partes[3];
                 
                 Usuario usuario = null;
                 Livro livro = null;
                 
                 for(Usuario u : usuarios){
                     if(u.getId() == idUsuario){
                         usuario = u;
                         break;
                    }
                 }
                     
                for(Livro l : livros){
                    if(l.getTitulo().equals(titulo)){
                        livro = l;
                        break;
                    }
                }     
            
                if(usuario != null && livro != null){
                    Emprestimo emprestimo = new Emprestimo(usuario, livro, dataEmprestimo);
                    
                    if(!dataDevolucao.equals("null")){
                        emprestimo.devolver(LocalDate.parse(dataDevolucao));
                    }
                    emprestimos.add(emprestimo);
                }
             }
             
        }catch(Exception erro){
            System.out.println(erro.getMessage());
        }
        return emprestimos;
    }

}    