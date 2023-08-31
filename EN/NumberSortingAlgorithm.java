   package EN;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberSortingAlgorithm {
    public static void main(String[] args) {

        /*
        =================================================
        Github: delunatriestocode
        Linkedin: in/gabrielsilveiradeluna
        =================================================
        */
        
        ArrayList<Integer> sequence = new ArrayList<Integer>(); //list
        Random random = new Random(); //random instance
        Scanner scanner = new Scanner(System.in); //scanner instance
        final int LIST_SIZE = 20; //list size
        final int MAX_VAL = 100; //max "random" value
        int tries = 0, n1, n2, temp; //atributes

        //Generate list with "random" values
        for (int i = 0; i <= LIST_SIZE; i++) {
            sequence.add(random.nextInt(MAX_VAL)+1);
        } 
        System.out.println("========================================\n\tNumber Sorting Algorithm\n\t\t   v1.0\n========================================\n");
        System.out.println("Original List:");
        for (int num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println(" \n");
        //Ascending or descending?
        int option = 0;
        System.out.println("Insert the number corresponding to the desired sorting style: \n\n[1] Ascending order\n[2] Descending order\n[3] Exit\n");
        do {
            do {
            try {
                System.out.print("> ");
                option = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ERROR: Only numbers, please.");
                scanner.next();
            }
        } while (true);
        if (option == 1) {
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
            } while (!SortedListAscendingOrder(sequence)); 
            //Show organized list
            System.out.println("\nList sorted in ascending order after " + tries + " tries:");
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println(" \n");  
            break;
        } else if (option == 2) {
            //Switch value in index j with the value in index j+1 if they're smaller
            do {
                for (int j = 0; j < sequence.size() - 1; j++) {
                    if (sequence.get(j) < sequence.get(j+1)) {
                        n1 = sequence.get(j);
                        n2 = sequence.get(j+1);
                        temp = n1;
                        sequence.set(j, n2);
                        sequence.set(j+1, temp);
                    }
                }
                tries++;
            } while (!SortedListDescendingOrder(sequence));
            //Show organized list
            System.out.println("List sorted in descending order after " + tries + " tries:");
            for (int num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println(" \n"); 
            break;      
        } else if (option == 3) {
            System.out.println("Bye!");
            break;
        } else {
            System.out.println("Invalid input!");
        }
        } while (true);
        scanner.close();
    }
    //Method that checks if the list was organized (ascending order)
    public static boolean SortedListAscendingOrder(ArrayList<Integer> arraylist) {
        for (int i = 0; i < arraylist.size() - 1; i++) {
            if (arraylist.get(i) > arraylist.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    //Method that checks if the list was organized (descending order)
    public static boolean SortedListDescendingOrder(ArrayList<Integer> arraylist) {
        for (int i = 0; i < arraylist.size() - 1; i++) {
            if (arraylist.get(i) < arraylist.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
