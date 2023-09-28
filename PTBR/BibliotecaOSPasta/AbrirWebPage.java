package PTBR.BibliotecaOSPasta;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AbrirWebPage {
    // MÉTODO QUE ABRE UMA PÁGINA DA WEB
    public static void abrirPagWeb(String link) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(link));
            } else {
                System.out.println("========================\n\tCréditos\n========================\n");
                System.out.println("Criado por TheLuna\nGithub: delunatriestocode\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    } 
}
