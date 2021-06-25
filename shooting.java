
import javax.swing.*;
import java.awt.event.*;
public class shooting{
	private JFrame f = new JFrame("HELP");
	private JButton bok = new JButton("OK");
	public shooting() {
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(bok);
		
		bok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new Pendulum();
			}
		});
		f.setSize(100,100);
		f.setVisible(true);
         
      
             
            JPanel panel=new JPanel();  
            
          panel.setBounds(0,0,100,100); 
         
      
            //JTextField tf1;  
            //public static JTextArea textArea;
            JTextArea textArea = new JTextArea("Press Left,Right,Up,Down to move the target dot.\nPress Space Bar to shoot the moving pendulum\n You have to shoot five pendulums with varing length and speeds one after another. ",20,20);  
            textArea.setEditable(false); 
            JScrollPane scrollableTextArea = new JScrollPane(textArea);  
            scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
           
            
    
    f.add(bok);
    bok.setBounds(100,300,80,50);
            f.add(panel);
            panel.add(scrollableTextArea);
            f.setSize(320, 400);  
            f.setVisible(true);  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            panel.setLayout(null); 
            scrollableTextArea.setBounds(20,20,250,250);
        }  
        
        //public static void display(String out){
         //   textArea.append(out);
      //  }
    
}

