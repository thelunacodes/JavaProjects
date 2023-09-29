package PTBR.BibliotecaOSPasta.Objetos;

import PTBR.BibliotecaOSPasta.BibliotecaOS;
import static PTBR.BibliotecaOSPasta.Esperar.esperar;
import static PTBR.BibliotecaOSPasta.ChecarSeArrayEstaOrganizado.listaCDsEstaOrganizada;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;
import java.util.ArrayList;

public class CD {
        
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String artistaCompositor, gravadora, album, UPC;
    private int id, ano;
    
    public CD (int id, String artistaCompositor, String gravadora, String album, int ano, String UPC) {
        this.id = id;
        this.artistaCompositor = artistaCompositor;
        this.gravadora = gravadora;
        this.album = album;
        this.ano = ano;
        this.UPC = UPC;
    }
    //GETTERS
    public int getId() {
        return id;
    }
    public String getArtistaCompositor() {
        return artistaCompositor;
    }
    public String getGravadora() {
        return gravadora;
    }
    public String getAlbum() {
        return album;
    }
    public int getAno() {
        return ano;
    }
    public String getUPC() {
        return UPC;
    }
    //SETTERS
    public void setArtistaCompositor(String artistaCompositor) {
        this.artistaCompositor = artistaCompositor;
    }
    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setUPC(String UPC) {
        this.UPC = UPC;
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
    // FILTRAR CD
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
}
