package TCP;

import Connection.Connection;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class TCPServer {
    public static void main (String args[]) {
        DataInputStream clienteInput;
        DataOutputStream clienteOutput;
        DataOutputStream co;
        try{
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("O servidor está pronto");
            ArrayList<Socket> chats = new ArrayList<>();

            while(true) {
                Socket clientSocket = listenSocket.accept();
                clienteInput = new DataInputStream(clientSocket.getInputStream());
                clienteOutput = new DataOutputStream(clientSocket.getOutputStream());

                if(clienteInput.readUTF().equals("#")){
                    Connection c = new Connection(clientSocket);
                }else if(clienteInput.readUTF().contains("$")){
                    chats.add(clientSocket);
                    String [] nome = clienteInput.readUTF().split(" ");
                    for (Socket s: chats) {
                        if(s.getPort() == clientSocket.getPort()){
                            clienteOutput.writeUTF(nome[0]);
                            Connection c = new Connection(s);
                        }
                        co = new DataOutputStream(s.getOutputStream());
                        co.writeUTF(nome[0]);
                        Connection c = new Connection(s);
                    }
                }else if(clienteInput.readUTF().equals("!")){
                    chats.remove(clientSocket);
                }else{
                    String nome = clienteInput.readUTF();
                    for (Socket s: chats) {
                        if(s.getPort() != clientSocket.getPort()){
                            co = new DataOutputStream(s.getOutputStream());
                            co.writeUTF(nome);
                            Connection c = new Connection(s);
                        }
                    }
                }
            }
        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }
}

