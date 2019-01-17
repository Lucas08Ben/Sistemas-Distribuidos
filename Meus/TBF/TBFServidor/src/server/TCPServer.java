package server;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer implements Serializable{

    public static void main (String args[]){
        try{
            int serverPort = 5678; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Running in port... " + serverPort);
            Despachante despachante = new Despachante();

            while(true){

                Socket clientSocket = listenSocket.accept();
                System.out.println("Conectado " + clientSocket.toString());

                while(true) {


                    if (clientSocket.isConnected()) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        Writer out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8));
//                PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8), true);
//                PrintStream out = new PrintStream(clientSocket.getOutputStream());
//                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                        try {

                            JSONObject tmg = (JSONObject) new JSONParser().parse(in.readLine());
                            JSONObject t = despachante.run(tmg);
                            out.write(t.toString());

                            out.flush();

                            if (t.get("nome").equals("close")) {
                                try {
                                    clientSocket.close();
                                    System.out.println("Usuário Fechado");
                                    System.out.println("Ouvindo novo cliente!");
                                    break;
                                }catch (IOException e){
                                    System.out.println("Por algum motivo o sock não foi fechado!!!");
                                }
                            }




                        } catch (ParseException e) {
                            e.printStackTrace();
                        } catch (EOFException e) {
                            System.out.println("EOF:" + e.getMessage());
                        } catch (IOException e) {
                            System.out.println("readline:" + e.getMessage());
                        }
                    }
                }
            }

        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage()); e.printStackTrace();}
    }
}

