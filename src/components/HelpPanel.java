package components;
import java.awt.*;
import javax.swing.*;

import listeners.HelpBackListener;

import java.io.*;
import javax.imageio.ImageIO;

/**
 * 
 * @author Patrick Wang
 * @apiNote the JPanel where the user will be able to view how to play
 * 
 */

public class HelpPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @apiNote Constructor for the HelpPanel component
	 * 
	 */
    public HelpPanel(){
        // initialize panel
        this.setLayout(null);

        // create back button
        JButton goBack = new JButton();
        goBack.setContentAreaFilled(false);
        goBack.setBorder(null);
        goBack.setBounds(new Rectangle(0, 0, 100, 100));

        // apply image
        try{
            Image backImage = ImageIO.read(new File("assets\\back.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            goBack.setIcon(new ImageIcon(backImage));
        }
        catch (IOException e){
            // print out traced error
            e.printStackTrace();
        }
        
        // add listener to back button
        goBack.addMouseListener(new HelpBackListener());

        // add back button
        this.add(goBack);
    }

    // paint graphics onto panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// apply background
		try {
			Image bg = ImageIO.read(new File("assets\\helpPanel.png")).getScaledInstance(1000, 770, java.awt.Image.SCALE_SMOOTH);
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}
	}
	
}
