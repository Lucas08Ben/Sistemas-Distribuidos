package TCP;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient {
    public static void main (String args[]) {
        // arguments supply message and hostname
        Socket s = null;
        try{
            int serverPort = 7896;

            boolean continuar = true;
            String checagem = "#";
            Scanner scanner = new Scanner(System.in);
            String resposta;
            String mensagem;
            String quemEntrou;
            String data;

            while(continuar){
                s = new Socket("localHost", serverPort);
                DataInputStream in = new DataInputStream( s.getInputStream());
                DataOutputStream out = new DataOutputStream( s.getOutputStream());
                out.writeUTF(checagem);      	// UTF is a string encoding see Sn. 4.4
                data = in.readUTF();	    // read a line of data from the stream
                System.out.println(data);

                if(data.equals("#")){
                    System.out.println("O Sistema de mensagens está pronto para ser ultilizado\nSe quiser conversar insira seu nome, caso contrário insira sair");
                }else{
                    System.out.println("Ocorreu um erro inesperado");
                }

                resposta = scanner.nextLine();

                if(resposta.equals("Sair") || resposta.equals("sair") || resposta.equals("SAIR") || resposta.equals("s") || resposta.equals("S")){
                    continuar = false;

                }else{
                    resposta += " $";
                    out.writeUTF(resposta);
                    quemEntrou = in.readUTF();
                    System.out.println("Digite 0 para sair a qualquer momento ou escreva suas mensagens");
                    System.out.println(quemEntrou + " entrou no chat!\n");
                    do{

                        System.out.println(in.readUTF());
                        mensagem = scanner.nextLine();
                        if(mensagem.equals("0")){
                            out.writeUTF("!");
                            break;
                        }

                    }while(true);
                }

            }










        }catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        }catch (IOException e){System.out.println("readline:"+e.getMessage());
        }finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
    }
}