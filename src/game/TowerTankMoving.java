package game;

import java.awt.Graphics;
import java.awt.Point;

public class TowerTankMoving extends Tower {

	private GameState state;
	private int x, y;

	public TowerTankMoving(GameState state) {

		// super(state, pos);
		this.state = state;

	}

	public void update(double timeElapsed) {

		AnimatablePath p = ResourceLoader.getLoader().getPath("path1.txt");
		Point q = new Point(state.getMouseX(), state.getMouseY());

		if (state.isMouseClicked() && p.distanceToNearestPathNode(q) > 25) {

			if (state.getMouseX() < 600) {
				state.removeGameObject(this);
				state.addGameObject(new TowerTankMap(state, state.getMouseX() - 25, state.getMouseY() - 15));
			}

			if (state.getMouseX() > 600) {

				state.removeGameObject(this);

			}
		}

	}

	public void draw(Graphics g) {

		g.drawImage(ResourceLoader.getLoader().getImage("Tank.png"), state.getMouseX() - 25, state.getMouseY() - 15, 50,
				30, null);

	}

}
