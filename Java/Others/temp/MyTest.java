import java.awt.*;
public class MyTest{
    public static void main(String args[]){
        Frame w = new Frame();
        w.setSize(1366,768);
        w.setBackground(new Color(0,0,0));
        MyPanel mp = new MyPanel();
        w.add(mp);
        w.setVisible(true);
    }

}
class MyPanel extends Panel{
    public void paint(Graphics g){
        g.setFont(new Font("",0,36));
        g.setColor(Color.WHITE);
        for(int i=0;i<300;i++){
            g.drawString("*", (int)(Math.random() * 1366), (int)(Math.random() * 768));
        }

    }
}