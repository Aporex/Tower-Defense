package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerTankMap extends Tower {

	private GameState state;
	private int x, y;
	private double timeSinceLastShot;

	public TowerTankMap(GameState state, int x, int y) {

		// super(state, pos);
		this.state = state;
		this.x = x;
		this.y = y;

		timeSinceLastShot = 0;

	}

	public void update(double timeElapsed) {

		timeSinceLastShot += timeElapsed;

		if (timeSinceLastShot < 2) {

			return;

		}

		Point towerPoint = new Point(x, y);

		Enemy e = state.findNearestEnemy(towerPoint);

		if (e == null) {
			return;
		}

		if (towerPoint.distance(e.getLocation()) > 100) {

			return;
		}

		EffectTank s = new EffectTank(state, towerPoint, e.getLocation());

		state.addGameObject(s);

		timeSinceLastShot = 0;

	}

	public void draw(Graphics g) {

		g.drawImage(ResourceLoader.getLoader().getImage("Tank.png"), x, y, 50, 30, null);

	}

}
