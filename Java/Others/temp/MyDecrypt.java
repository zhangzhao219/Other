import java.io.*;
public class MyDecrypt{
    public static void main(String args[]){
        try{
            int key[] = new int[128];
            File keyFile = new File("./key");
            FileInputStream inkey = new FileInputStream(keyFile);
    
            for(int i=0;i<128;i++){
                key[i] = inkey.read();
            }
            File infile = new File("./test1.txt");
            File outfile = new File("./test2.txt");
    
            FileInputStream inf = new FileInputStream(infile);
            FileOutputStream outf = new FileOutputStream(outfile);

            int length = inf.available();
            for(int i=0;i<length;i++){
                outf.write(inf.read() - key[i%128]);
            }
        }
        catch(Exception e){

        }

    }
}
