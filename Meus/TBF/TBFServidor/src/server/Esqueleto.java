package server;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Esqueleto implements Serializable {

    private InteradorTamagotchi interadorTamagotchi = new InteradorTamagotchi();


    public JSONObject born(JSONObject arg){
        System.out.println(arg.toString());
        Tamagotch tmg = interadorTamagotchi.born(arg.get("nome").toString());
        System.out.println("Modificado para:");
        System.out.println(tmg.toString());

        return tmg.toJson();
    }

    public JSONObject feed(JSONObject args){
        System.out.println(args.toString());
        Tamagotch tmg = interadorTamagotchi.feed(new Tamagotch(args));
        System.out.println("Modificado para:");
        System.out.println(tmg.toString());

        return tmg.toJson();
    }

    public JSONObject play(JSONObject args){
        System.out.println(args.toString());
        Tamagotch tmg = interadorTamagotchi.play(new Tamagotch(args));
        System.out.println("Modificado para:");
        System.out.println(tmg.toString());

        return tmg.toJson();
    }

    public JSONObject bathe(JSONObject args){
        System.out.println(args.toString());
        Tamagotch tmg = interadorTamagotchi.bathe(new Tamagotch(args));
        System.out.println("Modificado para:");
        System.out.println(tmg.toString());

        return tmg.toJson();
    }

    public JSONObject left_rest(JSONObject args){
        System.out.println(args.toString());
        Tamagotch tmg = interadorTamagotchi.let_rest(new Tamagotch(args));
        System.out.println("Modificado para:");
        System.out.println(tmg.toString());

        return tmg.toJson();
    }

    public JSONObject give_affection(JSONObject args){
        System.out.println(args.toString());
        Tamagotch tmg = interadorTamagotchi.give_affection(new Tamagotch(args));
        System.out.println("Modificado para:");
        System.out.println(tmg.toString());

        return tmg.toJson();
    }

    public JSONObject current_status(JSONObject args){
        System.out.println(args.toString());
        Tamagotch stt = interadorTamagotchi.current_status(new Tamagotch(args));
        return stt.toJson();
    }

    public String toStringTMG(Tamagotch tmg){
        return tmg.getNome() + " " + tmg.getFoodBar() + " " + tmg.getFunBar() + " " + tmg.getCleanBar() + " " + tmg.getEnergyBar() + " " + tmg.getMessage() + " " + tmg.getFace();
    }
}
