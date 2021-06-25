import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Pendulum extends JPanel implements Runnable {
 
    private double angle = Math.PI / 2;
    private static int length;
    public static int x = 0;
    public static int y = 0;
    public static int targetX = 0;
    public static int targetY = 0;
    private static double dt = 0.02 ;
    public static int i=1;
 
    public Pendulum(int length) {
        Pendulum.length = length;
        setDoubleBuffered(true);
    }
 
 
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        int anchorX = getWidth() / 2, anchorY = getHeight() / 4;
        int ballX = anchorX + (int) (Math.sin(angle) * length);
        targetX =ballX;
        int ballY = anchorY + (int) (Math.cos(angle) * length);
        targetY = ballY;
        g.drawLine(anchorX, anchorY, ballX, ballY);
        g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
        g.fillOval(ballX - 7, ballY - 7, 14, 14);
        g.setColor(Color.red);  
        g.fillOval(x, y, 10, 10);  
    }

    public void run() {
        double angleAccel, angleVelocity = 0;
        while (true) {
            angleAccel = -9.81 / length * Math.sin(angle);
            angleVelocity += angleAccel * dt;
            angle += angleVelocity * dt;
            repaint();
            try { Thread.sleep(15) ; } catch (InterruptedException ex) {}
        }
    }
 
    
    public Dimension getPreferredSize() {
        return new Dimension(2 * length + 50, length / 2 * 3);
    }
 
    Pendulum() {
        
        JFrame f = new JFrame("Pendulum");
        Pendulum p = new Pendulum(200);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.addKeyListener( new KeyAdapter() {
            public void keyPressed(KeyEvent e) {                
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    if(x<=targetX+7 && x>=targetX-7 && y<=targetY+7 && y>=targetY-7){
                        if(i <5){
                            i++;
                            dt+= 0.05;
                            length-=20;
                            JOptionPane.showMessageDialog(f,"Go on !!");
                        } 
                        else{
                        JOptionPane.showMessageDialog(f,"Woah!! Great Shooting.. Its all right..You have the permission of the king to roam around and can take anything.");
                        f.dispose();
                        }
                    }
                 }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                   if(x<=2*Pendulum.length+40 && x>0){x--;}
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(x<2*Pendulum.length+40 && x>=0){x++;}
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if(y<(Pendulum.length/2*3)-10 && y>=0){y++;}
                }
                else if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(y<=(Pendulum.length/2*3)-10 && y>0){y--;}
                }
             }
        });
        f.setVisible(true);
        f.setLayout(new BorderLayout());
        new Thread(p).start();
    }
}