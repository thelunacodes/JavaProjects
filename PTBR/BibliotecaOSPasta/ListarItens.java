package PTBR.BibliotecaOSPasta;

import java.util.ArrayList;
import java.util.Scanner;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;

public class ListarItens {
    static Scanner scanner = new Scanner(System.in);    

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
    // LISTAR LIVRO/REVISTA
    public static void listarItens() {
        try {
            do {
                switch (BibliotecaOS.opcao3) {
                    case 0:
                    System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                    BibliotecaOS.opcao3 = verificarInt("> ");
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
                if (BibliotecaOS.opcao3 == 3 || BibliotecaOS.opcao3_bL == 8 || BibliotecaOS.opcao3_bR == 8) {
                    BibliotecaOS.opcao3_bL = 0;
                    BibliotecaOS.opcao3_bR = 0;
                    BibliotecaOS.opcao3 = 0;
                    break;
                }
            } while (true);
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }
    // MÉTODO QUE PAUSA O PROGRAMA POR X MILISSEGUNDOS 
    public static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    // LISTAR LIVRO
    public static void listarLivro() {
        if (BibliotecaOS.listaLivros.size() == 0) {
            //se a lista de livro estiver vazia
            System.out.println(BibliotecaOS.listaVaziaString);
            BibliotecaOS.opcao0 = 0;
            BibliotecaOS.opcao3 = 3;
            esperar(1500);
        } else {
            int minIndexL = 0;
            int maxIndexL = 4;
            int indexL = 0;

            do {
                switch (BibliotecaOS.opcao3_bL) {
                    case 0:
                        int minPaginaL = (maxIndexL + 1) / 5;
                        int maxPaginaL = Math.round(BibliotecaOS.listaLivros.size() / 5) > 0 ? Math.round(BibliotecaOS.listaLivros.size() / 5) + 1 : 1;

                        System.out.println("\n===============================\n\tLista de Livros\n===============================\n");
                        // EXIBIR EM QUAL PÁGINA O USUÁRIO ESTÁ
                        System.out.printf("Página %d/%d:\n\n", minPaginaL, maxPaginaL);
                        // EXIBIR PÁGINA ATUAL (COMEÇANDO PELA PRIMEIRA)
                        for (int i = minIndexL; i <= maxIndexL; i++) {
                            try {
                                System.out.printf("%d - %s\n", i, BibliotecaOS.listaLivros.get(i).getNome());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de um livro pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir livro da lista pelo ID\n[7] - Organizar lista alfabéticamente\n[8] - Sair");
                        BibliotecaOS.opcao3_bL = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexL = verificarInt("Insira o ID do livro no qual você deseja acessar as informações: ");
                        System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", indexL, 
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getNome(),
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getAutor(),
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getEditora(), 
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getCDD(),
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getISBN(), 
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getEdicao(),
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getAnoPublicacao(),
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getSecao(),
                                                                                                                                                                                    BibliotecaOS.listaLivros.get(indexL).getPrateleira());
                        
                        esperar(3000);
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                    case 2:
                        // PÁGINA ANTERIOR
                        if (minIndexL > 0) {
                            minIndexL -= 5;
                            maxIndexL -= 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                    case 3:
                         // PRÓXIMA PÁGINA
                         if (BibliotecaOS.listaLivros.size() > maxIndexL + 1) {
                            minIndexL += 5; 
                            maxIndexL += 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                    case 4:
                        // PRIMEIRA PÁGINA
                        minIndexL = 0;
                        maxIndexL = 4;
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                    case 5: 
                        // ÚLTIMA PÁGINA
                        for (int i = 1; (i * 5) < BibliotecaOS.listaLivros.size(); i++) {
                            minIndexL = 5 * i;
                            maxIndexL = 5 * (i + 1);
                        }
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                    case 6:
                        // EXCLUIR LIVRO DA LISTA
                        indexL = verificarInt("Insira o ID do livro no qual você deseja remover da lista: ");
                        BibliotecaOS.listaLivros.remove(indexL);
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                    case 7:
                        // ORGANIZAR LISTA
                        do {
                            for (int i = 0; i < BibliotecaOS.listaLivros.size() - 1; i++) {
                                Livro item1 = BibliotecaOS.listaLivros.get(i);
                                Livro item2 = BibliotecaOS.listaLivros.get(i + 1);
                                Livro temp = item1;
                                
                                if (item1.getNome().toUpperCase().compareTo(item2.getNome().toUpperCase()) > 0) {
                                    item1 = item2;
                                    item2 = temp;
                                    BibliotecaOS.listaLivros.set(i, item1);
                                    BibliotecaOS.listaLivros.set(i + 1, item2);
                                }
                            }
                        } while (!listaLivrosEstaOrganizada(BibliotecaOS.listaLivros));
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                    case 8:
                        // SAIR
                        break;
                    default:
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                }
                if (BibliotecaOS.opcao3_bL == 8) {
                    BibliotecaOS.opcao0 = 0;
                    break;
                }
            } while (true);
        }
    }
    // LISTAR REVISTA
    public static void listarRevista() {
        if (BibliotecaOS.listaRevistas.size() == 0) {
            //se a lista de livro estiver vazia
            System.out.println(BibliotecaOS.listaVaziaString);
            BibliotecaOS.opcao0 = 0;
            BibliotecaOS.opcao3 = 3;
            esperar(1500);    
        } else {
            int minIndexR = 0;
            int maxIndexR = 4;
            int indexR = 0;

            do {
                switch (BibliotecaOS.opcao3_bR) {
                    case 0:
                        int minPaginaL = (maxIndexR + 1) / 5;
                        int maxPaginaL = Math.round(BibliotecaOS.listaRevistas.size() / 5) > 0 ? Math.round(BibliotecaOS.listaRevistas.size() / 5) + 1 : 1;

                        System.out.println("\n===============================\n\tLista de Revistas\n===============================\n");
                        // EXIBIR EM QUAL PÁGINA O USUÁRIO ESTÁ
                        System.out.printf("Página %d/%d:\n\n", minPaginaL, maxPaginaL);
                        // EXIBIR PÁGINA ATUAL (COMEÇANDO PELA PRIMEIRA)
                        for (int i = minIndexR; i <= maxIndexR; i++) {
                            try {
                                System.out.printf("%d - %s\n", i, BibliotecaOS.listaRevistas.get(i).getNome());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de uma revista pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir revista da lista pelo ID\n[7] - Organizar lista alfabéticamente\n[8] - Sair");
                        BibliotecaOS.opcao3_bR = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexR = verificarInt("Insira o ID do livro no qual você deseja acessar as informações: ");
                        System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nISSN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", indexR, 
                        BibliotecaOS.listaRevistas.get(indexR).getNome(),
                        BibliotecaOS.listaRevistas.get(indexR).getAutor(),
                        BibliotecaOS.listaRevistas.get(indexR).getEditora(), 
                        BibliotecaOS.listaRevistas.get(indexR).getCDD(),
                        BibliotecaOS.listaRevistas.get(indexR).getISBN(), 
                        BibliotecaOS.listaRevistas.get(indexR).getISSN(),
                        BibliotecaOS.listaRevistas.get(indexR).getEdicao(),
                        BibliotecaOS.listaRevistas.get(indexR).getAnoPublicacao(),
                        BibliotecaOS.listaRevistas.get(indexR).getSecao(),
                        BibliotecaOS.listaRevistas.get(indexR).getPrateleira());
                        esperar(3000);
                        BibliotecaOS.opcao3_bL = 0;
                        break;
                    case 2:
                        // PÁGINA ANTERIOR
                        if (minIndexR > 0) {
                            minIndexR -= 5;
                            maxIndexR -= 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bR = 0;
                        break;
                    case 3:
                         // PRÓXIMA PÁGINA
                         if (BibliotecaOS.listaRevistas.size() > maxIndexR + 1) {
                            minIndexR += 5; 
                            maxIndexR += 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bR = 0;
                        break;
                    case 4:
                        // PRIMEIRA PÁGINA
                        minIndexR = 0;
                        maxIndexR = 4;
                        BibliotecaOS.opcao3_bR = 0;
                        break;
                    case 5: 
                        // ÚLTIMA PÁGINA
                        for (int i = 1; (i * 5) < BibliotecaOS.listaRevistas.size(); i++) {
                            minIndexR = 5 * i;
                            maxIndexR = 5 * (i + 1);
                        }
                        BibliotecaOS.opcao3_bR = 0;
                        break;
                    case 6:
                        // EXCLUIR LIVRO DA LISTA
                        indexR = verificarInt("Insira o ID da revista no qual você deseja remover da lista: ");
                        BibliotecaOS.listaRevistas.remove(indexR);
                        BibliotecaOS.opcao3_bR = 0;
                        break;
                    case 7:
                        // ORGANIZAR LISTA
                        do {
                            for (int i = 0; i < BibliotecaOS.listaRevistas.size() - 1; i++) {
                                Revista item1 = BibliotecaOS.listaRevistas.get(i);
                                Revista item2 = BibliotecaOS.listaRevistas.get(i + 1);
                                Revista temp = item1;
                                
                                if (item1.getNome().toUpperCase().compareTo(item2.getNome().toUpperCase()) > 0) {
                                    item1 = item2;
                                    item2 = temp;
                                    BibliotecaOS.listaRevistas.set(i, item1);
                                    BibliotecaOS.listaRevistas.set(i + 1, item2);
                                }
                            }
                        } while (!listaRevistasEstaOrganizada(BibliotecaOS.listaRevistas));
                        BibliotecaOS.opcao3_bR = 0;
                        break;
                    case 8:
                        // SAIR
                        break;
                    default:
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        BibliotecaOS.opcao3_bR = 0;
                        break;
                }
                if (BibliotecaOS.opcao3_bR == 8) {
                    break;
                }
            } while (true);
        }
    }
}
