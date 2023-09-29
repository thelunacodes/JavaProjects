package PTBR.BibliotecaOSPasta;

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
                        Livro.listarLivro();
                        break;
                    case 2:
                        //REVISTA
                        Revista.listarRevista();
                        break;
                    case 3:
                        //ARTIGO
                        Artigo.listarArtigos();
                        break;
                    case 4:
                        CD.listarCDs();
                        break;
                    case 5:
                        DVD.listarDVDs();
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
    
    
}
