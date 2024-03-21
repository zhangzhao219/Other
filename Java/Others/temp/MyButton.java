import java.awt.*;
import javax.swing.*;
public class MyButton{
    public static void main(String args[]){
        JFrame w = new JFrame();
        w.setSize(300,400);

        JButton b1 = new JButton("OK1");
        JButton b2 = new JButton("OK2");
        JButton b3 = new JButton("OK3");
        JButton b4 = new JButton("OK4");
        JButton b5 = new JButton("OK5");

        w.setLayout(new FlowLayout());
        w.add(b1);
        w.add(b2);
        w.add(b3);
        w.add(b4);
        w.add(b5);

        w.setVisible(true);
    }
}