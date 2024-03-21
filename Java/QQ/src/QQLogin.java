import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class QQLogin extends JFrame implements ActionListener{

    JTextField txtUser = new JTextField();
    JPasswordField txtPass = new JPasswordField();

    QQLogin(){
        this.setSize(250,125);

        JLabel labUser = new JLabel("用户名");
        JLabel labPass = new JLabel("密码");

        JButton btnLogin = new JButton("登录");
        JButton btnReg = new JButton("注册");
        JButton btnCancel = new JButton("取消");

        btnLogin.addActionListener(this);
        btnReg.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel panInput = new JPanel();
        panInput.setLayout(new GridLayout(2,2));
        panInput.add(labUser);
        panInput.add(txtUser);
        panInput.add(labPass);
        panInput.add(txtPass);

        JPanel panButton = new JPanel();
        panButton.setLayout(new FlowLayout());

        panButton.add(btnLogin);
        panButton.add(btnReg);
        panButton.add(btnCancel);

        this.setLayout(new BorderLayout());
        this.add(panInput,BorderLayout.NORTH);
        this.add(panButton,BorderLayout.SOUTH);
    }
    public static void main(String args[]){
        QQLogin w = new QQLogin();
        w.setLocationByPlatform(true);
        w.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0){
        if(arg0.getActionCommand().equals("登录")){
            try{
                String user = txtUser.getText();
                String password = String.valueOf(txtPass.getPassword());
    
                Socket s = new Socket("127.0.0.1",8000);
                OutputStream os = s.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                PrintWriter pw = new PrintWriter(osw,true);
                pw.println(user + "%" + password);

                InputStream is = s.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String yorn = br.readLine();
                if(yorn.equals("ok")){
                    QQMain w = new QQMain();
                    w.setSocket(s);
                    w.setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(this, "wrong");
                }
            }
            catch(Exception e){

            }
        }
        if(arg0.getActionCommand().equals("注册")){
            System.out.println("用户点了注册");
        }
        if(arg0.getActionCommand().equals("取消")){
            System.out.println("用户点了取消");
        }
    }
}
