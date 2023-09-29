package PTBR.BibliotecaOSPasta.Objetos;

public class DVD {
    
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String nome, regiao, distribuidora, duracao, sinopse, bonus, genero, UPC;
    private int id, ano;
    
    public DVD(int id, String nome, String regiao, String distribuidora, String duracao, String sinopse, String bonus, int ano, String genero, String UPC) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.distribuidora = distribuidora;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.bonus = bonus;
        this.ano = ano;
        this.genero = genero;
        this.UPC = UPC;
    }
    //GETTERS
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getRegiao() {
        return regiao;
    }
    public String getDistribuidora() {
        return distribuidora;
    }
    public String getDuracao() {
        return duracao;
    }
    public String getSinopse() {
        return sinopse;
    }
    public String getBonus() {
        return bonus;
    }
    public int getAno() {
        return ano;
    }
    public String getGenero() {
        return genero;
    }
    public String getUPC() {
        return UPC;
    }
    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setUPC(String UPC) {
        this.UPC = UPC;
    }
}
