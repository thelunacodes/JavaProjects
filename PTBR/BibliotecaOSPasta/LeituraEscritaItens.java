package PTBR.BibliotecaOSPasta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import PTBR.BibliotecaOSPasta.Objetos.Artigo;
import PTBR.BibliotecaOSPasta.Objetos.CD;
import PTBR.BibliotecaOSPasta.Objetos.DVD;
import PTBR.BibliotecaOSPasta.Objetos.Livro;
import PTBR.BibliotecaOSPasta.Objetos.Revista;

public class LeituraEscritaItens {
    
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */
    
    // SALVAR LISTA LIVROS
    public static void salvarLivros() {
        //SALVAR LIVROS
        if (BibliotecaOS.listaLivros.size() == 0) {
            System.out.println("ERRO: A lista de livros está vazia!");
        } else {
            String listaLivrostxt = "", listaLivrosLinha;
            for (int i = 0; i < BibliotecaOS.listaLivros.size(); i++) {
                listaLivrosLinha = String.format("%d; %s; %s; %s; %s; %s; %d; %d; %s; %d\n", BibliotecaOS.listaLivros.get(i).getId(), BibliotecaOS.listaLivros.get(i).getNome(), BibliotecaOS.listaLivros.get(i).getAutor(), BibliotecaOS.listaLivros.get(i).getEditora(), BibliotecaOS.listaLivros.get(i).getCDD(), BibliotecaOS.listaLivros.get(i).getISBN(), BibliotecaOS.listaLivros.get(i).getEdicao(), BibliotecaOS.listaLivros.get(i).getAnoPublicacao(), BibliotecaOS.listaLivros.get(i).getSecao(), BibliotecaOS.listaLivros.get(i).getPrateleira());
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
    }
    public static void salvarRevistas() {
        //SALVAR REVISTAS
        if (BibliotecaOS.listaRevistas.size() == 0) {
            System.out.println("ERRO: A lista de revistas está vazia!");
        } else {
            String listaRevistastxt = "", listaRevistasLinha;
            for (int i = 0; i < BibliotecaOS.listaRevistas.size(); i++) {
                listaRevistasLinha = String.format("%d; %s; %s; %s; %s; %s; %d; %d; %s; %d; %s\n", BibliotecaOS.listaRevistas.get(i).getId(), BibliotecaOS.listaRevistas.get(i).getNome(), BibliotecaOS.listaRevistas.get(i).getAutor(), BibliotecaOS.listaRevistas.get(i).getEditora(), BibliotecaOS.listaRevistas.get(i).getCDD(), BibliotecaOS.listaRevistas.get(i).getISBN(), BibliotecaOS.listaRevistas.get(i).getEdicao(), BibliotecaOS.listaRevistas.get(i).getAnoPublicacao(), BibliotecaOS.listaRevistas.get(i).getSecao(), BibliotecaOS.listaRevistas.get(i).getPrateleira(), BibliotecaOS.listaRevistas.get(i).getISSN());
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
    }
    public static void salvarArtigos() {
        //SALVAR ARTIGOS
        if (BibliotecaOS.listaArtigos.size() == 0) {
            System.out.println("ERRO: A lista de artigos está vazia!");
        } else {
            String listaArtigostxt = "", listaArtigosLinha;
            for (int i = 0; i < BibliotecaOS.listaArtigos.size(); i++) {
                listaArtigosLinha = String.format("%d; %s; %s; %s; %s; %s; %d; %s\n", BibliotecaOS.listaArtigos.get(i).getId(), BibliotecaOS.listaArtigos.get(i).getDOI(), BibliotecaOS.listaArtigos.get(i).getChave(), BibliotecaOS.listaArtigos.get(i).getTema(), BibliotecaOS.listaArtigos.get(i).getAutor(), BibliotecaOS.listaArtigos.get(i).getAno(), BibliotecaOS.listaArtigos.get(i).getInstituto());
                listaArtigostxt += listaArtigosLinha;
            }
            try {
                BufferedWriter arquivoArtigo = new BufferedWriter(new FileWriter(BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoArtigos.txt"));
                arquivoArtigo.write(listaArtigostxt);
                System.out.println("Lista de artigos salva em: " + BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoArtigos.txt");
                arquivoArtigo.close();
            } catch (IOException e) {
                System.out.println("ERRO: O arquivo de artigos não pôde ser atualizado :( \n" + e.getMessage());
            }
        }  
    }
    public static void salvarCDs() {
        //SALVAR CDs
        if (BibliotecaOS.listaCDs.size() == 0) {
            System.out.println("ERRO: A lista de CDs está vazia!");
        } else {
            String listaCDstxt = "", listaCDsLinha;
            for (int i = 0; i < BibliotecaOS.listaCDs.size(); i++) {
                listaCDsLinha = String.format("%d; %s; %s; %s; %d; %s\n", BibliotecaOS.listaCDs.get(i).getId(), BibliotecaOS.listaCDs.get(i).getArtistaCompositor(), BibliotecaOS.listaCDs.get(i).getGravadora(), BibliotecaOS.listaCDs.get(i).getAlbum(), BibliotecaOS.listaCDs.get(i).getAno(), BibliotecaOS.listaCDs.get(i).getUPC());
                listaCDstxt += listaCDsLinha;
            }
            try {
                BufferedWriter arquivoCD = new BufferedWriter(new FileWriter(BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoCDs.txt"));
                arquivoCD.write(listaCDstxt);
                System.out.println("Lista de CDs salva em: " + BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoCDs.txt");
                arquivoCD.close();
            } catch (IOException e) {
                System.out.println("ERRO: O arquivo de CDs não pôde ser atualizado :( \n" + e.getMessage());
            }
        }  
    }
    public static void salvarDVDs() {
        //SALVAR DVDs
        if (BibliotecaOS.listaDVDs.size() == 0) {
            System.out.println("ERRO: A lista de DVDs está vazia!");
        } else {
            String listaDVDstxt = "", listaDVDsLinha;
            for (int i = 0; i < BibliotecaOS.listaDVDs.size(); i++) {
                listaDVDsLinha = String.format("%d; %s; %s; %s; %s; %s; %s; %s; %d; %s; %s\n", BibliotecaOS.listaDVDs.get(i).getId(), BibliotecaOS.listaDVDs.get(i).getNome(), BibliotecaOS.listaDVDs.get(i).getRegiao(), BibliotecaOS.listaDVDs.get(i).getDistribuidora(), BibliotecaOS.listaDVDs.get(i).getDuracao(), BibliotecaOS.listaDVDs.get(i).getSinopse(), BibliotecaOS.listaDVDs.get(i).getBonus(), BibliotecaOS.listaDVDs.get(i).getBonus(), BibliotecaOS.listaDVDs.get(i).getAno(), BibliotecaOS.listaDVDs.get(i).getGenero(), BibliotecaOS.listaDVDs.get(i).getUPC());
                listaDVDstxt += listaDVDsLinha;
            }
            try {
                BufferedWriter arquivoDVD = new BufferedWriter(new FileWriter(BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoDVDs.txt"));
                arquivoDVD.write(listaDVDstxt);
                System.out.println("Lista de DVDs salva em: " + BibliotecaOS.pastaArquivosBiblioteca + "\\arquivoDVDs.txt");
                arquivoDVD.close();
            } catch (IOException e) {
                System.out.println("ERRO: O arquivo de DVDs não pôde ser atualizado :( \n" + e.getMessage());
            }
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
                    BibliotecaOS.listaLivros.add(new Livro(Integer.parseInt(linhaLivrosArray[0].trim()),
                                                           linhaLivrosArray[1].trim(), 
                                                           linhaLivrosArray[2].trim(), 
                                                           linhaLivrosArray[3].trim(), 
                                                           linhaLivrosArray[4].trim(), 
                                                           linhaLivrosArray[5].trim(), 
                                                           Integer.parseInt(linhaLivrosArray[6].trim()), 
                                                           Integer.parseInt(linhaLivrosArray[7].trim()), 
                                                           linhaLivrosArray[8].trim(), 
                                                           Integer.parseInt(linhaLivrosArray[9].trim())));
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
                    BibliotecaOS.listaRevistas.add(new Revista(Integer.parseInt(linhaRevistasArray[0].trim()), 
                                                               linhaRevistasArray[1].trim(), 
                                                               linhaRevistasArray[2].trim(), 
                                                               linhaRevistasArray[3].trim(), 
                                                               linhaRevistasArray[4].trim(), 
                                                               linhaRevistasArray[5].trim(), 
                                                               Integer.parseInt(linhaRevistasArray[6].trim()), 
                                                               Integer.parseInt(linhaRevistasArray[7].trim()), 
                                                               linhaRevistasArray[8].trim(), 
                                                               Integer.parseInt(linhaRevistasArray[9].trim()),
                                                               linhaRevistasArray[10]));
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
    public static void lerPastaArtigos() {
        if (!Files.exists(BibliotecaOS.caminhoArtigo)) {
            System.out.println("ERRO: O arquivo \"arquivoArtigos.txt\" não existe!");
        } else {
            BufferedReader leitorArtigos = null;
            try {
                leitorArtigos = new BufferedReader(new FileReader(BibliotecaOS.caminhoArtigo.toString()));
                String linha;
                while ((linha = leitorArtigos.readLine()) != null) {
                    String[] linhaArtigosArray = linha.split(";");
                    BibliotecaOS.listaArtigos.add(new Artigo(Integer.parseInt(linhaArtigosArray[0].trim()),
                                                             linhaArtigosArray[1].trim(), 
                                                             linhaArtigosArray[2].trim(), 
                                                             linhaArtigosArray[3].trim(), 
                                                             linhaArtigosArray[4].trim(), 
                                                             Integer.parseInt(linhaArtigosArray[5].trim()), 
                                                             linhaArtigosArray[6].trim()));
                }
            } catch (IOException e) {
                System.out.println("ERRO: Não foi possível ler o \"arquivoArtigos.txt\"");
            } finally {
                try {
                    if (leitorArtigos != null) {
                        leitorArtigos.close();
                    }
                } catch (IOException e) {
                    System.out.println("ERRO: Não foi possível fechar o leitor de artigos.");
                }
            }
        }
    }
    public static void lerPastaCDs() {
        if (!Files.exists(BibliotecaOS.caminhoCD)) {
            System.out.println("ERRO: O arquivo \"arquivoCDs.txt\" não existe!");
        } else {
            BufferedReader leitorCDs = null;
            try {
                leitorCDs = new BufferedReader(new FileReader(BibliotecaOS.caminhoCD.toString()));
                String linha;
                while ((linha = leitorCDs.readLine()) != null) {
                    String[] linhaCDsArray = linha.split(";");
                    BibliotecaOS.listaCDs.add(new CD(Integer.parseInt(linhaCDsArray[0].trim()), 
                                                     linhaCDsArray[1].trim(), 
                                                     linhaCDsArray[2].trim(), 
                                                     linhaCDsArray[3].trim(), 
                                                     Integer.parseInt(linhaCDsArray[4].trim()), 
                                                     linhaCDsArray[5].trim()));
                }
            } catch (IOException e) {
                System.out.println("ERRO: Não foi possível ler o \"arquivoCDs.txt\"");
            } finally {
                try {
                    if (leitorCDs != null) {
                        leitorCDs.close();
                    }
                } catch (IOException e) {
                    System.out.println("ERRO: Não foi possível fechar o leitor de CDs.");
                }
            }
        }
    }
    public static void lerPastaDVDs() {
        if (!Files.exists(BibliotecaOS.caminhoDVD)) {
            System.out.println("ERRO: O arquivo \"arquivoDVDs.txt\" não existe!");
        } else {
            BufferedReader leitorDVDs = null;
            try {
                leitorDVDs = new BufferedReader(new FileReader(BibliotecaOS.caminhoDVD.toString()));
                String linha;
                while ((linha = leitorDVDs.readLine()) != null) {
                    String[] linhaDVDsArray = linha.split(";");
                    BibliotecaOS.listaDVDs.add(new DVD(Integer.parseInt(linhaDVDsArray[0].trim()),
                                                       linhaDVDsArray[1].trim(), 
                                                       linhaDVDsArray[2].trim(), 
                                                       linhaDVDsArray[3].trim(), 
                                                       linhaDVDsArray[4].trim(), 
                                                       linhaDVDsArray[5].trim(), 
                                                       linhaDVDsArray[6].trim(), 
                                                       Integer.parseInt(linhaDVDsArray[7].trim()),
                                                       linhaDVDsArray[8].trim(), 
                                                       linhaDVDsArray[9].trim()));
                }
            } catch (IOException e) {
                System.out.println("ERRO: Não foi possível ler o \"arquivoDVDs.txt\"");
            } finally {
                try {
                    if (leitorDVDs != null) {
                        leitorDVDs.close();
                    }
                } catch (IOException e) {
                    System.out.println("ERRO: Não foi possível fechar o leitor de DVDs.");
                }
            }
        }
    }
}
