package PTBR.BibliotecaOSPasta.Objetos;

import PTBR.BibliotecaOSPasta.BibliotecaOS;
import static PTBR.BibliotecaOSPasta.Esperar.esperar;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;

import java.util.ArrayList;

import static PTBR.BibliotecaOSPasta.ChecarSeArrayEstaOrganizado.listaRevistasEstaOrganizada;

public class Revista extends Livro {

    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */
    private String ISSN ;

    public Revista (int id, String nome, String autor, String editora, String CDD, String ISBN, int edicao, int anoPublicacao, String secao, int prateleira, String ISSN) {
        super(id, nome, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira);
        this.ISSN = ISSN;
    }
    //GETTERS
    public String getISSN() {
        return ISSN;
    }
    //SETTERS
    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
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
}
