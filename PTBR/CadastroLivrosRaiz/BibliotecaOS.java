package PTBR.CadastroLivrosRaiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaOS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeLivro = "", autor = "", editora = "", CDD = "", ISBN = "", secao = "";
        int edicao = 0, anoPublicacao = 0, prateleira = 0, opcao = 0;
        ArrayList<Livro> listaLivros = new ArrayList<Livro>();

        // LEMBRETES:
        //
        // 1- Navegação da lista de livros
        //


        //Navegação do App
        do {
            switch (opcao) {
                //Intro
                case 0:      
                    System.out.println("\n===================================\n\tCadastro De Livros\n\t\tv1.0\n===================================");
                    System.out.println("\nBem-vindo(a), usuário(a)! Insira o número correspondente à opção desejada:");
                    //Opções
                    System.out.println("\n[1] Cadastrar\n[2] Procurar pro palavra-chave\n[3] Listar livros\n[4] Espaço livre/usado\n[5] Excluir último elemento\n[6] Ordenar livros cadastrados\n[7] Sair\n");
                    //Input
                    do {
                        try {
                            System.out.print("> ");
                            opcao = scanner.nextInt();
                            break;
                        }
                        catch(InputMismatchException e) {
                            System.out.println("ERRO: Insira apenas números inteiros, por favor.");
                            scanner.next();
                        }
                    } while (true);
                    scanner.nextLine();
                    break;
                //Cadastro
                case 1:
                    if (listaLivros.size() < 1000) {
                        //Nome
                        do {
                            System.out.print("Insira o nome do livro: ");
                            nomeLivro = scanner.nextLine();
                            if (!nomeLivro.trim().isEmpty()) {
                                break;
                            }
                        } while(true);  
                        //Autor
                        do {
                            System.out.print("Insira o Autor do livro: ");
                            autor = scanner.next();
                            if (!autor.trim().isEmpty()) {
                                break;
                            }
                        } while(true); 
                        //Editora
                        do {
                            System.out.print("Insira a editora do livro: ");
                            editora = scanner.next();
                            if (!editora.trim().isEmpty()) {
                                break;
                            }
                        } while(true); 
                        //CDD
                        do {
                            System.out.print("Insira o CDD do livro: ");
                            CDD = scanner.next();
                            if (!CDD.trim().isEmpty()) {
                                break;
                            }
                        } while(true);
                        //ISBN
                        do {
                            scanner.nextLine();
                            System.out.print("Insira o ISBN do livro: ");
                            ISBN = scanner.next();
                            if (!ISBN.trim().isEmpty()) {
                                break;
                            }
                        } while(true);
                        //Edição
                        do {
                            try {
                                System.out.print("Insira a edição do livro: ");
                                edicao = scanner.nextInt();
                                break;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("ERRO: Apenas números, por favor.");
                            }
                        } while(true);
                        //Ano de Publicação
                        do {
                            try {
                                System.out.print("Insira o ano de publicação do livro: ");
                                anoPublicacao = scanner.nextInt();
                                break;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("ERRO: Apenas números, por favor.");
                            }
                        } while(true);
                        //Seção
                        do {
                            try {
                                scanner.nextLine();
                                System.out.print("Insira o nome da seção onde está o livro: ");
                                secao = scanner.next();
                                if (!secao.trim().isEmpty()) {
                                break;
                                }
                            }
                            catch (InputMismatchException e) {
                                System.out.println("ERRO: Apenas números, por favor.");
                            }
                        } while(true);
                        //Prateleira
                        do {
                            try {
                                System.out.print("Insira a prateleira onde está o livro: ");
                                prateleira = scanner.nextInt();
                                break;
                            }
                            catch (InputMismatchException e) {
                                System.out.println("ERRO: Apenas números, por favor.");
                            }
                        } while(true);
                        //Adicionar à lista
                        listaLivros.add(new Livro(nomeLivro, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira));
                        opcao = 0;
                    } else {
                       System.out.println("ERRO: A lista está cheia!");
                       opcao = 0;
                    }
                    break;
                case 3:
                    if (listaLivros.size() == 0) {
                        System.out.println("Não há nenhum livro cadastrado!");
                        esperar(2000);
                        opcao = 0;
                    } else {
                        for (int i = 0; i < listaLivros.size(); i++) {
                            System.out.printf("==================================================\n\t\t[Livro %d#]\n\nNome do Livro: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d",i,nomeLivro,autor,editora,CDD,ISBN,edicao,anoPublicacao,secao,prateleira);
                        }
                        System.out.println();
                        opcao = 0;
                    }
            }
               
            
        } while (true);
    }
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } 
        catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}
