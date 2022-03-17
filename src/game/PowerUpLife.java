package game;

import java.awt.Graphics;
import java.awt.Point;

public class PowerUpLife implements Animatable {

	GameState state;
	double position;
	EnemyWazowsker enemy;

	public PowerUpLife(GameState state, double position, EnemyWazowsker enemy) {

		this.state = state;
		this.position = position;
		this.enemy = enemy;

	}

	@Override
	public void update(double timeElapsed) {

	}

	@Override
	public void draw(Graphics g) {

		Point p = ResourceLoader.getLoader().getPath("path1.txt").getPathPosition(enemy.getPosition());
		g.drawImage(ResourceLoader.getLoader().getImage("Wazowsker.png"), p.x - 15, p.y - 15, 30, 30, null);

	}

}
