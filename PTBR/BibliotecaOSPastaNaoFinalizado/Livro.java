package PTBR.BibliotecaOSPastaNaoFinalizado;

public class Livro {

    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String nome, autor, editora, CDD, ISBN, secao;
    private int edicao, anoPublicacao, prateleira;
    
    Livro(String nome, String autor, String editora, String CDD, String ISBN, int edicao, int anoPublicacao, String secao, int prateleira) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.CDD = CDD;
        this.ISBN = ISBN;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.secao = secao;
        this.prateleira = prateleira;
    }
    //GETTERS
    public String getNome() {
        return nome;
    }
    public String getAutor() {
        return autor;
    }
    public String getEditora() {
        return editora;
    }
    public String getCDD() {
        return CDD;
    }
    public String getISBN() {
        return ISBN;
    }
    public int getEdicao() {
        return edicao;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public String getSecao() {
        return secao;
    }
    public int getPrateleira() {
        return prateleira;
    }
    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public void setCDD(String CDD) {
        this.CDD = CDD;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public void setSecao(String secao) {
        this.secao = secao;
    }
    public void setPrateleira(int prateleira) {
        this.prateleira = prateleira;
    }
}
