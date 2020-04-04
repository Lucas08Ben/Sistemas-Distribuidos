package user;

import java.net.*;
import java.io.*;
public class TCPClient {
    public String cliente (String expressao) {
        // arguments supply message and hostname
        Socket s = null;
        try{
            int serverPort = 7896;
            s = new Socket("localhost", serverPort);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out = new DataOutputStream( s.getOutputStream());
            out.writeUTF(expressao);      	// UTF is a string encoding see Sn. 4.4
            return in.readUTF();	        // read a line of data from the stream
        }catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        }catch (IOException e){System.out.println("readline:"+e.getMessage());
        }finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
        return "Null";
    }
}