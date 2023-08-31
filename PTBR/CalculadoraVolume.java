package PTBR;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculadoraVolume {
    public static void main(String[] args) {

        /*
        =================================================
        Github: delunatriestocode
        Linkedin: in/gabrielsilveiradeluna
        =================================================
        */

        Scanner scanner = new Scanner(System.in);
        int opcao;
        double aresta, raio, volume, apotema, altura, comprimento, largura, alturaBase, comprimentoBase;

        System.out.println("\n=====================================\n\tCalculadora de Volume\n\t\tv1.0\n=====================================\n");
        System.out.println("Insira o número correspondente à opção desejada:\n\n[1] Volume de um Cubo\n[2] Volume de uma esfera\n[3] Volume de um Cone\n[4] Volume de uma Pirâmide (base triangular)\n[5] Volume de uma Pirâmide (base quadrada)\n[6] Volume de uma Pirâmide (base hexagonal)\n[7] Volume de um Cilindro\n[8] Volume de um Paralelepipedo\n[9] Volume de um Prisma Hexagonal\n[10] Volume de um Prisma Pentagonal\n[11] Volume de um Prisma Triângular\n[12] Volume de um Dodecaedro\n[13] Volume de um Octaedro\n");

        //Input
        do {
            try {
                System.out.print("> ");
                opcao = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ERRO: Por favor, insira apenas números, por favor.");
            }
        } while (true);
        switch (opcao) {
            case 1:
                //Cubo
                //Comprimento arestas (valor de teste: 12) 
                aresta = inputDimensoes("Insira o comprimento das arestas: ");
                //Volume (valor esperado: 1728 um³)
                volume = Math.pow(aresta, 3);
                exibirVolume("do cubo", volume);
                break;
            case 2:
                //Esfera
                //Raio (valor de teste: 5)
                raio = inputDimensoes("Insira o valor do raio: ");
                //Volume (resultado esperado: 523,33 um³)
                volume = (4 * 3.14 * Math.pow(raio,3)) / 3;
                exibirVolume("da esfera", volume);
                break;
            case 3:
                //Cone
                //Raio (valor de teste: 6)
                raio = inputDimensoes("Insira o valor do raio: ");
                //Altura (valor de teste: 8)
                altura = inputDimensoes("Insira o valor da altura: ");
                //Volume (resultado esperado: 301,44 um³)
                volume = (3.14 * Math.pow(raio, 2) * altura) / 3;
                exibirVolume("da esfera", volume);
                break;
            case 4:
                //Pirâmide (base triangular) 
                //Comprimento base (valor de teste: 7)
                comprimentoBase = inputDimensoes("Insira o comprimento da base triangular: ");
                //Altura base (valor de teste: 2)
                alturaBase = inputDimensoes("Insira a altura da base triangular: ");
                //Altura (valor de teste: 9)
                altura = inputDimensoes("Insira a altura da pirâmide: ");
                //Volume (resultado esperado: 21 um³)
                volume = (((comprimentoBase * alturaBase) / 2) * altura) / 3;
                exibirVolume("da pirâmide de base triangular", volume);
                break;
            case 5:
                //Pirâmide (base quadrada)
                //Comprimento lateral base (valor de teste: 3)
                comprimentoBase = inputDimensoes("Insira o comprimento da de um dos lados da base quadrada: ");
                //Altura (valor de teste: 6)
                altura = inputDimensoes("Insira a altura da pirâmide: ");
                //Volume (resultado esperado: 18 um³)
                volume = (Math.pow(comprimentoBase, 2) * altura) / 3;
                exibirVolume("da pirâmide de base quadrada", volume);                
                break;
            case 6:
                //Pirâmide (base hexagonal) 
                //Comprimento lateral base (valor de teste: 1)
                comprimentoBase = inputDimensoes("Insira o comprimento de um dos lados da base hexagonal: ");
                //Altura (valor de teste: 4)
                altura = inputDimensoes("Insira a altura da pirâmide: ");
                //Volume (resultado esperado: 3,46 um³)
                volume = (Math.sqrt(3) / 2) * Math.pow(comprimentoBase, 2) * altura;
                exibirVolume("da pirâmide de base hexagonal", volume);
                break;
            case 7:
                //Cilindro 
                //Raio (valor de teste: 3,1)
                raio = inputDimensoes("Insira o raio do cilindro: ");
                //Altura (valor de teste: 10)
                altura = inputDimensoes("Insira a altura do cilindro: ");
                //Volume (resultado esperado: 301,75 um³)
                volume = 3.14 * Math.pow(raio, 2) * altura;
                exibirVolume("do cilindro", volume);
                break;
            case 8:
                //Paralelepipedo
                //Comprimento (valor de teste: 10)
                comprimento = inputDimensoes("Insira o comprimento do paralelepipedo: ");
                //Largura (valor de teste: 6)
                largura = inputDimensoes("Insira a largura do paralelepipedo: ");
                //Altura (valor de teste: 8)
                altura = inputDimensoes("Insira a altura do paralelepipedo: ");
                //Volume (resultado esperado: 480 um³)
                volume = comprimento * largura * altura;
                exibirVolume("do paralelepipedo", volume);
                break;
            case 9:
                //Prisma Hexagonal
                //Comprimento lateral base (valor de teste: 4)
                comprimentoBase = inputDimensoes("Insira o comprimento de um dos lados da base hexagonal: ");
                //Altura (valor de teste: 6) 
                altura = inputDimensoes("Insira a altura do prisma: ");
                //Volume (resultado esperado: 249,42 um³)
                volume = ((3 * Math.sqrt(3)) / 2) * Math.pow(comprimentoBase, 2) * altura;
                exibirVolume("do prisma hexagonal", volume);
                break;
            case 10:
                //Prisma Pentagonal 
                //Apótema (valor de teste: 5,5)
                apotema = inputDimensoes("Insira o comprimento do apótema: ");
                //Comprimento Lateral Base (valor de teste: 8)
                comprimentoBase = inputDimensoes("Insira o comprimento de um dos lados da base pentagonal: ");
                //Altura (valor de teste: 6)
                altura = inputDimensoes("Insira a altura do prisma: ");
                //Volume (resultado esperado: 660 um³)
                volume = 2.5 * apotema * comprimentoBase * altura;
                exibirVolume("do prisma pentagonal", volume);
                break;
            case 11:
                //Prisma Triângular
                //Comprimento base (valor de teste: 4)
                comprimentoBase = inputDimensoes("Insira o comprimento da base triangular: ");
                //Altura base (valor de teste: 3)
                alturaBase = inputDimensoes("Insira a altura da base triangular: ");
                //Altura prisma (valor de teste: 5)
                altura = inputDimensoes("Insira a altura do prisma: ");
                //Volume (resultado esperado: 30 um³)
                volume = 0.5 * comprimentoBase * alturaBase * altura;
                exibirVolume("do prisma triângular", volume);
                break;
            case 12:
                //Dodecaedro
                //Lado (valor de teste: 2)
                comprimento = inputDimensoes("Insira o comprimento de um dos lados do dodecaedro: ");
                //Volume (resultado esperado: 61,3 um³)
                volume = (15 + 7 * Math.sqrt(5)) / 4 * Math.pow(comprimento, 3);
                exibirVolume("do dodecaedro", volume);
                break;
            case 13:
                //Octaedro
                //Lado (valor de teste: 4)
                comprimento = inputDimensoes("Insira o comprimento de um dos lados do octaedro: ");
                //Volume (resultado esperado: 30,17 um³)
                volume = (Math.sqrt(2) * Math.pow(comprimento, 3)) / 3 ;
                exibirVolume("do octaedro", volume);
                break;
            default:
                break;
        }
    } 
    //Método para receber input e lidar com erros
    public static double inputDimensoes(String msg) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        double atributo = 0;
        do {
            try {
                System.out.print(msg);
                input = scanner.nextLine().replace('.',',');
                atributo = Double.parseDouble(input);
                return atributo;
            }
            catch (InputMismatchException e) {
                System.out.println("ERRO: Insira apenas números, por favor.");
                scanner.next();
            }
        } while(true);
    }
    //Método para formatar o volume
    public static void exibirVolume(String forma, double volume) {
        if (volume % 1 == 0) {
            System.out.printf("O volume %s é: %.0f um³", forma, volume);
        } else {
            System.out.printf("O volume %s é: %.2f um³", forma, volume);
        }
    }
}
