package PTBR.BibliotecaOSPasta;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;
import PTBR.BibliotecaOSPasta.Objetos.Livro;
import PTBR.BibliotecaOSPasta.Objetos.Revista;
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
                System.out.println("Livro ou revista?\n[1] Livro\n[2] Revista\n[3] Sair\n");
                int opcao1 = verificarInt("> ");
                if (opcao1 == 1) {
                    cadastrarLivro();  
                    break;    
                } else if (opcao1 == 2) {
                    cadastrarRevista();
                    break;
                } else if (opcao1 == 3) {
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
        if (BibliotecaOS.listaLivros.size() == 1000) {
            System.out.println(BibliotecaOS.listaCheiaString);
            esperar(1500);
            BibliotecaOS.opcao0 = 0;
        } else {
            System.out.println("\n===================================\n\tCadastro de Livros\n===================================\n");
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
            BibliotecaOS.listaLivros.add(new Livro(BibliotecaOS.nome, BibliotecaOS.autor, BibliotecaOS.editora, BibliotecaOS.CDD, BibliotecaOS.ISBN, BibliotecaOS.edicao, BibliotecaOS.anoPublicacao, BibliotecaOS.secao, BibliotecaOS.prateleira));
        }
    }
    //MÉTODO QUE CADASTRA REVISTA
    public static void cadastrarRevista() {
        if (BibliotecaOS.listaLivros.size() == 1000) {
            System.out.println(BibliotecaOS.listaCheiaString);
            esperar(1500);
            BibliotecaOS.opcao0 = 0;
        } else {
            System.out.println("\n===================================\n\tCadastro de Revistas\n===================================\n");
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
            BibliotecaOS.listaRevistas.add(new Revista(BibliotecaOS.nome, BibliotecaOS.autor, BibliotecaOS.editora, BibliotecaOS.CDD, BibliotecaOS.ISBN, BibliotecaOS.edicao, BibliotecaOS.anoPublicacao, BibliotecaOS.secao, BibliotecaOS.prateleira, BibliotecaOS.ISSN));   
        }
    }   
}
