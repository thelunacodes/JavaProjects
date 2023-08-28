package PTBR.BibliotecaOSPastaNaoFinalizado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaOS {
    public static void main(String[] args) {
        //atributos gerais
        Scanner scanner = new Scanner(System.in);
        String nomeLivro = "", autor = "", editora = "", CDD = "", ISBN = "", secao = "";
        int edicao = 0, anoPublicacao = 0, prateleira = 0, opcao1 = 0;
        ArrayList<Livro> listaLivros = new ArrayList<Livro>();

        //LEMBRETES:
        //
        //1- Criar algoritmo de organização em ordem alfabética
        //2- Cadastro Revista
        //3- Lista Revista
        //4- Procurar Revista
        //5- Excluir última revista

        //Navegação do App
        do {
            switch (opcao1) {
                //Intro
                case 0:
                    //ArrayList de teste
                    final int placeholderListaTamanho = 30;
                    for (int i = 0; i < placeholderListaTamanho; i++) {
                        listaLivros.add(new Livro("aaa" + i, "aaaaaa", "aaaa", "aaaa", "aaaa", 2, 2003, "aaaa", 3));      
                    }

                    System.out.println("\n============================\n\tBibliotecaOS\n\t    v1.0\n============================");
                    System.out.println("\nBem-vindo(a), usuário(a)! Insira o número correspondente à opção desejada:");
                    //Opções
                    System.out.println("\n[1] Cadastrar\n[2] Procurar por palavra-chave\n[3] Listar livros\n[4] Espaço livre\n[5] Excluir último elemento\n[6] Créditos\n[7] Sair\n");
                    do {
                        //Input
                        try {
                            System.out.print("> ");
                            opcao1 = scanner.nextInt();
                            break;
                        }
                        //Se o usuário ousar inserir algo que não é número
                        catch(InputMismatchException e) {
                            System.out.println("ERRO: Insira apenas números inteiros, por favor.");
                            scanner.next();
                        }
                    } while (true);
                    scanner.nextLine(); //limpar buffer do scanner
                    break;
                case 1:
                    //Cadastrar livro
                    if (listaLivros.size() < 1000) {
                        System.out.println("\n===================================\n\tCadastro de Livros\n===================================\n");
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
                                scanner.next();

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
                                scanner.next();
                            }
                        } while(true);
                        //Seção
                        do {
                            scanner.nextLine();
                            System.out.print("Insira o nome da seção onde está o livro: ");
                            secao = scanner.next();
                            if (!secao.trim().isEmpty()) {
                            break;
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
                                scanner.next();
                            }
                        } while(true);
                        //Adicionar à lista
                        listaLivros.add(new Livro(nomeLivro, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira));
                        opcao1 = 0;
                    } else {
                       System.out.println("ERRO: A lista está cheia!");
                       esperar(1500);
                       opcao1 = 0;
                    }
                    break;
                case 3:
                    //Listar livros
                    if (listaLivros.size() == 0) {
                        System.out.println("Não há nenhum livro cadastrado!");
                        esperar(1500);
                        opcao1 = 0;
                    } else {
                        int min_index = 0;
                        int max_index = 4;
                        int index = 0;
                        String opcao2 = "";
                        do {
                            System.out.println("\n===============================\n\tLista de Livros\n===============================\n");
                            System.out.printf("Página %d:\n\n", ((max_index + 1) / 5));
                            for (int i = min_index; i <= max_index; i++) {
                                try {
                                    System.out.printf("[%d] - %s\n", i, listaLivros.get(i).getNomeLivro());
                                }
                                catch (IndexOutOfBoundsException e) {
                                    break;
                                }
                            }
                            //Introdução + primeira página da lista
                            System.out.println("\nInsira: \n\n\"I\" para acessar as informações de um livro pelo ID.\n\"A\" para ir para a página anterior (se possível).\n\"D\" para ir para a próxima página\n\"S\" para voltar ao menu principal");
                            System.out.print("\n> ");
                            opcao2 = scanner.next();
                            if (opcao2.toUpperCase().trim().equals("I")) {
                                do {
                                    try {
                                        System.out.print("Insira o index do livro no qual você deseja acessar as informações: ");
                                        index = scanner.nextInt();
                                        if (index < 0 || index >= listaLivros.size()) {
                                            System.out.println("ERRO: Index inválido.");
                                        } else {
                                            break;
                                        }
                                    } 
                                    catch (InputMismatchException e) {
                                        System.out.println("ERRO: Apenas números, por favor.");
                                        scanner.next();
                                    }
                                } while (true);
                                System.out.printf("ID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", index, listaLivros.get(index).getNomeLivro(), listaLivros.get(index).getAutor(), listaLivros.get(index).getEditora(), listaLivros.get(index).getCDD(), listaLivros.get(index).getISBN(), listaLivros.get(index).getEdicao(), listaLivros.get(index).getAnoPublicacao(), listaLivros.get(index).getSecao(), listaLivros.get(index).getPrateleira());
                                scanner.nextLine(); //Limpar buffer
                                do {
                                    String opcao3 = "";
                                    System.out.print("\nVoltar para o menu com a lista? (Escreva \"sim\" ou \"não\"): ");
                                    opcao3 = scanner.nextLine().toUpperCase();
                                    switch(opcao3) {
                                        case "SIM":
                                            opcao2 = "";
                                            break;
                                        case "NÃO":
                                            break;
                                        default:
                                            System.out.println("Opção inválida!");
                                            break;
                                    }
                                    if (opcao3.equals("SIM")) {
                                        break;
                                    }
                                } while (true);
                            }else if (opcao2.toUpperCase().trim().equals("D")) {
                                //PRÓXIMA PÁGINA
                                if (listaLivros.size() > max_index) {
                                    System.out.println(min_index);
                                    System.out.println(max_index);
                                    min_index += 5;
                                    max_index += 5;
                                    System.out.printf("Página %d:\n\n", ((max_index + 1) / 5));
                                    for (int i = min_index; i <= max_index; i++) {
                                        try {
                                            System.out.printf("[%d] - %s\n", i, listaLivros.get(i).getNomeLivro());
                                        }
                                        catch (IndexOutOfBoundsException e) {
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("ERRO: Não foi possível ir para a próxima página.");
                                }
                            } else if (opcao2.toUpperCase().trim().equals("A")) {
                                //PÁGINA ANTERIOR
                                if (min_index > 0) {
                                    System.out.println(min_index);
                                    System.out.println(max_index);
                                    min_index -= 5;
                                    max_index -= 5;
                                    System.out.printf("Página %d:\n\n", ((max_index + 1) / 5));
                                    for (int i = min_index; i <= max_index; i++) {
                                        try {
                                            System.out.printf("[%d] - %s\n", i, listaLivros.get(i).getNomeLivro());
                                        }
                                        catch (IndexOutOfBoundsException e) {
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("ERRO: Você já está na primeira página!");
                                }
                            } else if (opcao2.toUpperCase().trim().equals("S")) {
                                //SAIR
                                break;
                            } else {
                                //BRUH
                                System.out.println("ERRO: Opção inválida!");
                            }
                        } while (true);
                    }
                    opcao1 = 0;
                    break;
                case 4:
                    double porcEspacoOcupado = listaLivros.size() * 100 / 1000;
                    String opcao4 = "";
                    System.out.println("================================\n\tGerenciar Espaço\n================================\n");
                    if (porcEspacoOcupado % 1 == 0) {
                        System.out.printf("\nEspaço ocupado: %d/1000 (%.0f%%)\n", listaLivros.size(), porcEspacoOcupado);
                    } else {
                        System.out.printf("\nEspaço ocupado: %d/1000 (%.2f%%)\n", listaLivros.size(), porcEspacoOcupado);
                    }
                    System.out.println("Insira: \n\n\"Limpar\" para limpar a lista de livros.\n\"Organizar\" para organizar a lista em ordem alfabética\n\"Sair\" para sair.");
                    do {
                        System.out.print("\n> ");
                        opcao4 = scanner.nextLine().toUpperCase();
                        break;
                    } while (true);
                    switch(opcao4) {
                        case "LIMPAR":
                            String opcao4_B = "";
                            do {
                                System.out.println("Tem certeza que deseja limpar a lista? Essa ação não poderá ser desfeita (escreva \"sim\" ou \"não\").");
                                System.out.print("/n> ");
                                opcao4_B = scanner.nextLine();
                                if (opcao4_B.equals("SIM")) {
                                    listaLivros.clear();
                                    break;
                                }
                            } while (true);
                            
                            break;
                        case "ORGANIZAR":
                            //organizar lista em ordem alfabética aqui
                    }
                    opcao1 = 0;
                    esperar(3000);
                    break;    
                case 6:
                    System.out.println("========================\n\tCréditos\n========================\n");
                    System.out.println("Criado por TheLuna\nGithub: delunatriestocode\n");
                    opcao1 = 0;
                    esperar(5000);
                case 7:
                    //Se o usuário tiver escolhido sair
                    break;
                default:
                    //Se o usuário tiver escolhido um número abaixo de 0 ou maior que 7
                    System.out.println("ERRO: Opção inválida!");
                    esperar(1500);
                    opcao1 = 0;
            }
            //Se o usuário tiver escolhido sair
            if (opcao1 == 7) {
                System.out.println("\n===========================\n\tTchauzinho!\n===========================\n");                
                break;
            }
        } while (true);
        //Fechar scanner
        scanner.close();
    }
    //Método que pausa a aplicação por x milisegundos (1000 ms = 1 s)
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } 
        catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}