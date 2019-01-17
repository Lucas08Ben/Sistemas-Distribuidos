package Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Connection extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    public Connection (Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream( clientSocket.getInputStream());
            out = new DataOutputStream( clientSocket.getOutputStream());
        } catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
    }
    public void run(){
        try {

            DataInputStream clienteInput;
            DataOutputStream clienteOutput;
            Scanner scanner = new Scanner(System.in);
            String mensagem;
            String variavel;

            clienteInput = new DataInputStream(clientSocket.getInputStream());
            clienteOutput = new DataOutputStream(clientSocket.getOutputStream());
            variavel = clienteInput.readUTF();
            System.out.println(variavel);
            clienteOutput.writeUTF(scanner.nextLine());
//            if(variavel.equals("#")){
//                clienteOutput.writeUTF("$");
//            }else if(variavel.contains("$")) {
//                variavel.replace("$", " ");
//                System.out.println(variavel + " aguardando resposta...");
//                String s = variavel +"@" + scanner.nextLine();
//                clienteOutput.writeUTF(s);
//            }else{
//                //System.out.println(clienteInput.readUTF());
//                mensagem = scanner.nextLine();
//                clienteOutput.writeUTF(mensagem);
//            }

//            String data = in.readUTF();	                  // read a line of data from the stream
//            out.writeUTF(data);
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        } catch(IOException e) {System.out.println("readline:"+e.getMessage());
        } finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}


    }
}
