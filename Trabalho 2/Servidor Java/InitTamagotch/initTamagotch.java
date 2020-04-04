package InitTamagotch;

import server.Tamagotch;

import java.util.Scanner;

public class initTamagotch {
    public static void main(String[] tmg) {

        int opcao;

        System.out.println("seja bem vindo!\nComeçe inserindo o nome do seu bichinho");
        Scanner scanner = new Scanner(System.in);
//        String nome = scanner.nextLine();
        String nome = "Shell";

        Proxy proxy = new Proxy();

        Tamagotch tamagotch = proxy.born(nome);

        System.out.println(tamagotch.toString());

        while (true) {
            System.out.println("O que deseja fazer agora ?");
            System.out.println("1-Alimentar\n2-Brincar\n3-Dar banho\n4-Colocar para dormir\n5-Conversar\n6-Status\n0-Sair\n");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Ate logo mais!");
                    return;
                case 1:
                    proxy.Action("feed");
                    break;
                case 2:
                    proxy.Action("play");
                    break;
                case 3:
                    proxy.Action("bathe");
                    break;
                case 4:
                    proxy.Action("left_rest");
                    break;
                case 5:
                    proxy.Action("give_affection");
                    break;
                case 6:
                    proxy.Action("current_status");
                    break;
            }
        }
    }
}
