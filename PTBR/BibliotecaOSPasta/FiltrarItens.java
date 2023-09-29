package PTBR.BibliotecaOSPasta;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;
import java.util.ArrayList;

import PTBR.BibliotecaOSPasta.Objetos.Artigo;
import PTBR.BibliotecaOSPasta.Objetos.CD;
import PTBR.BibliotecaOSPasta.Objetos.DVD;
import PTBR.BibliotecaOSPasta.Objetos.Livro;
import static PTBR.BibliotecaOSPasta.Esperar.esperar;

public class FiltrarItens {

    /*
     * =================================================
     * Github: delunatriestocode
     * Linkedin: in/gabrielsilveiradeluna
     * =================================================
     */

    // FILTRAR LIVRO/REVISTA
    public static void filtrarItens() {
        try {
            do {
                switch (BibliotecaOS.opcao2) {
                    case 0:
                        System.out.println("\nInsira o número correspondente à opção desejada:\n\n[1] Livro\n[2] Revista\n[3] Artigo \n[4] CD \n[5] DVD \n[6] Sair\n");
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
                        // ARTIGO
                        filtrarArtigo();
                        break;
                    case 4:
                        // CD
                        filtrarCD();
                        break;
                    case 5:
                        // DVD
                        filtrarDVD();
                        break;
                    case 6:
                        // SAIR
                        break;
                    default:
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        break;
                }
                // SAIR
                if (BibliotecaOS.opcao2 == 6 || BibliotecaOS.opcao2_bL == 10 || BibliotecaOS.opcao2_bR == 11 || BibliotecaOS.opcao2_bA == 7 || BibliotecaOS.opcao2_bC == 6 || BibliotecaOS.opcao2_bD == 10) {
                    BibliotecaOS.opcao2_bL = 0;
                    BibliotecaOS.opcao2_bR = 0;
                    BibliotecaOS.opcao2_bA = 0;
                    BibliotecaOS.opcao2_bC = 0;
                    BibliotecaOS.opcao2_bD = 0;
                    BibliotecaOS.opcao2 = 0;
                    break;
                }
            } while (true);
        } catch (Throwable e) {
            System.out.println(
                    "Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber()
                            + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
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
                            System.out.println(
                                    "\n=============================\n\tFiltrar Livros\n=============================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - Edição\n[7] - Ano de Publicação\n[8] - Seção\n[9] - Número da Prateleira\n[10] - Sair\n");
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
                                    System.out.printf("%d - %s\n",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaLivros.get(i).getAutor().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaLivros.get(i).getEditora().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaLivros.get(i).getCDD().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaLivros.get(i).getISBN().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
                                    System.out.printf("%d - %s\n",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
                                    System.out.printf("%d - %s\n",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaLivros.get(i).getSecao().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaLivros.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s\n",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaLivros.indexOf(listaFiltrada.get(j)),
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
        } catch (Throwable e) {
            System.out.println(
                    "Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
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
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaRevistas.get(i).getAutor().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaRevistas.get(i).getEditora().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaRevistas.get(i).getCDD().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaRevistas.get(i).getISBN().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaRevistas.get(i).getISSN().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                if (BibliotecaOS.listaRevistas.get(i).getSecao().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaRevistas.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s",
                                    BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)),
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
                                    System.out.printf("\n%d - %s", BibliotecaOS.listaRevistas.indexOf(listaFiltrada.get(j)), listaFiltrada.get(j).getNome());
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
        } catch (Throwable e) {
            System.out.println(
                    "Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }

    // FILTRAR ARTIGO
    public static void filtrarArtigo() {
        try {
            if (BibliotecaOS.listaArtigos.size() == 0) {
                System.out.println(BibliotecaOS.listaVaziaString);
                BibliotecaOS.opcao0 = 0;
                BibliotecaOS.opcao2 = 3;
                esperar(1500);
            } else {
                do {
                    int atributoInt = 0;
                    String atributoString = "";
                    ArrayList<Artigo> listaFiltrada = new ArrayList<>();

                    switch (BibliotecaOS.opcao2_bA) {
                        case 0:
                            System.out.println(
                                    "\n================================\n\tFiltrar Artigos\n================================\n\n[1] - DOI\n[2] - Chave\n[3] - Tema\n[4] - Autor\n[5] - Ano\n[6] - Instituto \n[7] - Sair\n");
                            BibliotecaOS.opcao2_bA = verificarInt("> ");
                            break;
                        case 1:
                            // FILTRAR POR DOI
                            atributoString = verificarString("Insira o DOI do artigo: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaArtigos.size(); i++) {
                                if (BibliotecaOS.listaArtigos.get(i).getDOI().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaArtigos.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s, %s (%d)\n", j, BibliotecaOS.listaArtigos.get(j).getTema(), BibliotecaOS.listaArtigos.get(j).getAutor(), BibliotecaOS.listaArtigos.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bA = 0;
                            break;
                        case 2:
                            // FILTRAR POR CHAVE
                            atributoString = verificarString("Insira a chave do artigo: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaArtigos.size(); i++) {
                                if (BibliotecaOS.listaArtigos.get(i).getChave().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaArtigos.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s, %s (%d)\n", j, BibliotecaOS.listaArtigos.get(j).getTema(), BibliotecaOS.listaArtigos.get(j).getAutor(), BibliotecaOS.listaArtigos.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bA = 0;
                            break;
                        case 3:
                            // FILTRAR POR TEMA
                            atributoString = verificarString("Insira o tema do artigo: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaArtigos.size(); i++) {
                                if (BibliotecaOS.listaArtigos.get(i).getTema().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaArtigos.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s, %s (%d)\n", j, BibliotecaOS.listaArtigos.get(j).getTema(), BibliotecaOS.listaArtigos.get(j).getAutor(), BibliotecaOS.listaArtigos.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bA = 0;
                            break;
                        case 4:
                            // FILTRAR POR AUTOR
                            atributoString = verificarString("Insira o CDD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaArtigos.size(); i++) {
                                if (BibliotecaOS.listaArtigos.get(i).getAutor().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaArtigos.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s, %s (%d)\n", j, BibliotecaOS.listaArtigos.get(j).getTema(), BibliotecaOS.listaArtigos.get(j).getAutor(), BibliotecaOS.listaArtigos.get(j).getAno());                       
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bA = 0;
                            break;
                        case 5:
                            // FILTRAR POR ANO
                            atributoInt = verificarInt("Insira o ano: ");
                            for (int i = 0; i < BibliotecaOS.listaArtigos.size(); i++) {
                                if (BibliotecaOS.listaArtigos.get(i).getAno() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaArtigos.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s, %s (%d)\n", j, BibliotecaOS.listaArtigos.get(j).getTema(), BibliotecaOS.listaArtigos.get(j).getAutor(), BibliotecaOS.listaArtigos.get(j).getAno());                       
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bA = 0;
                            break;
                        case 6:
                            // FILTRAR POR INSTITUTO
                            atributoString = verificarString("Insira o Instituto: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaArtigos.size(); i++) {
                                if (BibliotecaOS.listaArtigos.get(i).getInstituto().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaArtigos.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s, %s (%d)\n", j, BibliotecaOS.listaArtigos.get(j).getTema(), BibliotecaOS.listaArtigos.get(j).getAutor(), BibliotecaOS.listaArtigos.get(j).getAno());                       
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bA = 0;
                            break;
                        case 7:
                            // SAIR
                            break;
                        default:
                            System.out.println(BibliotecaOS.opcaoInvalidaString);
                            break;
                    }
                    System.out.println();
                    if (BibliotecaOS.opcao2_bA == 7) {
                        break;
                    }
                } while (true);
            }
        } catch (Throwable e) {
            System.out.println(
                    "Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }
    // FILTRAR REVISTA
    public static void filtrarCD() {
        try {
            if (BibliotecaOS.listaCDs.size() == 0) {
                System.out.println(BibliotecaOS.listaVaziaString);
                BibliotecaOS.opcao0 = 0;
                BibliotecaOS.opcao2 = 3;
                esperar(1500);
            } else {
                do {
                    int atributoInt = 0;
                    String atributoString = "";
                    ArrayList<CD> listaFiltrada = new ArrayList<>();

                    switch (BibliotecaOS.opcao2_bC) {
                        case 0:
                            System.out.println("\n================================\n\tFiltrar CDs\n================================\n\n[1] - Artista/Compositor\n[2] - Gravadora\n[3] - Álbum\n[4] - Ano\n[5] - UPC\n[11] - Sair\n");
                            BibliotecaOS.opcao2_bC = verificarInt("> ");
                            break;
                        case 1:
                            // FILTRAR POR ARTISTA/COMPOSITOR
                            atributoString = verificarString("Insira o artista/compositor do CD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaCDs.size(); i++) {
                                if (BibliotecaOS.listaCDs.get(i).getArtistaCompositor().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaCDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%s)\n", j, BibliotecaOS.listaCDs.get(j).getAlbum(), BibliotecaOS.listaCDs.get(j).getArtistaCompositor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bC = 0;
                            break;
                        case 2:
                            // FILTRAR POR GRAVADORA
                            atributoString = verificarString("Insira o nome da gravadora: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaCDs.size(); i++) {
                                if (BibliotecaOS.listaCDs.get(i).getGravadora().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaCDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%s)\n", j, BibliotecaOS.listaCDs.get(j).getAlbum(), BibliotecaOS.listaCDs.get(j).getArtistaCompositor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bC = 0;
                            break;
                        case 3:
                            // FILTRAR POR ALBUM
                            atributoString = verificarString("Insira o nome do Álbum: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaCDs.size(); i++) {
                                if (BibliotecaOS.listaCDs.get(i).getAlbum().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaCDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%s)\n", j, BibliotecaOS.listaCDs.get(j).getAlbum(), BibliotecaOS.listaCDs.get(j).getArtistaCompositor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bC = 0;
                            break;
                        case 4:
                            // FILTRAR POR ANO
                            atributoString = verificarString("Insira o ano: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaCDs.size(); i++) {
                                if (BibliotecaOS.listaCDs.get(i).getAno() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaCDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%s)\n", j, BibliotecaOS.listaCDs.get(j).getAlbum(), BibliotecaOS.listaCDs.get(j).getArtistaCompositor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bC = 0;
                            break;
                        case 5:
                            // FILTRAR POR UPC
                            atributoString = verificarString("Insira o UPC do CD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaCDs.size(); i++) {
                                if (BibliotecaOS.listaCDs.get(i).getUPC().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaCDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%s)\n", j, BibliotecaOS.listaCDs.get(j).getAlbum(), BibliotecaOS.listaCDs.get(j).getArtistaCompositor());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bC = 0;
                            break;
                        case 6:
                            // SAIR
                            break;
                        default:
                            System.out.println(BibliotecaOS.opcaoInvalidaString);
                            break;
                    }
                    System.out.println();
                    if (BibliotecaOS.opcao2_bC == 6) {
                        break;
                    }
                } while (true);
            }
        } catch (Throwable e) {
            System.out.println(
                    "Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber()
                            + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }

    // FILTRAR DVD
    public static void filtrarDVD() {
        try {
            if (BibliotecaOS.listaDVDs.size() == 0) {
                System.out.println(BibliotecaOS.listaVaziaString);
                BibliotecaOS.opcao0 = 0;
                BibliotecaOS.opcao2 = 3;
                esperar(1500);
            } else {
                do {
                    int atributoInt = 0;
                    String atributoString = "";
                    ArrayList<DVD> listaFiltrada = new ArrayList<>();

                    switch (BibliotecaOS.opcao2_bD) {
                        case 0:
                            System.out.println("\n================================\n\tFiltrar DVDs\n================================\n\n[1] - Nome\n[2] - Autor\n[3] - Editora\n[4] - CDD\n[5] - ISBN\n[6] - ISSN \n[7] - Edição\n[8] - Ano de Publicação\n[9] - Seção\n[10] - Número da Prateleira\n[11] - Sair\n");
                            BibliotecaOS.opcao2_bD = verificarInt("> ");
                            break;
                        case 1:
                            // FILTRAR POR NOME
                            atributoString = verificarString("Insira o nome do DVD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getNome().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("\n%d - %s",
                                            BibliotecaOS.listaDVDs.indexOf(listaFiltrada.get(j)),
                                            listaFiltrada.get(j).getNome());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 2:
                            // FILTRAR POR REGIÃO
                            atributoString = verificarString("Insira a região: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getRegiao().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%d)\n", j, BibliotecaOS.listaDVDs.get(j).getNome(), BibliotecaOS.listaDVDs.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 3:
                            // FILTRAR POR DISTRIBUIDORA
                            atributoString = verificarString("Insira o nome da distribuidora: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getDistribuidora().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%d)\n", j, BibliotecaOS.listaDVDs.get(j).getNome(), BibliotecaOS.listaDVDs.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 4:
                            // FILTRAR POR DURAÇÃO
                            atributoString = verificarString("Insira a duração (formato: ##h##m): ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getDuracao().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%d)\n", j, BibliotecaOS.listaDVDs.get(j).getNome(), BibliotecaOS.listaDVDs.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 5:
                            // FILTRAR POR SINOPSE
                            atributoString = verificarString("Insira a sinopse (ou parte dela): ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getSinopse().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%d)\n", j, BibliotecaOS.listaDVDs.get(j).getNome(), BibliotecaOS.listaDVDs.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 6:
                            // FILTRAR POR BONUS
                            atributoString = verificarString("Insira o conteúdo bônus do DVD: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getBonus().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%d)\n", j, BibliotecaOS.listaDVDs.get(j).getNome(), BibliotecaOS.listaDVDs.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 7:
                            // FILTRAR POR ANO
                            atributoInt = verificarInt("Insira o ano: ");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getAno() == atributoInt) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%d)\n", j, BibliotecaOS.listaDVDs.get(j).getNome(), BibliotecaOS.listaDVDs.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 8:
                            // FILTRAR POR GÊNERO
                            atributoString = verificarString("Insira o gênero: ");
                            atributoString = atributoString.toUpperCase().replace(" ", "");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getGenero().toUpperCase().replace(" ", "")
                                        .contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%d)\n", j, BibliotecaOS.listaDVDs.get(j).getNome(), BibliotecaOS.listaDVDs.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 9:
                            // FILTRAR POR UPC
                            atributoInt = verificarInt("Insira o UPC: ");
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                                if (BibliotecaOS.listaDVDs.get(i).getUPC().toUpperCase().replace(" ", "").contains(atributoString)) {
                                    listaFiltrada.add(BibliotecaOS.listaDVDs.get(i));
                                }
                            }
                            if (listaFiltrada.size() == 0) {
                                System.out.println(BibliotecaOS.nenhumItemEncontradoString);
                                listaFiltrada.clear();
                                esperar(1500);
                            } else {
                                for (int j = 0; j < listaFiltrada.size(); j++) {
                                    System.out.printf("%d - %s (%d)\n", j, BibliotecaOS.listaDVDs.get(j).getNome(), BibliotecaOS.listaDVDs.get(j).getAno());
                                }
                                listaFiltrada.clear();
                                esperar(1500);
                            }
                            BibliotecaOS.opcao2_bD = 0;
                            break;
                        case 10:
                            // SAIR
                            break;
                        default:
                            System.out.println(BibliotecaOS.opcaoInvalidaString);
                            break;
                    }
                    System.out.println();
                    if (BibliotecaOS.opcao2_bD == 10) {
                        break;
                    }
                } while (true);
            }
        } catch (Throwable e) {
            System.out.println(
                    "Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber()
                            + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }

}
