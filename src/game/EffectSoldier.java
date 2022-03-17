package game;

import java.awt.Graphics;
import java.awt.Point;

public class EffectSoldier extends Effect {

	private GameState state;
	private double age;
	private double x, y;
	private double dx, dy;

	public EffectSoldier(GameState state, Point origin, Point dest) {

		this.state = state;
		age = 0;
		x = origin.x;
		y = origin.y;
		dx = dest.x - origin.x;
		dy = dest.y - origin.y;

	}

	public void update(double timeElapsed) {

		age += timeElapsed;

		if (age > 1.0) {

			state.removeGameObject(this);
			return;

		}

		x += dx * timeElapsed;
		y += dy * timeElapsed;

		Point p = new Point((int) x, (int) y);
		Enemy e = state.findNearestEnemy(p);

		if (e != null && e.getLocation().distance(p) < 30) {

			e.changeLivesBy(1);
			state.removeGameObject(this);

			if (e instanceof EnemyWazowsker) {

				state.changeGameCredit(30);

			}
			
			if (e instanceof EnemyFourLeggedFreak) {
				
				state.changeGameCredit(15);
				
			}

		}

	}

	public void draw(Graphics g) {

		g.drawImage(ResourceLoader.getLoader().getImage("Bullet.png"), (int) x, (int) y, 30, 15, null);

	}

}
