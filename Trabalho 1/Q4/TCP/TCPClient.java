package TCP;

import java.net.*;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TCPClient {
    public static void main (String args[]) {
        // arguments supply message and hostname
        Socket s = null;
        try {


            boolean continuar = true;
            Scanner scanner = new Scanner(System.in);
            String resposta;
            String mensagem;
            String contato = "Servidor: ";
            int serverPort = 7896;
            String check = "#";
            do{
                s = new Socket("localhost", serverPort);
                DataInputStream in = new DataInputStream( s.getInputStream());
                DataOutputStream out = new DataOutputStream( s.getOutputStream());
//                out.writeUTF(check);            // UTF is a string encoding see Sn. 4.4
//                String data = in.readUTF();	    // read a line of data from the stream
//                if(data.equals("$")){
//                    System.out.println("Servidor conectado\nDigite sair para sair ou digite seu nome para iniciar o Chat");
//                    resposta = scanner.nextLine();
//
//                    if(resposta.equals("Sair") || resposta.equals("sair") || resposta.equals("SAIR") || resposta.equals("s") || resposta.equals("S")){
//                        continuar = false;
//                    }else{
//                        resposta += " $";
//                        out.writeUTF(resposta);
//                        if(in.available() > 0){
//                            String [] strings = in.readUTF().split("@");
//                            System.out.println(strings[0] + "entrou no Chat\nInsira as mensagens ou para sair digite: !!");
//                            System.out.println(strings[1]);
//                            while(true){
//                                mensagem = scanner.nextLine();
//                                if(mensagem.equals("!!")){
//                                    break;
//                                }
//                                out.writeUTF(mensagem);
//                                System.out.println(contato + in.readUTF());
//                            }
//                        }
//                    }
//                }
//
//

                out.writeUTF(scanner.nextLine());
                System.out.println(in.readUTF());

            }while (continuar);





//            int serverPort = 7896;
//
//            boolean continuar = true;
//            String checagem = "#";
//            Scanner scanner = new Scanner(System.in);
//            String resposta;
//            String mensagem;
//            String quemEntrou;
//            String data;
//
//            s = new Socket("localHost", serverPort);
//            DataInputStream in = new DataInputStream(s.getInputStream());
//            DataOutputStream out = new DataOutputStream(s.getOutputStream());
//            out.writeUTF(checagem);
//            data = in.readUTF();
//            if (data.equals("#")) {
//                System.out.println("O Sistema de mensagens está pronto para ser ultilizado\nSe quiser conversar insira seu nome, caso contrário insira sair");
//            } else {
//                System.out.println("Ocorreu um erro inesperado");
//            }
//
//            do {
//
//
//                continuar = false;
//            } while(continuar);

        }catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        }catch (IOException e){System.out.println("readline:"+e.getMessage());
        }finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
    }
}


//           while(continuar){


// UTF is a string encoding see Sn. 4.4
// read a line of data from the stream



//                resposta = scanner.nextLine();
//
//                if(resposta.equals("Sair") || resposta.equals("sair") || resposta.equals("SAIR") || resposta.equals("s") || resposta.equals("S")){
//                    continuar = false;
//                }else{
//                    resposta += " $";
//                    out.writeUTF(resposta);
//                    quemEntrou = in.readUTF();
//                    System.out.println("Digite 0 para sair a qualquer momento ou escreva suas mensagens");
//                    System.out.println(quemEntrou + " entrou no chat!\n");
//                    do{
//                        System.out.println(in.readUTF());
//                        mensagem = scanner.nextLine();
//                        if(mensagem.equals("0")){
//                            out.writeUTF("!");
//                            break;
//                        }
//
//                    }while(true);
//                }

//}