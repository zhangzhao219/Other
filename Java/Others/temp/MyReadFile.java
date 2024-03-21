import java.io.*;
public class MyReadFile{
    public static void main(String args[]){
        try{
            File infile = new File("./testbook.pdf");
            File outfile = new File("./testbook1.pdf");

            FileInputStream inf = new FileInputStream(infile);
            FileOutputStream outf = new FileOutputStream(outfile);

            byte[] tmp = new byte[8192];

            int length = inf.available()/8192;
            for(int i=0;i<length;i++){
                inf.read(tmp);
                outf.write(tmp);
            }
            int size = inf.read(tmp);
            outf.write(tmp,0,size);
        }
        catch(Exception e){

        }
    }
}