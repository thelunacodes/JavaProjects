package PTBR.BibliotecaOSPasta.Objetos;

public class Artigo {
            
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String DOI, chave, tema, autor, instituto;
    private int ano;

    public Artigo (String DOI, String chave, String tema, String autor, int ano, String instituto) {
        this.DOI = DOI;
        this.chave = chave;
        this.tema = tema;
        this.autor = autor;
        this.ano = ano;
        this.instituto = instituto;
    }
    //GETTERS
    public String getDOI() {
        return DOI;
    }
    public String getChave() {
        return chave;
    }
    public String getTema() {
        return tema;
    }
    public String getAutor() {
        return autor;
    }
    public int getAno() {
        return ano;
    }
    public String getInstituto() {
        return instituto;
    }
    //SETTERS
    public void setDOI(String DOI) {
        this.DOI = DOI;
    }
    public void setChave(String chave) {
        this.chave = chave;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
}
