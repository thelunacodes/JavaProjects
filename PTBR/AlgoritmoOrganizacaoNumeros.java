package PTBR;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AlgoritmoOrganizacaoNumeros {
    public static void main(String[] args) {

        /*
        =================================================
        Github: delunatriestocode
        Linkedin: in/gabrielsilveiradeluna
        =================================================
        */
        
        ArrayList<Integer> sequencia = new ArrayList<Integer>(); //lista
        Random random = new Random(); //instância de random
        Scanner scanner = new Scanner(System.in); //instância de scanner
        final int TAMANHO_LISTA = 20; //tamanho da lista
        final int VAL_MAX = 100; //valor máximo gerado
        int tentativas = 0, n1, n2, temp; //atributos

        //Gerar lista com números "aleatórios"
        for (int i = 0; i <= TAMANHO_LISTA; i++) {
            sequencia.add(random.nextInt(VAL_MAX)+1);
        } 
        System.out.println("========================================\n\tAlgoritmo de Organização\n\t     de Números v1.0\n========================================\n");
        //Lista Original
        System.out.println("Lista original:");
        for (int num : sequencia) {
            System.out.print(num + " ");
        }
        System.out.println(" \n");
        //Crescente ou decresente?
        int opcao = 0;
        System.out.println("Insira o número correspondente à opção desejada: \n\n[1] Crescente\n[2] Decrescente\n[3] Sair\n");
        do {
            do {
            try {
                System.out.print("> ");
                opcao = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ERRO: Apenas números, por favor.");
                scanner.next();
            }
        } while (true);
        if (opcao == 1) {
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
            } while (!listaEstaOrganizadaCrescente(sequencia)); 
            //Exibir lista organizada
            System.out.println("\nLista organizada em ordem crescente depois de " + tentativas + " tentativas:");
            for (int num : sequencia) {
                System.out.print(num + " ");
            }
            System.out.println(" \n");  
            break;
        } else if (opcao == 2) {
            //Fazer a troca se o valor j for maior que o próximo valor
            do {
                for (int j = 0; j < sequencia.size() - 1; j++) {
                    if (sequencia.get(j) < sequencia.get(j+1)) {
                        n1 = sequencia.get(j);
                        n2 = sequencia.get(j+1);
                        temp = n1;
                        sequencia.set(j, n2);
                        sequencia.set(j+1, temp);
                    }
                }
                tentativas++;
            } while (!listaEstaOrganizadaDecrescente(sequencia));
            //Exibir lista organizada
            System.out.println("\nLista organizada em ordem decrescente depois de " + tentativas + " tentativas:");
            for (int num : sequencia) {
                System.out.print(num + " ");
            }
            System.out.println(" \n"); 
            break;      
        } else if (opcao == 3) {
            System.out.println("Tchau!");
            break;
        } else {
            System.out.println("Opção inválida!");
        }
        } while (true);
        scanner.close();
    }
    //Método que checa se a lista foi organizada (ordem crescente)
    public static boolean listaEstaOrganizadaCrescente(ArrayList<Integer> arraylist) {
        for (int i = 0; i < arraylist.size() - 1; i++) {
            if (arraylist.get(i) > arraylist.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    //Método que checa se a lista foi organizada (ordem decrescente)
    public static boolean listaEstaOrganizadaDecrescente(ArrayList<Integer> arraylist) {
        for (int i = 0; i < arraylist.size() - 1; i++) {
            if (arraylist.get(i) < arraylist.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
