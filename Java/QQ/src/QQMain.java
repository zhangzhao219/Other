import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class QQMain extends JFrame implements ActionListener{
    private Socket s;
    public void setSocket(Socket value){
        s = value;
    }

    JTextField txtMess = new JTextField();
    JComboBox cmbUser = new JComboBox();
    JTextArea txtContent = new JTextArea();
    QQMain(){
        this.setSize(300,400);

        JButton btnSend = new JButton("发送");
        btnSend.addActionListener(this);

        JScrollPane spContent = new JScrollPane(txtContent);

        JPanel panSmall = new JPanel();
        panSmall.setLayout(new GridLayout(1,2));
        panSmall.add(cmbUser);
        panSmall.add(btnSend);

        JPanel panBig = new JPanel();
        panBig.setLayout(new GridLayout(2,1));
        panBig.add(txtMess);
        panBig.add(panSmall);

        this.setLayout(new BorderLayout());
        this.add(panBig,BorderLayout.NORTH);
        this.add(spContent,BorderLayout.SOUTH);
        try{
            File f = new File("./聊天记录.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while(br.ready()){
                txtContent.append(br.readLine() + "\n");
            }
        }
        catch(Exception e){

        }

    }
    @Override
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getActionCommand().equals("发送")){
            txtContent.append(txtContent.getText() + "\n");
            try{
                File f = new File("./聊天记录.txt");
                FileWriter fw = new FileWriter(f,true);
                PrintWriter pw = new PrintWriter(fw);

                pw.println(txtMess.getText());
                pw.close();
            }
            catch(Exception e){

            }
            try{
                OutputStream os = s.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                PrintWriter pw = new PrintWriter(osw,true);

                pw.println(txtMess.getText());
            }
            catch(Exception e){
                
            }
            txtMess.setText("");
        }
    }
}

