package PTBR;

import java.util.Scanner;

public class ValidadorDeData {
    public static void main(String[] args) {

        /*
        =================================================
        Github: delunatriestocode
        Linkedin: in/gabrielsilveiradeluna
        =================================================
        */

        String data;
        Scanner sacanner = new Scanner(System.in);
        int contadorDeBarras = 0;
        boolean bissexto = false;

        //Input do usuário
        System.out.print("Insira uma data: ");
        data = sacanner.nextLine();
        //Verificar a quantidade de traços
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '/') {
                contadorDeBarras++;
            }
        }
        //Checar se a data possui duas barras
        if (contadorDeBarras == 2) {
            //Checar se a data possui dia, mês e ano
            if (data.split("/").length == 3) {
                //Validar dia, mês a ano
                int dia = Integer.parseInt(data.split("/")[0]);
                int mes = Integer.parseInt(data.split("/")[1]);
                int ano = Integer.parseInt(data.split("/")[2]);
                if ((dia > 0 && dia <= 31) && (mes > 0 && mes <= 12) && (ano > 0)){
                    //Checar se o ano é bissexto
                    if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                        bissexto = true;
                    }
                    //Fevereiro
                    if (mes == 2) {
                        if (dia <= 29) {
                            if ((bissexto && dia <= 29) || (!bissexto && dia <= 28)) {
                                System.out.println("A data " + data + " é valida!");
                            } else {
                                System.out.println("DATA INVÁLIDA: O mês de Fevereiro vai só até o dia 28 (ou 29, em anos bissextos).");
                            }
                        } else {
                            System.out.println("DATA INVÁLIDA: O mês de Fevereiro vai só até o dia 28 (ou 29, em anos bissextos).");
                        }
                    //Meses que acabam em 30 (abril, junho, setembro, novembro)
                    } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                        if (dia <= 30) {
                            System.out.println("A data " + data + " é valida!");
                        } else {
                            System.out.println("DATA INVÁLIDA: Os meses de Abril, Junho, Setembro e Novembro acabam no dia 30. ");
                        }
                    //Meses que acabam em 31 (janeiro, março, maio, julho, agosto, outubro e dezembro)
                    } else {
                        if (dia <= 31) {
                            System.out.println("A data " + data + " é valida!");
                        } else {
                            System.out.println("DATA INVÁLIDA: Os meses de Janeiro, Março, Maio, Julho, Agosto, Outubro e Dezembro acabam no dia 31.");
                        }
                    }
                } else {
                    System.out.println("DATA INVÁLIDA: Em uma data válida, o dia deve ser meior que 0 e menor ou igual a 31, o mês deve ser maior que 0 e menor ou igual a 12 e o ano deve ser maior que 0.");
                }

            } else {
                System.out.println("DATA INVÁLIDA: Uma data válida deve ter dia, mês e ano");
            }
        } else {
            System.out.println("DATA INVÁLIDA: Uma data válida deve ter duas barras.");
        }
        sacanner.close();
    }
}
