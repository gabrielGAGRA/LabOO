package JAVA.LabOO.Exercicios.Aula_1;

import java.util.Scanner; //biblioteca stdin, java.util.Scanner

public class CelsiusConvert { // criamos classe publica (nosso codigo)
    public static void converte_temperatura(double temperatura, int escolha) { // criamos funcao static void (converte e
                                                                               // print)
        if (escolha == 1) { // C para F
            System.out.println((temperatura * 9 / 5) + 32);
            double farenheit = (temperatura * 9 / 5) + 32;
            System.out.print(String.format("Farenheit: %.2f", farenheit));
        }
        if (escolha == 2) { // F para C
            double celsius = (temperatura - 32) * 5 / 9;
            System.out.print(String.format("Celsius: %.2f", celsius));
        }
        if (escolha == 3) { // C para K
            double kelvin = temperatura + 273;
            System.out.print(String.format("Kelvin: %.2f", kelvin));
        }
        if (escolha == 4) { // K para C
            double celsius = temperatura - 273;
            System.out.print(String.format("Celsius: %.2f", celsius));
        }
        if (escolha == 5) { // K para F
            double farenheit = (temperatura - 273) * 9 / 5 + 32;
            System.out.print(String.format("Farenheit: %.2f", farenheit));
        }
    }

    public static void main(String[] args) {
        int escolha = Integer.parseInt(args[0]);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temperatura = input.nextDouble();
        converte_temperatura(temperatura, escolha);
    }
}
