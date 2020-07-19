package Server;

public class Despachante extends Thread {

    public String run(String in){
            String data = in;
            String dataB [] = data.split(" ");

            data = dataB[0];

            dataB[0] = dataB[1];
            dataB[1] = dataB[2];
            Esqueleto esqueleto = new Esqueleto();
            switch (data){
                case "+":
                    data = esqueleto.adc(dataB);
                    break;
                case "-":
                    data = esqueleto.sub(dataB);
                    break;
                case "*":
                    data = esqueleto.mul(dataB);
                    break;
                case "/":
                    data = esqueleto.div(dataB);
                    break;

            }

            return data;


    }
}
