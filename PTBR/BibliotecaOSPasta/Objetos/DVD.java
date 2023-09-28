package PTBR.BibliotecaOSPasta.Objetos;

public class DVD {
    
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String nome, regiao, distribuidora, duracao, sinopse, bonus, genero, UPC;
    private int ano;
    
    public DVD(String nome, String regiao, String distribuidora, String duracao, String sinopse, String bonus, int ano, String genero, String UPC) {
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
}
