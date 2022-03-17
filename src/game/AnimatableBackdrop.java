package game;

import java.awt.Graphics;

public class AnimatableBackdrop implements Animatable {

	/** Draw the backdrop with the given file name
	 * 
	 */
	public void draw(Graphics g) {
		
		g.drawImage(ResourceLoader.getLoader().getImage("path1.jpg"), 0, 0, null);
	
	}

	public void update(double timeElapsed) {

	}

}
