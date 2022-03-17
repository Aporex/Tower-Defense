package game;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Enemy implements Animatable {

	protected double position;
	private int enemyLife;

	public Enemy(GameState state, double p) {

		this.position = p;

	}

	public Point getLocation() {

		Point p = ResourceLoader.getLoader().getPath("path1.txt").getPathPosition(position);
		return p;

	}

	public void changeLivesBy(int i) {
	}

}
