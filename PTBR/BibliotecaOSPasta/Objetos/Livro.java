package PTBR.BibliotecaOSPasta.Objetos;

import PTBR.BibliotecaOSPasta.BibliotecaOS;
import static PTBR.BibliotecaOSPasta.Esperar.esperar;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;

import java.util.ArrayList;

import static PTBR.BibliotecaOSPasta.ChecarSeArrayEstaOrganizado.listaLivrosEstaOrganizada;

public class Livro {

    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String nome, autor, editora, CDD, ISBN, secao;
    private int id, edicao, anoPublicacao, prateleira;
    
    public Livro(int id, String nome, String autor, String editora, String CDD, String ISBN, int edicao, int anoPublicacao, String secao, int prateleira) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.CDD = CDD;
        this.ISBN = ISBN;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.secao = secao;
        this.prateleira = prateleira;
    }
    //GETTERS
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getAutor() {
        return autor;
    }
    public String getEditora() {
        return editora;
    }
    public String getCDD() {
        return CDD;
    }
    public String getISBN() {
        return ISBN;
    }
    public int getEdicao() {
        return edicao;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public String getSecao() {
        return secao;
    }
    public int getPrateleira() {
        return prateleira;
    }
    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public void setCDD(String CDD) {
        this.CDD = CDD;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public void setSecao(String secao) {
        this.secao = secao;
    }
    public void setPrateleira(int prateleira) {
        this.prateleira = prateleira;
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

}
