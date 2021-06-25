
import javax.swing.*;
import java.awt.event.*;
public class intro{
	private JFrame f = new JFrame("INTRO");
	private JButton bok = new JButton("OK");
	public intro() {
	
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(bok);
		
		bok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new firstFrame();
			}
		});
		f.setSize(100,100);
		f.setVisible(true);
         
      
             
            JPanel panel=new JPanel();  
            
          panel.setBounds(0,0,100,100); 
         
      
            //JTextField tf1;  
            //public static JTextArea textArea;
            JTextArea textArea = new JTextArea("Welcome to Zork!!\n\nWe welcome you in a land full of adventures and thrill. You are going to enter in a long forgotten genre of Classic Text Adventure game where it all stared.\nRelive the essence of classic text based  game.Here are some objectives and tips to play the games \n**For information about commands used you can click on the HELP button** \nThis game contains a series of objectives and puzzles that lead the way to the main puzzle at the last.\nExplore all the locations and enjoy the thrilling and exciting adventures along in the way!\nTIPS\nREAD EVERY READABLE ITEM \nTRY TO EXPLORE EVERY LOCATION\n\nDeveloped By -: \nRavi Gurjar \nRagesh Gupta \nPrakhar Bharadwaj",30,30);  
            textArea.setEditable(false); 
            JScrollPane scrollableTextArea = new JScrollPane(textArea);  
            scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
           
            
    
    f.add(bok);
    bok.setBounds(170,400,80,30);
            f.add(panel);
            panel.add(scrollableTextArea);
            f.setSize(420, 500);  
            f.setVisible(true);  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            panel.setLayout(null); 
            scrollableTextArea.setBounds(30,30,350,350);
        }  
        
        //public static void display(String out){
         //   textArea.append(out);
      //  }
    
}