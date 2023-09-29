package PTBR.BibliotecaOSPasta.Objetos;

import java.util.ArrayList;
import PTBR.BibliotecaOSPasta.BibliotecaOS;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;
import static PTBR.BibliotecaOSPasta.Esperar.esperar;
import static PTBR.BibliotecaOSPasta.ChecarSeArrayEstaOrganizado.listaArtigosEstaOrganizada;

public class Artigo {
            
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String DOI, chave, tema, autor, instituto;
    private int id, ano;

    public Artigo (int id, String DOI, String chave, String tema, String autor, int ano, String instituto) {
        this.id = id;
        this.DOI = DOI;
        this.chave = chave;
        this.tema = tema;
        this.autor = autor;
        this.ano = ano;
        this.instituto = instituto;
    }
    //GETTERS
    public int getId() {
        return id;
    }
    public String getDOI() {
        return DOI;
    }
    public String getChave() {
        return chave;
    }
    public String getTema() {
        return tema;
    }
    public String getAutor() {
        return autor;
    }
    public int getAno() {
        return ano;
    }
    public String getInstituto() {
        return instituto;
    }
    //SETTERS
    public void setDOI(String DOI) {
        this.DOI = DOI;
    }
    public void setChave(String chave) {
        this.chave = chave;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setInstituto(String instituto) {
        this.instituto = instituto;
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
}
