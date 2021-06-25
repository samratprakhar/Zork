
import javax.swing.JFrame;  
import javax.swing.*; 
import java.util.Random;
import java.awt.event.*;

public class captcha{ 
    public static String text ="";
    captcha(){
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    frame.getContentPane();
    JLabel l1=new JLabel();
    l1.setBounds(10,10,100,20);
    JLabel l2=new JLabel("Fill out the captcha");
    l2.setBounds(10,100,200,20);
    JTextField tf1=new JTextField();  
    tf1.setBounds(10,40,80,20); 
    l1.setText(getText());
    Icon icon = new ImageIcon("refresh.jpeg");
    JButton b1 = new JButton(icon);
    JButton b2 = new JButton("Submit");
    b2.setBounds(10,70,100,20); 
    b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(text.equals(tf1.getText())){
                JOptionPane.showMessageDialog(frame,"Correct");
                frame.dispose();
            }
            else{
                JOptionPane.showMessageDialog(frame,"Incorrect");
                frame.dispose();
                l1.setText("");
                new captcha();
            }
        }
        });
    panel.add(b2); 

    b1.setBounds(120,10,20,20); 
    b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            l1.setText("");
            l1.setText(getText());
        }
        });
    panel.add(b1); 
   
    panel.add(tf1);
    panel.add(l1);
    panel.add(l2);
    panel.setLayout(null);
    frame.add(panel);
    frame.setSize(500,500);  
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    } 
    String getText(){
    text="";
    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321";
    Random rnd = new Random();
        for (int i =0; i<5;i++){
            char c = chars.charAt(rnd.nextInt(chars.length()));
            text = text +c ;
        } 
    return text;
    }
    
}  