import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class UDPServer{
    public static void main(String args[]){
        DatagramSocket aSocket = null;
        try{
            aSocket = new DatagramSocket(6788);
            // create socket at agreed port
            byte[] buffer = new byte[1000];
            while(true){
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                String s = new String(request.getData(), 0, request.getLength());
                ArrayList<String> as = new ArrayList<>();
                for (String sp: s.split(" ")) {
                    as.add(sp);
                }

                Double result = 0.;

                if(as.get(1).equals("+")){
                    result =  Double.parseDouble(as.get(0)) + Double.parseDouble(as.get(2));
                }else if (as.get(1).equals("-")){
                    result =  Double.parseDouble(as.get(0)) - Double.parseDouble(as.get(2));
                }else if (as.get(1).equals("*")){
                    result =  Double.parseDouble(as.get(0)) * Double.parseDouble(as.get(2));
                }else{
                    result =  Double.parseDouble(as.get(0)) / Double.parseDouble(as.get(2));
                }

                System.out.println(result);
                String respost = result.toString();
                respost += "$";
                byte[] resposta = respost.getBytes();

                request.setData(resposta, 0, resposta.length);

                DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
                aSocket.send(reply);
            }
        }catch (SocketException e){System.out.println("Socket: " + e.getMessage());
        }catch (IOException e) {System.out.println("IO: " + e.getMessage());
        }finally {if(aSocket != null) aSocket.close();}
    }
}