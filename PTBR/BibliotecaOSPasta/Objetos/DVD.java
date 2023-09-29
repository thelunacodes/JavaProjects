package PTBR.BibliotecaOSPasta.Objetos;

import java.util.ArrayList;
import PTBR.BibliotecaOSPasta.BibliotecaOS;
import static PTBR.BibliotecaOSPasta.Esperar.esperar;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;
import static PTBR.BibliotecaOSPasta.ChecarSeArrayEstaOrganizado.listaDVDsEstaOrganizada;

public class DVD {
    
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String nome, regiao, distribuidora, duracao, sinopse, bonus, genero, UPC;
    private int id, ano;
    
    public DVD(int id, String nome, String regiao, String distribuidora, String duracao, String sinopse, String bonus, int ano, String genero, String UPC) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.distribuidora = distribuidora;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.bonus = bonus;
        this.ano = ano;
        this.genero = genero;
        this.UPC = UPC;
    }
    //GETTERS
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getRegiao() {
        return regiao;
    }
    public String getDistribuidora() {
        return distribuidora;
    }
    public String getDuracao() {
        return duracao;
    }
    public String getSinopse() {
        return sinopse;
    }
    public String getBonus() {
        return bonus;
    }
    public int getAno() {
        return ano;
    }
    public String getGenero() {
        return genero;
    }
    public String getUPC() {
        return UPC;
    }
    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setUPC(String UPC) {
        this.UPC = UPC;
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
