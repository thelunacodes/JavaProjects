package PTBR.BibliotecaOSPasta.Objetos;

public class CD {
        
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */

    private String artistaCompositor, gravadora, album, UPC;
    private int id, ano;
    
    public CD (int id, String artistaCompositor, String gravadora, String album, int ano, String UPC) {
        this.id = id;
        this.artistaCompositor = artistaCompositor;
        this.gravadora = gravadora;
        this.album = album;
        this.ano = ano;
        this.UPC = UPC;
    }
    //GETTERS
    public int getId() {
        return id;
    }
    public String getArtistaCompositor() {
        return artistaCompositor;
    }
    public String getGravadora() {
        return gravadora;
    }
    public String getAlbum() {
        return album;
    }
    public int getAno() {
        return ano;
    }
    public String getUPC() {
        return UPC;
    }
    //SETTERS
    public void setArtistaCompositor(String artistaCompositor) {
        this.artistaCompositor = artistaCompositor;
    }
    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setUPC(String UPC) {
        this.UPC = UPC;
    }
}
