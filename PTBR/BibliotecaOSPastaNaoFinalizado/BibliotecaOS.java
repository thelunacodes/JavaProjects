package PTBR.BibliotecaOSPastaNaoFinalizado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaOS {
    public static void main(String[] args) {

        /*
        =================================================
        Github: delunatriestocode
        Linkedin: in/gabrielsilveiradeluna
        =================================================
        */

        //atributos gerais
        Scanner scanner = new Scanner(System.in);
        String nomeLivro = "", autorLivro = "", editoraLivro = "", CDDLivro = "", ISBNLivro = "", secaoLivro = "";
        String nomeRevista = "", autorRevista = "", editoraRevista = "", CDDRevista = "", ISBNRevista = "", secaoRevista = "", ISSNRevista = "";
        int edicaoLivro = 0, anoPublicacaoLivro = 0, prateleiraLivro = 0, opcao1 = 0;
        int edicaoRevista = 0, anoPublicacaoRevista = 0, prateleiraRevista = 0;
        ArrayList<Livro> listaLivros = new ArrayList<Livro>();
        ArrayList<Revista> listaRevistas = new ArrayList<Revista>();

        //LEMBRETES:
        //
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

            listaRevistas.add(new Revista("Veja", "Roberto Civita", "Abril", "123", "978-8523203245", 3000, 2021, "política, cultura e econômia", 7, "0100-7122"));

        //Navegação do App
        do {
            switch (opcao1) {
                case 0:
                    //Intro
                    System.out.println("\n============================\n\tBibliotecaOS\n\t    v1.0\n============================");
                    System.out.println("\nBem-vindo(a), usuário(a)! Insira o número correspondente à opção desejada:");
                    System.out.println("\n[1] Cadastrar Livro \n[2] Cadastrar Revista\n[3] Procurar Livro por palavra-chave \n[4] Procurar Revista por palavra-chave\n[5] Listar livros \n[6] Listar revistas\n[7] Espaço livre\n[8] Créditos\n[9] Sair\n");
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
                        autorLivro = verificarString("Insira o autor do livro: ");
                        //Editora
                        editoraLivro = verificarString("Insira a editora do livro: ");
                        //CDD
                        CDDLivro = verificarString("Insira o CDD do livro: ");
                        //ISBN
                        ISBNLivro = verificarString("Insira o ISBN do livro: ");
                        //Edição
                        edicaoLivro = verificarInt("Insira a edição do livro: ");
                        //Ano de Publicação
                        anoPublicacaoLivro = verificarInt("Insira o ano de publicação do livro: ");
                        //Seção
                        secaoLivro = verificarString("Insira o nome da seção onde está o livro: ");
                        //Prateleira
                        prateleiraLivro = verificarInt("Insira o número da prateleira onde está o livro: ");
                        //Adicionar à lista
                        listaLivros.add(new Livro(nomeLivro, autorLivro, editoraLivro, CDDLivro, ISBNLivro, edicaoLivro, anoPublicacaoLivro, secaoLivro, prateleiraLivro));
                        opcao1 = 0;
                    } else {
                       System.out.println("ERRO: A lista está cheia!");
                       esperar(1500);
                       opcao1 = 0;
                    }
                    break;
                case 2:
                    //Cadastrar revista
                    if (listaRevistas.size() < 1000) {
                        System.out.println("\n===================================\n\tCadastro de Revistas\n===================================\n");
                        //Nome
                        nomeRevista = verificarString("Insira o nome da revista: ");
                        //Autor
                        autorRevista = verificarString("Insira o autor da revista: ");
                        //Editora
                        editoraRevista = verificarString("Insira a editora da revista: ");
                        //CDD
                        CDDRevista = verificarString("Insira o CDD da revista: ");
                        //ISBN
                        ISBNRevista = verificarString("Insira o ISBN da revista: ");
                        //ISSN
                        ISSNRevista = verificarString("Insira o ISSN da revista: ");
                        //Edição
                        edicaoRevista = verificarInt("Insira a edição da revista: ");
                        //Ano de Publicação
                        anoPublicacaoRevista = verificarInt("Insira o ano de publicação da revista: ");
                        //Seção
                        secaoRevista = verificarString("Insira o nome da seção onde está a revista: ");
                        //Prateleira
                        prateleiraRevista = verificarInt("Insira o número da prateleira onde está a revista: ");
                        //Adicionar à lista
                        listaRevistas.add(new Revista(nomeRevista, autorRevista, editoraRevista, CDDRevista, ISBNRevista, edicaoRevista, anoPublicacaoRevista, secaoRevista, prateleiraRevista, ISSNRevista));
                        opcao1 = 0;
                    } else {
                       System.out.println("ERRO: A lista está cheia!");
                       esperar(1500);
                       opcao1 = 0;
                    }
                    break;
                case 3:
                    do {
                        int opcao2 = 0;
                        int atributoInt = 0;
                        ArrayList<Livro> listaFiltrada = new ArrayList<Livro>();
                        String atributoString = "";

                        System.out.println("\n=============================\n\tFiltrar Livros\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                        opcao2 = verificarInt("\n> ");
                        //FILTRAR POR NOME
                        if (opcao2 == 1 ) { 
                            atributoString = verificarString("Insira o nome do livro: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getNome().toUpperCase().trim());
                                if (listaLivros.get(i).getNome().toUpperCase().replace(" ","").contains(atributoString)) {
                                    //System.out.println(listaLivros.get(i).getNome().toUpperCase().trim().contains(atributoString));
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR AUTOR   
                        } else if (opcao2 == 2) {
                            atributoString = verificarString("Insira o nome do autor: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getAutor().toUpperCase().replace(" ",""));
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
                        } else if (opcao2 == 3) {
                            atributoString = verificarString("Insira o nome da editora: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getEditora().toUpperCase().replace(" ",""));
                                if (listaLivros.get(i).getEditora().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getEditora());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR CDD
                        } else if (opcao2 == 4) {
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getCDD().toUpperCase().replace(" ",""));
                                if (listaLivros.get(i).getCDD().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR ISBN
                        } else if (opcao2 == 5) {
                            atributoString = verificarString("Insira o ISBN: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getISBN().toUpperCase().replace(" ",""));
                                if (listaLivros.get(i).getISBN().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR EDIÇÃO
                        } else if (opcao2 == 6) {
                            atributoInt = verificarInt("Insira a edição: ");
                            //System.out.println(atributoInt);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getEdicao());
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
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR ANO DE PUBLICAÇÃO
                        } else if (opcao2 == 7) {
                            atributoInt = verificarInt("Insira o ano: ");
                            //System.out.println(atributoInt);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getAnoPublicacao().toUpperCase().replace(" ",""));
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
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR SEÇÃO
                        } else if (opcao2 == 8) {
                            atributoString = verificarString("Insira a seção: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getSecao().toUpperCase().replace(" ",""));
                                if (listaLivros.get(i).getSecao().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltrada.add(listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR NÚMERO DE PRATELEIRA
                        } else if (opcao2 == 9) {
                            atributoInt = verificarInt("Insira o número da prateleira: ");
                            //System.out.println(atributoInt);
                            for (int i = 0; i < listaLivros.size(); i++) {
                                //System.out.println(listaLivros.get(i).getPrateleira().toUpperCase().replace(" ",""));
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
                                    System.out.printf("\n%d - %s\n", listaLivros.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                        //SAIR
                        } else if (opcao2 == 10) {
                            opcao1 = 0;
                            break;
                        } else {
                            System.out.println("ERRO: Opção inválida!");
                        }
                    } while(true);
                    break;
                case 4:
                //Filtrar Revistas
                    do {
                        int opcao2 = 0;
                        int atributoInt = 0;
                        ArrayList<Revista> listaFiltradaRevista = new ArrayList<Revista>();
                        String atributoString = "";

                        System.out.println("\n=============================\n\tFiltrar Revistas\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                        opcao2 = verificarInt("\n> ");
                        //FILTRAR POR NOME
                        if (opcao2 == 1 ) { 
                            atributoString = verificarString("Insira o nome da revista: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getNome().toUpperCase().trim());
                                if (listaRevistas.get(i).getNome().toUpperCase().replace(" ","").contains(atributoString)) {
                                    //System.out.println(listaRevistas.get(i).getNome().toUpperCase().trim().contains(atributoString));
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR AUTOR   
                        } else if (opcao2 == 2) {
                            atributoString = verificarString("Insira o nome do autor: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getAutor().toUpperCase().replace(" ",""));
                                if (listaRevistas.get(i).getAutor().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getAutor());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR EDITORA
                        } else if (opcao2 == 3) {
                            atributoString = verificarString("Insira o nome da editora: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getEditora().toUpperCase().replace(" ",""));
                                if (listaRevistas.get(i).getEditora().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getEditora());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR CDD
                        } else if (opcao2 == 4) {
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getCDD().toUpperCase().replace(" ",""));
                                if (listaRevistas.get(i).getCDD().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR ISBN
                        } else if (opcao2 == 5) {
                            atributoString = verificarString("Insira o ISBN: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getISBN().toUpperCase().replace(" ",""));
                                if (listaRevistas.get(i).getISBN().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR EDIÇÃO
                        } else if (opcao2 == 6) {
                            atributoInt = verificarInt("Insira a edição: ");
                            //System.out.println(atributoInt);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getEdicao());
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
                                    System.out.printf("\n%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR ANO DE PUBLICAÇÃO
                        } else if (opcao2 == 7) {
                            atributoInt = verificarInt("Insira o ano: ");
                            //System.out.println(atributoInt);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getAnoPublicacao().toUpperCase().replace(" ",""));
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
                                    System.out.printf("\n%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR SEÇÃO
                        } else if (opcao2 == 8) {
                            atributoString = verificarString("Insira a seção: ");
                            atributoString = atributoString.toUpperCase().replace(" ","");
                            //System.out.println(atributoString);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getSecao().toUpperCase().replace(" ",""));
                                if (listaRevistas.get(i).getSecao().toUpperCase().replace(" ","").contains(atributoString)) {           
                                    listaFiltradaRevista.add(listaRevistas.get(i));
                                }
                            }
                            if (listaFiltradaRevista.size() == 0) {
                                System.out.println("ERRO: Nenhum item encontrado.");
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltradaRevista.size(); j++) {
                                    System.out.printf("\n%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //FILTRAR POR NÚMERO DE PRATELEIRA
                        } else if (opcao2 == 9) {
                            atributoInt = verificarInt("Insira o número da prateleira: ");
                            //System.out.println(atributoInt);
                            for (int i = 0; i < listaRevistas.size(); i++) {
                                //System.out.println(listaRevistas.get(i).getPrateleira().toUpperCase().replace(" ",""));
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
                                    System.out.printf("\n%d - %s\n", listaRevistas.indexOf(listaFiltradaRevista.get(j)), listaFiltradaRevista.get(j).getNome());
                                }
                                listaFiltradaRevista.clear();
                                esperar(1500);
                            }
                        //SAIR
                        } else if (opcao2 == 10) {
                            opcao1 = 0;
                            break;
                        } else {
                            System.out.println("ERRO: Opção inválida!");
                        }
                    } while(true);
                    break;
                case 5:
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
                            System.out.printf("Página %d/%d:\n\n", ((max_index+1) / 5), (Math.round(listaLivros.size() / 5) > 0 ? Math.round(listaLivros.size() / 5) : 1));
                            for (int i = min_index; i <= max_index; i++) {
                                try {
                                    System.out.printf("%d - %s\n", i, listaLivros.get(i).getNome());
                                }
                                catch (IndexOutOfBoundsException e) {
                                    break;
                                }
                            }
                            //Introdução + primeira página da lista
                            System.out.println("\n[I] - Acessar as informações de um livro pelo ID.\n[A] - Página anterior\n[D] - Próxima página\n[P] - Primeira página\n[U] - Última página\n[E] - Excluir livro da lista pelo ID\n[O] - Organizar lista alfabéticamente\n[S] - Sair");
                            System.out.print("\n> ");
                            opcao3 = scanner.next().toUpperCase().trim();
                            if (opcao3.equals("I")) {
                                index = verificarInt("Insira o ID do livro no qual você deseja acessar as informações: ");
                                //Exibir informações
                                System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", index, listaLivros.get(index).getNome(), listaLivros.get(index).getAutor(), listaLivros.get(index).getEditora(), listaLivros.get(index).getCDD(), listaLivros.get(index).getISBN(), listaLivros.get(index).getEdicao(), listaLivros.get(index).getAnoPublicacao(), listaLivros.get(index).getSecao(), listaLivros.get(index).getPrateleira());
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
                            } else if (opcao3.equals("E")) {
                                //EXCLUIR LIVRO DA LISTA
                                index = verificarInt("Insira o ID do livro no qual você deseja remover da lista: ");
                                listaLivros.remove(index);
                            } else if (opcao3.equals("O")) {
                                //organizar lista em ordem numérica
                                //organizar lista em ordem alfabética aqui
                                Livro item1;
                                Livro item2;
                                Livro temp;
                                //int tentativas = 0;
                                do {
                                    for (int i = 0; i < listaLivros.size() - 1; i++) {
                                        if (listaLivros.get(i).getNome().toUpperCase().charAt(0) > listaLivros.get(i+1).getNome().toUpperCase().charAt(0)) {
                                            item1 = listaLivros.get(i);
                                            item2 = listaLivros.get(i+1);
                                            temp = item1;
                                            item1 = item2;
                                            item2 = temp;
                                            listaLivros.set(i, item1);
                                            listaLivros.set(i+1, item2);
                                        }
                                    }
                                    // System.out.println(tentativas);
                                    // tentativas++;
                                } while (!listaLivrosEstaOrganizada(listaLivros));
                                //System.out.println("Tentativas: " + tentativas);
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
                case 6:
                    //Listar revistas
                    if (listaRevistas.size() == 0) {
                        System.out.println("ERRO: Não há nenhuma revista cadastrada!");
                        esperar(1500);
                        opcao1 = 0;
                    } else {
                        int min_index = 0;
                        int max_index = 4;
                        int index = 0;
                        String opcao3 = "";
                        do {
                            System.out.println("\n===============================\n\tLista de Revistas\n===============================\n");
                            System.out.printf("Página %d/%d:\n\n", ((max_index+1) / 5), (Math.round(listaRevistas.size() / 5) > 0 ? Math.round(listaRevistas.size() / 5) : 1));
                            for (int i = min_index; i <= max_index; i++) {
                                try {
                                    System.out.printf("%d - %s\n", i, listaRevistas.get(i).getNome());
                                }
                                catch (IndexOutOfBoundsException e) {
                                    break;
                                }
                            }
                            //Introdução + primeira página da lista
                            System.out.println("\n[I] - Acessar as informações de uma revista pelo ID.\n[A] - Página anterior\n[D] - Próxima página\n[P] - Primeira página\n[U] - Última página\n[E] - Excluir revista da lista pelo ID\n[O] - Organizar lista alfabéticamente\n[S] - Sair");
                            System.out.print("\n> ");
                            opcao3 = scanner.next().toUpperCase().trim();
                            if (opcao3.equals("I")) {
                                index = verificarInt("Insira o ID da revista no qual você deseja acessar as informações: ");
                                //Exibir informações
                                System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", index, listaRevistas.get(index).getNome(), listaRevistas.get(index).getAutor(), listaRevistas.get(index).getEditora(), listaRevistas.get(index).getCDD(), listaRevistas.get(index).getISBN(), listaRevistas.get(index).getEdicao(), listaRevistas.get(index).getAnoPublicacao(), listaRevistas.get(index).getSecao(), listaRevistas.get(index).getPrateleira());
                                scanner.nextLine(); //Limpar buffer
                                esperar(3000);
                            }else if (opcao3.equals("D")) {
                                //PRÓXIMA PÁGINA
                                if (listaRevistas.size() > max_index+1) {
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
                                for (int i = 1; (i * 5) < listaRevistas.size(); i++) {
                                    min_index = 5 * i;
                                    max_index = 5 * (i+1);
                                }
                            } else if (opcao3.equals("E")) {
                                //EXCLUIR LIVRO DA LISTA
                                index = verificarInt("Insira o ID da revista no qual você deseja remover da lista: ");
                                listaRevistas.remove(index);
                            } else if (opcao3.equals("O")) {
                                //organizar lista em ordem numérica
                                //organizar lista em ordem alfabética aqui
                                Revista item1;
                                Revista item2;
                                Revista temp;
                                //int tentativas = 0;
                                do {
                                    for (int i = 0; i < listaRevistas.size() - 1; i++) {
                                        if (listaRevistas.get(i).getNome().toUpperCase().charAt(0) > listaRevistas.get(i+1).getNome().toUpperCase().charAt(0)) {
                                            item1 = listaRevistas.get(i);
                                            item2 = listaRevistas.get(i+1);
                                            temp = item1;
                                            item1 = item2;
                                            item2 = temp;
                                            listaRevistas.set(i, item1);
                                            listaRevistas.set(i+1, item2);
                                        }
                                    }
                                    // System.out.println(tentativas);
                                    // tentativas++;
                                } while (!listaRevistasEstaOrganizada(listaRevistas));
                                //System.out.println("Tentativas: " + tentativas);
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
                case 7:
                    String opcao4 = "";
                    do {
                        System.out.println("=========================================\n\tGerenciar Espaço (livros)\n=========================================");
                        System.out.printf("\nEspaço ocupado (livros): %d/1000", listaLivros.size());
                        System.out.printf("\nEspaço ocupado (revistas): %d/1000", listaRevistas.size());
                        System.out.println("\n\n[L] - Limpar a lista de livros\n[R] - Limpar a lista de revistas\n[S] - Sair");
                        do {
                            System.out.print("\n> ");
                            opcao4 = scanner.nextLine().toUpperCase().trim();
                            break;
                        } while (true);
                        if (opcao4.equals("L")) {
                            String opcao4_B = "";
                                do {
                                    System.out.println("Tem certeza que deseja limpar a lista de livros? Essa ação não poderá ser desfeita (escreva \"S\" ou \"N\").");
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
                                    System.out.println("Tem certeza que deseja limpar a lista de revistas? Essa ação não poderá ser desfeita (escreva \"S\" ou \"N\").");
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
                    opcao1 = 0;
                    break;    
                case 8:
                    System.out.println("========================\n\tCréditos\n========================\n");
                    System.out.println("Criado por TheLuna\nGithub: delunatriestocode\n");
                    opcao1 = 0;
                    esperar(3000);
                case 9:
                    //Se o usuário tiver escolhido sair
                    break;
                default:
                    //Se o usuário tiver escolhido um número abaixo de 0 ou maior que 7
                    System.out.println("ERRO: Opção inválida!");
                    esperar(1000);
                    opcao1 = 0;
            }
            //Se o usuário tiver escolhido sair
            if (opcao1 == 9) {
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
    public static boolean listaLivrosEstaOrganizada(ArrayList<Livro> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            if (lista.get(i).getNome().toUpperCase().charAt(0) > lista.get(i+1).getNome().toUpperCase().charAt(0)) {
                return false;
            }
        }
        return true;
    }
    public static boolean listaRevistasEstaOrganizada(ArrayList<Revista> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            if (lista.get(i).getNome().toUpperCase().charAt(0) > lista.get(i+1).getNome().toUpperCase().charAt(0)) {
                return false;
            }
        }
        return true;
    }
}