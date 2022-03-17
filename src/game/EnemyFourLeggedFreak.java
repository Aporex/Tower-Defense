package game;

import java.awt.Graphics;
import java.awt.Point;

public class EnemyFourLeggedFreak extends Enemy {

	private GameState state;
	private int enemyLives;

	public EnemyFourLeggedFreak(GameState state, double pos, int enemyLives) {

		super(state, pos);
		this.state = state;
		this.position = pos;
		this.enemyLives = enemyLives;

	}

	public void update(double timeElapsed) {
		position = position + 0.060 * timeElapsed;
		if (position > 1) {
			state.removeGameObject(this);
			state.changeLives(-1);
		}

		if (enemyLives <= 0) {

			state.removeGameObject(this);

		}
	}

	public void draw(Graphics g) {

		Point p = getLocation();
		g.drawImage(ResourceLoader.getLoader().getImage("FourLeggedFreak.png"), p.x - 15, p.y - 15, 30, 30, null);

	}

	@Override
	public void changeLivesBy(int i) {

		enemyLives -= i;

	}

}
