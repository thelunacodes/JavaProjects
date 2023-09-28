package PTBR.BibliotecaOSPasta;

import java.util.InputMismatchException;

public class InputHandler {
    
    /*
    =================================================
    Github: delunatriestocode
    Linkedin: in/gabrielsilveiradeluna
    =================================================
    */
    
    // INPUTS EM INT
    public static int verificarInt(String msg) {
        int atributo = 0;
        do {                                                                                                                                                          
            try {
                System.out.print(msg);
                atributo = BibliotecaOS.scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                BibliotecaOS.scanner.next();
            }
        } while (true);
        BibliotecaOS.scanner.nextLine(); 
        return atributo;
    }

    // INPUTS EM DOUBLE
    public static double verificarDouble(String msg) {
        double atributo = 0;                                                                                                                                                        
        do {       
            try {
                System.out.print(msg);
                atributo = BibliotecaOS.scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                BibliotecaOS.scanner.next();
            }
        } while (true);
        BibliotecaOS.scanner.nextLine(); 
        return atributo;
    }

    // INPUT EM STRINGS
    public static String verificarString(String msg) {
        String atributo = "";

        do {
            System.out.print(msg);
            atributo = BibliotecaOS.scanner.nextLine();
            if (!atributo.trim().isEmpty()) {
                break;
            }
        } while (true);
        return atributo;
    }
}
