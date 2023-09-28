package PTBR.BibliotecaOSPasta;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;

public class IntroducaoPrograma {
    
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */
    
    public static void introducaoBibliotecaOS() {
        System.out.println("\n============================\n\tBibliotecaOS\n\t    v1.0\n============================");
        // OPÇÕES E INPUT
        System.out.println("\nBem-vindo(a), usuário(a)! Insira o número correspondente à opção desejada:");
        System.out.println("\n[1] Cadastrar \n[2] Filtrar \n[3] Listar \n[4] Espaço livre\n[5] Créditos\n[6] Sair\n");
        BibliotecaOS.opcao0 = verificarInt("> ");
    }
}
