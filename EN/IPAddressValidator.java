package EN;
import java.util.Scanner;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ip = "";
        Scanner scanner = new Scanner(System.in);
        int dotCounter = 0;
        String[] octets = new String[4];
        boolean octetIsValid = false;
        
        //User Input
        System.out.print("Insert an IP address: ");
        ip = scanner.nextLine();

        //Count dots in IP address
        for (int i = 1; i <= ip.length(); i++) {
            if (ip.charAt(i-1) == '.') {
                dotCounter++;
            }
        }

        //Split IP address into array of octets
        octets = ip.split("\\.");

        //Check if IP address has 4 octets
        if (octets.length == 4) {

            //Check if every octet is bigger or equal to 0 AND smaller or equal to 255
            if ((Integer.parseInt(octets[0]) >= 0 && Integer.parseInt(octets[0]) <= 255) && (Integer.parseInt(octets[1]) >= 0 && Integer.parseInt(octets[1]) <= 255) && (Integer.parseInt(octets[2]) >= 0 && Integer.parseInt(octets[2]) <= 255) && (Integer.parseInt(octets[3]) >= 0 && Integer.parseInt(octets[3]) <= 255)) {
                octetIsValid = true;
            } else {
                System.out.println("INVALID IP: every octet has to have a value between 0 and 255.");
                octetIsValid = false;
            }
        } else {
            System.out.println("INVALID IP: every IP adress has to have four octets.");
            octetIsValid = false;
        }  

        if (dotCounter == 3 && octetIsValid) {
            System.out.printf("The ip %s is valid!", ip);
        }
        scanner.close();
    }
}
