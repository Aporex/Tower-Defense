package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerSoldierMoving extends Tower {

	private GameState state;
	private int x, y;

	public TowerSoldierMoving(GameState state) {

		// super(state, pos);
		this.state = state;

	}

	public void update(double timeElapsed) {

		AnimatablePath p = ResourceLoader.getLoader().getPath("path1.txt");
		Point q = new Point(state.getMouseX(), state.getMouseY());

		if (state.isMouseClicked() && p.distanceToNearestPathNode(q) > 25) {

			if (state.getMouseX() < 600) {
				state.removeGameObject(this);
				state.addGameObject(new TowerSoldierMap(state, state.getMouseX() - 15, state.getMouseY() - 25));
			}

			if (state.getMouseX() > 600) {

				state.removeGameObject(this);

			}
		}

	}

	public void draw(Graphics g) {

		g.drawImage(ResourceLoader.getLoader().getImage("BasicSoldier.png"), state.getMouseX() - 15,
				state.getMouseY() - 25, 30, 50, null);

	}

}
