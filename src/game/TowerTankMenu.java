package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerTankMenu extends Tower {

	private GameState state;
	private int x, y;

	public TowerTankMenu(GameState state, int x, int y) {

		// super(state, pos);
		this.state = state;
		this.x = x;
		this.y = y;

	}

	public void update(double timeElapsed) {

		if (state.getMouseX() >= x && state.getMouseX() < x + 100 && state.getMouseY() >= y
				&& state.getMouseY() < y + 60 && state.isMouseClicked() && state.getGameCredit() >= 50) {

			state.addGameObject(new TowerTankMoving(state));
			state.changeGameCredit(-50);
		}

	}

	public void draw(Graphics g) {

		g.drawImage(ResourceLoader.getLoader().getImage("Tank.png"), x, y, 100, 60, null);

	}

}
