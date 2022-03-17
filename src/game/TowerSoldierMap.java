package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerSoldierMap extends Tower {

	private GameState state;
	private int x, y;
	private double timeSinceLastShot;

	public TowerSoldierMap(GameState state, int x, int y) {

		this.state = state;
		this.x = x;
		this.y = y;

		timeSinceLastShot = 0;

	}

	public void update(double timeElapsed) {

		timeSinceLastShot += timeElapsed;

		if (timeSinceLastShot < 1) {

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

		EffectSoldier s = new EffectSoldier(state, towerPoint, e.getLocation());

		state.addGameObject(s);
		
		timeSinceLastShot = 0;

	}

	public void draw(Graphics g) {

		g.drawImage(ResourceLoader.getLoader().getImage("BasicSoldier.png"), x, y, 30, 50, null);

	}

}
