package game;

import java.awt.Graphics;
import java.util.Arrays;

public class EnemyLoader implements Animatable {

	private GameState state;
	private String[] wave;
	private boolean isAdded;
	private int i;
	private int counter;

	public EnemyLoader(GameState state) {

		this.state = state;
		wave = ResourceLoader.getLoader().getWave("wave1.txt");
		isAdded = false;
		i = 0;
		counter = 0;

	}

	@Override
	public void update(double timeElapsed) {

		if (wave[i].equals("E")) {

			counter = 0;
			i = 0;

		}

		if (timeElapsed <= 100) {

			counter++;

		}

		if (wave[i].equals("F") && isAdded == false && counter % 10 == 0) {

			isAdded = true;
			state.addGameObject(new EnemyFourLeggedFreak(state, 0.0, 1));

		}

		if (wave[i].equals("W") && isAdded == false && counter % 10 == 0) {

			isAdded = true;
			state.addGameObject(new EnemyWazowsker(state, 0.0, 2));

		}

		if (counter % 10 == 0) {

			i++;
			isAdded = false;

		}

	}

	@Override
	public void draw(Graphics g) {

	}

}
