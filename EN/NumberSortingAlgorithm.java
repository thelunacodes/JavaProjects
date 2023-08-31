package EN;

import java.util.ArrayList;
import java.util.Random;

public class NumberSortingAlgorithm {
    public static void main(String[] args) {
        ArrayList<Integer> sequence = new ArrayList<Integer>(); //list
        Random random = new Random(); //random instance
        final int LIST_SIZE = 20; //list size
        final int MAX_VAL = 100; //max "random" value
        int tries = 0, n1, n2, temp; //atributes

        //Generate list with "random" values
        for (int i = 0; i <= LIST_SIZE; i++) {
            sequence.add(random.nextInt(MAX_VAL)+1);
        } 
        System.out.println("========================================\n\tNumber Sorting Algorithm\n\t\t   v1.0\n========================================\n");
        System.out.println("Original List: \n");
        for (int num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println(" \n");
        //Switch value in index j with the value in index j+1 if they're bigger
        do {
            for (int j = 0; j < sequence.size() - 1; j++) {
                if (sequence.get(j) > sequence.get(j+1)) {
                    n1 = sequence.get(j);
                    n2 = sequence.get(j+1);
                    temp = n1;
                    sequence.set(j, n2);
                    sequence.set(j+1, temp);
                }
            }
            tries++;
        } while (!listIsOrganized(sequence));
        //Show organized list
        System.out.println("Organized list after " + tries + " tries: \n");
        for (int num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println(" \n");
    }
    //Método que checa se a lista foi organizada
    public static boolean listIsOrganized(ArrayList<Integer> arraylist) {
        for (int i = 0; i < arraylist.size() - 1; i++) {
            if (arraylist.get(i) > arraylist.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
