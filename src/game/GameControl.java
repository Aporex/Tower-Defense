//Allen Sekepyan, 10/31/2021.
package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.Timer;

public class GameControl implements Runnable, ActionListener {

	// Fields
	private Timer timer;
	private GameView view;
	private GameState state;
	private long previousTime;

	public GameControl() {
	}

	public void run() {

		// Build a new state
		state = new GameState();

		// Build a new view
		view = new GameView(state);

		// Add all Animatable Objects
		state.addGameObject(new AnimatableBackdrop());
		state.addGameObject(new AnimatableMenu(state));
		state.addGameObject(new EnemyLoader(state));
		state.addGameObject(new GameStart(state));

		// Start the animation loop.
		Timer timer = new Timer(16, this);
		timer.start();

		previousTime = System.nanoTime();

	}

	public void actionPerformed(ActionEvent e) {

		long currentTime = System.nanoTime();
		double timeElapsed = (currentTime - previousTime) / 1_000_000_000.0;
		previousTime = currentTime;
		state.changeTotalTime(timeElapsed);

		// Animation loop
		// Update game objects
		if (state.getLives() <= 0) {
			state.changeIsGameOver(true);
			state.addGameObject(new AnimatableGameOver());
			state.updateAll(timeElapsed);
		} else {
			state.updateAll(timeElapsed);
		}

		state.consumeMouseClick();

		// Draw game objects
		view.repaint();
	}

}
