package PTBR.BibliotecaOSPasta;

import java.util.ArrayList;

import PTBR.BibliotecaOSPasta.Objetos.Artigo;
import PTBR.BibliotecaOSPasta.Objetos.CD;
import PTBR.BibliotecaOSPasta.Objetos.DVD;
import PTBR.BibliotecaOSPasta.Objetos.Livro;
import PTBR.BibliotecaOSPasta.Objetos.Revista;

public class ChecarSeArrayEstaOrganizado {
    // CHECAR SE O ARRAY DE LIVROS ESTÁ ORGANIZADO
    public static boolean listaLivrosEstaOrganizada(ArrayList<Livro> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getNome().toUpperCase().compareTo(lista.get(k+1).getNome().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }
    // CHECAR SE O ARRAY DE ARTIGOS ESTÁ ORGANIZADO
    public static boolean listaArtigosEstaOrganizada(ArrayList<Artigo> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getDOI().toUpperCase().compareTo(lista.get(k+1).getDOI().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }
    // CHECAR SE O ARRAY DE CDS ESTÁ ORGANIZADO
    public static boolean listaCDsEstaOrganizada(ArrayList<CD> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getAlbum().toUpperCase().compareTo(lista.get(k+1).getAlbum().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }
    // CHECAR SE O ARRAY DE DVDS ESTÁ ORGANIZADO
    public static boolean listaDVDsEstaOrganizada(ArrayList<DVD> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getNome().toUpperCase().compareTo(lista.get(k+1).getNome().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }
    // CHECAR SE O ARRAY DE REVISTAS ESTÁ ORGANIZADO
    public static boolean listaRevistasEstaOrganizada(ArrayList<Revista> lista) {
        for (int k = 0; k < lista.size() - 1; k++) {
            if (lista.get(k).getNome().toUpperCase().compareTo(lista.get(k+1).getNome().toUpperCase()) > 0) {
                return false;
            }
        }
        return true;
    }
}
