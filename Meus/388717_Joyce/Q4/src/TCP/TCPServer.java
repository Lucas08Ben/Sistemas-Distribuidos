package TCP;

import Connection.Connection;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TCPServer {
    public static void main (String args[]) {
        try{
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("O servidor está pronto");

            while(true) {
                Socket clientSocket = listenSocket.accept();
                Connection connection = new Connection(clientSocket);
                connection.start();
            }
//                clienteInput = new DataInputStream(clientSocket.getInputStream());
//                clienteOutput = new DataOutputStream(clientSocket.getOutputStream());

//                System.out.println(clienteInput.readUTF());

//                if(clienteInput.readUTF().equals("#")) {
//                    Connection c = new Connection(clientSocket);
//                }

//                }else if(clienteInput.readUTF().equals("!")){
//                    chats.remove(clientSocket);
//                }else{
//                    String nome = clienteInput.readUTF();
//                    for (Socket s: chats) {
//                        if(s.getPort() != clientSocket.getPort()){
//                            Connection c = new Connection(s);
//                        }
//                    }
//                }
        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }
}

