import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class quiz 
{
    JFrame f;
	JButton b1,b2;
    JTextArea l1,l2,l3,l4,l5;
    //JTextField tf1,tf2,tf3,tf4,tf5;
    JCheckBox cb1a,cb1b,cb1c,cb2a,cb2b,cb2c,cb3a,cb3b,cb3c,cb4a,cb4b,cb4c,cb5a,cb5b,cb5c;
    private ButtonGroup check1,check2,check3,check4,check5;
      

    public quiz()
    {   
        JFrame f =new JFrame();
        f.setTitle("quiz");
       // setSize(600,300);
        //setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
  
        f.setLayout(new BorderLayout());
   
        f.setLayout(null);
        l1=new JTextArea("QUESTION 1- what is the name of 6th noble gas ?");
        l2=new JTextArea("QUESTION 2- what will happen if you overreact in front of raju ?");
        l3=new JTextArea("QUESTION 3- what does bheem's power (bheem ki shakti) do ?");
        l4=new JTextArea("QUESTION 4- matchmaking algorithms are a ?");
        l5=new JTextArea("QUESTION 5- utha le re baba uhta le is whose catchphrase ?");

     

        JCheckBox cb1a = new JCheckBox("Helium");  
        JCheckBox cb1b = new JCheckBox("Neon");  
        JCheckBox cb1c = new JCheckBox("Radon "); 

        check1 = new ButtonGroup();
        check1.add(cb1a);
        check1.add(cb1b);
        check1.add(cb1c);


        JCheckBox cb2a = new JCheckBox("50 rupiya kaat overacting ka");  
        JCheckBox cb2b = new JCheckBox("break your head");  
        JCheckBox cb2c = new JCheckBox("sell your kidney");  

        check2 = new ButtonGroup();
        check2.add(cb2a);
        check2.add(cb2b);
        check2.add(cb2c);

        JCheckBox cb3a = new JCheckBox("khoob nachaye");  
        JCheckBox cb3b = new JCheckBox("Maar bhagaye");  
        JCheckBox cb3c = new JCheckBox("Dhoom Machaye");  

        check3 = new ButtonGroup();
        check3.add(cb3a);
        check3.add(cb3b);
        check3.add(cb3c);

        JCheckBox cb4a = new JCheckBox("Excellent");  
        JCheckBox cb4b = new JCheckBox("A Complete Hokum");  
        JCheckBox cb4c = new JCheckBox("You Don't Know");  

        check4 = new ButtonGroup();
        check4.add(cb4a);
        check4.add(cb4b);
        check4.add(cb4c);

        JCheckBox cb5a = new JCheckBox("Babu Bhaiya");  
        JCheckBox cb5b = new JCheckBox("Kachra Seth");  
        JCheckBox cb5c = new JCheckBox("Devi Prasad"); 
        
        check5 = new ButtonGroup();
        check5.add(cb5a);
        check5.add(cb5b);
        check5.add(cb5c);


        l1.setEditable(false);
        l2.setEditable(false);
        l3.setEditable(false);
        l4.setEditable(false);
        l5.setEditable(false);


        b1=new JButton("SUBMIT");
        b2=new JButton("BACK");
     
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);

        f.add(b1);
        f.add(b2);

        f.add(cb1a);
        f.add(cb1b);
        f.add(cb1c);

        f.add(cb2a);
        f.add(cb2b);
        f.add(cb2c);

        f.add(cb3a);
        f.add(cb3b);
        f.add(cb3c);

        f.add(cb4a);
        f.add(cb4b);
        f.add(cb4c);

        f.add(cb5a);
        f.add(cb5b);
        f.add(cb5c);

 
      l1.setBounds(10,10,600,20);
      l1.setLineWrap(true);
	  l1.setWrapStyleWord(true);

      l2.setBounds(10,80,600,20);
      l2.setLineWrap(true);
	  l2.setWrapStyleWord(true);

      l3.setBounds(10,150,500,20);
      l3.setLineWrap(true);
      l3.setWrapStyleWord(true);

      l4.setBounds(10,220,600,20);
      l4.setLineWrap(true);
      l4.setWrapStyleWord(true);


      l5.setBounds(10,290,600,20);
      l5.setLineWrap(true);
      l5.setWrapStyleWord(true);

     // tf1.setBounds(10,70,300,30);
    //tf2.setBounds(10,180,300,30);
      //tf3.setBounds(10,290,300,30);
      //tf4.setBounds(10,400,300,30);
      //tf5.setBounds(10,510,300,30);

      cb1a.setBounds(10,40,200,30);
      cb1b.setBounds(210,40,200,30);
      cb1c.setBounds(410,40,200,30);
     
      cb2a.setBounds(10,110,200,30);
      cb2b.setBounds(210,110,200,30);
      cb2c.setBounds(410,110,200,30);
      
      cb3a.setBounds(10,180,200,30);
      cb3b.setBounds(210,180,200,30);
      cb3c.setBounds(410,180,200,30);

      cb4a.setBounds(10,250,200,30);
      cb4b.setBounds(210,250,200,30);
      cb4c.setBounds(410,250,200,30);
      
      cb5a.setBounds(10,320,200,30);
      cb5b.setBounds(210,320,200,30);
      cb5c.setBounds(410,320,200,30);

      l1.setBackground(UIManager.getColor("Label.background"));
      l2.setBackground(UIManager.getColor("Label.background"));
      l3.setBackground(UIManager.getColor("Label.background"));
      l4.setBackground(UIManager.getColor("Label.background"));
      l5.setBackground(UIManager.getColor("Label.background"));
        b1.setBounds(200,370,80,30);
        b2.setBounds(300,370,80,30); 
 
        f.setSize(650,470);

        b1.addActionListener( new ActionListener() { 
            public void actionPerformed(ActionEvent e){                
                        if(cb1c.isSelected() && cb2a.isSelected() && cb3c.isSelected() && cb4b.isSelected() && cb5a.isSelected() ){
                            JOptionPane.showMessageDialog(f,"Woah!! All your answers are correct!! Now you can play the puzzle.");
                            f.dispose();
                            Commands.quizCounter = true;
                        } 
                        else{
                        JOptionPane.showMessageDialog(f,"Oh No !! Some of the answers are incorrect. You can go the Library to find the answers.");
                        f.dispose();
                        }
                }
             }
             );
             b2.addActionListener( new ActionListener() { 
                public void actionPerformed(ActionEvent e){ 
                            f.dispose();
                         }
                 }
                 );
    }
} 