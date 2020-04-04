package server;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Despachante extends Thread implements Serializable {

    public JSONObject run(JSONObject in){
        Esqueleto esqueleto = new Esqueleto();
        if(in.get("action").equals("born")){
            System.out.println("Born...");
//            System.out.println(in.toString());
             return esqueleto.born(in);
        }else if(in.get("action").equals("feed")){
            System.out.println("Feed...");
            return esqueleto.feed(in);
        }else if(in.get("action").equals("play")){
            System.out.println("Play...");
            return esqueleto.play(in);
        }else if(in.get("action").equals("bathe")){
            System.out.println("Batche...");
            return esqueleto.bathe(in);
        }else if(in.get("action").equals("let_rest")){
            System.out.println("Let Rest...");
            return esqueleto.left_rest(in);
        }else if(in.get("action").equals("give_affection")){
            System.out.println("Give Affection...");
            return esqueleto.give_affection(in);
        }else if(in.get("action").equals("current_status")) {
            System.out.println("Current Status...");
            return esqueleto.current_status(in);
        }else if(in.get("action").equals("close")){
            JSONObject T = new JSONObject();
            T.put("nome", "close");
            return T;
        }else{
            System.out.println("Algo deu errado!");
        }
        return null;
    }
}
