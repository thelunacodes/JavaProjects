package PTBR.BibliotecaOSPasta;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;
import PTBR.BibliotecaOSPasta.Objetos.Livro;
import PTBR.BibliotecaOSPasta.Objetos.Revista;
import PTBR.BibliotecaOSPasta.Objetos.Artigo;
import PTBR.BibliotecaOSPasta.Objetos.CD;
import PTBR.BibliotecaOSPasta.Objetos.DVD;

import static PTBR.BibliotecaOSPasta.Esperar.esperar;

public class CadastrarItens {
            
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    // MÉTODO QUE CADASTRA LIVRO/REVISTA
    public static void cadastrarItens() {
        try {
            do {
                System.out.println("\nInsira o número correspondente à opção desejada:\n\n[1] Livro\n[2] Revista\n[3] Artigo \n[4] CD \n[5] DVD \n[6] Sair\n");
                int opcao1 = verificarInt("> ");
                if (opcao1 == 1) {
                    cadastrarLivro();  
                    break;    
                } else if (opcao1 == 2) {
                    cadastrarRevista();
                    break;
                } else if (opcao1 == 3) {
                    cadastrarArtigo();
                    break;
                } else if (opcao1 == 4) {
                    cadastrarCD();
                    break;
                } else if (opcao1 == 5) {
                    cadastrarDVD();
                    break;
                } else if (opcao1 == 6) {
                    break;
                }
            } while (true); 
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }  
    }
    //MÉTODO QUE CADASTRA LIVRO
    public static void cadastrarLivro() {
        boolean indexExiste = true;

        if (BibliotecaOS.listaLivros.size() == 1000) {
            System.out.println(BibliotecaOS.listaCheiaString);
            esperar(1500);
            BibliotecaOS.opcao0 = 0;
        } else {
            System.out.println("\n===================================\n\tCadastro de Livros\n===================================\n");
            do {
                BibliotecaOS.id = verificarInt("Insira o ID: ");
                for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                    if (BibliotecaOS.listaLivros.get(i).getId() == BibliotecaOS.id) {
                        indexExiste = true;
                        break;
                    } else {
                        indexExiste = false;
                    }
                }
                if (indexExiste) {
                    System.out.println("ERRO: Já existe um livro com esse id");
                } else {
                    break;
                }
            } while (true);
            BibliotecaOS.nome = verificarString("Insira o nome: ");
            BibliotecaOS.autor = verificarString("Insira o autor: ");
            BibliotecaOS.editora = verificarString("Insira a editora: ");
            BibliotecaOS.CDD = verificarString("Insira o CDD: ");
            BibliotecaOS.ISBN = verificarString("Insira o ISBN: ");
            BibliotecaOS.edicao = verificarInt("Insira a edição: ");
            BibliotecaOS.anoPublicacao = verificarInt("Insira o ano de publicação: ");
            BibliotecaOS.secao = verificarString("Insira o nome da seção onde está o livro: ");
            BibliotecaOS.prateleira = verificarInt("Insira o número da prateleira onde está o livro: ");
                        
            // ADICIONAR À LISTA
            BibliotecaOS.listaLivros.add(new Livro(BibliotecaOS.id, BibliotecaOS.nome, BibliotecaOS.autor, BibliotecaOS.editora, BibliotecaOS.CDD, BibliotecaOS.ISBN, BibliotecaOS.edicao, BibliotecaOS.anoPublicacao, BibliotecaOS.secao, BibliotecaOS.prateleira));
        }
    }
    //MÉTODO QUE CADASTRA REVISTA
    public static void cadastrarRevista() {
        boolean indexExiste = true;

        if (BibliotecaOS.listaRevistas.size() == 1000) {
            System.out.println(BibliotecaOS.listaCheiaString);
            esperar(1500);
            BibliotecaOS.opcao0 = 0;
        } else {
            System.out.println("\n===================================\n\tCadastro de Revistas\n===================================\n");
            do {
                BibliotecaOS.id = verificarInt("Insira o ID: ");
                for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                    if (BibliotecaOS.listaRevistas.get(i).getId() == BibliotecaOS.id) {
                        indexExiste = true;
                        break;
                    } else {
                        indexExiste = false;
                    }
                }
                if (indexExiste) {
                    System.out.println("ERRO: Já existe uma revista com esse id");
                } else {
                    break;
                }
            } while (true);
            BibliotecaOS.nome = verificarString("Insira o nome: ");
            BibliotecaOS.autor = verificarString("Insira o autor: ");
            BibliotecaOS.editora = verificarString("Insira a editora: ");
            BibliotecaOS.CDD = verificarString("Insira o CDD: ");
            BibliotecaOS.ISBN = verificarString("Insira o ISBN: ");
            BibliotecaOS.ISSN = verificarString("Insira o ISSN: ");
            BibliotecaOS.edicao = verificarInt("Insira a edição: ");
            BibliotecaOS.anoPublicacao = verificarInt("Insira o ano de publicação: ");
            BibliotecaOS.secao = verificarString("Insira o nome da seção onde está a revista: ");
            BibliotecaOS.prateleira = verificarInt("Insira o número da prateleira onde está a revista: ");
                    
            // ADICIONAR À LISTA
            BibliotecaOS.listaRevistas.add(new Revista(BibliotecaOS.id, BibliotecaOS.nome, BibliotecaOS.autor, BibliotecaOS.editora, BibliotecaOS.CDD, BibliotecaOS.ISBN, BibliotecaOS.edicao, BibliotecaOS.anoPublicacao, BibliotecaOS.secao, BibliotecaOS.prateleira, BibliotecaOS.ISSN));   
        }
    }   
    //MÉTODO QUE CADASTRA ARTIGO
    public static void cadastrarArtigo() {
        boolean indexExiste = true;

        if (BibliotecaOS.listaArtigos.size() == 1000) {
            System.out.println(BibliotecaOS.listaCheiaString);
            esperar(1500);
            BibliotecaOS.opcao0 = 0;
        } else {
            System.out.println("\n===================================\n\tCadastro de Artigos\n===================================\n");
            do {
                BibliotecaOS.id = verificarInt("Insira o ID: ");
                for (int i = 0; i < BibliotecaOS.listaArtigos.size(); i++) {
                    if (BibliotecaOS.listaArtigos.get(i).getId() == BibliotecaOS.id) {
                        indexExiste = true;
                        break;
                    } else {
                        indexExiste = false;
                    }
                }
                if (indexExiste) {
                    System.out.println("ERRO: Já existe um artigo com esse id");
                } else {
                    break;
                }
            } while (true);
            BibliotecaOS.DOI = verificarString("Insira o DOI: ");
            BibliotecaOS.chave = verificarString("Insira a chave do artigo: ");
            BibliotecaOS.tema = verificarString("Insira o tema: ");
            BibliotecaOS.autor = verificarString("Insira o autor: ");
            BibliotecaOS.anoPublicacao = verificarInt("Insira o ano de publicação: ");
            BibliotecaOS.instituto = verificarString("Insira o instituto: ");
                    
            // ADICIONAR À LISTA
            BibliotecaOS.listaArtigos.add(new Artigo(BibliotecaOS.id, BibliotecaOS.DOI, BibliotecaOS.chave, BibliotecaOS.tema, BibliotecaOS.autor, BibliotecaOS.anoPublicacao, BibliotecaOS.instituto));   
        }
    }   
    //MÉTODO QUE CADASTRA CD
    public static void cadastrarCD() {
        boolean indexExiste = true;
        
        if (BibliotecaOS.listaCDs.size() == 1000) {
            System.out.println(BibliotecaOS.listaCheiaString);
            esperar(1500);
            BibliotecaOS.opcao0 = 0;
        } else {
            System.out.println("\n===================================\n\tCadastro de CDs\n===================================\n");
            do {
                BibliotecaOS.id = verificarInt("Insira o ID: ");
                for (int i = 0; i < BibliotecaOS.listaCDs.size(); i++) {
                    if (BibliotecaOS.listaCDs.get(i).getId() == BibliotecaOS.id) {
                        indexExiste = true;
                        break;
                    } else {
                        indexExiste = false;
                    }
                }
                if (indexExiste) {
                    System.out.println("ERRO: Já existe um CD com esse id");
                } else {
                    break;
                }
            } while (true);
            BibliotecaOS.artistaCompositor = verificarString("Insira o artista/compositor: ");
            BibliotecaOS.gravadora = verificarString("Insira a gravadora: ");
            BibliotecaOS.album = verificarString("Insira o album: ");
            BibliotecaOS.anoPublicacao = verificarInt("Insira o ano de publicação: ");
            BibliotecaOS.UPC = verificarString("Insira o UPC: ");
                        
            // ADICIONAR À LISTA
            BibliotecaOS.listaCDs.add(new CD(BibliotecaOS.id, BibliotecaOS.artistaCompositor, BibliotecaOS.gravadora, BibliotecaOS.album, BibliotecaOS.anoPublicacao, BibliotecaOS.UPC));
        }
    }
    //MÉTODO QUE CADASTRA DVD
    public static void cadastrarDVD() {
        boolean indexExiste = true;

        if (BibliotecaOS.listaDVDs.size() == 1000) {
            System.out.println(BibliotecaOS.listaCheiaString);
            esperar(1500);
            BibliotecaOS.opcao0 = 0;
        } else {
            System.out.println("\n===================================\n\tCadastro de DVDs\n===================================\n");
            do {
                BibliotecaOS.id = verificarInt("Insira o ID: ");
                for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                    if (BibliotecaOS.listaDVDs.get(i).getId() == BibliotecaOS.id) {
                        indexExiste = true;
                        break;
                    } else {
                        indexExiste = false;
                    }
                }
                if (indexExiste) {
                    System.out.println("ERRO: Já existe um DVD com esse id");
                } else {
                    break;
                }
            } while (true);
            BibliotecaOS.nome = verificarString("Insira o nome: ");
            BibliotecaOS.regiao = verificarString("Insira a região: ");
            BibliotecaOS.distribuidora = verificarString("Insira a distribuidora: ");
            BibliotecaOS.duracao = verificarString("Insira a duração: ");
            BibliotecaOS.sinopse = verificarString("Insira a sinopse: ");
            BibliotecaOS.bonus = verificarString("Insira o conteúdo bônus: ");
            BibliotecaOS.anoPublicacao = verificarInt("Insira o ano de publicação: ");
            BibliotecaOS.genero = verificarString("Insira o gênero: ");
            BibliotecaOS.UPC = verificarString("Insira o UPC: ");
                        
            // ADICIONAR À LISTA
            BibliotecaOS.listaDVDs.add(new DVD(BibliotecaOS.id, BibliotecaOS.nome, BibliotecaOS.regiao, BibliotecaOS.distribuidora, BibliotecaOS.duracao, BibliotecaOS.sinopse, BibliotecaOS.bonus, BibliotecaOS.anoPublicacao, BibliotecaOS.genero, BibliotecaOS.UPC));
        }
    }
}
