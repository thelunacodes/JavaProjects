package PTBR.BibliotecaOSPastaNaoFinalizado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class BibliotecaOS {
    public static void main(String[] args) {

        /*
         * =================================================
         * Github: delunatriestocode
         * Linkedin: in/gabrielsilveiradeluna
         * =================================================
         */

        // atributos gerais
        Scanner scanner = new Scanner(System.in);
        String nomeLivro = "", autorLivro = "", editoraLivro = "", CDDLivro = "", ISBNLivro = "", secaoLivro = "";
        String nomeRevista = "", autorRevista = "", editoraRevista = "", CDDRevista = "", ISBNRevista = "",
                secaoRevista = "", ISSNRevista = "";
        int edicaoLivro = 0, anoPublicacaoLivro = 0, prateleiraLivro = 0, opcao0 = 0;
        int edicaoRevista = 0, anoPublicacaoRevista = 0, prateleiraRevista = 0;
        ArrayList<Livro> listaLivros = new ArrayList<Livro>();
        ArrayList<Revista> listaRevistas = new ArrayList<Revista>();

        listaLivros.add(new Livro("O Pequeno Principe", "Antoine de Saint-Exupéry", "Nova Fronteira", "843",
                "978-8520930144", 1, 2016, "Infantil, Fábula, Ficção", 10));

        listaLivros.add(new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowlling", "Rocco", "239",
                "978-8532530783", 1, 2017, "Infantil, Fantasia, Aventura, Ficção", 7));

        listaLivros
                .add(new Livro("Biblia Sagrada", "Deus", "Paulinas", "200", "978-8535611748", 1, 2005, "Religião", 4));

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

        // Revistas
        listaRevistas.add(new Revista("Veja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021,
                "política, cultura e econômia", 7, "0100-7122"));

        // Navegação do App
        do {
            switch (opcao0) {
                case 0:
                    // Intro
                    System.out.println(
                            "\n============================\n\tBibliotecaOS\n\t    v1.0\n============================");
                    System.out.println("\nBem-vindo(a), usuário(a)! Insira o número correspondente à opção desejada:");
                    System.out.println(
                            "\n[1] Cadastrar \n[2] Filtrar \n[3] Listar \n[4] Espaço livre\n[5] Créditos\n[6] Sair\n");
                    // Input
                    opcao0 = verificarInt("> ");
                    break;
                case 1:
                    // Cadastrar
                    do {
                        System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                        int opcao1 = verificarInt("> ");
                        if (opcao1 == 1) {
                            // Cadastro de Livro
                            if (listaLivros.size() < 1000) {
                                System.out.println(
                                        "\n===================================\n\tCadastro de Livros\n===================================\n");
                                // Nome
                                nomeLivro = verificarString("Insira o nome do livro: ");
                                // Autor
                                autorLivro = verificarString("Insira o autor do livro: ");
                                // Editora
                                editoraLivro = verificarString("Insira a editora do livro: ");
                                // CDD
                                CDDLivro = verificarString("Insira o CDD do livro: ");
                                // ISBN
                                ISBNLivro = verificarString("Insira o ISBN do livro: ");
                                // Edição
                                edicaoLivro = verificarInt("Insira a edição do livro: ");
                                // Ano de Publicação
                                anoPublicacaoLivro = verificarInt("Insira o ano de publicação do livro: ");
                                // Seção
                                secaoLivro = verificarString("Insira o nome da seção onde está o livro: ");
                                // Prateleira
                                prateleiraLivro = verificarInt("Insira o número da prateleira onde está o livro: ");
                                // Adicionar à lista
                                listaLivros.add(new Livro(nomeLivro, autorLivro, editoraLivro, CDDLivro, ISBNLivro,
                                        edicaoLivro, anoPublicacaoLivro, secaoLivro, prateleiraLivro));
                                opcao0 = 0;
                                break;
                            } else {
                                // JOptionPane.showMessageDialog(null, "A lista está cheia!");
                                System.out.println("ERRO: A lista está cheia!");
                                esperar(1500);
                                opcao0 = 0;
                            }
                        } else if (opcao1 == 2) {
                            // Cadastro de Revista
                            if (listaRevistas.size() < 1000) {
                                System.out.println(
                                        "\n===================================\n\tCadastro de Revistas\n===================================\n");
                                // Nome
                                nomeRevista = verificarString("Insira o nome da revista: ");
                                // Autor
                                autorRevista = verificarString("Insira o autor da revista: ");
                                // Editora
                                editoraRevista = verificarString("Insira a editora da revista: ");
                                // CDD
                                CDDRevista = verificarString("Insira o CDD da revista: ");
                                // ISBN
                                ISBNRevista = verificarString("Insira o ISBN da revista: ");
                                // ISSN
                                ISSNRevista = verificarString("Insira o ISSN da revista: ");
                                // Edição
                                edicaoRevista = verificarInt("Insira a edição da revista: ");
                                // Ano de Publicação
                                anoPublicacaoRevista = verificarInt("Insira o ano de publicação da revista: ");
                                // Seção
                                secaoRevista = verificarString("Insira o nome da seção onde está a revista: ");
                                // Prateleira
                                prateleiraRevista = verificarInt("Insira o número da prateleira onde está a revista: ");
                                // Adicionar à lista
                                listaRevistas.add(new Revista(nomeRevista, autorRevista, editoraRevista, CDDRevista,
                                        ISBNRevista, edicaoRevista, anoPublicacaoRevista, secaoRevista,
                                        prateleiraRevista, ISSNRevista));
                                opcao0 = 0;
                                break;
                            } else {
                                System.out.println("ERRO: A lista está cheia!");
                                esperar(1500);
                                opcao0 = 0;
                            }
                        } else if (opcao1 == 3) {
                            // sair
                        } else {
                            System.out.println("Opção inválida!");
                        }
                        // sair
                        if (opcao1 == 3) {
                            opcao0 = 0;
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    // Filtrar
                    int opcao2 = 0;
                    int opcao2_b = 0;
                    do {
                        System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                        opcao2 = verificarInt("> ");
                        if (opcao2 == 1) {
                            // Filtrar livro
                            do {
                                int atributoInt = 0;
                                ArrayList<Livro> listaFiltrada = new ArrayList<Livro>();
                                String atributoString = "";

                                System.out.println(
                                        "\n=============================\n\tFiltrar Livros\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                                opcao2_b = verificarInt("\n> ");
                                // FILTRAR POR NOME
                                if (opcao2_b == 1) {
                                    atributoString = verificarString("Insira o nome do livro: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getNome().toUpperCase().trim());
                                        if (listaLivros.get(i).getNome().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            // System.out.println(listaLivros.get(i).getNome().toUpperCase().trim().contains(atributoString));
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
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
                                    // FILTRAR POR AUTOR
                                } else if (opcao2_b == 2) {
                                    atributoString = verificarString("Insira o nome do autor: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getAutor().toUpperCase().replace("
                                        // ",""));
                                        if (listaLivros.get(i).getAutor().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltrada.size(); j++) {
                                            System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                                    listaFiltrada.get(j).getAutor());
                                        }
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR EDITORA
                                } else if (opcao2_b == 3) {
                                    atributoString = verificarString("Insira o nome da editora: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getEditora().toUpperCase().replace("
                                        // ",""));
                                        if (listaLivros.get(i).getEditora().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltrada.size(); j++) {
                                            System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                                    listaFiltrada.get(j).getEditora());
                                        }
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR CDD
                                } else if (opcao2_b == 4) {
                                    atributoString = verificarString("Insira o CDD: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getCDD().toUpperCase().replace("
                                        // ",""));
                                        if (listaLivros.get(i).getCDD().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltrada.size(); j++) {
                                            System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                                    listaFiltrada.get(j).getNome());
                                        }
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR ISBN
                                } else if (opcao2_b == 5) {
                                    atributoString = verificarString("Insira o ISBN: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getISBN().toUpperCase().replace("
                                        // ",""));
                                        if (listaLivros.get(i).getISBN().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltrada.size(); j++) {
                                            System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                                    listaFiltrada.get(j).getNome());
                                        }
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR EDIÇÃO
                                } else if (opcao2_b == 6) {
                                    atributoInt = verificarInt("Insira a edição: ");
                                    // System.out.println(atributoInt);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getEdicao());
                                        if (listaLivros.get(i).getEdicao() == atributoInt) {
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltrada.size(); j++) {
                                            System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                                    listaFiltrada.get(j).getNome());
                                        }
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR ANO DE PUBLICAÇÃO
                                } else if (opcao2_b == 7) {
                                    atributoInt = verificarInt("Insira o ano: ");
                                    // System.out.println(atributoInt);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getAnoPublicacao().toUpperCase().replace("
                                        // ",""));
                                        if (listaLivros.get(i).getAnoPublicacao() == atributoInt) {
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltrada.size(); j++) {
                                            System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                                    listaFiltrada.get(j).getNome());
                                        }
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR SEÇÃO
                                } else if (opcao2_b == 8) {
                                    atributoString = verificarString("Insira a seção: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getSecao().toUpperCase().replace("
                                        // ",""));
                                        if (listaLivros.get(i).getSecao().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltrada.size(); j++) {
                                            System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                                    listaFiltrada.get(j).getNome());
                                        }
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR NÚMERO DE PRATELEIRA
                                } else if (opcao2_b == 9) {
                                    atributoInt = verificarInt("Insira o número da prateleira: ");
                                    // System.out.println(atributoInt);
                                    for (int i = 0; i < listaLivros.size(); i++) {
                                        // System.out.println(listaLivros.get(i).getPrateleira().toUpperCase().replace("
                                        // ",""));
                                        if (listaLivros.get(i).getPrateleira() == atributoInt) {
                                            listaFiltrada.add(listaLivros.get(i));
                                        }
                                    }
                                    if (listaFiltrada.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltrada.size(); j++) {
                                            System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)),
                                                    listaFiltrada.get(j).getNome());
                                        }
                                        listaFiltrada.clear();
                                        esperar(1500);
                                    }
                                    // SAIR
                                } else if (opcao2_b == 10) {
                                    opcao0 = 0;
                                    break;
                                } else {
                                    System.out.println("ERRO: Opção inválida!");
                                }
                            } while (true);
                        } else if (opcao2 == 2) {
                            // Filtrar Revistas
                            do {
                                int atributoInt = 0;
                                ArrayList<Revista> listaFiltradaRevista = new ArrayList<Revista>();
                                String atributoString = "";

                                System.out.println(
                                        "\n=============================\n\tFiltrar Revistas\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                                opcao2_b = verificarInt("\n> ");
                                // FILTRAR POR NOME
                                if (opcao2_b == 1) {
                                    atributoString = verificarString("Insira o nome da revista: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getNome().toUpperCase().trim());
                                        if (listaRevistas.get(i).getNome().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            // System.out.println(listaRevistas.get(i).getNome().toUpperCase().trim().contains(atributoString));
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getNome());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR AUTOR
                                } else if (opcao2_b == 2) {
                                    atributoString = verificarString("Insira o nome do autor: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getAutor().toUpperCase().replace("
                                        // ",""));
                                        if (listaRevistas.get(i).getAutor().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("\n%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getAutor());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR EDITORA
                                } else if (opcao2_b == 3) {
                                    atributoString = verificarString("Insira o nome da editora: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getEditora().toUpperCase().replace("
                                        // ",""));
                                        if (listaRevistas.get(i).getEditora().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("\n%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getEditora());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR CDD
                                } else if (opcao2_b == 4) {
                                    atributoString = verificarString("Insira o CDD: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getCDD().toUpperCase().replace("
                                        // ",""));
                                        if (listaRevistas.get(i).getCDD().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("\n%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getNome());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR ISBN
                                } else if (opcao2_b == 5) {
                                    atributoString = verificarString("Insira o ISBN: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getISBN().toUpperCase().replace("
                                        // ",""));
                                        if (listaRevistas.get(i).getISBN().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("\n%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getNome());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR EDIÇÃO
                                } else if (opcao2_b == 6) {
                                    atributoInt = verificarInt("Insira a edição: ");
                                    // System.out.println(atributoInt);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getEdicao());
                                        if (listaRevistas.get(i).getEdicao() == atributoInt) {
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("\n%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getNome());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR ANO DE PUBLICAÇÃO
                                } else if (opcao2_b == 7) {
                                    atributoInt = verificarInt("Insira o ano: ");
                                    // System.out.println(atributoInt);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getAnoPublicacao().toUpperCase().replace("
                                        // ",""));
                                        if (listaRevistas.get(i).getAnoPublicacao() == atributoInt) {
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("\n%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getNome());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR SEÇÃO
                                } else if (opcao2_b == 8) {
                                    atributoString = verificarString("Insira a seção: ");
                                    atributoString = atributoString.toUpperCase().replace(" ", "");
                                    // System.out.println(atributoString);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getSecao().toUpperCase().replace("
                                        // ",""));
                                        if (listaRevistas.get(i).getSecao().toUpperCase().replace(" ", "")
                                                .contains(atributoString)) {
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("\n%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getNome());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // FILTRAR POR NÚMERO DE PRATELEIRA
                                } else if (opcao2_b == 9) {
                                    atributoInt = verificarInt("Insira o número da prateleira: ");
                                    // System.out.println(atributoInt);
                                    for (int i = 0; i < listaRevistas.size(); i++) {
                                        // System.out.println(listaRevistas.get(i).getPrateleira().toUpperCase().replace("
                                        // ",""));
                                        if (listaRevistas.get(i).getPrateleira() == atributoInt) {
                                            listaFiltradaRevista.add(listaRevistas.get(i));
                                        }
                                    }
                                    if (listaFiltradaRevista.size() == 0) {
                                        System.out.println("ERRO: Nenhum item encontrado.");
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    } else {
                                        for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                            System.out.printf("\n%d - %s\n",
                                                    listaRevistas.indexOf(listaFiltradaRevista.get(j)),
                                                    listaFiltradaRevista.get(j).getNome());
                                        }
                                        listaFiltradaRevista.clear();
                                        esperar(1500);
                                    }
                                    // SAIR
                                } else if (opcao2_b == 10) {
                                    opcao0 = 0;
                                    break;
                                } else {
                                    System.out.println("ERRO: Opção inválida!");
                                }
                            } while (true);
                        } else if (opcao2 == 3) {
                            // sair
                        } else {
                            System.out.println("Opção inválida");
                        }
                        if (opcao2 == 3 || opcao2_b == 10) {
                            opcao0 = 0;
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    // Listar
                    int opcao3 = 0;
                    String opcao3_b = "";
                    do {
                        System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                        opcao3 = verificarInt("> ");

                        if (opcao3 == 1) {
                            // Listar livros
                            if (listaLivros.size() == 0) {
                                System.out.println("ERRO: Não há nenhum livro cadastrado!");
                                esperar(1500);
                                opcao0 = 0;
                            } else {
                                int min_index = 0;
                                int max_index = 4;
                                int index = 0;

                                do {
                                    System.out.println(
                                            "\n===============================\n\tLista de Livros\n===============================\n");
                                    System.out.printf("Página %d/%d:\n\n", ((max_index + 1) / 5),
                                            (Math.round(listaLivros.size() / 5) > 0
                                                    ? Math.round(listaLivros.size() / 5) + 1
                                                    : 1));
                                    for (int i = min_index; i <= max_index; i++) {
                                        try {
                                            System.out.printf("%d - %s\n", i, listaLivros.get(i).getNome());
                                        } catch (IndexOutOfBoundsException e) {
                                            break;
                                        }
                                    }
                                    // Introdução + primeira página da lista
                                    System.out.println(
                                            "\n[I] - Acessar as informações de um livro pelo ID.\n[A] - Página anterior\n[D] - Próxima página\n[P] - Primeira página\n[U] - Última página\n[E] - Excluir livro da lista pelo ID\n[O] - Organizar lista alfabéticamente\n[S] - Sair");
                                    System.out.print("\n> ");
                                    opcao3_b = scanner.next().toUpperCase().trim();
                                    if (opcao3_b.equals("I")) {
                                        index = verificarInt(
                                                "Insira o ID do livro no qual você deseja acessar as informações: ");
                                        // Exibir informações
                                        System.out.printf(
                                                "\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n",
                                                index, listaLivros.get(index).getNome(),
                                                listaLivros.get(index).getAutor(),
                                                listaLivros.get(index).getEditora(), listaLivros.get(index).getCDD(),
                                                listaLivros.get(index).getISBN(), listaLivros.get(index).getEdicao(),
                                                listaLivros.get(index).getAnoPublicacao(),
                                                listaLivros.get(index).getSecao(),
                                                listaLivros.get(index).getPrateleira());
                                        scanner.nextLine(); // Limpar buffer
                                        esperar(3000);
                                    } else if (opcao3_b.equals("D")) {
                                        // PRÓXIMA PÁGINA
                                        if (listaLivros.size() > max_index + 1) {
                                            min_index += 5;
                                            max_index += 5;
                                        } else {
                                            System.out.println("ERRO: Não foi possível ir para a próxima página.");
                                            esperar(1500);
                                        }
                                    } else if (opcao3_b.equals("A")) {
                                        // PÁGINA ANTERIOR
                                        if (min_index > 0) {
                                            min_index -= 5;
                                            max_index -= 5;
                                        } else {
                                            System.out.println("ERRO: Não foi possível ir para a página anterior.");
                                            esperar(1500);
                                        }
                                    } else if (opcao3_b.equals("P")) {
                                        min_index = 0;
                                        max_index = 4;
                                    } else if (opcao3_b.equals("U")) {
                                        // ÚLTIMA PÁGINA
                                        for (int i = 1; (i * 5) < listaLivros.size(); i++) {
                                            min_index = 5 * i;
                                            max_index = 5 * (i + 1);
                                        }
                                    } else if (opcao3_b.equals("E")) {
                                        // EXCLUIR LIVRO DA LISTA
                                        index = verificarInt(
                                                "Insira o ID do livro no qual você deseja remover da lista: ");
                                        listaLivros.remove(index);
                                    } else if (opcao3_b.equals("O")) {
                                        Livro item1;
                                        Livro item2;
                                        Livro temp;
                                        int numitem1 = 0;
                                        int numitem2 = 0;

                                        // Colocar os números pro início da lista
                                        for (int j = 0; j < listaLivros.size(); j++) {
                                            if (Character.isDigit(listaLivros.get(j).getNome().charAt(0))) {
                                                Livro itemNum = listaLivros.get(j);
                                                listaLivros.remove(j);
                                                listaLivros.add(0, itemNum);
                                            }
                                        }

                                        do {
                                            for (int i = 0; i < listaLivros.size() - 1; i++) {
                                                item1 = listaLivros.get(i);
                                                item2 = listaLivros.get(i + 1);

                                                // Organizar nomes com número
                                                numitem1 = nomeComecaComNumero(item1.getNome());
                                                System.out.println(numitem1);
                                                numitem2 = nomeComecaComNumero(item2.getNome());
                                                System.out.println(numitem2);

                                                // Os dois nomes começam com números
                                                if (numitem1 != -999999999 && numitem2 != -999999999) {
                                                    if (numitem1 < numitem2) {
                                                        System.out.println("teste");
                                                        temp = item1;
                                                        item1 = item2;
                                                        item2 = temp;
                                                        listaLivros.set(i, item1);
                                                        listaLivros.set(i + 1, item2);
                                                    } else {
                                                        System.out.println("teste2");
                                                    }
                                                } else {
                                                    // Nenhum dos nomes começam com números
                                                    if (listaLivros.get(i).getNome().toUpperCase()
                                                            .charAt(0) > listaLivros
                                                                    .get(i + 1).getNome().toUpperCase().charAt(0)) {
                                                        item1 = listaLivros.get(i);
                                                        item2 = listaLivros.get(i + 1);
                                                        temp = item1;
                                                        item1 = item2;
                                                        item2 = temp;
                                                        listaLivros.set(i, item1);
                                                        listaLivros.set(i + 1, item2);
                                                    }
                                                }
                                            }
                                            System.out.println(listaLivrosEstaOrganizada(listaLivros, numitem1, numitem2));
                                        } while (!listaLivrosEstaOrganizada(listaLivros, numitem1, numitem2));
                                    } else if (opcao3_b.equals("S")) {
                                        // SAIR
                                        break;
                                    } else {
                                        // VALOR INVÁLIDO
                                        System.out.println("ERRO: Opção inválida!");
                                    }
                                } while (true);
                            }
                            opcao0 = 0;
                        } else if (opcao3 == 2) {
                            // Listar revistas
                            if (listaRevistas.size() == 0) {
                                System.out.println("ERRO: Não há nenhuma revista cadastrada!");
                                esperar(1500);
                                opcao0 = 0;
                            } else {
                                int min_index = 0;
                                int max_index = 4;
                                int index = 0;
                                do {
                                    System.out.println(
                                            "\n===============================\n\tLista de Revistas\n===============================\n");
                                    System.out.printf("Página %d/%d:\n\n", ((max_index + 1) / 5),
                                            (Math.round(listaRevistas.size() / 5) > 0
                                                    ? Math.round(listaRevistas.size() / 5)
                                                    : 1));
                                    for (int i = min_index; i <= max_index; i++) {
                                        try {
                                            System.out.printf("%d - %s\n", i, listaRevistas.get(i).getNome());
                                        } catch (IndexOutOfBoundsException e) {
                                            break;
                                        }
                                    }
                                    // Introdução + primeira página da lista
                                    System.out.println(
                                            "\n[I] - Acessar as informações de uma revista pelo ID.\n[A] - Página anterior\n[D] - Próxima página\n[P] - Primeira página\n[U] - Última página\n[E] - Excluir revista da lista pelo ID\n[O] - Organizar lista alfabéticamente\n[S] - Sair");
                                    System.out.print("\n> ");
                                    opcao3_b = scanner.next().toUpperCase().trim();
                                    if (opcao3_b.equals("I")) {
                                        index = verificarInt(
                                                "Insira o ID da revista no qual você deseja acessar as informações: ");
                                        // Exibir informações
                                        System.out.printf(
                                                "\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n",
                                                index, listaRevistas.get(index).getNome(),
                                                listaRevistas.get(index).getAutor(),
                                                listaRevistas.get(index).getEditora(),
                                                listaRevistas.get(index).getCDD(),
                                                listaRevistas.get(index).getISBN(),
                                                listaRevistas.get(index).getEdicao(),
                                                listaRevistas.get(index).getAnoPublicacao(),
                                                listaRevistas.get(index).getSecao(),
                                                listaRevistas.get(index).getPrateleira());
                                        scanner.nextLine(); // Limpar buffer
                                        esperar(3000);
                                    } else if (opcao3_b.equals("D")) {
                                        // PRÓXIMA PÁGINA
                                        if (listaRevistas.size() > max_index + 1) {
                                            min_index += 5;
                                            max_index += 5;
                                        } else {
                                            System.out.println("ERRO: Não foi possível ir para a próxima página.");
                                            esperar(1500);
                                        }
                                    } else if (opcao3_b.equals("A")) {
                                        // PÁGINA ANTERIOR
                                        if (min_index > 0) {
                                            min_index -= 5;
                                            max_index -= 5;
                                        } else {
                                            System.out.println("ERRO: Não foi possível ir para a página anterior.");
                                            esperar(1500);
                                        }
                                    } else if (opcao3_b.equals("P")) {
                                        min_index = 0;
                                        max_index = 4;
                                    } else if (opcao3_b.equals("U")) {
                                        // ÚLTIMA PÁGINA
                                        for (int i = 1; (i * 5) < listaRevistas.size(); i++) {
                                            min_index = 5 * i;
                                            max_index = 5 * (i + 1);
                                        }
                                    } else if (opcao3_b.equals("E")) {
                                        // EXCLUIR LIVRO DA LISTA
                                        index = verificarInt(
                                                "Insira o ID da revista no qual você deseja remover da lista: ");
                                        listaRevistas.remove(index);
                                    } else if (opcao3_b.equals("O")) {
                                        // organizar lista em ordem numérica
                                        // organizar lista em ordem alfabética aqui
                                        Revista item1;
                                        Revista item2;
                                        Revista temp;
                                        // int tentativas = 0;
                                        do {
                                            for (int i = 0; i < listaRevistas.size() - 1; i++) {
                                                if (listaRevistas.get(i).getNome().toUpperCase()
                                                        .charAt(0) > listaRevistas
                                                                .get(i + 1).getNome().toUpperCase().charAt(0)) {
                                                    item1 = listaRevistas.get(i);
                                                    item2 = listaRevistas.get(i + 1);
                                                    temp = item1;
                                                    item1 = item2;
                                                    item2 = temp;
                                                    listaRevistas.set(i, item1);
                                                    listaRevistas.set(i + 1, item2);
                                                }
                                            }
                                            // System.out.println(tentativas);
                                            // tentativas++;
                                        } while (!listaRevistasEstaOrganizada(listaRevistas));
                                        // System.out.println("Tentativas: " + tentativas);
                                    } else if (opcao3_b.equals("S")) {
                                        opcao0 = 0;
                                        // SAIR
                                        break;
                                    } else {
                                        // VALOR INVÁLIDO
                                        System.out.println("ERRO: Opção inválida!");
                                    }
                                } while (true);
                            }
                            opcao0 = 0;
                        } else if (opcao3 == 3) {
                            opcao0 = 0;
                            // sair
                        } else {
                            System.out.println("Opção inválida");
                        }
                        if (opcao3 == 3 || opcao3_b.equals("S")) {
                            break;
                        }
                    } while (true);
                    break;
                case 4:
                    String opcao4 = "";
                    do {
                        System.out.println("================================\n\tGerenciar Espaço\n================================");
                        System.out.printf("\nEspaço ocupado (livros): %d/1000", listaLivros.size());
                        System.out.printf("\nEspaço ocupado (revistas): %d/1000", listaRevistas.size());
                        System.out.println(
                                "\n\n[L] - Limpar a lista de livros\n[R] - Limpar a lista de revistas\n[S] - Sair");
                        do {
                            System.out.print("\n> ");
                            opcao4 = scanner.nextLine().toUpperCase().trim();
                            break;
                        } while (true);
                        if (opcao4.equals("L")) {
                            String opcao4_B = "";
                            do {
                                System.out.println(
                                        "Tem certeza que deseja limpar a lista de livros? Essa ação não poderá ser desfeita (escreva \"S\" ou \"N\").");
                                System.out.print("> ");
                                opcao4_B = scanner.nextLine().toUpperCase();
                                if (opcao4_B.equals("S")) {
                                    listaLivros.clear();
                                    break;
                                }
                            } while (true);
                        } else if (opcao4.equals("R")) {
                            String opcao4_B = "";
                            do {
                                System.out.println(
                                        "Tem certeza que deseja limpar a lista de revistas? Essa ação não poderá ser desfeita (escreva \"S\" ou \"N\").");
                                System.out.print("> ");
                                opcao4_B = scanner.nextLine().toUpperCase();
                                if (opcao4_B.equals("S")) {
                                    listaRevistas.clear();
                                    break;
                                }
                            } while (true);
                        } else if (opcao4.equals("S")) {
                            break;
                        } else {
                            System.out.println("ERRO: Opção inválida.");
                        }
                    } while (true);
                    opcao0 = 0;
                    break;
                case 5:
                    // Abrir página do git (se possível)
                    try {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            Desktop.getDesktop().browse(new URI("https://github.com/delunatriestocode"));
                        } else {
                            // System.out.println("========================\n\tCréditos\n========================\n");
                            // System.out.println("Criado por TheLuna\nGithub: delunatriestocode\n");
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    } catch (URISyntaxException e) {
                        System.out.println(e);
                    }
                    opcao0 = 0;
                case 6:
                    // Se o usuário tiver escolhido sair
                    break;
                default:
                    // Se o usuário tiver escolhido um número abaixo de 0 ou maior que 7
                    System.out.println("ERRO: Opção inválida!");
                    esperar(1000);
                    opcao0 = 0;
            }
            // Se o usuário tiver escolhido sair
            if (opcao0 == 6) {
                System.out.println("\n===========================\n\tTchauzinho!\n===========================\n");
                break;
            }
        } while (true);
        // Fechar scanner
        scanner.close();

    }

    // Método que pausa a aplicação por x milisegundos (1000 ms = 1 s)
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // Método que valida input em INT
    public static int verificarInt(String msg) {
        int atributo = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print(msg);
                atributo = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                scanner.next();
            }
        } while (true);
        return atributo;
    }

    // Método que valida input em DOUBLE
    public static double verificarDouble(String msg) {
        double atributo = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print(msg);
                atributo = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                scanner.next();
            }
        } while (true);
        return atributo;
    }

    // Método que valida Strings
    public static String verificarString(String msg) {
        String atributo = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(msg);
            atributo = scanner.nextLine();
            if (!atributo.trim().isEmpty()) {
                break;
            }
        } while (true);
        return atributo;
    }

    // Método que checa se o array de livros ta organizado
    public static boolean listaLivrosEstaOrganizada(ArrayList<Livro> lista, int numItem1, int numIntem2) {
        //verificar até onde vão os itens que começam com número
        int indexNumEnd = 0;
        for (int i = 0; i < lista.size() - 1; i++) {
            if (Character.isDigit(lista.get(i).getNome().toUpperCase().charAt(0))) {
                indexNumEnd++;
            } else {
                break;
            }
        }
        //checar se números estão ordenados
        for (int j = 0; j <= indexNumEnd; j++) {
            if (numItem1 < numIntem2) {
                return false;
            }
        }
        for (int k = indexNumEnd + 1; k < lista.size() - 1; k++) {
            if (lista.get(k).getNome().toUpperCase().charAt(0) > lista.get(k + 1).getNome().toUpperCase().charAt(0)) {
                return false;
            }
        }
        return true;
    }

    // Método que checa se o array de revistas ta organizado
    public static boolean listaRevistasEstaOrganizada(ArrayList<Revista> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            if (lista.get(i).getNome().toUpperCase().charAt(0) > lista.get(i + 1).getNome().toUpperCase().charAt(0)) {
                return false;
            }
        }
        return true;
    }

    // Método que checa se o nome de um livro/revista contém números, retornando
    // esses números
    public static int nomeComecaComNumero(String nome) {
        String numString = "";
        int num;
        boolean ehDigito = true;
        for (int i = 0; ehDigito; i++) {
            if (i < nome.length()) {
                if (Character.isDigit(nome.charAt(i))) {
                    numString = nome.substring(0, i + 1);
                } else {
                    ehDigito = false;
                    break;
                }
            } else {
                break;
            }
        }
        if (numString.isEmpty()) {
            return -999999999;
        } else {
            num = Integer.parseInt(numString);
            return num;
        }

    }
}