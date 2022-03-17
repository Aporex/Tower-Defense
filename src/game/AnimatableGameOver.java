package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class AnimatableGameOver implements Animatable {

	@Override
	public void update(double timeElapsed) {

	}

	@Override
	public void draw(Graphics g) {

		g.drawImage(ResourceLoader.getLoader().getImage("GameOver.png"), 150, 0, null);

	}

}
