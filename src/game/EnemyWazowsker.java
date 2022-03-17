package game;

import java.awt.Graphics;
import java.awt.Point;

public class EnemyWazowsker extends Enemy {

	private GameState state;
	private int enemyLives;

	public EnemyWazowsker(GameState state, double pos, int enemyLives) {

		super(state, pos);
		this.state = state;
		this.position = pos;
		this.enemyLives = enemyLives;

	}

	public void update(double timeElapsed) {
		position = position + 0.060 * timeElapsed * 0.5;
		if (position > 1) {
			state.removeGameObject(this);
			state.changeLives(-3);
		}
		
		if (enemyLives <= 0) {
			
			state.removeGameObject(this);
			
		}
	}

	public void draw(Graphics g) {

		Point p = getLocation();
		g.drawImage(ResourceLoader.getLoader().getImage("Wazowsker.png"), p.x - 15, p.y - 15, 30, 30, null);

	}

	public double getPosition() {

		return position;

	}

	@Override
	public void changeLivesBy(int i) {
		
		enemyLives -= i;

	}

}
