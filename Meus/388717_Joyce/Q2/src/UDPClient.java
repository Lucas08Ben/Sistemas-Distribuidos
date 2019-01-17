import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UDPClient{
    public static void main(String args[]){
        // args give message contents and destination hostname
        DatagramSocket aSocket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Por favor insira: número operação número.\nEx: -25 * 44 " );
            String s = scanner.nextLine();
            aSocket = new DatagramSocket();
            byte [] m = s.getBytes();
            InetAddress aHost = InetAddress.getByName("localhost");
            int serverPort = 6788;
            DatagramPacket request = new DatagramPacket(m,  s.length(), aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[s.length() * 2];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);

            ArrayList<String> resposta = new ArrayList<>();
            for (String res :new String(reply.getData()).split("\\$")) {
                resposta.add(res);
            }

            System.out.println("Resposta: " + resposta.get(0));
        }catch (SocketException e){System.out.println("Socket: " + e.getMessage());
        }catch (IOException e){System.out.println("IO: " + e.getMessage());
        }finally {if(aSocket != null) aSocket.close();}
    }
}
