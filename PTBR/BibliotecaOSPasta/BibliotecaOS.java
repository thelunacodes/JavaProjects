package PTBR.BibliotecaOSPasta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BibliotecaOS {
    // ATRIBUTOS GERAIS
    static Scanner scanner = new Scanner(System.in);
    static String nome = "", autor = "", editora = "", CDD = "", ISBN = "", secao = "";
    static String ISSN = "";
    static int edicao = 0, anoPublicacao = 0, prateleira = 0, opcao0 = 0, opcao2 = 0, opcao2_bL = 0, opcao2_bR = 0, opcao3 = 0, opcao3_bL = 0, opcao3_bR;
    static ArrayList<Livro> listaLivros = new ArrayList<Livro>();
    static ArrayList<Revista> listaRevistas = new ArrayList<Revista>();
    // ERROS
    static String nenhumItemEncontradoString = "ERRO: Nenhum item encontrado!";
    static String opcaoInvalidaString = "ERRO: Opção inválida!";
    static String listaCheiaString = "ERRO: A lista está cheia!";
    static String listaVaziaString = "ERRO: A lista está vazia!";
    // CAMINHO DOS ARQUIVOS
    static String nomeDaClasseCompleto = BibliotecaOS.class.getName();
    static String nomeDaClasseSimples = BibliotecaOS.class.getSimpleName();
    static String nomeDoPacote = nomeDaClasseCompleto.substring(0, nomeDaClasseCompleto.length() - nomeDaClasseSimples.length() - 1);
    static String caminhoArquivoLivro = System.getProperty("user.dir") + "\\PRBR\\" + nomeDoPacote.replace(".", "\\") + "\\arquivoLivros.txt";

    public static void main(String[] args) {

        /*
         * =================================================
         * Github: delunatriestocode
         * Linkedin: in/gabrielsilveiradeluna
         * =================================================
         */

        System.out.println(nomeDoPacote);

        listaLivros.add(new Livro("O Pequeno Principe", "Antoine de Saint-Exupéry", "Nova Fronteira", "843",
                "978-8520930144", 1, 2016, "Infantil, Fábula, Ficção", 10));

        listaLivros.add(new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowlling", "Rocco", "239",
                "978-8532530783", 1, 2017, "Infantil, Fantasia, Aventura, Ficção", 7));

        listaLivros.add(new Livro("Biblia Sagrada", "Deus", "Paulinas", "200", "978-8535611748", 1, 2005, "Religião", 4));

        listaLivros.add(new Livro("Heartstopper", "Alice Oseman e Guilherme Miranda", "Seguinte", "741.5",
                "978-8555341618", 1, 2021, "Drama, Romance, LGBT, Comédia", 17));

        listaLivros.add(new Livro("Percy Jackson: O Ladrão de Raios", "Rick Riordan", "Intrínseca", "028.5",
                "978-8580575392", 1, 2014, "Ação, Aventura, Fantasia", 4));

        listaLivros.add(new Livro("99 Tons de Cinza", "E. L. James", "Intrínseca", "123", "978-8580572186", 2, 2012,
                "Erótico", 8));

        listaLivros.add(new Livro("50 Tons de Cinza", "E. L. James", "Intrínseca", "123", "978-8580572186", 2, 2012,
                "Erótico", 8));

        listaLivros.add(new Livro("1984", "George Orwell", "Companhia das Letras", "123", "978-8535914849", 1, 2009,
                "Ficção Distópica, Sci-fi, Ficção Política", 3));

        // REVISTAS
        listaRevistas.add(new Revista("Veja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7122"));

        listaRevistas.add(new Revista("Xeja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7135"));

        listaRevistas.add(new Revista("Geja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7127"));

        listaRevistas.add(new Revista("Beja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7182"));
        // NAVEGAÇÃO DO SISTEMA
        do {
            switch (opcao0) {
                case 0:
                    System.out.println("\n============================\n\tBibliotecaOS\n\t    v1.0\n============================");
                    // OPÇÕES E INPUT
                    System.out.println("\nBem-vindo(a), usuário(a)! Insira o número correspondente à opção desejada:");
                    System.out.println("\n[1] Cadastrar \n[2] Filtrar \n[3] Listar \n[4] Espaço livre\n[5] Créditos\n[6] Sair\n");
                    opcao0 = verificarInt("> ");
                    break;
                case 1:
                    // CADASTRAR
                    cadastrarLivroRevista();
                    opcao0 = 0;
                    break;
                case 2:
                    // FILTRAR
                    filtrarLivroRevista();
                    opcao0 = 0;
                    break;
                case 3:
                    // LISTAR
                    listarLivroRevista();
                    opcao0 = 0;
                    break;
                case 4:
                    // GERENCIAR ESPAÇO
                    gerenciarEspacoLivrosRevistas();
                    opcao0 = 0;
                    break;
                case 5:
                    // ABRIR PÁGINA DO GIT
                    abrirPagWeb("https://github.com/delunatriestocode");
                    opcao0 = 0;
                case 6:
                    // SAIR
                    break;
                default:
                    System.out.println(opcaoInvalidaString);
                    esperar(1000);
                    opcao0 = 0;
            }
            // SAIR
            if (opcao0 == 6) {
                System.out.println("\n===========================\n\tTchauzinho!\n===========================\n");
                //escrever no arquivo
                String listaLivrostxt = "", listaLivrosLinha;
                for (int i = 0; i < listaLivros.size(); i++) {
                    listaLivrosLinha = String.format("%s; %s; %s; %s; %s; %d; %d; %s; %d\n", listaLivros.get(i).getNome(), listaLivros.get(i).getAutor(), listaLivros.get(i).getEditora(), listaLivros.get(i).getCDD(), listaLivros.get(i).getISBN(), listaLivros.get(i).getEdicao(), listaLivros.get(i).getAnoPublicacao(), listaLivros.get(i).getSecao(), listaLivros.get(i).getPrateleira());
                    listaLivrostxt += listaLivrosLinha;
                }
                //System.out.println(listaLivrostxt);
                try {
                    BufferedWriter arquivoLivro = new BufferedWriter(new FileWriter(caminhoArquivoLivro));
                    arquivoLivro.write(listaLivrostxt);
                    arquivoLivro.close();
                } catch (IOException e) {
                    System.out.println("ERRO: O arquivo não pode ser atualizado com sucesso :( \n" + e.getMessage());
                }
                break;
            }
        } while (true);
        // FECHAR SCANNER
        scanner.close();
    }

    // MÉTODO QUE PAUSA O PROGRAMA POR X MILISSEGUNDOS 
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // INPUTS EM INT
    public static int verificarInt(String msg) {
        int atributo = 0;
        do {                                                                                                                                                          
            try {
                System.out.print(msg);
                atributo = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                //scanner.next();
            }
        } while (true);
        scanner.nextLine(); 
        return atributo;
    }

    // INPUTS EM DOUBLE
    public static double verificarDouble(String msg) {
        double atributo = 0;                                                                                                                                                        
        do {       
            try {
                System.out.print(msg);
                atributo = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                //scanner.next();
            }
        } while (true);
        scanner.nextLine(); 
        return atributo;
    }

    // INPUT EM STRINGS
    public static String verificarString(String msg) {
        String atributo = "";

        do {
            System.out.print(msg);
            atributo = scanner.nextLine();
            if (!atributo.trim().isEmpty()) {
                break;
            }
        } while (true);
        return atributo;
    }

    // CHECAR SE O ARRAY DE LIVROS ESTÁ ORGANIZADO
    public static boolean listaLivrosEstaOrganizada(ArrayList<Livro> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getNome().toUpperCase().compareTo(lista.get(k+1).getNome().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }

    // CHECAR SE O ARRAY DE REVISTAS ESTÁ ORGANIZADO
    public static boolean listaRevistasEstaOrganizada(ArrayList<Revista> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getNome().toUpperCase().compareTo(lista.get(k+1).getNome().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }

    // MÉTODO QUE ABRE UMA PÁGINA DA WEB
    public static void abrirPagWeb(String link) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(link));
            } else {
                System.out.println("========================\n\tCréditos\n========================\n");
                System.out.println("Criado por TheLuna\nGithub: delunatriestocode\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }

    // MÉTODO QUE CADASTRA LIVRO/REVISTA
    public static void cadastrarLivroRevista() {
        try {
            do {
                System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                int opcao1 = verificarInt("> ");
                if (opcao1 == 1) {
                    if (listaLivros.size() == 1000) {
                        System.out.println(listaCheiaString);
                        esperar(1500);
                        opcao0 = 0;
                    } else {
                        System.out.println("\n===================================\n\tCadastro de Livros\n===================================\n");
                    }
                } else if (opcao1 == 2) {
                    if (listaRevistas.size() == 1000) {
                        System.out.println(listaCheiaString);
                        esperar(1500);
                        opcao0 = 0;
                    } else {
                        System.out.println("\n===================================\n\tCadastro de Revistas\n===================================\n");
                    }
                } else if (opcao1 == 3) {
                    //SAIR
                    opcao0 = 0;
                    break;
                } else {
                    System.out.println(opcaoInvalidaString);
                } 
                        

                nome = verificarString("Insira o nome: ");
                autor = verificarString("Insira o autor: ");
                editora = verificarString("Insira a editora: ");
                CDD = verificarString("Insira o CDD: ");
                ISBN = verificarString("Insira o ISBN: ");
                if (opcao1 == 2) {
                    ISSN = verificarString("Insira o ISSN: ");
                }
                edicao = verificarInt("Insira a edição: ");
                anoPublicacao = verificarInt("Insira o ano de publicação: ");
                secao = verificarString("Insira o nome da seção onde está o livro/a revista: ");
                prateleira = verificarInt("Insira o número da prateleira onde está o livro/a revista: ");
                        
                // ADICIONAR À LISTA
                if (opcao1 == 1) {
                    listaLivros.add(new Livro(nome, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira));
                    opcao0 = 0;
                    break;
                } else if (opcao1 == 2) {
                    listaRevistas.add(new Revista(nome, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira, ISSN));
                    break;
                }
            } while (true); 
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }        
    }

    // FILTRAR LIVRO/REVISTA
    public static void filtrarLivroRevista() {
        try {
            do {
                System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                opcao2 = verificarInt("> ");
                switch (opcao2) {
                    case 1:
                        // LIVRO
                        filtrarLivro();
                        break;
                    case 2:
                        // REVISTA
                        filtrarRevista();
                        break;
                    case 3:
                        // SAIR
                        break;
                    default:
                        System.out.println(opcaoInvalidaString);
                        break;
                }
                // SAIR
                if (opcao2 == 3 || opcao2_bL == 10 || opcao2_bR == 11) {
                    opcao2_bL = 0;
                    opcao2_bR = 0;
                    break;
                }
            } while (true);
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }                      
    }

    // FILTRAR LIVRO
    public static void filtrarLivro() {
        try {
            if (listaLivros.size() == 0) {
                System.out.println(listaVaziaString);
            } else {
                do {
                    int atributoInt = 0;
                    String atributoString = "";
                    ArrayList<Livro> listaFiltrada = new ArrayList<>();

                    switch (opcao2_bL) {
                        case 0:
                            System.out.println("\n=============================\n\tFiltrar Livros\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                            opcao2_bL = verificarInt("> ");
                            break;
                        case 1:
                            // FILTRAR POR NOME
                            atributoString = verificarString("Insira o nome do livro: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getNome().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 2:
                            // FILTRAR POR AUTOR
                            atributoString = verificarString("Insira o nome do autor: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getAutor().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getAutor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 3:
                            // FILTRAR POR EDITORA
                            atributoString = verificarString("Insira o nome da editora: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getEditora().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getEditora());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 4: 
                            // FILTRAR POR CDD
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getCDD().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 5:
                            // FILTRAR POR ISBN
                            atributoString = verificarString("Insira o ISBN: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getISBN().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 6:
                            // FILTRAR POR EDIÇÃO
                            atributoInt = verificarInt("Insira a edição: ");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getEdicao() == atributoInt) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 7:
                            // FILTRAR POR ANO
                            atributoInt = verificarInt("Insira o ano: ");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getAnoPublicacao() == atributoInt) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 8:
                            // FILTRAR POR SEÇÃO
                            atributoString = verificarString("Insira a seção: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getSecao().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 9:
                            // FILTRAR POR PRATELEIRA
                            atributoInt = verificarInt("Insira o número da prateleira: ");
                            for (int i = 0; i < listaLivros.size(); i++) {
                                if (listaLivros.get(i).getPrateleira() == atributoInt) {
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bL = 0;
                            break;
                        case 10:
                            // SAIR
                            break;
                        default:
                            System.out.println(opcaoInvalidaString);
                            break;
                    }
                    System.out.println();
                    if (opcao2_bL == 10) {
                        break;
                    }
                } while (true);
            }
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }

    // FILTRAR REVISTA
    public static void filtrarRevista() {
        try {
            if (listaRevistas.size() == 0) {
                System.out.println(listaVaziaString);
            } else {
                do {
                    int atributoInt = 0;
                    String atributoString = "";
                    ArrayList<Livro> listaFiltrada = new ArrayList<>();

                    switch (opcao2_bR) {
                        case 0:
                            System.out.println("\n================================\n\tFiltrar Revistas\n================================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - ISSN \n[7] - Edição\n[8] - Ano de Publicação\n[9] - Seção\n[10] - Número da Prateleira\n[11] - Sair\n");
                            opcao2_bR = verificarInt("> ");
                            break;
                        case 1:
                            // FILTRAR POR NOME
                            atributoString = verificarString("Insira o nome da revista: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getNome().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 2:
                            // FILTRAR POR AUTOR
                            atributoString = verificarString("Insira o nome do autor: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getAutor().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getAutor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 3:
                            // FILTRAR POR EDITORA
                            atributoString = verificarString("Insira o nome da editora: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getEditora().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getEditora());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 4: 
                            // FILTRAR POR CDD
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getCDD().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 5:
                            // FILTRAR POR ISBN
                            atributoString = verificarString("Insira o ISBN: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getISBN().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 6:
                            // FILTRAR POR ISSN
                            atributoString = verificarString("Insira o ISSN: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getISSN().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 7:
                            // FILTRAR POR EDIÇÃO
                            atributoInt = verificarInt("Insira a edição: ");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getEdicao() == atributoInt) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 8:
                            // FILTRAR POR ANO
                            atributoInt = verificarInt("Insira o ano: ");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getAnoPublicacao() == atributoInt) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 9:
                            // FILTRAR POR SEÇÃO
                            atributoString = verificarString("Insira a seção: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getSecao().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 10:
                            // FILTRAR POR PRATELEIRA
                            atributoInt = verificarInt("Insira o número da prateleira: ");
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                if (listaRevistas.get(i).getPrateleira() == atributoInt) {
                                    listaFiltrada.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            opcao2_bR = 0;
                            break;
                        case 11:
                            // SAIR
                            break;
                        default:
                            System.out.println(opcaoInvalidaString);
                            break;
                    }
                    System.out.println();
                    if (opcao2_bR == 11) {
                        break;
                    }
                } while (true);
            }
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }

    // LISTAR LIVRO/REVISTA
    public static void listarLivroRevista() {
        int opcao3 = 0;
        try {
            do {
                switch (opcao3) {
                    case 0:
                    System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                    opcao3 = verificarInt("> ");
                        break;
                    case 1:
                        //LIVRO
                        listarLivro();
                        break;
                    case 2:
                        //REVISTA
                        listarRevista();
                        break;
                    case 3:
                        //SAIR
                        break;
                    default:
                        break;
                }
                if (opcao3 == 3 || opcao3_bL == 8 || opcao3_bR == 8) {
                    opcao3_bL = 0;
                    opcao3_bR = 0;
                    break;
                }
            } while (true);
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }
    
    // LISTAR LIVRO
    public static void listarLivro() {
        if (listaLivros.size() == 0) {
            //se a lista de livro estiver vazia
            System.out.println(listaVaziaString);
            esperar(1500);
            opcao0 = 0;
        } else {
            int minIndexL = 0;
            int maxIndexL = 4;
            int indexL = 0;

            do {
                switch (opcao3_bL) {
                    case 0:
                        int minPaginaL = (maxIndexL + 1) / 5;
                        int maxPaginaL = Math.round(listaLivros.size() / 5) > 0 ? Math.round(listaLivros.size() / 5) + 1 : 1;

                        System.out.println("\n===============================\n\tLista de Livros\n===============================\n");
                        // EXIBIR EM QUAL PÁGINA O USUÁRIO ESTÁ
                        System.out.printf("Página %d/%d:\n\n", minPaginaL, maxPaginaL);
                        // EXIBIR PÁGINA ATUAL (COMEÇANDO PELA PRIMEIRA)
                        for (int i = minIndexL; i <= maxIndexL; i++) {
                            try {
                                System.out.printf("%d - %s\n", i, listaLivros.get(i).getNome());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de um livro pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir livro da lista pelo ID\n[7] - Organizar lista alfabéticamente\n[8] - Sair");
                        opcao3_bL = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexL = verificarInt("Insira o ID do livro no qual você deseja acessar as informações: ");
                        System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", indexL, 
                                                                                                                                                                                    listaLivros.get(indexL).getNome(),
                                                                                                                                                                                    listaLivros.get(indexL).getAutor(),
                                                                                                                                                                                    listaLivros.get(indexL).getEditora(), 
                                                                                                                                                                                    listaLivros.get(indexL).getCDD(),
                                                                                                                                                                                    listaLivros.get(indexL).getISBN(), 
                                                                                                                                                                                    listaLivros.get(indexL).getEdicao(),
                                                                                                                                                                                    listaLivros.get(indexL).getAnoPublicacao(),
                                                                                                                                                                                    listaLivros.get(indexL).getSecao(),
                                                                                                                                                                                    listaLivros.get(indexL).getPrateleira());
                        
                        esperar(3000);
                        break;
                    case 2:
                        // PÁGINA ANTERIOR
                        if (minIndexL > 0) {
                            minIndexL -= 5;
                            maxIndexL -= 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                        }
                        opcao3_bL = 0;
                        break;
                    case 3:
                         // PRÓXIMA PÁGINA
                         if (listaLivros.size() > maxIndexL + 1) {
                            minIndexL += 5; 
                            maxIndexL += 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                        }
                        opcao3_bL = 0;
                        break;
                    case 4:
                        // PRIMEIRA PÁGINA
                        minIndexL = 0;
                        maxIndexL = 4;
                        opcao3_bL = 0;
                        break;
                    case 5: 
                        // ÚLTIMA PÁGINA
                        for (int i = 1; (i * 5) < listaLivros.size(); i++) {
                            minIndexL = 5 * i;
                            maxIndexL = 5 * (i + 1);
                        }
                        opcao3_bL = 0;
                        break;
                    case 6:
                        // EXCLUIR LIVRO DA LISTA
                        indexL = verificarInt("Insira o ID do livro no qual você deseja remover da lista: ");
                        listaLivros.remove(indexL);
                        opcao3_bL = 0;
                        break;
                    case 7:
                        // ORGANIZAR LISTA
                        do {
                            for (int i = 0; i < listaLivros.size() - 1; i++) {
                                Livro item1 = listaLivros.get(i);
                                Livro item2 = listaLivros.get(i + 1);
                                Livro temp = item1;
                                
                                if (item1.getNome().toUpperCase().compareTo(item2.getNome().toUpperCase()) > 0) {
                                    item1 = item2;
                                    item2 = temp;
                                    listaLivros.set(i, item1);
                                    listaLivros.set(i + 1, item2);
                                }
                            }
                        } while (!listaLivrosEstaOrganizada(listaLivros));
                        opcao3_bL = 0;
                        break;
                    case 8:
                        // SAIR
                        break;
                    default:
                        System.out.println(opcaoInvalidaString);
                        opcao3_bL = 0;
                        break;
                }
                if (opcao2_bL == 8) {
                    break;
                }
            } while (true);
        }
    }

    // LISTAR REVISTA
    public static void listarRevista() {
        if (listaLivros.size() == 0) {
            //se a lista de livro estiver vazia
            System.out.println(listaVaziaString);
            esperar(1500);
            opcao0 = 0;
        } else {
            int minIndexR = 0;
            int maxIndexR = 4;
            int indexR = 0;

            do {
                switch (opcao3_bR) {
                    case 0:
                        int minPaginaL = (maxIndexR + 1) / 5;
                        int maxPaginaL = Math.round(listaRevistas.size() / 5) > 0 ? Math.round(listaRevistas.size() / 5) + 1 : 1;

                        System.out.println("\n===============================\n\tLista de Revistas\n===============================\n");
                        // EXIBIR EM QUAL PÁGINA O USUÁRIO ESTÁ
                        System.out.printf("Página %d/%d:\n\n", minPaginaL, maxPaginaL);
                        // EXIBIR PÁGINA ATUAL (COMEÇANDO PELA PRIMEIRA)
                        for (int i = minIndexR; i <= maxIndexR; i++) {
                            try {
                                System.out.printf("%d - %s\n", i, listaRevistas.get(i).getNome());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de uma revista pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir revista da lista pelo ID\n[7] - Organizar lista alfabéticamente\n[8] - Sair");
                        opcao3_bR = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexR = verificarInt("Insira o ID do livro no qual você deseja acessar as informações: ");
                        System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nISSN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", indexR, 
                                                                                                                                                                                    listaRevistas.get(indexR).getNome(),
                                                                                                                                                                                    listaRevistas.get(indexR).getAutor(),
                                                                                                                                                                                    listaRevistas.get(indexR).getEditora(), 
                                                                                                                                                                                    listaRevistas.get(indexR).getCDD(),
                                                                                                                                                                                    listaRevistas.get(indexR).getISBN(), 
                                                                                                                                                                                    listaRevistas.get(indexR).getISSN(),
                                                                                                                                                                                    listaRevistas.get(indexR).getEdicao(),
                                                                                                                                                                                    listaRevistas.get(indexR).getAnoPublicacao(),
                                                                                                                                                                                    listaRevistas.get(indexR).getSecao(),
                                                                                                                                                                                    listaRevistas.get(indexR).getPrateleira());
                        
                        esperar(3000);
                        break;
                    case 2:
                        // PÁGINA ANTERIOR
                        if (minIndexR > 0) {
                            minIndexR -= 5;
                            maxIndexR -= 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                        }
                        opcao3_bR = 0;
                        break;
                    case 3:
                         // PRÓXIMA PÁGINA
                         if (listaRevistas.size() > maxIndexR + 1) {
                            minIndexR += 5; 
                            maxIndexR += 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                        }
                        opcao3_bR = 0;
                        break;
                    case 4:
                        // PRIMEIRA PÁGINA
                        minIndexR = 0;
                        maxIndexR = 4;
                        opcao3_bR = 0;
                        break;
                    case 5: 
                        // ÚLTIMA PÁGINA
                        for (int i = 1; (i * 5) < listaRevistas.size(); i++) {
                            minIndexR = 5 * i;
                            maxIndexR = 5 * (i + 1);
                        }
                        opcao3_bR = 0;
                        break;
                    case 6:
                        // EXCLUIR LIVRO DA LISTA
                        indexR = verificarInt("Insira o ID da revista no qual você deseja remover da lista: ");
                        listaRevistas.remove(indexR);
                        opcao3_bR = 0;
                        break;
                    case 7:
                        // ORGANIZAR LISTA
                        do {
                            for (int i = 0; i < listaRevistas.size() - 1; i++) {
                                Revista item1 = listaRevistas.get(i);
                                Revista item2 = listaRevistas.get(i + 1);
                                Revista temp = item1;
                                
                                if (item1.getNome().toUpperCase().compareTo(item2.getNome().toUpperCase()) > 0) {
                                    item1 = item2;
                                    item2 = temp;
                                    listaRevistas.set(i, item1);
                                    listaRevistas.set(i + 1, item2);
                                }
                            }
                        } while (!listaRevistasEstaOrganizada(listaRevistas));
                        opcao3_bR = 0;
                        break;
                    case 8:
                        // SAIR
                        break;
                    default:
                        System.out.println(opcaoInvalidaString);
                        opcao3_bR = 0;
                        break;
                }
                if (opcao2_bL == 8) {
                    break;
                }
            } while (true);
        }
    }

    // GERENCIAR ESPAÇO OCUPADO POR LIVRO/REVISTA
    public static void gerenciarEspacoLivrosRevistas() {
        String opcao4 = "";
        try {
            do {
                System.out.println("================================\n\tGerenciar Espaço\n================================");
                // espaço livre
                System.out.printf("\nEspaço ocupado (livros): %d/1000", listaLivros.size());
                System.out.printf("\nEspaço ocupado (revistas): %d/1000", listaRevistas.size());
                // opção de input + input do usuário
                System.out.println("\n\n[L] - Limpar a lista de livros\n[R] - Limpar a lista de revistas\n[S] - Sair");
                do {
                    opcao4 = verificarString("\n> ").toUpperCase().trim();
                    break;
                } while (true);
                if (opcao4.equals("L")) {
                    // LIMPAR LISTA LIVROS
                    String opcao4_B = "";
                    do {
                        System.out.println("Tem certeza que deseja limpar a lista de livros? Essa ação não poderá ser revertida (escreva \"S\" ou \"N\").");
                        opcao4_B = verificarString("> ").toUpperCase();
                        if (opcao4_B.equals("S")) {
                            listaLivros.clear();
                            break;
                        }
                    } while (true);
                } else if (opcao4.equals("R")) {
                    // LIMPAR LISTA REVISTAS
                    String opcao4_B = "";
                    do {
                        System.out.println("Tem certeza que deseja limpar a lista de revistas? Essa ação não poderá ser revertida (escreva \"S\" ou \"N\").");
                        opcao4_B = verificarString("> ").toUpperCase();
                        if (opcao4_B.equals("S")) {
                            listaRevistas.clear();
                            break;
                        }
                    } while (true);
                } else if (opcao4.equals("S")) {
                    // SAIR
                    break;
                } else {
                    //OPÇÃO INVÁLIDA
                    System.out.println(opcaoInvalidaString);
                }
            } while (true);
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
        opcao0 = 0;
    }
}