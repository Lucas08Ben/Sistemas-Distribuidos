package server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InteradorTamagotchi implements Serializable {
    List<String> feedMessageOptions = new ArrayList<String>(){
        {
            add("Que comida boa, Yammy");
            add("Tava ruim mas pelo menos é comida");
            add("Obrigado pela comida");
        }
    };
    List<String> playMessageOptions = new ArrayList<String>(){
        {
            add("Hahahaha, que divertido!");
            add("Mas que brincadeira ruim!");
            add("Você não teria coisa melhor não?");
            add("Você me faz feliz");
        }
    };
    List<String> batheMessageOptions = new ArrayList<String>(){
        {
            add("Estou limpinho!");
            add("Que banho gostoso");
            add("Cadê o meu chulé? Sumiu!");
        }
    };
    List<String> letRestMessageOptions = new ArrayList<String>(){
        {
            add("Quem foi que apagou a luzes?");
            add("Mais 5 minutos por favor");
            add("BIP, TURNING ON");
        }
    };
    List<String> giveAffectionMessageOptions = new ArrayList<String>(){
        {
            add("kkkkkkkk, boa piada!");
            add("Te amo");
            add("Que papo furado");
        }
    };
    public Tamagotch born(String nome){
        int bar = 70;
        String tamagoth = "";
        //Criando tamagosh, gerando formas

        Random random = new Random();
        for(int i = 0; i < 5; i++){

            if(i == 2){
                tamagoth += nome + "\n";
            }else{
                for(int j = 0; j < nome.length(); j++){
                    tamagoth += random.nextInt(10);
                }
                tamagoth += "\n";
            }

        }
//        System.out.println(tamagoth);

        return new Tamagotch(nome, tamagoth ,bar, bar, bar, bar, "GUGU DADA");
    }

    public Tamagotch feed(Tamagotch tmg){
        tmg.setMessage("");

        int opcao = new Random().nextInt(feedMessageOptions.size());

        String message = feedMessageOptions.get(opcao);

        tmg.setFoodBar(tmg.getFoodBar() + new Random().nextInt(21));
        tmg.setEnergyBar(tmg.getEnergyBar() - new Random().nextInt(11));
        tmg.setCleanBar(tmg.getCleanBar() - new Random().nextInt(11));

        return messageStatus(tmg, message);
    }

    public Tamagotch play(Tamagotch tmg){
        tmg.setMessage("");

        int opcao = new Random().nextInt(playMessageOptions.size());

        String message = playMessageOptions.get(opcao);

        tmg.setFoodBar(tmg.getFoodBar() - new Random().nextInt(11));
        tmg.setEnergyBar(tmg.getEnergyBar() - new Random().nextInt(11));
        tmg.setCleanBar(tmg.getCleanBar() - new Random().nextInt(11));
        tmg.setFunBar(tmg.getFunBar() + new Random().nextInt(21));

        return  messageStatus(tmg, message);
    }
    public Tamagotch bathe(Tamagotch tmg){
        tmg.setMessage("");

        int opcao = new Random().nextInt(batheMessageOptions.size());

        String message = batheMessageOptions.get(opcao);

        tmg.setFoodBar(tmg.getFoodBar() - new Random().nextInt(6));
        tmg.setEnergyBar(tmg.getEnergyBar() - new Random().nextInt(6));
        tmg.setCleanBar(100);

        return  messageStatus(tmg, message);
    }
    public Tamagotch let_rest(Tamagotch tmg){
        tmg.setMessage("");

        int opcao = new Random().nextInt(letRestMessageOptions.size());

        String message = letRestMessageOptions.get(opcao);

        tmg.setFoodBar(tmg.getFoodBar() - new Random().nextInt(11));
        tmg.setEnergyBar(100);
        tmg.setCleanBar(tmg.getCleanBar() - new Random().nextInt(6));
        tmg.setFunBar(tmg.getFunBar() - new Random().nextInt(31));

        return  messageStatus(tmg, message);
    }
    public Tamagotch give_affection(Tamagotch tmg){
        tmg.setMessage("");

        int opcao = new Random().nextInt(giveAffectionMessageOptions.size());

        String message = giveAffectionMessageOptions.get(opcao);

        tmg.setFoodBar(tmg.getFoodBar() - new Random().nextInt(6));
        tmg.setEnergyBar(tmg.getEnergyBar() - new Random().nextInt(11));
        tmg.setFunBar(tmg.getFunBar() + new Random().nextInt(11));

        return  messageStatus(tmg, message);
    }

    //Retornar o sentimento na mensagem, Feliz, Triste, Doente, etc
    public Tamagotch current_status(Tamagotch tmg){
        tmg.setMessage("");
        int geral = (tmg.getFoodBar() + tmg.getFunBar() + tmg.getEnergyBar() + tmg.getCleanBar())/4;
        String message = "";
        if(geral == 0){
            return messageStatus(tmg, message);
        }else if(geral < 50){
            message += "Irritado ";
        }else if(geral < 70){
            message += "Normal ";
        }else if(geral < 90){
            message += "Feliz ";
        }else if(geral < 100){
            message += "Inspirado ";
        }else{
            message += "Enjoado ";
        }

        return  messageStatus(tmg, message);
    }

    public Tamagotch messageStatus(Tamagotch tmg, String message){
        if(tmg.getFoodBar() > 150 || tmg.getFunBar() > 150 || tmg.getCleanBar() > 150 || tmg.getEnergyBar() > 150 || tmg.getFoodBar() <= 0 || tmg.getFunBar() <= 0 || tmg.getCleanBar() <= 0 || tmg.getEnergyBar() <= 0){
            tmg.setMessage("R.I.P.");
            tmg.setCleanBar(0);
            tmg.setEnergyBar(0);
            tmg.setFunBar(0);
            tmg.setFoodBar(0);

            return tmg;
        }

        if(tmg.getFoodBar() > 100 || tmg.getFunBar() > 100 || tmg.getCleanBar() > 100 || tmg.getEnergyBar() > 100){
            message += " Mas estou dodói";
        }

        if(tmg.getFoodBar() < 50){
            message+=" e Ainda estou com fome";
        }
        if(tmg.getFunBar() < 50){
            message+=" e Preciso me divertir";
        }
        if(tmg.getCleanBar() < 50){
            message+=" e Preciso tomar banho";
        }
        if(tmg.getEnergyBar() < 50){
            message+=" e Preciso descansar";
        }

        tmg.setMessage(message);
        return tmg;
    }

    public Tamagotch toTamagotch (String args[]){
        return new Tamagotch(args[1],args[8], Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]),args[7]);
    }
}
