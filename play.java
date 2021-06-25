
import javax.swing.JFrame;  
import javax.swing.JScrollPane;  
import javax.swing.JTextArea; 
import javax.swing.*; 
import java.awt.event.*;



public class play extends KeyAdapter{
    public static JTextArea textArea = new JTextArea("Welcome to Zork\n\n"); 
    public static JFrame frame;
    
     
    
    play(){
        frame = new JFrame();
    JTextField tf1;   
    JPanel panel=new JPanel(); 
    textArea.setEditable(false); 
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    textArea.scrollRectToVisible(textArea.getVisibleRect());
    JScrollPane scrollableTextArea = new JScrollPane(textArea);  
    scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

    JLabel l1=new JLabel("Enter Command :"); 
    l1.setBounds(18,477,110,20);
    tf1=new JTextField();  
    tf1.setBounds(125,478,270,20);  
    tf1.addKeyListener(new KeyAdapter(){public void keyPressed(KeyEvent e) {
        Commands.in=tf1.getText(); 
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            
            textArea.append(Commands.in+"\n");
                Commands.tokens = Commands.in.split("\\s+");
                Commands.valid = Commands.checkCommand(Commands.tokens[0]);
                if (!Commands.valid) {
                    Commands.out=("I don't know how to " + Commands.tokens[0]);
                    textArea.append(Commands.out+"\n");	
                    textArea.setCaretPosition(textArea.getDocument().getLength());
                }
            Commands.command = Commands.tokens[0].toLowerCase();
            Commands.execute(Commands.command);
            Commands.display();
            tf1.setText("");
        }
    }});
    Icon icon1 = new ImageIcon("buttonup.png");
    Icon icon2 = new ImageIcon("buttondown.jpeg");
    Icon icon3 = new ImageIcon("buttonright.jpeg");
    Icon icon4 = new ImageIcon("buttonleft.jpeg");
    Icon icon5 = new ImageIcon("map.png");
    JButton b1 = new JButton(icon1);
    JButton b2 = new JButton(icon2);
    JButton b3 = new JButton(icon3);
    JButton b4 = new JButton(icon4);
    JButton b5 = new JButton(icon5);




    //b=new JButton("REFRESH");  
    b1.setBounds(175,500,50,50); 
    panel.add(b1); 
    b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
                textArea.append("north\n");
                Commands.north(Commands.currentRoom);
                Commands.display();
        }
        });


    b2.setBounds(175,600,50,50); 
    panel.add(b2); 
    b4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
                textArea.append("west\n");
                Commands.west(Commands.currentRoom);
                Commands.display();
        }
        });


    b3.setBounds(225,550,50,50); 
    panel.add(b3); 
    b3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
                textArea.append("east\n");
                Commands.east(Commands.currentRoom);
                Commands.display();
        }
        });


    b4.setBounds(125,550,50,50); 
    panel.add(b4);
    b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
                textArea.append("south\n");
                Commands.south(Commands.currentRoom);
                Commands.display();
        }
        }); 


    b5.setBounds(175,550,50,50); 
    panel.add(b5); 



    b5.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ae) {
        if(Commands.level == 0){
            new Map2();
        }
        else if( Commands.level == 2){
            new Map3();
        }
        else if(Commands.level == 3){
            new Map4();
        }
        else if(Commands.level == 4){
            new Map5();
        }
        }});

        
    b5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {                
                if((Commands.level == 2)){
                    {
                        new Map3();
                        }
                    
                    
                 }
                else if((Commands.level == 3)){
                    new Map3();
                   
                }
              
             }
        });
    
        tf1.addKeyListener(new KeyAdapter(){public void keyPressed(KeyEvent a)  {                
            if(a.getKeyCode() == KeyEvent.VK_SHIFT && Commands.level == 0){
                    new Map2();
            }
            else if(a.getKeyCode() == KeyEvent.VK_SHIFT && Commands.level == 2){
                new Map3();
            }
            else if(a.getKeyCode() == KeyEvent.VK_SHIFT && Commands.level == 3){
                new Map4();
            }
            else if(a.getKeyCode() == KeyEvent.VK_SHIFT && Commands.level == 4){
                new Map5();
            }
            else if(a.getKeyCode() == KeyEvent.VK_LEFT){
                textArea.append("west\n");
                Commands.west(Commands.currentRoom);
                Commands.display();
            }
            else if(a.getKeyCode() == KeyEvent.VK_RIGHT){
                textArea.append("east\n");
                Commands.east(Commands.currentRoom);
                Commands.display();
            }
            else if(a.getKeyCode() == KeyEvent.VK_DOWN){
                textArea.append("south\n");
                Commands.south(Commands.currentRoom);
                Commands.display();
                
            }
            else if(a.getKeyCode() == KeyEvent.VK_UP){
                textArea.append("north\n");
                Commands.north(Commands.currentRoom);
                Commands.display();
            }
        }});
        
           
    panel.add(tf1);
    panel.add(l1);
    frame.add(panel);
    panel.add(scrollableTextArea);
    panel.setLayout(null);
    scrollableTextArea.setBounds(15, 10, 450, 465);
    frame.setSize(500,800);  
    frame.setVisible(true);  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    } 
    
}