import java.io.*;
public class MyReadfile2{
    public static void main(String args[]){
        try{
            File inFile = new File("./test.txt");
            File outfile = new File("./test1.txt");

            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outfile);
            PrintWriter pw = new PrintWriter(fw);

            while(br.ready()){
                pw.println(br.readLine());
            }
            pw.close();
        }
        catch(Exception e){
            
        }
    }
}