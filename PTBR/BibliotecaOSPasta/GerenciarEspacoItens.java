package PTBR.BibliotecaOSPasta;

import static PTBR.BibliotecaOSPasta.InputHandler.verificarString;
import static PTBR.BibliotecaOSPasta.InputHandler.verificarInt;
import static PTBR.BibliotecaOSPasta.Esperar.esperar;

public class GerenciarEspacoItens {
    
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */
    
    // GERENCIAR ESPAÇO OCUPADO POR LIVRO/REVISTA
    public static void gerenciarEspacoItens() {
        int opcao4 = 0;
        String opcao4_B = "";   
        try {
            do {
                switch (opcao4) {
                    case 0: 
                        System.out.println("================================\n\tGerenciar Espaço\n================================");
                        // espaço livre
                        System.out.printf("\nEspaço ocupado (livros): %d/1000", BibliotecaOS.listaLivros.size());
                        System.out.printf("\nEspaço ocupado (revistas): %d/1000", BibliotecaOS.listaRevistas.size());
                        System.out.printf("\nEspaço ocupado (artigos): %d/1000", BibliotecaOS.listaArtigos.size());
                        System.out.printf("\nEspaço ocupado (CDs)): %d/1000", BibliotecaOS.listaCDs.size());
                        System.out.printf("\nEspaço ocupado (DVDs): %d/1000", BibliotecaOS.listaDVDs.size());
                        // opção de input + input do usuário
                        System.out.println("\n\n[1] - Limpar a lista de livros\n[2] - Limpar a lista de revistas\n[3] - Limpar lista de artigos \n[4] - Limpar lista de CDs \n[5] - Limpar lista de DVDs \n[6] - Sair");
                        opcao4 = verificarInt("\nInsira o número correspondente à opção desejada: ");
                        break;
                    case 1:
                        // LIMPAR LISTA LIVROS
                        do {
                            if (BibliotecaOS.listaLivros.size() == 0) {
                                System.out.println("\n" + BibliotecaOS.listaVaziaString);
                                esperar(1500);
                                break;
                            } else {
                                System.out.println("Tem certeza que deseja limpar a lista de livros? Essa ação não poderá ser desfeita (escreva \"S\" ou \"N\").");
                                opcao4_B = verificarString("> ").toUpperCase();
                                if (opcao4_B.equals("S")) {
                                    BibliotecaOS.listaLivros.clear();
                                    break;
                                }
                            }   
                        } while (true);
                        opcao4 = 0;
                        break;
                    case 2:
                        //LIMPAR LISTA REVISTAS
                        do {
                            if (BibliotecaOS.listaRevistas.size() == 0) {
                                System.out.println("\n" + BibliotecaOS.listaVaziaString);
                                esperar(1500);
                                break;
                            } else {
                                System.out.println("Tem certeza que deseja limpar a lista de revistas? Essa ação não poderá ser desfeita (escreva \"S\" ou \"N\").");
                                opcao4_B = verificarString("> ").toUpperCase();
                                if (opcao4_B.equals("S")) {
                                    BibliotecaOS.listaRevistas.clear();
                                    break;
                                }
                            }
                        } while (true);
                        opcao4 = 0;
                        break;
                    case 3:
                        //LIMPAR LISTA ARTIGOS
                        do {
                            if (BibliotecaOS.listaArtigos.size() == 0) {
                                System.out.println("\n" + BibliotecaOS.listaVaziaString);
                                esperar(1500);
                                break;
                            } else {
                                System.out.println("Tem certeza que deseja limpar a lista de artigos? Essa ação não poderá ser desfeita (escreva \"S\" ou \"N\").");
                                opcao4_B = verificarString("> ").toUpperCase();
                                if (opcao4_B.equals("S")) {
                                    BibliotecaOS.listaArtigos.clear();
                                    break;
                                }
                            }
                        } while (true);
                        opcao4 = 0;
                        break;
                    case 4:
                        //LIMPAR LISTA CDS
                        do {
                            if (BibliotecaOS.listaDVDs.size() == 0) {
                                System.out.println("\n" + BibliotecaOS.listaVaziaString);
                                esperar(1500);
                                break;
                            } else {
                                System.out.println("Tem certeza que deseja limpar a lista de DVDs? Essa ação não poderá ser revertida (escreva \"S\" ou \"N\").");
                                opcao4_B = verificarString("> ").toUpperCase();
                                if (opcao4_B.equals("S")) {
                                    BibliotecaOS.listaDVDs.clear();
                                    break;
                                }
                            }
                        } while (true);
                        opcao4 = 0;
                        break;
                    case 5:
                        //LIMPAR LISTA DVDS
                        do {
                            if (BibliotecaOS.listaDVDs.size() == 0) {
                                System.out.println("\n" + BibliotecaOS.listaVaziaString);
                                esperar(1500);
                                break;
                            } else {
                                System.out.println("Tem certeza que deseja limpar a lista de CDs? Essa ação não poderá ser revertida (escreva \"S\" ou \"N\").");
                                opcao4_B = verificarString("> ").toUpperCase();
                                if (opcao4_B.equals("S")) {
                                    BibliotecaOS.listaCDs.clear();
                                    break;
                                }
                            }
                        } while (true);
                        opcao4 = 0;
                        break;
                    case 6:
                        //SAIR
                        break;
                }
                if (opcao4 == 6) {
                    break;
                }
            } while (true);   
        }
        catch (Throwable e) {
            System.out.println("Um erro foi encontrado! Contate o suporte! \nLinha: " + e.getStackTrace()[0].getLineNumber() + "\nTipo de Erro: " + e.getStackTrace()[0].getClass().getName());
        }
        BibliotecaOS.opcao0 = 0;
    }
}
