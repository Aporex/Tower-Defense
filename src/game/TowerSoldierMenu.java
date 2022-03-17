package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerSoldierMenu extends Tower {

	private GameState state;
	private int x, y;

	public TowerSoldierMenu(GameState state, int x, int y) {

		// super(state, pos);
		this.state = state;
		this.x = x;
		this.y = y;

	}

	public void update(double timeElapsed) {

		if (state.getMouseX() >= x && state.getMouseX() < x + 60 && state.getMouseY() >= y
				&& state.getMouseY() < y + 100 && state.isMouseClicked() && state.getGameCredit() >= 20) {

			state.addGameObject(new TowerSoldierMoving(state));
			state.changeGameCredit(-20);
			
		}

	}

	public void draw(Graphics g) {

		g.drawImage(ResourceLoader.getLoader().getImage("BasicSoldier.png"), x, y, 60, 100, null);

	}

}
