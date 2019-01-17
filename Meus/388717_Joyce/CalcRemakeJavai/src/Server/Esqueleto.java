package Server;

public class Esqueleto {

    Calculadora calculadora = new Calculadora();

    public String adc(String args[]){
        double result = calculadora.adc(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        return "" + result;
    }

    public String sub(String args []){
        double result = calculadora.sub(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        return "" + result;
    }

    public String mul(String args []){
        double result = calculadora.mul(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        return "" + result;
    }

    public String div(String args []){
        double result = calculadora.div(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        return "" + result;
    }
}
