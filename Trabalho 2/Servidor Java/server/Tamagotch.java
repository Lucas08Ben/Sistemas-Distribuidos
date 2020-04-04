package server;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Tamagotch implements Serializable {
    private String nome;
    private String face;
    private int foodBar;
    private int funBar;
    private int cleanBar;
    private int energyBar;
    private String message;

    public Tamagotch(String nome, String face, int foodBar, int funBar, int cleanBar, int energyBar, String message) {
        this.nome = nome;
        this.face = face;
        this.foodBar = foodBar;
        this.funBar = funBar;
        this.cleanBar = cleanBar;
        this.energyBar = energyBar;
        this.message = message;
    }



    public Tamagotch(JSONObject tama) {
        this.nome = (String) tama.get("nome");
        this.foodBar = Integer.parseInt(tama.get("food").toString());
        this.funBar = Integer.parseInt(tama.get("fun").toString());
        this.cleanBar = Integer.parseInt(tama.get("clean").toString());
        this.energyBar = Integer.parseInt(tama.get("energy").toString());
        this.message = (String) tama.get("message");
        this.face = (String) tama.get("face");
    }


    public int getFoodBar() {
        return foodBar;
    }

    public void setFoodBar(int foodBar) {
        this.foodBar = foodBar;
    }

    public int getFunBar() {
        return funBar;
    }

    public void setFunBar(int funBar) {
        this.funBar = funBar;
    }

    public int getCleanBar() {
        return cleanBar;
    }

    public void setCleanBar(int cleanBar) {
        this.cleanBar = cleanBar;
    }

    public int getEnergyBar() {
        return energyBar;
    }

    public void setEnergyBar(int energyBar) {
        this.energyBar = energyBar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "Tamagotch{" +
                "nome='" + nome + '\'' +
                ", face='" + face + '\'' +
                ", foodBar=" + foodBar +
                ", funBar=" + funBar +
                ", cleanBar=" + cleanBar +
                ", energyBar=" + energyBar +
                ", message='" + message + '\'' +
                '}';
    }

    public JSONObject toJson(){
        JSONObject T = new JSONObject();
        T.put("nome", nome);
        T.put("food", foodBar);
        T.put("fun", funBar);
        T.put("clean", cleanBar);
        T.put("energy", energyBar);
        T.put("face", face);
        T.put("message", message);
        return T;
    }
}
