import java.awt.*;
import javax.swing.*;

/* PotLuck Game- PotLuck Frame with inner class, main method
 * @author: Nashiha Ahmed
 * @version: 1.00
 */

public class PotLuckFrame extends JFrame
{
    /* PotLuckFrame 
     * Layout: BorderLayout
     * Close: Exits on close
     */
    public PotLuckFrame( String title)
    {
        //code
        //1. Set frame properties
        super( title);
        setLayout( new BorderLayout());
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    }
    
    /* Inner class: main method */
    public static void main( String[] args)
    {
        //1. Create Frame
        PotLuckFrame frame;
        frame = new PotLuckFrame( "Pot Luck");
        //2. Create panel
        PotLuckPanel panel;
        panel = new PotLuckPanel();
        //3. Add panel to center of frame
        frame.getContentPane().add( panel, BorderLayout.CENTER);
        
        //2. Set Location, pack, and make visible
        frame.setLocation( 450, 150);
        frame.pack();
        frame.setVisible( true);
    }
}