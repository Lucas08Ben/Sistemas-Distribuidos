package user;

import java.util.Scanner;

public class User {

    public static void main(String args []){
        System.out.println("Seja Bem Vindo ao sistema de calculadoras");
        System.out.println("Por favor insira sua expressão: (Ex: 22 + 21)");
        Scanner scanner = new Scanner(System.in);
        String expressão = scanner.nextLine();

        String termos [] = expressão.split(" ");
        Proxy proxy = new Proxy();

        double resultado;

        switch (termos[1]) {
            case "+":
                resultado = proxy.adc(Double.parseDouble(termos[0]), Double.parseDouble(termos[2]));
                break;
            case "-":
                resultado = proxy.sub(Double.parseDouble(termos[0]), Double.parseDouble(termos[2]));
                break;
            case "*":
                resultado = proxy.mul(Double.parseDouble(termos[0]), Double.parseDouble(termos[2]));
                break;
            default:
                resultado = proxy.div(Double.parseDouble(termos[0]), Double.parseDouble(termos[2]));
                break;
        }

        System.out.println("A resposta é: " + resultado);


    }

}