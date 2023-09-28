package PTBR.BibliotecaOSPasta;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;

public class GerenciarEspacoItens {
    
    // GERENCIAR ESPAÇO OCUPADO POR LIVRO/REVISTA
    public static void gerenciarEspacoItens() {
        String opcao4 = "";
        try {
            do {
                System.out.println("================================\n\tGerenciar Espaço\n================================");
                // espaço livre
                System.out.printf("\nEspaço ocupado (livros): %d/1000", BibliotecaOS.listaLivros.size());
                System.out.printf("\nEspaço ocupado (revistas): %d/1000", BibliotecaOS.listaRevistas.size());
                // opção de input + input do usuário
                System.out.println("\n\n[L] - Limpar a lista de livros\n[R] - Limpar a lista de revistas\n[S] - Sair");
                do {
                    opcao4 = verificarString("\n> ").toUpperCase().trim();
                    break;
                } while (true);
                if (opcao4.equals("L")) {
                    // LIMPAR LISTA LIVROS
                    String opcao4_B = "";
                    do {
                        System.out.println("Tem certeza que deseja limpar a lista de livros? Essa ação não poderá ser revertida (escreva \"S\" ou \"N\").");
                        opcao4_B = verificarString("> ").toUpperCase();
                        if (opcao4_B.equals("S")) {
                            BibliotecaOS.listaLivros.clear();
                            break;
                        }
                    } while (true);
                } else if (opcao4.equals("R")) {
                    // LIMPAR LISTA REVISTAS
                    String opcao4_B = "";
                    do {
                        System.out.println("Tem certeza que deseja limpar a lista de revistas? Essa ação não poderá ser revertida (escreva \"S\" ou \"N\").");
                        opcao4_B = verificarString("> ").toUpperCase();
                        if (opcao4_B.equals("S")) {
                            BibliotecaOS.listaRevistas.clear();
                            break;
                        }
                    } while (true);
                } else if (opcao4.equals("S")) {
                    // SAIR
                    break;
                } else {
                    //OPÇÃO INVÁLIDA
                    System.out.println(BibliotecaOS.opcaoInvalidaString);
                }
            } while (true);
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
        BibliotecaOS.opcao0 = 0;
    }
}
