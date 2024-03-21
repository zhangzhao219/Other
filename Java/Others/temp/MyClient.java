import java.io.*;
import java.net.*;
public class MyClient{
    public static void main(String args[]){
        try{
            Socket s = new Socket("127.0.0.1",8000);

            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw,true);

            pw.println("Õı—Û");

            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String mess = br.readLine();
            System.out.println(mess);
        }
        catch(Exception e){

        }
    }
}