import java.io.*;
import java.net.*;

public class QQServer{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(8000);

            System.out.println("服务器正在8000端口监听。。。");
            Socket s = ss.accept();

            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String uandp = br.readLine();

            String u = "";
            String p = "";
            try{
                u = uandp.split("%")[0];
                p = uandp.split("%")[1];
            }
            catch(Exception ee){

            }

            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw,true);

            if(u.equals("aaa") && p.equals("111")){
                pw.println("ok");
                while(true){
                    String message = br.readLine();
                    System.out.println(message);
                }
            }
            else{
                pw.println("err");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}