package PTBR.BibliotecaOSPasta;

public class Esperar {

    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */
    
    // MÉTODO QUE PAUSA O PROGRAMA POR X MILISSEGUNDOS 
    public static void esperar(int ms) {
                


        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
