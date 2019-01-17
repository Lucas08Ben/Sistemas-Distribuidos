package user;

public class Proxy {

    private TCPClient tcpClient = new TCPClient();

    public double adc(double num1, double num2){
        String request = "+ " + num1 + " " + num2;
        String response = tcpClient.cliente(request);
        return Double.parseDouble(response);
    }

    public double sub(double num1, double num2){
        String request = "- " + num1 + " " + num2;
        String response = tcpClient.cliente(request);
        return Double.parseDouble(response);
    }

    public double mul(double num1, double num2){
        String request = "* " + num1 + " " + num2;
        String response = tcpClient.cliente(request);
        return Double.parseDouble(response);
    }

    public double div(double num1, double num2){
        String request = "/ " + num1 + " " + num2;
        String response = tcpClient.cliente(request);
        return Double.parseDouble(response);
    }
    


}
