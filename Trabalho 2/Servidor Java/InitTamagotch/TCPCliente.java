package InitTamagotch;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TCPCliente implements Serializable{
    public JSONObject cliente (JSONObject jsonTamagotch) {
        // arguments supply message and hostname
        Socket s = null;
        try{
            System.out.println("TCP Client init");
            int serverPort = 4444;
            s = new Socket("localhost", serverPort);
//            DataInputStream in = new DataInputStream( s.getInputStream());
//            DataOutputStream out = new DataOutputStream( s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            Writer out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8));
            System.out.println("1");
//            System.out.println(jsonTamagotch.toString());
            try {
                out.write(jsonTamagotch.toJSONString());
                out.flush();

                JSONObject tmg = (JSONObject) new JSONParser().parse(in.readLine());
                System.out.println(tmg.toString());
                return tmg;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        }catch (IOException e){System.out.println("readline:"+e.getMessage()); e.printStackTrace();
        }finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
        return null;
    }
}
