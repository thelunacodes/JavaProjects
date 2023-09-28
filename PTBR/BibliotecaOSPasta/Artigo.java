package PTBR.BibliotecaOSPasta;

public class Artigo {
    public String DOI, chave, tema, autor, instituto;
    public int ano;

    public Artigo (String DOI, String chave, String tema, String autor, int ano, String instituto) {
        this.DOI = DOI;
        this.chave = chave;
        this.tema = tema;
        this.autor = autor;
        this.ano = ano;
        this.instituto = instituto;
    }
}
