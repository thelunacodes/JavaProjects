package PTBR.BibliotecaOSPasta;

import java.util.ArrayList;
import java.util.Scanner;
import PTBR.BibliotecaOSPasta.Objetos.Livro;
import PTBR.BibliotecaOSPasta.Objetos.Revista;
import PTBR.BibliotecaOSPasta.Objetos.Artigo;
import PTBR.BibliotecaOSPasta.Objetos.DVD;
import PTBR.BibliotecaOSPasta.Objetos.CD;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

//import das classes 
import static PTBR.BibliotecaOSPasta.IntroducaoPrograma.introducaoBibliotecaOS;
import static PTBR.BibliotecaOSPasta.ListarItens.listarItens;
import static PTBR.BibliotecaOSPasta.CadastrarItens.cadastrarItens;
import static PTBR.BibliotecaOSPasta.FiltrarItens.filtrarItens;
import static PTBR.BibliotecaOSPasta.GerenciarEspacoItens.gerenciarEspacoItens;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.criarPastaArquivo;
import static PTBR.BibliotecaOSPasta.AbrirWebPage.abrirPagWeb;
//leitura de arquivo
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.lerPastaLivros;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.lerPastaRevistas;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.lerPastaArtigos;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.lerPastaCDs;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.lerPastaDVDs;
//escrita de arquivo
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.salvarLivros;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.salvarRevistas;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.salvarArtigos;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.salvarCDs;
import static PTBR.BibliotecaOSPasta.LeituraEscritaItens.salvarDVDs;
import static PTBR.BibliotecaOSPasta.Esperar.esperar;

public class BibliotecaOS {
  
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    // ATRIBUTOS GERAIS
    static Scanner scanner = new Scanner(System.in);
    static String nome = "", autor = "", editora = "", CDD = "", ISBN = "", secao = "", DOI = "", chave = "", tema = "", instituto = "", artistaCompositor = "", gravadora = "", album = "", UPC = "", regiao = "", distribuidora = "", duracao = "", sinopse = "", bonus = "", genero = "";
    static String ISSN = "";
    static int id = 0, edicao = 0, anoPublicacao = 0, prateleira = 0, opcao0 = 0, opcao1 = 0, opcao2 = 0, opcao2_bL = 0, opcao2_bR = 0, opcao2_bA = 0, opcao2_bC = 0, opcao2_bD = 0, opcao3 = 0, opcao3_bL = 0, opcao3_bR = 0, opcao3_bA = 0, opcao3_bC = 0, opcao3_bD = 0;
    static ArrayList<Livro> listaLivros = new ArrayList<Livro>();
    static ArrayList<Revista> listaRevistas = new ArrayList<Revista>();
    static ArrayList<Artigo> listaArtigos = new ArrayList<Artigo>();
    static ArrayList<CD> listaCDs = new ArrayList<CD>();
    static ArrayList<DVD> listaDVDs = new ArrayList<DVD>();
    // ERROS
    static String nenhumItemEncontradoString = "ERRO: Nenhum item encontrado!";
    static String opcaoInvalidaString = "ERRO: Opção inválida!";
    static String listaCheiaString = "ERRO: A lista está cheia!";
    static String listaVaziaString = "ERRO: A lista está vazia!";
    // CAMINHO DOS ARQUIVOS
    static String caminhoDesktop = System.getProperty("user.home") + File.separator +"Desktop";
    static String pastaArquivosBiblioteca = caminhoDesktop + "\\BibliotecaOSFiles";
    static Path caminhoLivro = Paths.get(pastaArquivosBiblioteca + "\\arquivoLivros.txt");
    static Path caminhoRevista = Paths.get(pastaArquivosBiblioteca + "\\arquivoRevistas.txt");
    static Path caminhoArtigo = Paths.get(pastaArquivosBiblioteca + "\\arquivoArtigos.txt");
    static Path caminhoCD = Paths.get(pastaArquivosBiblioteca + "\\arquivoCDs.txt");
    static Path caminhoDVD = Paths.get(pastaArquivosBiblioteca + "\\arquivoDVDs.txt");


    public static void main(String[] args) {
        // LER LISTA ARQUIVOS
        criarPastaArquivo();
        lerPastaLivros();
        lerPastaRevistas();
        lerPastaArtigos();
        lerPastaCDs();
        lerPastaDVDs();
        // NAVEGAÇÃO DO SISTEMA
        do {
            switch (opcao0) {
                case 0:
                    introducaoBibliotecaOS();
                    break;
                case 1:
                    // CADASTRAR
                    cadastrarItens();
                    opcao0 = 0;
                    break;
                case 2:
                    // FILTRAR
                    filtrarItens();
                    opcao0 = 0;
                    break;
                case 3:
                    // LISTAR
                    listarItens();
                    opcao0 = 0;
                    break;
                case 4:
                    // GERENCIAR ESPAÇO
                    gerenciarEspacoItens();
                    opcao0 = 0;
                    break;
                case 5:
                    // ABRIR PÁGINA DO GIT
                    abrirPagWeb("https://github.com/delunatriestocode");
                    opcao0 = 0;
                case 6:
                    // SAIR
                    break;
                default:
                    System.out.println(opcaoInvalidaString);
                    esperar(1000);
                    opcao0 = 0;
            }
            // SAIR
            if (opcao0 == 6) {
                salvarLivros();
                salvarRevistas();
                salvarArtigos();
                salvarCDs();
                salvarDVDs();
                break;
            }
        } while (true);
        // FECHAR SCANNER
        scanner.close();
    }
}