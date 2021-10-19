import java.util.*;
import java.awt.*;
import java.awt.Button.*;
import java.awt.event.*;
import javax.swing.*;

/* PotLuck game- PotLuck Button Panel
 * @author: Nashiha Ahmed
 * @version: 1.00
 */

public class PotLuckPanel extends JPanel implements ActionListener
{
    //constants
    final int ARRAYSIZE = 25;
    
    //Objects
    JPanel buttonPanel;
    JPanel labelPanel;
    JButton b;
    JButton prize;
    JLabel l;
    JLabel l2;
    
    //Variables and Arraylist
    ArrayList<JButton> buttons;    
    boolean gameOver;
    int randomNumber;
    int attempts;
    Font myFont = new Font( "Courier New", Font.BOLD, 14);
    Font myFont2 = new Font( "Courier New", Font.BOLD, 20);
    
    //Constructor
    public PotLuckPanel()
    {
        //1. Initialize all the variables
        gameOver = false;
        prize = null;
        attempts = 0;
        
        //2. Set this panel properties
        setLayout( new BorderLayout());
        setPreferredSize( new Dimension( 500, 400));
        
        //3. Button Panel
        //3.1 Create new panel called button panel to add the buttons!
        buttonPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout( 5, 5, 2, 2));
        
        //3.2 Create buttons and add the buttons to the button panel
        buttons = new ArrayList<JButton>();
        for ( int i = 0; i < ARRAYSIZE; i++)
        {
            b = new JButton( "Try Me!");
            b.setBackground( new Color( 30, 144, 255));
            b.addActionListener( this);
            buttons.add( b);
            buttonPanel.add( b);
        }

        //3.3 Add button panel to this panel
        add( buttonPanel, BorderLayout.CENTER);
        
        //4. Label Panel
        //4.1 Create label panel
        labelPanel = new JPanel();

        //4.2 Set label panel properties
        labelPanel.setLayout( new BoxLayout( labelPanel, BoxLayout.Y_AXIS));

        //4.3 Create the labels and 4.4 set their properties
        l2 =  new JLabel( "Find the prize!");
        l2.setFont( myFont2);
        l2.setForeground( Color.GRAY);
        l = new JLabel( "Attempts: " + attempts);
        l.setForeground( new Color( 60, 179, 113 ));
        l.setFont( myFont);
        l.setAlignmentX( Component.CENTER_ALIGNMENT);
        l2.setAlignmentX( Component.CENTER_ALIGNMENT);

        //4.5 Add the labels to the label panel
        labelPanel.add( l2);
        labelPanel.add( l);

        //4.6 Set the background color to white
        labelPanel.setBackground( Color.WHITE);

        //4.7 Add the label panel to this panel
        add( labelPanel, BorderLayout.NORTH);
        
        //Prize Button
        //5.1 Create random number between 1-25 to randomize prize button
        randomNumber = (int) Math.ceil( Math.random() * 25);
        
        //5.2 Set prize to buttons at randomnumber
        prize = buttons.get( randomNumber - 1);
    }

    
    /*Action Performed Method 
     * Increment attempts by one in each case and tell user how many attempts they have had so far
     */
    public void actionPerformed( ActionEvent e)
    {
        /* If Button is the Prize Button and the game is not over, then set the text appropriately */
        if( (JButton)e.getSource() == prize && !gameOver)
        {
            attempts = attempts + 1;
            gameOver = true;
            prize.setText( "Prize!");
            prize.setBackground( new Color( 238, 18, 137 ));
            l.setForeground( new Color( 154, 50, 205 ));
            l.setText( "You found the prize in " + attempts + " attempts.");
        }
        /* If the game is not over and the buttons are not prize buttons, make the buttons invisible, and set the text
         * appropriately */
        if( !gameOver)
        { 
            attempts = attempts + 1;   
            l.setForeground( new Color( 60, 179, 113 ));
            l.setText( "Attempts: " + attempts + ". Try Again!");
            ((JButton)e.getSource()).setVisible( false);
        }
        /*if the game is over, set the text appropriately */
        if( gameOver)
        {
            l.setText( "You found the prize in " + attempts + " attempts.");
            JOptionPane.showConfirmDialog( null, "GAME OVER. Play Again?");
        }    
    }
}