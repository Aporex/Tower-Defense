package game;

import java.awt.Graphics;

public class GameStart implements Animatable {

	GameState state;

	public GameStart(GameState state) {

		this.state = state;

	}

	@Override
	public void update(double timeElapsed) {

		if (state.getIsGameStarted()) {

			state.removeGameObject(this);

		}

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(ResourceLoader.getLoader().getImage("Start.png"), 150, 150, null);

	}

}
