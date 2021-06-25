import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class firstFrame extends JFrame
{
    JButton b1,b2,b3;
    JLabel l1;

    public firstFrame()
    {   
        setTitle("IMPLEMENTING ACTION LISTENERS FOR JAVA LAB ");
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
      
        
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("image.jpeg")));
        setLayout(null);
       
        b1=new JButton("INTRO");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dispose();
                new intro();
            } 
        });
        b2=new JButton("PLAY");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dispose();
                new play();
            }
            
        });
        b3=new JButton("HELP");
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dispose();
                new help();
            }
            
        });
      
        add(b1);
        add(b2);
        add(b3);
        b1.setBounds(100,300,80,50);
        b2.setBounds(200,300,80,50); 
        b3.setBounds(300,300,80,50); 
      
        setSize(492,398);
        setSize(492,398);
    }

 public static void main(String[] args) {
    new firstFrame();
    }
}