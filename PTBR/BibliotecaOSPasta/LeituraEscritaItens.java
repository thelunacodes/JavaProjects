package PTBR.BibliotecaOSPasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeituraEscritaItens {
    // SALVAR LISTA LIVROS
    public static void salvarLivros() {
        //SALVAR LIVROS
        String listaLivrostxt = "", listaLivrosLinha;
        for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
            listaLivrosLinha = String.format("%s; %s; %s; %s; %s; %d; %d; %s; %d\n", BibliotecaOS.listaLivros.get(i).getNome(), BibliotecaOS.listaLivros.get(i).getAutor(), BibliotecaOS.listaLivros.get(i).getEditora(), BibliotecaOS.listaLivros.get(i).getCDD(), BibliotecaOS.listaLivros.get(i).getISBN(), BibliotecaOS.listaLivros.get(i).getEdicao(), BibliotecaOS.listaLivros.get(i).getAnoPublicacao(), BibliotecaOS.listaLivros.get(i).getSecao(), BibliotecaOS.listaLivros.get(i).getPrateleira());
            listaLivrostxt += listaLivrosLinha;
        }
        try {
            BufferedWriter arquivoLivro = new BufferedWriter(new FileWriter(BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoLivros.txt"));
            arquivoLivro.write(listaLivrostxt);
            System.out.println("Lista de livros salva em: " + BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoLivros.txt");
            arquivoLivro.close();
        } catch (IOException e) {
            System.out.println("ERRO: O arquivo de livros não pôde ser atualizado :( \n" + e.getMessage());
        }
    }
    public static void salvarRevistas() {
        //SALVAR REVISTAS
        String listaRevistastxt = "", listaRevistasLinha;
        for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
            listaRevistasLinha = String.format("%s; %s; %s; %s; %s; %d; %d; %s; %d; %s\n", BibliotecaOS.listaRevistas.get(i).getNome(), BibliotecaOS.listaRevistas.get(i).getAutor(), BibliotecaOS.listaRevistas.get(i).getEditora(), BibliotecaOS.listaRevistas.get(i).getCDD(), BibliotecaOS.listaRevistas.get(i).getISBN(), BibliotecaOS.listaRevistas.get(i).getEdicao(), BibliotecaOS.listaRevistas.get(i).getAnoPublicacao(), BibliotecaOS.listaRevistas.get(i).getSecao(), BibliotecaOS.listaRevistas.get(i).getPrateleira(), BibliotecaOS.listaRevistas.get(i).getISSN());
            listaRevistastxt += listaRevistasLinha;
        }
        try {
            BufferedWriter arquivoRevista = new BufferedWriter(new FileWriter(BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoRevistas.txt"));
            arquivoRevista.write(listaRevistastxt);
            System.out.println("Lista de revistas salva em: " + BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoRevistas.txt");
            arquivoRevista.close();
        } catch (IOException e) {
            System.out.println("ERRO: O arquivo de revistas não pôde ser atualizado :( \n" + e.getMessage());
        }
    }
    public static void criarPastaArquivo() {
        Path pastaArquivos = Paths.get(BibliotecaOS.pastaArquivosBiblioteca);
        try {
            if (!Files.exists(pastaArquivos)) {
                Files.createDirectories(pastaArquivos);
                System.out.println("A pasta \"BibliotecaOSFiles\" foi criada em sua Área de Trabalho!");
            }
        } catch (IOException e) {
            System.out.println("ERRO: Não foi possível criar a pasta");
        }
    }
    public static void lerPastaLivros() {
        if (!Files.exists(BibliotecaOS.caminhoLivro)) {
            System.out.println("ERRO: O arquivo \"arquivoLivros.txt\" não existe!");
        } else {
            BufferedReader leitorLivros = null;
            try {
                leitorLivros = new BufferedReader(new FileReader(BibliotecaOS.caminhoLivro.toString()));
                String linha;
                while ((linha = leitorLivros.readLine()) != null) {
                    String[] linhaLivrosArray = linha.split(";");
                    BibliotecaOS.listaLivros.add(new Livro(linhaLivrosArray[0].trim(), 
                                              linhaLivrosArray[1].trim(), 
                                              linhaLivrosArray[2].trim(), 
                                              linhaLivrosArray[3].trim(), 
                                              linhaLivrosArray[4].trim(), 
                                              Integer.parseInt(linhaLivrosArray[5].trim()), 
                                              Integer.parseInt(linhaLivrosArray[6].trim()), 
                                              linhaLivrosArray[7].trim(), 
                                              Integer.parseInt(linhaLivrosArray[8].trim())));
                }
            } catch (IOException e) {
                System.out.println("ERRO: Não foi possível ler o \"arquivoLivros.txt\"");
            } finally {
                try {
                    if (leitorLivros != null) {
                        leitorLivros.close();
                    }
                } catch (IOException e) {
                    System.out.println("ERRO: Não foi possível fechar o leitor de livros.");
                }
            }
        }
    }
    public static void lerPastaRevistas() {
        if (!Files.exists(BibliotecaOS.caminhoRevista)) {
            System.out.println("ERRO: O arquivo \"arquivoRevistas.txt\" não existe!");
        } else {
            BufferedReader leitorRevistas = null;
            try {
                leitorRevistas = new BufferedReader(new FileReader(BibliotecaOS.caminhoRevista.toString()));
                String linha;
                while ((linha = leitorRevistas.readLine()) != null) {
                    String[] linhaRevistasArray = linha.split(";");
                    BibliotecaOS.listaRevistas.add(new Revista(linhaRevistasArray[0].trim(), 
                                              linhaRevistasArray[1].trim(), 
                                              linhaRevistasArray[2].trim(), 
                                              linhaRevistasArray[3].trim(), 
                                              linhaRevistasArray[4].trim(), 
                                              Integer.parseInt(linhaRevistasArray[5].trim()), 
                                              Integer.parseInt(linhaRevistasArray[6].trim()), 
                                              linhaRevistasArray[7].trim(), 
                                              Integer.parseInt(linhaRevistasArray[8].trim()),
                                              linhaRevistasArray[9]));
                }
            } catch (IOException e) {
                System.out.println("ERRO: Não foi possível ler o \"arquivoRevistas.txt\"");
            } finally {
                try {
                    if (leitorRevistas != null) {
                        leitorRevistas.close();
                    }
                } catch (IOException e) {
                    System.out.println("ERRO: Não foi possível fechar o leitor de revistas.");
                }
            }
        }
    }
}
