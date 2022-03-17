//Allen Sekepyan, 10/31/2021. This class will create the games control by calling and using the other
//classes to control the game.
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameView extends JPanel implements MouseListener, MouseMotionListener {
	// This constant is needed to get rid of a warning. It won't matter to us.

	private static final long serialVersionUID = 1L;

	// Fields -- These variables will be part of the GameView object (that we make
	// in GameControl).

	private GameState state;
	// I have removed the other fields. Add them back in as part of the first
	// checkpoint.

	/**
	 * Our GameView constructor. The 'view' is the GUI (Graphical User Interface)
	 * and this constructor builds a JFrame (window) so the user can see our
	 * 'drawing'.
	 */
	public GameView(GameState state) {

		// Sets the GameState field equal to the input parameter
		this.state = state;

		// Build the frame. The frame object represents the application 'window'.

		JFrame frame = new JFrame("Tower Defense 2021");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add a drawing area to the frame (a panel). Note that 'this' object IS the
		// panel that we need, so we add it.

		JPanel p = this;
		frame.setContentPane(p);

		// Set the size of 'this' panel to match the size of the backdrop.

		Dimension d = new Dimension(900, 600);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setMaximumSize(d);

		// Allow the JFrame to layout the window (by 'packing' it) and make it visible.

		frame.pack();
		frame.setVisible(true);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

	}

	/**
	 * Draws our game. This function will be called automatically when Java needs to
	 * repaint our window. Use the repaint() function call (on this object) to cause
	 * this function to be executed.
	 * 
	 * @param Graphics g the Graphics object to use for drawing
	 */
	public void paint(Graphics g) {

		// Draws all animatable objects
		state.drawAll(g);
	}

	/*
	 * The following methods are required for mouse events. I've collapsed some of
	 * them to make it easier to see which one you need. Also note: You'll need to
	 * register 'this' object as a listener to its own events. See the missing code
	 * in the constructor.
	 */

	public void mousePressed(MouseEvent e) {

		state.setMouseClicked();

	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		state.setMouseLocation(e.getX(), e.getY());

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		state.setMouseLocation(e.getX(), e.getY());

	}
}
