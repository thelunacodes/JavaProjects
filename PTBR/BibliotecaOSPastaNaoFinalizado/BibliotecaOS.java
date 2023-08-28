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

        //ArrayList de teste
            // final int placeholderListaTamanho = 72;
            // for (int i = 0; i < placeholderListaTamanho; i++) {
            //     listaLivros.add(new Livro("aaa", "aaaaaa", "aaaa", "aaaa", "aaaa", 2, 2003, "aaaa", 3));      
            // }
            listaLivros.add(new Livro("O Pequeno Principe","Antoine de Saint-Exupéry","Nova Fronteira", "843", "978-8520930144", 1, 2016, "Infantil, Fábula, Ficção", 10));

            listaLivros.add(new Livro("Harry Potter e a Pedra Filosofal","J. K. Rowlling","Rocco", "239", "978-8532530783", 1, 2017, "Infantil, Fantasia, Aventura, Ficção", 7));

            listaLivros.add(new Livro("Biblia Sagrada","Deus","Paulinas", "200", "978-8535611748", 1, 2005, "Religião", 4));

            listaLivros.add(new Livro("Heartstopper","Alice Oseman e Guilherme Miranda","Seguinte", "741.5", "978-8555341618", 1, 2021, "Drama, Romance, LGBT, Comédia", 17));
            
            listaLivros.add(new Livro("Percy Jackson: O Ladrão de Raios","Rick Riordan","Intrínseca", "028.5", "978-8580575392", 1, 2014, "Ação, Aventura, Fantasia", 4));
        //Navegação do App
        do {
            switch (opcao1) {
                case 0:
                    //Intro
                    System.out.println("\n============================\n\tBibliotecaOS\n\t    v1.0\n============================");
                    System.out.println("\nBem-vindo(a), usuário(a)! Insira o número correspondente à opção desejada:");
                    System.out.println("\n[1] Cadastrar\n[2] Procurar por palavra-chave\n[3] Listar livros\n[4] Espaço livre\n[5] Excluir último elemento\n[6] Créditos\n[7] Sair\n");
                    //Input
                    opcao1 = verificarInt("> ");
                    break;
                case 1:
                    //Cadastrar livro
                    if (listaLivros.size() < 1000) {
                        System.out.println("\n===================================\n\tCadastro de Livros\n===================================\n");
                        //Nome
                        nomeLivro = verificarString("Insira o nome do livro: ");
                        //Autor
                        autor = verificarString("Insira o autor do livro: ");
                        //Editora
                        editora = verificarString("Insira a editora do livro: ");
                        //CDD
                        CDD = verificarString("Insira o CDD do livro: ");
                        //ISBN
                        ISBN = verificarString("Insira o ISBN do livro: ");
                        //Edição
                        edicao = verificarInt("Insira a edição do livro: ");
                        //Ano de Publicação
                        anoPublicacao = verificarInt("Insira o ano de publicação do livro: ");
                        //Seção
                        secao = verificarString("Insira o nome da seção onde está o livro: ");
                        //Prateleira
                        prateleira = verificarInt("Insira o número da prateleira onde está o livro: ");
                        //Adicionar à lista
                        listaLivros.add(new Livro(nomeLivro, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira));
                        opcao1 = 0;
                    } else {
                       System.out.println("ERRO: A lista está cheia!");
                       esperar(1500);
                       opcao1 = 0;
                    }
                    break;
                case 2:
                    do {
                        int opcao2 = 0;
                        int atributoInt = 0;
                        ArrayList<Livro> listaFiltrada = new ArrayList<Livro>();
                        String atributoString = "";

                        System.out.println("\n=============================\n\tFiltrar Lista\n=============================\n\n[1] - Nome do Livro\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                        opcao2 = verificarInt("\n> ");
                        //FILTRAR POR NOME
                        if (opcao2 == 1 ) { 
                            atributoString = verificarString("Insira o nome do livro que você procura (ou parte dele): ");
                            atributoString = atributoString.toUpperCase().trim();
                            System.out.println();
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getNomeLivro().toUpperCase().trim().contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNomeLivro());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR AUTOR   
                        } else if (opcao2 == 2) {
                            atributoString = verificarString("Insira o nome do autor que você procura (ou parte dele): ");
                            atributoString = atributoString.toUpperCase().trim();
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getAutor().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getAutor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR EDITORA
                        //FILTRAR POR CDD
                        //FILTRAR POR ISBN
                        //FILTRAR POR EDIÇÃO
                        //FILTRAR POR ANO DE PUBLICAÇÃO
                        //FILTRAR POR SEÇÃO
                        //FILTRAR POR NÚMERO DE PRATELEIRA
                        //SAIR
                        } else if (opcao2 == 10) {
                            opcao1 = 0;
                            break;
                        } else {
                            System.out.println("ERRO: Opção inválida!");
                        }
                    } while(true);
                    break;
                case 3:
                    //Listar livros
                    if (listaLivros.size() == 0) {
                        System.out.println("ERRO: Não há nenhum livro cadastrado!");
                        esperar(1500);
                        opcao1 = 0;
                    } else {
                        int min_index = 0;
                        int max_index = 4;
                        int index = 0;
                        String opcao3 = "";
                        do {
                            System.out.println("\n===============================\n\tLista de Livros\n===============================\n");
                            System.out.printf("Página %d/%d:\n\n", ((max_index+1) / 5), (Math.round(listaLivros.size() / 5) + 1));
                            for (int i = min_index; i <= max_index; i++) {
                                try {
                                    System.out.printf("%d - %s\n", i, listaLivros.get(i).getNomeLivro());
                                }
                                catch (IndexOutOfBoundsException e) {
                                    break;
                                }
                            }
                            //Introdução + primeira página da lista
                            System.out.println("\n[I] - Acessar as informações de um livro pelo ID.\n[A] - Página anterior\n[D] - Próxima página\n[P] - Primeira página\n[U] - Última página\n[S] - Sair");
                            System.out.print("\n> ");
                            opcao3 = scanner.next().toUpperCase().trim();
                            if (opcao3.equals("I")) {
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
                                        scanner.next(); //Limpar buffer
                                    }
                                } while (true);
                                System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", index, listaLivros.get(index).getNomeLivro(), listaLivros.get(index).getAutor(), listaLivros.get(index).getEditora(), listaLivros.get(index).getCDD(), listaLivros.get(index).getISBN(), listaLivros.get(index).getEdicao(), listaLivros.get(index).getAnoPublicacao(), listaLivros.get(index).getSecao(), listaLivros.get(index).getPrateleira());
                                scanner.nextLine(); //Limpar buffer
                                esperar(3000);
                            }else if (opcao3.equals("D")) {
                                //PRÓXIMA PÁGINA
                                if (listaLivros.size() > max_index+1) {
                                    min_index += 5;
                                    max_index += 5;
                               } else {
                                    System.out.println("ERRO: Não foi possível ir para a próxima página.");
                                    esperar(1500);
                                }
                            } else if (opcao3.equals("A")) {
                                //PÁGINA ANTERIOR
                                if (min_index > 0) {
                                    min_index -= 5;
                                    max_index -= 5;
                                } else {
                                    System.out.println("ERRO: Não foi possível ir para a página anterior.");
                                    esperar(1500);
                                }
                            } else if (opcao3.equals("P")) {
                                min_index = 0;
                                max_index = 4;
                            } else if (opcao3.equals("U")) {
                                //ÚLTIMA PÁGINA
                                for (int i = 1; (i * 5) < listaLivros.size(); i++) {
                                    min_index = 5 * i;
                                    max_index = 5 * (i+1);
                                }
                            } else if (opcao3.equals("S")) {
                                //SAIR
                                break;
                            } else {
                                //VALOR INVÁLIDO
                                System.out.println("ERRO: Opção inválida!");
                            }
                        } while (true);
                    }
                    opcao1 = 0;
                    break;
                case 4:
                    String opcao4 = "";
                    System.out.println("================================\n\tGerenciar Espaço\n================================");
                    System.out.printf("\nEspaço ocupado: %d/1000", listaLivros.size());
                    System.out.println("\n\n[L] - Limpar a lista de livros\n[O] - Organizar a lista em ordem alfabética\n[S] - Sair");
                    do {
                        System.out.print("\n> ");
                        opcao4 = scanner.nextLine().toUpperCase().trim();
                        break;
                    } while (true);
                    switch(opcao4) {
                        case "L":
                            String opcao4_B = "";
                            do {
                                System.out.println("Tem certeza que deseja limpar a lista? Essa ação não poderá ser desfeita (escreva \"S\" ou \"N\").");
                                System.out.print("> ");
                                opcao4_B = scanner.nextLine().toUpperCase();
                                if (opcao4_B.equals("S")) {
                                    listaLivros.clear();
                                    break;
                                }
                            } while (true);
                            break;
                        case "O":
                            //organizar lista em ordem alfabética aqui
                            break;
                        case "S":
                            break;
                        default:
                            System.out.println("ERRO: Opção inválida.");
                            break;
                    }
                    opcao1 = 0;
                    break;    
                case 6:
                    System.out.println("========================\n\tCréditos\n========================\n");
                    System.out.println("Criado por TheLuna\nGithub: delunatriestocode\n");
                    opcao1 = 0;
                    esperar(3000);
                case 7:
                    //Se o usuário tiver escolhido sair
                    break;
                default:
                    //Se o usuário tiver escolhido um número abaixo de 0 ou maior que 7
                    System.out.println("ERRO: Opção inválida!");
                    esperar(1000);
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
    //Método que valida input em INT
    public static int verificarInt(String msg) {
        int atributo = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                    System.out.print(msg);
                    atributo = scanner.nextInt();
                    break;
            }
            catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                scanner.next();
            }
        } while(true);
        return atributo;
    }
    //Método que valida input em DOUBLE
    public static double verificarDouble(String msg) {
        double atributo = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                    System.out.print(msg);
                    atributo = scanner.nextDouble();
                    break;
            }
            catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                scanner.next();
            }
        } while(true);
        return atributo;
    }
    public static String verificarString(String msg) {
        String atributo = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(msg);
            atributo = scanner.nextLine();
            if (!atributo.trim().isEmpty()) {
                break;
            }
        } while(true); 
        return atributo; 
    }
}