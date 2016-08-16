/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleAnimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *NAME: AYODELE OWOYELE
 * DATE: SPRING, 2016
 * PURPOSE: DRAW NUMBERS ON A FORM IN A RANDOM PATTERN. 
 * 
 */
public class SimpleAnimation extends JComponent implements ActionListener {

    /**
     * @param args the command line arguments
     */
    //This is the program's jframe
    static JFrame simplegame;
    static SimpleAnimation game;
    
    //set game size variables here 
    int GameWidth = 800;
    int GameHeight = 600;
    
    //get random random from here
    static SecureRandom random;
    int number = 1;
    
    //location to print out character on the form
    int LocationX = 0;
    int LocationY = 0;
    
    //space between characters.
    int Space = 40;
    private int Controller;
    
    //to determine when to start over
    private boolean Resetit;
    static Timer timer;
    
    //constructor 
      public SimpleAnimation()
    {
        repaint();
    
       
    }

      //the main method 
    public static void main(String[] args) {
        simplegame = new JFrame();
        
        //creating a simple game object 
       game = new SimpleAnimation();
       
       //adding the game object to the frame 
        simplegame.add(game);
        simplegame.pack();
        
        //set default frame load variables
        simplegame.setLocationRelativeTo(null);
        
        //terminate the program when the close button is clicked 
        simplegame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //creating a random value creator here
        random = new SecureRandom ();
        
        //set the frame visible to the user
        simplegame.setVisible(true);
        
       //creating a new timer object at 100 millisecond interval 
       //this timer checks how big the JFrame (Window) is and make appropriate decision
       //as to whether to restart counting 
      timer = new Timer (100, game);
      
      //starting the timer here 
      timer.start();
       
    }

  
    //Resize the JFrame (Windows)
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GameWidth, GameHeight);
    }

    //the code for the timer above is here. Check the frame size 
    @Override
    public void actionPerformed(ActionEvent ae) {
        GameWidth = (int) simplegame.getWidth();
        GameHeight = (int) simplegame.getHeight();
        //System.out.println ((GameWidth - Space) * (GameHeight - Space));
       if (Controller >= (int) (268 * ((GameWidth - Space) * (GameHeight - Space)))/ 464824)
       {
            ResetNumbers();
            
       }
       else
       {
           Controller = Controller + 1;
       }
    }

    //variable to begin the number from 1
    //positing the number on the form 
    public void ResetNumbers() {
        
        Resetit = true;
        Controller = 1;
        LocationX = 0;
        LocationY = 0;
        Space = 40;
                
      
    }

    //Paints the text on the screens
    @Override
    public void paintComponent(Graphics g) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        
        g.setColor(Color.white);
        g.fillRect(0, 0, GameWidth, GameHeight);
        
        
        drawNumbers(g);
         
        repaint();
    }

    //this determine what is to be drawn on the screen
    public void drawNumbers(Graphics g) {
        LocationX = 0;
        LocationY = 0;
        Space = 40;
        
        if (Resetit==false)
        {
            
            for (int a = 1; a < Controller; a++) {
                g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                g.drawString(String.valueOf(a), LocationX + Space, LocationY + Space);
                if (LocationX >= (GameWidth - (3 * Space))) {
                    LocationX = 0;
                    LocationY = LocationY + Space;
                } else {
                    LocationX = LocationX + Space;
                }
                if (LocationY >= GameHeight - 80) {
                    {
                        break;
                    }
                }
            }
        }else
        {
            g.setColor(Color.white);
            g.fillRect(0, 0, GameWidth, GameHeight);
            Resetit=false;
        }
    }

}
