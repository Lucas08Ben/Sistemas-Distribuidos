package Server;

import java.net.*;
import java.io.*;
public class TCPServer {

    public static void main (String args[]) {
        DataInputStream in;
        DataOutputStream out;
        try{
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Running");
            while(true) {
                Socket clientSocket = listenSocket.accept();
                Despachante despachante = new Despachante();
                in = new DataInputStream( clientSocket.getInputStream());
                out = new DataOutputStream( clientSocket.getOutputStream());

                out.writeUTF(despachante.run(in.readUTF()));


            }
        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }
}

