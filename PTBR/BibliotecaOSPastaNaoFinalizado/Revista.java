package PTBR.BibliotecaOSPastaNaoFinalizado;

public class Revista extends Livro {

    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */
    private String ISSN ;

    public Revista (String nome, String autor, String editora, String CDD, String ISBN, int edicao, int anoPublicacao, String secao, int prateleira, String ISSN) {
        super(nome, autor, editora, CDD, ISBN, edicao, anoPublicacao, secao, prateleira);
        this.ISSN = ISSN;
    }
        //GETTERS
        public String getISSN() {
            return ISSN;
        }
        //SETTERS
        public void setISSN(String ISSN) {
            this.ISSN = ISSN;
        }
}
