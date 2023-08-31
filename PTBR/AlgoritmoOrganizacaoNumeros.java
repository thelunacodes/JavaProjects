package PTBR;

import java.util.ArrayList;
import java.util.Random;

public class AlgoritmoOrganizacaoNumeros {
    public static void main(String[] args) {
        ArrayList<Integer> sequencia = new ArrayList<Integer>(); //lista
        Random random = new Random(); //instância de random
        final int TAMANHO_LISTA = 20; //tamanho da lista
        final int VAL_MAX = 100; //valor máximo gerado
        int tentativas = 0, n1, n2, temp; //atributos

        //Gerar lista com números "aleatórios"
        for (int i = 0; i <= TAMANHO_LISTA; i++) {
            sequencia.add(random.nextInt(VAL_MAX)+1);
        } 
        //Fazer a troca se o valor j for maior que o próximo valor
        do {
            for (int j = 0; j < sequencia.size() - 1; j++) {
                if (sequencia.get(j) > sequencia.get(j+1)) {
                    n1 = sequencia.get(j);
                    n2 = sequencia.get(j+1);
                    temp = n1;
                    sequencia.set(j, n2);
                    sequencia.set(j+1, temp);
                }
            }
            tentativas++;
        } while (!listaEstaOrganizada(sequencia));
        //Exibir lista organizada
        System.out.println("Lista organizada depois de " + tentativas + " tentativas: ");
        for (int num : sequencia) {
            System.out.println(num);
        }
    }
    //Método que checa se a lista foi organizada
    public static boolean listaEstaOrganizada(ArrayList<Integer> arraylist) {
        for (int i = 0; i < arraylist.size() - 1; i++) {
            if (arraylist.get(i) > arraylist.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
