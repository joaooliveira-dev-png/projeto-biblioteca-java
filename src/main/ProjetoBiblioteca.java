package main;

import java.time.LocalDate;
import java.util.Scanner;
import model.Livro;
import model.Usuario;
import service.Biblioteca;

public class ProjetoBiblioteca {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner entrada = new Scanner(System.in);
        int escolha;
        
        System.out.println("===== SISTEMA DA BIBLIOTECA =====\n");
        
        while(true){
        
            System.out.println("\n[1] Cadastrar livro");
            System.out.println("[2] Cadastrar usuário");
            System.out.println("[3] Emprestar livro");
            System.out.println("[4] Devolver livro");
            System.out.println("[5] Listar livros");
            System.out.println("[6] Listar usuários");
            System.out.println("[0] Sair");
            System.out.println("\nEscolha uma opção: ");
            escolha = entrada.nextInt();
            entrada.nextLine();
        
            switch(escolha){
                case 1:
                    System.out.println("\nDigite as informações necessárias para o Cadastro\n");
                    try{
                        System.out.println("Titulo: ");
                        String titulo = entrada.nextLine();
                        
                        System.out.println("Autor: ");
                        String autor = entrada.nextLine();
                        
                        System.out.println("Data de Laçanmento: ");
                        LocalDate data = LocalDate.parse(entrada.nextLine());
                        
                        Livro livro = new Livro(titulo, autor, data);
                        biblioteca.adicionarLivro(livro);
                        
                        System.out.println("Livro adicionado com sucesso!");
                        
                    }catch(java.time.format.DateTimeParseException erro){
                        System.out.println("Formato de data inválido! Use yyyy-MM-dd");
                    }catch(Exception erro){
                        System.out.println("Erro: " + erro.getMessage());
                    }
                    break;
                    
                case 2:
                    System.out.println("\nDigite as informações necessárias para o Cadastro\n");
                    
                    try{
                        System.out.println("ID: ");
                        int id = entrada.nextInt();
                        
                        entrada.nextLine();
                        
                        System.out.println("Nome: ");
                        String nome = entrada.nextLine();
                        
                        System.out.println("E-mail: ");
                        String email = entrada.nextLine();
                        
                        Usuario usuario = new Usuario(id, nome, email);
                        biblioteca.adicionarUsuario(usuario);
                        
                        System.out.println("Usuário cadastrado com sucesso!");
                        
                    }catch(Exception erro){
                        System.out.println("Erro: " + erro.getMessage());
                    }
                    break;
                    
                case 3:
                    System.out.println("----- EMPRÉSTIMO -----");
                    
                    biblioteca.listarLivros();
                    try{
                        System.out.println("Escolha o livro pelo titulo: ");
                        String titulo = entrada.nextLine();
                        
                        Livro livro = biblioteca.buscarLivroPorTitulo(titulo);
                        
                        if(livro == null){
                            System.out.println("Livro não encontrado!");
                            break;
                        }
                        
                        biblioteca.listarUsuarios();
                        
                        System.out.println("Escolha o usuário pelo e-mail: ");
                        String email = entrada.nextLine();
                        
                        Usuario usuario = biblioteca.buscarUsuarioPorEmail(email);
                        
                        if(usuario == null){
                            System.out.println("Usuário não encontrado!");
                            break;
                        }
                        
                        biblioteca.emprestarLivro(livro, usuario);
                      
                    }catch(Exception erro){
                        System.out.println("Erro: " + erro.getMessage());
                    }
                    break;
                    
                case 4:
                    System.out.println("----- DEVOLUÇÃO -----");
                    
                    biblioteca.listarLivros();
                    try{
                        System.out.println("Escolha o livro pelo titulo: ");
                        String titulo = entrada.nextLine();
                        
                        Livro livro = biblioteca.buscarLivroPorTitulo(titulo);
                        
                        if(livro == null){
                            System.out.println("Livro não encontrado!");
                            break;
                        }
                        
                        biblioteca.devolverLivro(livro);
                        
                    }catch(Exception erro){
                        System.out.println("Erro: " + erro.getMessage());
                    }
                    break;
                    
                case 5:
                    System.out.println("----- TODOS OS LIVROS -----");
                    
                    biblioteca.listarLivros();
                    
                    break;
                    
                case 6:
                    System.out.println("----- TODOS OS USUÁRIOS -----");
                    
                    biblioteca.listarUsuarios();
                    
                    break;
                    
                case 0:
                    System.out.println("Programa encerrado! Obrigado por usar nosso sistema!");
                    return;
            }
        }
        
    }
    
}
