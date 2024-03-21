import java.awt.*;
import java.awt.event.*;


public class MyBall3{
    public static void  main(String args[]){
        Frame w = new Frame();
        w.setSize(300,400);
        MyPanel mp = new MyPanel();
        w.add(mp);
        w.addMouseMotionListener(mp);
        mp.addMouseMotionListener(mp);
        w.setVisible(true);

    }
}
class MyPanel extends Panel implements MouseMotionListener{
    int x = 30;
    int y = 30;
    public void paint(Graphics g){
        g.fillOval(x, y, 20, 20);
    }
    @Override
    public void mouseDragged(MouseEvent arg0){
        x = arg0.getX();
        y = arg0.getY();
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent arg0){
        
    }
}