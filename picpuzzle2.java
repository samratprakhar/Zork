import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class picpuzzle2 extends JFrame implements ActionListener{
static String result = "idle";
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,sample,starB;
Icon star;
Icon ic0=new ImageIcon("pic//starB50.jpg");
Icon ic10=new ImageIcon("pic//starB60.jpg");
Icon ic20=new ImageIcon("pic//starB20.jpg");
Icon samicon1=new ImageIcon("pic//main4.jpg");
Icon samicon2=new ImageIcon("pic//main.jpg");
Icon samicon3=new ImageIcon("pic//main3.jpg");
Icon ic1=new ImageIcon("pic//001.jpg");
Icon ic2=new ImageIcon("pic//005.jpg");
Icon ic3=new ImageIcon("pic//002.jpg");
Icon ic4=new ImageIcon("pic//007.jpg");
Icon ic5=new ImageIcon("pic//004.jpg");
Icon ic6=new ImageIcon("pic//006.jpg");
Icon ic7=new ImageIcon("pic//008.jpg");
Icon ic8=new ImageIcon("pic//009.jpg");
Icon ic9=new ImageIcon("pic//003 bchaged.jpg");





picpuzzle2(){

picpuzzle2.setplay("running");
b1=new JButton(ic1);
b1.setBounds(10,80,100,100);
b2=new JButton(ic2);
b2.setBounds(110,80,100,100);
b3=new JButton(ic3);
b3.setBounds(210,80,100,100);
b4=new JButton(ic4);
b4.setBounds(10,180,100,100);
b5=new JButton(ic5);
b5.setBounds(110,180,100,100);
b6=new JButton(ic6);
b6.setBounds(210,180,100,100);
b7=new JButton(ic7);
b7.setBounds(10,280,100,100);
b8=new JButton(ic8);
b8.setBounds(110,280,100,100);
b9=new JButton(ic9);
b9.setBounds(210,280,100,100);
sample=new JButton(samicon1);
sample.setBounds(380,100,200,200);

JLabel l1=new JLabel(":");
l1.setBounds(330,200,70,20);
JLabel l2=new JLabel("NOTE:: icon has power to swap with neighbour icon=>");
l2.setBounds(5,15,500,20);
JLabel l3=new JLabel("sample picture ");
l3.setBounds(380,320,200,20);
l3.setForeground(Color.red);

starB=new JButton(ic0);
starB.setBounds(330,5,50,50);
star=b9.getIcon();

add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);add(sample);/*add(l1);add(l2);add(starB);add(l3);*/
b1.addActionListener(this); b2.addActionListener(this); b3.addActionListener(this); b4.addActionListener(this); b5.addActionListener(this); b6.addActionListener(this); b7.addActionListener(this); b8.addActionListener(this); b9.addActionListener(this); 
/*sample.addActionListener(this);*/
setLayout(null);
setSize(600,500);
setVisible(true);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
addWindowListener(new WindowAdapter ()
{
    public void windowClosing(WindowEvent we)
    {
      picpuzzle2.setplay("quit");  
    }

});

}

public void actionPerformed(ActionEvent e){
if(e.getSource()==b1){
    Icon s1=b1.getIcon();
      if(b2.getIcon()==star){
        b2.setIcon(s1);
        b1.setIcon(star);
      } else if(b4.getIcon()==star){
                    b4.setIcon(s1);
                    b1.setIcon(star);
                   }
  }//end of if

if(e.getSource()==b2){
    Icon s1=b2.getIcon();
      if(b1.getIcon()==star){
        b1.setIcon(s1);
        b2.setIcon(star);
      } else if(b5.getIcon()==star){
                    b5.setIcon(s1);
                    b2.setIcon(star);
                   }
         else if(b3.getIcon()==star){
                    b3.setIcon(s1);
                    b2.setIcon(star);
                   }
  }//end of if

if(e.getSource()==b3){
    Icon s1=b3.getIcon();
      if(b2.getIcon()==star){
        b2.setIcon(s1);
        b3.setIcon(star);
      } else if(b6.getIcon()==star){
                    b6.setIcon(s1);
                    b3.setIcon(star);
                   }
  if(b1.getIcon() == ic1 && b2.getIcon() == ic3&& b3.getIcon() == ic9&& b4.getIcon() == ic5&& b5.getIcon() == ic2&& b6.getIcon() == ic6 && b7.getIcon() == ic4 && b8.getIcon() == ic7 && b9.getIcon() == ic8 ){ 
    JOptionPane.showMessageDialog(picpuzzle2.this,"!!!you won!!!");
    dispose();
    picpuzzle2.setplay("completed");
    String vehicle = "bus";
		Commands.map[0][3][0].unlockdoor( vehicle);
		Commands.out = ("You are selected!! Bus is leaving for IGI Airport soon taking the selected students to Caltech. Rush to the campus entrance.");
		play.textArea.append(Commands.out+"\n");
  }
  }//end of if
//1,3,9,5,2,6,4,7,8
if(e.getSource()==b4){
    Icon s1=b4.getIcon();
      if(b1.getIcon()==star){
        b1.setIcon(s1);
        b4.setIcon(star);
      } else if(b5.getIcon()==star){
                    b5.setIcon(s1);
                    b4.setIcon(star);
                   }
         else if(b7.getIcon()==star){
                    b7.setIcon(s1);
                    b4.setIcon(star);
                   }
  }//end of if

if(e.getSource()==b5){
    Icon s1=b5.getIcon();
      if(b2.getIcon()==star){
        b2.setIcon(s1);
        b5.setIcon(star);
      } else if(b4.getIcon()==star){
                    b4.setIcon(s1);
                    b5.setIcon(star);
                   }
         else if(b6.getIcon()==star){
                    b6.setIcon(s1);
                    b5.setIcon(star);
                   }
          else if(b8.getIcon()==star){
                    b8.setIcon(s1);
                    b5.setIcon(star);
                   }
  }//end of if

if(e.getSource()==b6){
    Icon s1=b6.getIcon();
      if(b3.getIcon()==star){
        b3.setIcon(s1);
        b6.setIcon(star);
      } else if(b5.getIcon()==star){
                    b5.setIcon(s1);
                    b6.setIcon(star);
                   }
         else if(b9.getIcon()==star){
                    b9.setIcon(s1);
                    b6.setIcon(star);
                   }
}//end of if

if(e.getSource()==b7){
    Icon s1=b7.getIcon();
      if(b4.getIcon()==star){
        b4.setIcon(s1);
        b7.setIcon(star);
      } else if(b8.getIcon()==star){
                    b8.setIcon(s1);
                    b7.setIcon(star);
                   }
 }//end of if

   if(e.getSource()==b8){
    Icon s1=b8.getIcon();
      if(b7.getIcon()==star){
        b7.setIcon(s1);
        b8.setIcon(star);
      } else if(b5.getIcon()==star){
                    b5.setIcon(s1);
                    b8.setIcon(star);
                   }
         else if(b9.getIcon()==star){
                    b9.setIcon(s1);
                    b8.setIcon(star);
                   }

  }//end of if

 if(e.getSource()==b9){
    Icon s1=b9.getIcon();
      if(b8.getIcon()==star){
        b8.setIcon(s1);
        b9.setIcon(star);
      } else if(b6.getIcon()==star){
                    b6.setIcon(s1);
                    b9.setIcon(star);
                   }
  }//end of if

if(e.getSource()==sample){
Icon s1=sample.getIcon();
 if(s1==samicon3){
sample.setIcon(samicon1);
b1.setIcon(ic1);
b2.setIcon(ic2);
b3.setIcon(ic3);
b4.setIcon(ic4);
b5.setIcon(ic5);
b6.setIcon(ic6);
b7.setIcon(ic7);
b8.setIcon(ic8);
b9.setIcon(ic9);
star=b9.getIcon();
starB.setIcon(ic0);
}//eof if
else if(s1==samicon1){
sample.setIcon(samicon2);

starB.setIcon(ic10);
}//eof else
else{
sample.setIcon(samicon3);

starB.setIcon(ic20);
}//eof else

}
}//end of actionPerformed

public static String getplay(){  
  return result;
  }
public static void setplay(String r){  
  result = r;
  }
  public static void main(String[] args) {
    new picpuzzle2();
    }

}//end of class
