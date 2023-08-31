package EN;

import java.util.Scanner;
import java.util.InputMismatchException;


public class VolumeCalculator {
    public static void main(String[] args) {

        /*
        =================================================
        Github: delunatriestocode
        Linkedin: in/gabrielsilveiradeluna
        =================================================
        */
    
        Scanner scanner = new Scanner(System.in);
        int option;
        double edge, radius, volume, apothem, height, length, width, heightBase, lengthBase;

        System.out.println("=================================\n\tVolume Calculator\n\t      v1.0\n=================================\n");
        System.out.println("Insert the number corresponding to the desired option:\n\n[1] Cube volume\n[2] Sphere volume\n[3] Cone volume\n[4] Pyramid volume (triangular base)\n[5] Pyramid volume (square base)\n[6] Pyramid volume (hexagonal base)\n[7] Cylinder volume\n[8] Parallelepiped volume\n[9] Hexagonal prism volume\n[10] Pentagonal prism volume\n[11] Triangular prism volume\n[12] Dodecahedron volume\n[13] Octahedron volume\n");

        //Input
        do {
            try {
                System.out.print("> ");
                option = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ERROR: Only numbers, please.");
            }
        } while (true);
        switch (option) {
        case 1:
            //Cube 
            //Edge length (test value: 12)
            edge = DimensionsInput("Insert the length of the edge: ");
            //Volume (expected outcome: 1728 um³)
            volume = Math.pow(edge, 3);
            returnVolume("the cube", volume);
            break;
        case 2:
            //Sphere 
            //Radius (test value: 5)
            radius = DimensionsInput("Insert the radius of the circumference: ");
            //Volume (expected outcome: 523,33 um³)
            volume = (4 * 3.14 * Math.pow(radius, 3)) / 3;
            returnVolume("the sphere", volume);
            break;
        case 3:
            //Cone 
            //Radius (test value: 6)
            radius = DimensionsInput("Insert the radius of the circumference: ");
            //Height (test value: 8)
            height = DimensionsInput("Insert the height of the cone: ");
            //Volume (expected outcome: 301,44 um³)
            volume =  (3.14 * Math.pow(radius, 2) * height) / 3;
            returnVolume("the cone", volume);
            break;
        case 4:
            //Pyramid (triangular base)
            //Base length (test value: 7)
            lengthBase = DimensionsInput("Insert the length of the triangular base: ");
            //Base height (test value: 2)
            heightBase = DimensionsInput("Insert the height of the triangular base: ");
            //Height (test value: 9)
            height = DimensionsInput("Insert the height of the pyramid: ");
            //Volume (expected outcome: 21 um³)
            volume = (((lengthBase * heightBase) / 2) * height) / 3;
            returnVolume("the pyramid with triangular base", volume);
            break;
        case 5:
            //Pyramid (square base)
            //Square base side length (test value: 3)
            lengthBase = DimensionsInput("Insert the length of the sides of the square base: ");
            //Height (test value: 6)
            height = DimensionsInput("Insert the height of the pyramid: ");
            //Volume (expected outcome: 18 um³)
            volume = (Math.pow(lengthBase, 2) * height) / 3;
            returnVolume("the pyramid with square base", volume);
            break;
        case 6:
            //Pyramid (hexagonal base)
            //Comprimento lateral base (test value: 1)
            lengthBase = DimensionsInput("Insert the length of the sides of the hexagonal base: ");
            //Height (test value: 4)
            height = DimensionsInput("Insert the height of the pyramid: ");
            //Volume (expected outcome: 3,46 um³)
            volume = (Math.sqrt(3) / 2) * Math.pow(lengthBase, 2) * height;
            returnVolume("the pyramid with hexagonal base", volume);
            break;
        case 7:
            //Cylinder 
            //Radius (test value: 2)
            radius = DimensionsInput("Insert the radius of the cylinder: ");
            //Height (test value: 10)
            height = DimensionsInput("Insert the height of the cylinder: ");
            //Volume (expected outcome: 125,6 um³)
            volume = 3.14 * Math.pow(radius, 2) * height;
            returnVolume("the cylinder", volume);
            break;
        case 8:
            //Parallelepiped
            //Length (test value: 10)
            length = DimensionsInput("Insert the length of the parallelepiped: ");
            //Width (test value: 6)
            width = DimensionsInput("Insert the width of the parallelepiped: ");
            //Height (test value: 8)
            height = DimensionsInput("Insert the height of the parallelepiped: ");
            //Volume (expected outcome: 480 um³)
            volume = length * width * height;
            returnVolume("the parallelepiped", volume);
            break;
        case 9:
            //Hexagonal Prism
            //Base side length (test value: 4)
            lengthBase = DimensionsInput("Insert the length of the sides of the hexagonal base: ");
            //Height (test value: 6) 
            height = DimensionsInput("Insert the height of the prism: ");
            //Volume (expected outcome: 249,42 um³)
            volume = (3 * Math.sqrt(3) / 2) * Math.pow(lengthBase, 2) * height;
            returnVolume("the hexagonal prism", volume);
            break;
        case 10:
            //Pentagonal Prism
            //Apothem (test value: 5,5)
            apothem = DimensionsInput("Insert the length of the apothem: ");
            //Base side length (test value: 8)
            lengthBase = DimensionsInput("Insert the length of the sides of the pentagonal base: ");
            //Height (test value: 6)
            height = DimensionsInput("Insert the height of the prism: ");
            //Volume (expected outcome: 660 um³)
            volume = 2.5 * apothem * lengthBase * height;
            returnVolume("the pentagonal prism", volume);
            break;
        case 11:
            //Triangular prism
            //Base length (test value: 4)
            lengthBase = DimensionsInput("Insert the length of the triangular base: ");
            //Base height (test value: 3)
            heightBase = DimensionsInput("Insert the height of the triangular base: ");
            //Height (test value: 5)
            height = DimensionsInput("Insert the height of the prism: ");
            //Volume (expected outcome: 30 um³)
            volume = 0.5 * lengthBase * heightBase * height;
            returnVolume("the triangular prism", volume);
            break;
        case 12:
            //Dodecahedron
            //Side (test value: 2)
            length = DimensionsInput("Insert the length of the side of the dodecahedron: ");
            //Volume (expected outcome: 61,3 um³)
            volume = (15 + 7 * Math.sqrt(5)) / 4 * Math.pow(length, 3);
            returnVolume("the dodecahedron", volume);
            break;
        case 13:
            //Octahedron
            //Lado (test value: 4) 
            length = DimensionsInput("Insert the length of the side of the octahedron: ");
            //Volume (expected outcome: 30,17 um³)
            volume = (Math.sqrt(2) * Math.pow(length, 3)) / 3;
            returnVolume("the octahedron", volume);
            break;
        default:
            System.out.println("Invalid option!");
            break;
    }
        System.out.println("\nObs: \"um\" = unity of measurement");
    } 
    //Method to receive user input and deal with exceptions
    public static double DimensionsInput(String msg) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        double atributo = 0;
        do {
            try {
                System.out.print(msg);
                input = scanner.nextLine().replace(',', '.');
                atributo = Double.parseDouble(input);
                return atributo;
            }
            catch (InputMismatchException e) {
                System.out.println("ERROR: Only numbers, please.");
                scanner.next();
            }
        } while(true);
    }
    //Method to format the volume result message
    public static void returnVolume(String shape, double volume) {
        if (volume % 1 == 0) {
            System.out.printf("The volume of %s is: %.0f um³", shape, volume);
        } else {
            System.out.printf("The volume of %s is: %.2f um³", shape, volume);
        }
    }
}
