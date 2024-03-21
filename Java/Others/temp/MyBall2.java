import java.awt.*;
import java.awt.event.*;

public class MyBall2{
    public static void main(String args[]){
        Frame w = new Frame();
        w.setSize(1024,768);

        MyPanel mp = new MyPanel();
        w.add(mp);
        w.addKeyListener(mp);
        mp.addKeyListener(mp);

        w.setVisible(true);
    }
}
class MyPanel extends Panel implements KeyListener{
    int x = 30;
    int y = 30;
    public void paint(Graphics g){
        g.fillOval(x,y,20,20);
    }
    @Override
    public void keyPressed(KeyEvent arg0){
        if(arg0.getKeyCode() == 37){
            x--;
        }
        else if(arg0.getKeyCode() == 38){
            y--;
        }
        else if(arg0.getKeyCode() == 39){
            x++;
        }
        else if(arg0.getKeyCode() == 40){
            y++;
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent arg0){
        
    }
    @Override
    public void keyTyped(KeyEvent arg0){
        
    }
    
}