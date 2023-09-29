package PTBR.BibliotecaOSPasta;

import java.util.ArrayList;
import java.util.Scanner;

import PTBR.BibliotecaOSPasta.Objetos.Artigo;
import PTBR.BibliotecaOSPasta.Objetos.CD;
import PTBR.BibliotecaOSPasta.Objetos.DVD;
import PTBR.BibliotecaOSPasta.Objetos.Livro;
import PTBR.BibliotecaOSPasta.Objetos.Revista;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;

public class ListarItens {
    
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */
    
    static Scanner scanner = new Scanner(System.in);    

    // LISTAR LIVRO/REVISTA
    public static void listarItens() {
        try {
            do {
                switch (BibliotecaOS.opcao3) {
                    case 0:
                    System.out.println("\nInsira o número correspondente à opção desejada:\n\n[1] Livro\n[2] Revista\n[3] Artigo \n[4] CD \n[5] DVD \n[6] Sair\n");
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
                        listarArtigos();
                        break;
                    case 4:
                        listarCDs();
                        break;
                    case 5:
                        listarDVDs();
                        break;
                    case 6:
                        //SAIR
                        break;
                    default:
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        break;
                }
                if (BibliotecaOS.opcao3 == 6 || BibliotecaOS.opcao3_bL == 8 || BibliotecaOS.opcao3_bR == 8 || BibliotecaOS.opcao3_bA == 8 || BibliotecaOS.opcao3_bC == 8 || BibliotecaOS.opcao3_bD == 8) {
                    BibliotecaOS.opcao3_bL = 0;
                    BibliotecaOS.opcao3_bR = 0;
                    BibliotecaOS.opcao3_bA = 0;
                    BibliotecaOS.opcao3_bC = 0;
                    BibliotecaOS.opcao3_bD = 0;
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
            boolean indexExiste = true;
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
                                System.out.printf("%d - %s\n", BibliotecaOS.listaLivros.get(i).getId(), BibliotecaOS.listaLivros.get(i).getNome());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de um livro pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir livro da lista pelo ID\n[7] - Organizar lista\n[8] - Sair");
                        BibliotecaOS.opcao3_bL = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexL = verificarInt("Insira o ID do livro no qual você deseja acessar as informações: ");
                        for (int j = 0; j < BibliotecaOS.listaLivros.size(); j++) {
                            if (BibliotecaOS.listaLivros.get(j).getId() == indexL) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaLivros.size(); k++) {
                                if (BibliotecaOS.listaLivros.get(k).getId() == indexL) {
                                    System.out.printf("\n\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", BibliotecaOS.listaLivros.get(k).getId(), 
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getNome(),
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getAutor(),
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getEditora(), 
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getCDD(),
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getISBN(), 
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getEdicao(),
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getAnoPublicacao(),
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getSecao(),
                                                                                                                                                                                        BibliotecaOS.listaLivros.get(k).getPrateleira());
                                } 
                            }
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }
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
                        for (int j = 0; j < BibliotecaOS.listaLivros.size(); j++) {
                            if (BibliotecaOS.listaLivros.get(j).getId() == indexL) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaLivros.size(); k++) {
                                if (BibliotecaOS.listaLivros.get(k).getId() == indexL) {
                                    BibliotecaOS.listaLivros.remove(k);
                                    System.out.println("Livro removido com sucesso!");
                                }
                            }
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }  
                        BibliotecaOS.opcao3_bL = 0;
                        esperar(3000);
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
            boolean indexExiste = true;
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
                                System.out.printf("%d - %s\n", BibliotecaOS.listaRevistas.get(i).getId(), BibliotecaOS.listaRevistas.get(i).getNome());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de uma revista pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir revista da lista pelo ID\n[7] - Organizar lista\n[8] - Sair");
                        BibliotecaOS.opcao3_bR = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexR = verificarInt("Insira o ID da revista no qual você deseja acessar as informações: ");
                        for (int j = 0; j < BibliotecaOS.listaRevistas.size(); j++) {
                            if (BibliotecaOS.listaRevistas.get(j).getId() == indexR) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaRevistas.size(); k++) {
                                if (BibliotecaOS.listaRevistas.get(k).getId() == indexR) {
                                    System.out.printf("\nID: %d\nNome: %s\nAutor: %s\nEditora: %s\nCDD: %s\nISBN: %s\nISSN: %s\nEdição: %d°\nAno de Publicação: %d\nSeção: %s\nPrateleira: %d\n", BibliotecaOS.listaRevistas.get(k).getId(), 
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getNome(),
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getAutor(),
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getEditora(), 
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getCDD(),
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getISBN(), 
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getISSN(), 
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getEdicao(),
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getAnoPublicacao(),
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getSecao(),
                                                                                                                                                                                            BibliotecaOS.listaRevistas.get(k).getPrateleira());
                                                                                                                                                                                        } 
                            }
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }
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
                        for (int j = 0; j < BibliotecaOS.listaRevistas.size(); j++) {
                            if (BibliotecaOS.listaRevistas.get(j).getId() == indexR) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaRevistas.size(); k++) {
                                if (BibliotecaOS.listaRevistas.get(k).getId() == indexR) {
                                    BibliotecaOS.listaRevistas.remove(k);
                                    System.out.println("Revista removida com sucesso!");
                                }
                            }
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }  
                        BibliotecaOS.opcao3_bR = 0;
                        esperar(3000);
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
    // LISTAR ARTIGO
    public static void listarArtigos() {
        if (BibliotecaOS.listaArtigos.size() == 0) {
            //se a lista de livro estiver vazia
            System.out.println(BibliotecaOS.listaVaziaString);
            BibliotecaOS.opcao0 = 0;
            BibliotecaOS.opcao3 = 3;
            esperar(1500);
        } else {
            int minIndexA = 0;
            int maxIndexA = 4;
            int indexA = 0;
            boolean indexExiste = true;
            do {
                switch (BibliotecaOS.opcao3_bA) {
                    case 0:
                        int minPaginaA = (maxIndexA + 1) / 5;
                        int maxPaginaA = Math.round(BibliotecaOS.listaArtigos.size() / 5) > 0 ? Math.round(BibliotecaOS.listaArtigos.size() / 5) + 1 : 1;

                        System.out.println("\n===============================\n\tLista de Artigos\n===============================\n");
                        // EXIBIR EM QUAL PÁGINA O USUÁRIO ESTÁ
                        System.out.printf("Página %d/%d:\n\n", minPaginaA, maxPaginaA);
                        // EXIBIR PÁGINA ATUAL (COMEÇANDO PELA PRIMEIRA)
                        for (int i = minIndexA; i <= maxIndexA; i++) {
                            try {
                                System.out.printf("%d - %s, %s (%d)\n", BibliotecaOS.listaArtigos.get(i).getId(), BibliotecaOS.listaArtigos.get(i).getTema(), BibliotecaOS.listaArtigos.get(i).getAutor(), BibliotecaOS.listaArtigos.get(i).getAno());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de um artigo pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir artigo da lista pelo ID\n[7] - Organizar lista\n[8] - Sair");
                        BibliotecaOS.opcao3_bA = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexA = verificarInt("Insira o ID do artigo no qual você deseja acessar as informações: ");
                        for (int j = 0; j < BibliotecaOS.listaArtigos.size(); j++) {
                            if (BibliotecaOS.listaArtigos.get(j).getId() == indexA) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaArtigos.size(); k++) {
                                if (BibliotecaOS.listaArtigos.get(k).getId() == indexA) {
                                    System.out.printf("\nID: %d\nDOI: %s\nChave: %s\nTema: %s\nAutor(a): %s\nAno: %d\nInstituto: %s\n", BibliotecaOS.listaArtigos.get(k).getId(), 
                                                                                                                                BibliotecaOS.listaArtigos.get(k).getDOI(),
                                                                                                                                BibliotecaOS.listaArtigos.get(k).getChave(),
                                                                                                                                BibliotecaOS.listaArtigos.get(k).getTema(), 
                                                                                                                                BibliotecaOS.listaArtigos.get(k).getAutor(),
                                                                                                                                BibliotecaOS.listaArtigos.get(k).getAno(), 
                                                                                                                                BibliotecaOS.listaArtigos.get(k).getInstituto());                                                                                                                        
                                }
                            } 
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }
                        esperar(3000);
                        BibliotecaOS.opcao3_bA = 0;
                        break;
                    case 2:
                        // PÁGINA ANTERIOR
                        if (minIndexA > 0) {
                            minIndexA -= 5;
                            maxIndexA -= 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bA = 0;
                        break;
                    case 3:
                         // PRÓXIMA PÁGINA
                         if (BibliotecaOS.listaArtigos.size() > maxIndexA + 1) {
                            minIndexA += 5; 
                            maxIndexA += 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bA = 0;
                        break;
                    case 4:
                        // PRIMEIRA PÁGINA
                        minIndexA = 0;
                        maxIndexA = 4;
                        BibliotecaOS.opcao3_bA = 0;
                        break;
                    case 5: 
                        // ÚLTIMA PÁGINA
                        for (int i = 1; (i * 5) < BibliotecaOS.listaArtigos.size(); i++) {
                            minIndexA = 5 * i;
                            maxIndexA = 5 * (i + 1);
                        }
                        BibliotecaOS.opcao3_bA = 0;
                        break;
                    case 6:
                        // EXCLUIR LIVRO DA LISTA
                        indexA = verificarInt("Insira o ID do artigo no qual você deseja remover da lista: ");
                        for (int j = 0; j < BibliotecaOS.listaArtigos.size(); j++) {
                            if (BibliotecaOS.listaArtigos.get(j).getId() == indexA) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaArtigos.size(); k++) {
                                if (BibliotecaOS.listaArtigos.get(k).getId() == indexA) {
                                    BibliotecaOS.listaRevistas.remove(k);
                                    System.out.println("Artigo removido com sucesso!");
                                }
                            }     
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }  
                        BibliotecaOS.opcao3_bA = 0;
                        esperar(3000);
                        break;
                    case 7:
                        // ORGANIZAR LISTA
                        do {
                            for (int i = 0; i < BibliotecaOS.listaArtigos.size() - 1; i++) {
                                Artigo item1 = BibliotecaOS.listaArtigos.get(i);
                                Artigo item2 = BibliotecaOS.listaArtigos.get(i + 1);
                                Artigo temp = item1;
                                
                                if (item1.getDOI().toUpperCase().compareTo(item2.getDOI().toUpperCase()) > 0) {
                                    item1 = item2;
                                    item2 = temp;
                                    BibliotecaOS.listaArtigos.set(i, item1);
                                    BibliotecaOS.listaArtigos.set(i + 1, item2);
                                }
                            }
                        } while (!listaArtigosEstaOrganizada(BibliotecaOS.listaArtigos));
                        BibliotecaOS.opcao3_bA = 0;
                        break;
                    case 8:
                        // SAIR
                        break;
                    default:
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        BibliotecaOS.opcao3_bA = 0;
                        break;
                }
                if (BibliotecaOS.opcao3_bA == 8) {
                    BibliotecaOS.opcao0 = 0;
                    break;
                }
            } while (true);
        }
    }
    // LISTAR CD
    public static void listarCDs() {
        if (BibliotecaOS.listaCDs.size() == 0) {
            //se a lista de livro estiver vazia
            System.out.println(BibliotecaOS.listaVaziaString);
            BibliotecaOS.opcao0 = 0;
            BibliotecaOS.opcao3 = 3;
            esperar(1500);
        } else {
            int minIndexC = 0;
            int maxIndexC = 4;
            int indexC = 0;
            boolean indexExiste = true;

            do {
                switch (BibliotecaOS.opcao3_bC) {
                    case 0:
                        int minPaginaC = (maxIndexC + 1) / 5;
                        int maxPaginaC = Math.round(BibliotecaOS.listaCDs.size() / 5) > 0 ? Math.round(BibliotecaOS.listaCDs.size() / 5) + 1 : 1;

                        System.out.println("\n===============================\n\tLista de CDs\n===============================\n");
                        // EXIBIR EM QUAL PÁGINA O USUÁRIO ESTÁ
                        System.out.printf("Página %d/%d:\n\n", minPaginaC, maxPaginaC);
                        // EXIBIR PÁGINA ATUAL (COMEÇANDO PELA PRIMEIRA)
                        for (int i = minIndexC; i <= maxIndexC; i++) {
                            try {
                                System.out.printf("%d - %s (%s)\n", BibliotecaOS.listaCDs.get(i).getId(), BibliotecaOS.listaCDs.get(i).getAlbum(), BibliotecaOS.listaCDs.get(i).getArtistaCompositor());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de um CD pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir CD da lista pelo ID\n[7] - Organizar lista\n[8] - Sair");
                        BibliotecaOS.opcao3_bC = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexC = verificarInt("Insira o ID do CD no qual você deseja acessar as informações: ");
                        for (int j = 0; j < BibliotecaOS.listaCDs.size(); j++) {
                            if (BibliotecaOS.listaCDs.get(j).getId() == indexC) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaCDs.size(); k++) {
                                if (BibliotecaOS.listaCDs.get(k).getId() == indexC) {
                                    System.out.printf("\nID: %d\nArtista/Compositor: %s\nGravadora: %s\nÁlbum: %s\nAno: %d\nUPC: %s\n", BibliotecaOS.listaCDs.get(k).getId(), 
                                                                                                                                BibliotecaOS.listaCDs.get(k).getArtistaCompositor(),
                                                                                                                                BibliotecaOS.listaCDs.get(k).getGravadora(),
                                                                                                                                BibliotecaOS.listaCDs.get(k).getAlbum(), 
                                                                                                                                BibliotecaOS.listaCDs.get(k).getAno(),
                                                                                                                                BibliotecaOS.listaCDs.get(k).getUPC());                                                                                                                      
                                }
                            }
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }
                        esperar(3000);
                        BibliotecaOS.opcao3_bC = 0;
                        break;
                    case 2:
                        // PÁGINA ANTERIOR
                        if (minIndexC > 0) {
                            minIndexC -= 5;
                            maxIndexC -= 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bC = 0;
                        break;
                    case 3:
                         // PRÓXIMA PÁGINA
                         if (BibliotecaOS.listaCDs.size() > maxIndexC + 1) {
                            minIndexC += 5; 
                            maxIndexC += 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bC = 0;
                        break;
                    case 4:
                        // PRIMEIRA PÁGINA
                        minIndexC = 0;
                        maxIndexC = 4;
                        BibliotecaOS.opcao3_bC = 0;
                        break;
                    case 5: 
                        // ÚLTIMA PÁGINA
                        for (int i = 1; (i * 5) < BibliotecaOS.listaCDs.size(); i++) {
                            minIndexC = 5 * i;
                            maxIndexC = 5 * (i + 1);
                        }
                        BibliotecaOS.opcao3_bC = 0;
                        break;
                    case 6:
                        // EXCLUIR CD DA LISTA
                        indexC = verificarInt("Insira o ID do CD no qual você deseja remover da lista: ");
                        for (int j = 0; j < BibliotecaOS.listaCDs.size(); j++) {
                            if (BibliotecaOS.listaCDs.get(j).getId() == indexC) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaCDs.size(); k++) {
                                if (BibliotecaOS.listaCDs.get(k).getId() == indexC) {
                                    BibliotecaOS.listaRevistas.remove(k);
                                    System.out.println("CD removido com sucesso!");
                                }
                            }  
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }  
                        BibliotecaOS.opcao3_bC = 0;
                        esperar(3000);
                        break;
                    case 7:
                        // ORGANIZAR LISTA
                        do {
                            for (int i = 0; i < BibliotecaOS.listaCDs.size() - 1; i++) {
                                CD item1 = BibliotecaOS.listaCDs.get(i);
                                CD item2 = BibliotecaOS.listaCDs.get(i + 1);
                                CD temp = item1;
                                
                                if (item1.getAlbum().toUpperCase().compareTo(item2.getAlbum().toUpperCase()) > 0) {
                                    item1 = item2;
                                    item2 = temp;
                                    BibliotecaOS.listaCDs.set(i, item1);
                                    BibliotecaOS.listaCDs.set(i + 1, item2);
                                }
                            }
                        } while (!listaCDsEstaOrganizada(BibliotecaOS.listaCDs));
                        BibliotecaOS.opcao3_bC = 0;
                        break;
                    case 8:
                        // SAIR
                        break;
                    default:
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        BibliotecaOS.opcao3_bC = 0;
                        break;
                }
                if (BibliotecaOS.opcao3_bC == 8) {
                    BibliotecaOS.opcao0 = 0;
                    break;
                }
            } while (true);
        }
    }
    // LISTAR DVD
    public static void listarDVDs() {
        if (BibliotecaOS.listaDVDs.size() == 0) {
            //se a lista de livro estiver vazia
            System.out.println(BibliotecaOS.listaVaziaString);
            BibliotecaOS.opcao0 = 0;
            BibliotecaOS.opcao3 = 3;
            esperar(1500);
        } else {
            int minIndexD = 0;
            int maxIndexD = 4;
            int indexD = 0;
            boolean indexExiste = true;

            do {
                switch (BibliotecaOS.opcao3_bD) {
                    case 0:
                        int minPaginaD = (maxIndexD + 1) / 5;
                        int maxPaginaD = Math.round(BibliotecaOS.listaDVDs.size() / 5) > 0 ? Math.round(BibliotecaOS.listaDVDs.size() / 5) + 1 : 1;

                        System.out.println("\n===============================\n\tLista de DVDs\n===============================\n");
                        // EXIBIR EM QUAL PÁGINA O USUÁRIO ESTÁ
                        System.out.printf("Página %d/%d:\n\n", minPaginaD, maxPaginaD);
                        // EXIBIR PÁGINA ATUAL (COMEÇANDO PELA PRIMEIRA)
                        for (int i = minIndexD; i <= maxIndexD; i++) {
                            try {
                                System.out.printf("%d - %s (%d)\n", BibliotecaOS.listaDVDs.get(i).getId(), BibliotecaOS.listaDVDs.get(i).getNome(), BibliotecaOS.listaDVDs.get(i).getAno());
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        // OPÇÕES E INPUT 
                        System.out.println("\n[1] - Acessar as informações de um DVD pelo ID.\n[2] - Página anterior\n[3] - Próxima página\n[4] - Primeira página\n[5] - Última página\n[6] - Excluir DVD da lista pelo ID\n[7] - Organizar lista\n[8] - Sair");
                        BibliotecaOS.opcao3_bD = verificarInt("\n> ");
                        System.out.println();
                        break;
                    case 1:
                        // ACESSAR INFORMAÇÕES PELO ID
                        indexD = verificarInt("Insira o ID do DVD no qual você deseja acessar as informações: ");
                        for (int j = 0; j < BibliotecaOS.listaDVDs.size(); j++) {
                            if (BibliotecaOS.listaDVDs.get(j).getId() == indexD) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaDVDs.size(); k++) {
                                if (BibliotecaOS.listaDVDs.get(k).getId() == indexD) {
                                    System.out.printf("\nID: %d\nNome: %s\nRegião: %s\nDistribuidora: %s\nDuração: %s\nSinopse: %s\nBônus: %s\nAno de Publicação: %d\nGênero: %s\nUPC: %s\n", BibliotecaOS.listaDVDs.get(k).getId(), 
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getNome(),
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getRegiao(),
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getDistribuidora(), 
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getDuracao(),
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getSinopse(), 
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getBonus(),
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getAno(),
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getGenero(),
                                                                                                                                                                                              BibliotecaOS.listaDVDs.get(k).getUPC());
                                }
                            }
                                                                                                                                               
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }
                        esperar(3000);
                        BibliotecaOS.opcao3_bD = 0;
                        break;
                    case 2:
                        // PÁGINA ANTERIOR
                        if (minIndexD > 0) {
                            minIndexD -= 5;
                            maxIndexD -= 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a página anterior."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bD = 0;
                        break;
                    case 3:
                         // PRÓXIMA PÁGINA
                         if (BibliotecaOS.listaDVDs.size() > maxIndexD + 1) {
                            minIndexD += 5; 
                            maxIndexD += 5;
                        } else {
                            System.out.println("ERRO: Não foi possível ir para a próxima página."); esperar(1500);
                        }
                        BibliotecaOS.opcao3_bD = 0;
                        break;
                    case 4:
                        // PRIMEIRA PÁGINA
                        minIndexD = 0;
                        maxIndexD = 4;
                        BibliotecaOS.opcao3_bD = 0;
                        break;
                    case 5: 
                        // ÚLTIMA PÁGINA
                        for (int i = 1; (i * 5) < BibliotecaOS.listaDVDs.size(); i++) {
                            minIndexD = 5 * i;
                            maxIndexD = 5 * (i + 1);
                        }
                        BibliotecaOS.opcao3_bD = 0;
                        break;
                    case 6:
                        // EXCLUIR LIVRO DA LISTA
                        indexD = verificarInt("Insira o ID do livro no qual você deseja remover da lista: ");
                        for (int j = 0; j < BibliotecaOS.listaDVDs.size(); j++) {
                            if (BibliotecaOS.listaDVDs.get(j).getId() == indexD) {
                                indexExiste = true;
                                break;
                            } else {
                                indexExiste = false;
                            }
                        }
                        if (indexExiste) {
                            for (int k = 0; k < BibliotecaOS.listaDVDs.size(); k++) {
                                if (BibliotecaOS.listaDVDs.get(k).getId() == indexD) {
                                    BibliotecaOS.listaRevistas.remove(k);
                                System.out.println("DVD removido com sucesso!");
                                }
                            } 
                        } else {
                            System.out.println("ERRO: ID inválido!");
                        }  
                        BibliotecaOS.opcao3_bD = 0;
                        esperar(3000);
                        break;
                    case 7:
                        // ORGANIZAR LISTA
                        do {
                            for (int i = 0; i < BibliotecaOS.listaDVDs.size() - 1; i++) {
                                DVD item1 = BibliotecaOS.listaDVDs.get(i);
                                DVD item2 = BibliotecaOS.listaDVDs.get(i + 1);
                                DVD temp = item1;
                                
                                if (item1.getNome().toUpperCase().compareTo(item2.getNome().toUpperCase()) > 0) {
                                    item1 = item2;
                                    item2 = temp;
                                    BibliotecaOS.listaDVDs.set(i, item1);
                                    BibliotecaOS.listaDVDs.set(i + 1, item2);
                                }
                            }
                        } while (!listaDVDsEstaOrganizada(BibliotecaOS.listaDVDs));
                        BibliotecaOS.opcao3_bD = 0;
                        break;
                    case 8:
                        // SAIR
                        break;
                    default:
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        BibliotecaOS.opcao3_bD = 0;
                        break;
                }
                if (BibliotecaOS.opcao3_bD == 8) {
                    BibliotecaOS.opcao0 = 0;
                    break;
                }
            } while (true);
        }
        
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
    // CHECAR SE O ARRAY DE ARTIGOS ESTÁ ORGANIZADO
    public static boolean listaArtigosEstaOrganizada(ArrayList<Artigo> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getDOI().toUpperCase().compareTo(lista.get(k+1).getDOI().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }
    // CHECAR SE O ARRAY DE CDS ESTÁ ORGANIZADO
    public static boolean listaCDsEstaOrganizada(ArrayList<CD> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getAlbum().toUpperCase().compareTo(lista.get(k+1).getAlbum().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }
    // CHECAR SE O ARRAY DE DVDS ESTÁ ORGANIZADO
    public static boolean listaDVDsEstaOrganizada(ArrayList<DVD> lista) {
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
    //CHECAR SE EXISTE UM ITEM COM O MESMO ID
    // public static boolean idExiste(int id, int size, ArrayList<T> lista) {
    //     for (Object elemento : lista) {
    //         if (elemento == id) {
    //             return true;
    //         } 
    //     }
    //     return false;
    // }
}
