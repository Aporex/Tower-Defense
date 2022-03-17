package game;

import java.awt.Color;
import java.awt.Graphics;

public class AnimatableMenu implements Animatable {

	private GameState state;
	private boolean objectsAdded;

	public AnimatableMenu(GameState state) {

		this.state = state;
		this.objectsAdded = false;

	}

	@Override
	public void update(double timeElapsed) {

		if (!objectsAdded) {
			state.addGameObject(new TowerSoldierMenu(state, 650, 50));
			state.addGameObject(new TowerTankMenu(state, 750, 70));
			objectsAdded = true;

		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0.9f, 0.8f, 0.7f));
		g.fillRect(600, 0, 300, 600);

		g.setColor(Color.BLACK);
		g.drawString("Lives: " + state.getLives(), 610, 20);
		g.drawString("Credits: " + state.getGameCredit(), 820, 20);

	}

}
