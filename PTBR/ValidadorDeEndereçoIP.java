package PTBR;

import java.util.Scanner;

public class ValidadorDeEndereçoIP {
    public static void main(String[] args) {

        /*
        =================================================
        Github: delunatriestocode
        Linkedin: in/gabrielsilveiradeluna
        =================================================
        */
        
        String ip = "";
        Scanner scanner = new Scanner(System.in);
        int contadorDePontos = 0;
        String[] octetos = new String[4];
        boolean octetoEhValido = false;
        
        //Input do usuário
        System.out.print("Insira um endereço de IP: ");
        ip = scanner.nextLine();
        //Contar os "." no endereço de IP inserido
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') {
                contadorDePontos++;
            }
        }
        //Criar um array de octetos a partir do endereço de IP
        octetos = ip.split("\\.");
        //Checar se o endereço de IP tem quatro octetos
        if (octetos.length == 4) {
            //Checar se todos os octetos são maiores ou iguais a 0 E menores ou iguais a 255
            if ((Integer.parseInt(octetos[0]) >= 0 && Integer.parseInt(octetos[0]) <= 255) && (Integer.parseInt(octetos[1]) >= 0 && Integer.parseInt(octetos[1]) <= 255) && (Integer.parseInt(octetos[2]) >= 0 && Integer.parseInt(octetos[2]) <= 255) && (Integer.parseInt(octetos[3]) >= 0 && Integer.parseInt(octetos[3]) <= 255)) {
                octetoEhValido = true;
            } else {
                System.out.println("IP INVÁLIDO: Todos os octetos devem estar entre 0 e 255.");
                octetoEhValido = false;
            }
        } else {
            System.out.println("IP INVÁLIDO: O endereço de IP deve ter quatro octetos.");
            octetoEhValido = false;
        }  
        if (contadorDePontos == 3 && octetoEhValido) {
            System.out.printf("O IP %s é um endereço válido!", ip);
        } 
        scanner.close();
    }
}
