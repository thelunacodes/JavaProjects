package PTBR.BibliotecaOSPasta;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;

import java.util.ArrayList;

import static PTBR.BibliotecaOSPasta.Esperar.esperar;

public class FiltrarItens {
    // FILTRAR LIVRO/REVISTA
    public static void filtrarItens() {
        try {
            do {      
                switch (BibliotecaOS.opcao2) {
                    case 0:
                        System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                        BibliotecaOS.opcao2 = verificarInt("> ");
                        break;
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
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        break;
                }
                // SAIR
                if (BibliotecaOS.opcao2 == 3 || BibliotecaOS.opcao2_bL == 10 || BibliotecaOS.opcao2_bR == 11) {
                    BibliotecaOS.opcao2_bL = 0;
                    BibliotecaOS.opcao2_bR = 0;
                    BibliotecaOS.opcao2 = 0;
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
            if (BibliotecaOS.listaLivros.size() == 0) {
                System.out.println(BibliotecaOS.listaVaziaString);
                BibliotecaOS.opcao0 = 0;
                BibliotecaOS.opcao2 = 3;
                esperar(1500);
            } else {
                do {
                    int atributoInt = 0;
                    String atributoString = "";
                    ArrayList<Livro> listaFiltrada = new ArrayList<>();

                    switch (BibliotecaOS.opcao2_bL) {
                        case 0:
                            System.out.println("\n=============================\n\tFiltrar Livros\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
                            BibliotecaOS.opcao2_bL = verificarInt("> ");
                            break;
                        case 1:
                            // FILTRAR POR NOME
                            atributoString = verificarString("Insira o nome do livro: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getNome().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 2:
                            // FILTRAR POR AUTOR
                            atributoString = verificarString("Insira o nome do autor: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getAutor().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getAutor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 3:
                            // FILTRAR POR EDITORA
                            atributoString = verificarString("Insira o nome da editora: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getEditora().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getEditora());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 4: 
                            // FILTRAR POR CDD
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getCDD().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 5:
                            // FILTRAR POR ISBN
                            atributoString = verificarString("Insira o ISBN: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getISBN().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 6:
                            // FILTRAR POR EDIÇÃO
                            atributoInt = verificarInt("Insira a edição: ");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getEdicao() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 7:
                            // FILTRAR POR ANO
                            atributoInt = verificarInt("Insira o ano: ");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getAnoPublicacao() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 8:
                            // FILTRAR POR SEÇÃO
                            atributoString = verificarString("Insira a seção: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getSecao().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 9:
                            // FILTRAR POR PRATELEIRA
                            atributoInt = verificarInt("Insira o número da prateleira: ");
                            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                                if (BibliotecaOS.listaLivros.get(i).getPrateleira() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bL = 0;
                            break;
                        case 10:
                            // SAIR
                            break;
                        default:
                            System.out.println(BibliotecaOS.opcaoInvalidaString);
                            break;
                    }
                    System.out.println();
                    if (BibliotecaOS.opcao2_bL == 10) {
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
            if (BibliotecaOS.listaRevistas.size() == 0) {
                System.out.println(BibliotecaOS.listaVaziaString);
                BibliotecaOS.opcao0 = 0;
                BibliotecaOS.opcao2 = 3;
                esperar(1500);
            } else {
                do {
                    int atributoInt = 0;
                    String atributoString = "";
                    ArrayList<Livro> listaFiltrada = new ArrayList<>();

                    switch (BibliotecaOS.opcao2_bR) {
                        case 0:
                            System.out.println("\n================================\n\tFiltrar Revistas\n================================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - ISSN \n[7] - Edição\n[8] - Ano de Publicação\n[9] - Seção\n[10] - Número da Prateleira\n[11] - Sair\n");
                            BibliotecaOS.opcao2_bR = verificarInt("> ");
                            break;
                        case 1:
                            // FILTRAR POR NOME
                            atributoString = verificarString("Insira o nome da revista: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getNome().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 2:
                            // FILTRAR POR AUTOR
                            atributoString = verificarString("Insira o nome do autor: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getAutor().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getAutor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 3:
                            // FILTRAR POR EDITORA
                            atributoString = verificarString("Insira o nome da editora: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getEditora().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getEditora());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 4: 
                            // FILTRAR POR CDD
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getCDD().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 5:
                            // FILTRAR POR ISBN
                            atributoString = verificarString("Insira o ISBN: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getISBN().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 6:
                            // FILTRAR POR ISSN
                            atributoString = verificarString("Insira o ISSN: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getISSN().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 7:
                            // FILTRAR POR EDIÇÃO
                            atributoInt = verificarInt("Insira a edição: ");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getEdicao() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 8:
                            // FILTRAR POR ANO
                            atributoInt = verificarInt("Insira o ano: ");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getAnoPublicacao() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 9:
                            // FILTRAR POR SEÇÃO
                            atributoString = verificarString("Insira a seção: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getSecao().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 10:
                            // FILTRAR POR PRATELEIRA
                            atributoInt = verificarInt("Insira o número da prateleira: ");
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                                if (BibliotecaOS.listaRevistas.get(i).getPrateleira() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bR = 0;
                            break;
                        case 11:
                            // SAIR
                            break;
                        default:
                            System.out.println(BibliotecaOS.opcaoInvalidaString);
                            break;
                    }
                    System.out.println();
                    if (BibliotecaOS.opcao2_bR == 11) {
                        break;
                    }
                } while (true);
            }
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }

    
}
