package PTBR.BibliotecaOSPasta;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;
import java.util.ArrayList;

import PTBR.BibliotecaOSPasta.Objetos.Artigo;
import PTBR.BibliotecaOSPasta.Objetos.CD;
import PTBR.BibliotecaOSPasta.Objetos.DVD;
import PTBR.BibliotecaOSPasta.Objetos.Livro;
import PTBR.BibliotecaOSPasta.Objetos.Revista;

import static PTBR.BibliotecaOSPasta.Esperar.esperar;

public class FiltrarItens {

    /*
     * =================================================
     * Github: delunatriestocode
     * Linkedin: in/gabrielsilveiradeluna
     * =================================================
     */

    // FILTRAR LIVRO/REVISTA
    public static void filtrarItens() {
        try {
            do {
                switch (BibliotecaOS.opcao2) {
                    case 0:
                        System.out.println("\nInsira o número correspondente à opção desejada:\n\n[1] Livro\n[2] Revista\n[3] Artigo \n[4] CD \n[5] DVD \n[6] Sair\n");
                        BibliotecaOS.opcao2 = verificarInt("> ");
                        break;
                    case 1:
                        // LIVRO
                        Livro.filtrarLivro();
                        break;
                    case 2:
                        // REVISTA
                        Revista.filtrarRevista();
                        break;
                    case 3:
                        // ARTIGO
                        Artigo.filtrarArtigo();
                        break;
                    case 4:
                        // CD
                        CD.filtrarCD();
                        break;
                    case 5:
                        // DVD
                        DVD.filtrarDVD();
                        break;
                    case 6:
                        // SAIR
                        break;
                    default:
                        System.out.println(BibliotecaOS.opcaoInvalidaString);
                        break;
                }
                // SAIR
                if (BibliotecaOS.opcao2 == 6 || BibliotecaOS.opcao2_bL == 10 || BibliotecaOS.opcao2_bR == 11 || BibliotecaOS.opcao2_bA == 7 || BibliotecaOS.opcao2_bC == 6 || BibliotecaOS.opcao2_bD == 10) {
                    BibliotecaOS.opcao2_bL = 0;
                    BibliotecaOS.opcao2_bR = 0;
                    BibliotecaOS.opcao2_bA = 0;
                    BibliotecaOS.opcao2_bC = 0;
                    BibliotecaOS.opcao2_bD = 0;
                    BibliotecaOS.opcao2 = 0;
                    break;
                }
            } while (true);
        } catch (Throwable e) {
            System.out.println(
                    "Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber()
                            + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
    }
}
