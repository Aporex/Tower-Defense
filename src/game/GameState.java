//Allen Sekepyan, 10/31/2021.
package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GameState {
	// Fields
	private List<Animatable> gameObjects;
	private List<Animatable> objectsToRemove;
	private List<Animatable> objectsToAdd;

	private int mouseX, mouseY;
	private boolean mouseClicked;

	private int gameCredit;
	private int lives;

	private boolean isGameOver;

	private double totalTime;

	private boolean isAdded;

	private boolean gameIsStarted;

	// Constructor
	public GameState() {
		// Create a new ArrayList with Animatable objects
		gameObjects = new ArrayList<Animatable>();
		objectsToRemove = new ArrayList<Animatable>();
		objectsToAdd = new ArrayList<Animatable>();

		mouseX = mouseY = 0;
		mouseClicked = false;
		gameCredit = 50;
		lives = 5;

		isGameOver = false;
		totalTime = 0;

		isAdded = false;

		gameIsStarted = false;
	}

	/**
	 * Adds an animatable object to the ArrayList
	 * 
	 * @param a Animatable Object
	 */
	public void addGameObject(Animatable a) {
		objectsToAdd.add(a);
	}

	public void removeGameObject(Animatable a) {
		objectsToRemove.add(a);
	}

	public void setMouseLocation(int x, int y) {

		this.mouseX = x;
		this.mouseY = y;

	}

	public int getMouseX() {

		return mouseX;

	}

	public int getMouseY() {

		return mouseY;

	}

	public boolean isMouseClicked() {

		return mouseClicked;

	}

	public void setMouseClicked() {

		mouseClicked = true;

	}

	public void consumeMouseClick() {

		mouseClicked = false;

	}

	public int getGameCredit() {

		return gameCredit;

	}

	public int getLives() {

		return lives;

	}

	public boolean getIsGameOver() {

		return isGameOver;

	}

	public void changeIsGameOver(boolean b) {

		isGameOver = b;

	}

	public void changeGameCredit(int changeBy) {

		gameCredit += changeBy;

	}

	public void changeLives(int changeBy) {

		lives += changeBy;

	}

	public double getTotalTime() {

		return totalTime;

	}

	public void changeTotalTime(double timeElapsed) {

		totalTime += timeElapsed;

	}

	public boolean getIsAdded() {

		return isAdded;

	}
	
	public boolean getIsGameStarted() {
		
		return gameIsStarted;
		
	}

	public void changeIsAdded(boolean changeTo) {

		isAdded = changeTo;

	}

	public void spawnEnemy(Animatable a) {

		this.addGameObject(a);

	}

	/**
	 * Update all animatable objects in the ArrayList
	 * 
	 */
	public void updateAll(double timeElapsed) {

		if (!gameIsStarted) {

			if (this.getMouseX() >= 225 && this.getMouseX() < 685 && this.getMouseY() >= 150 && this.getMouseY() < 450
					&& this.isMouseClicked()) {

				System.out.println(gameIsStarted);
				gameIsStarted = true;

			}

		}

		if (gameIsStarted) {

			if (!isGameOver) {
				for (Animatable a : gameObjects) {
					a.update(timeElapsed);
				}
			}

			else {

				lives = 0;

			}

		}

		gameObjects.removeAll(objectsToRemove);
		objectsToRemove.clear();

		gameObjects.addAll(objectsToAdd);
		objectsToAdd.clear();

	}

	/**
	 * Draw all the animatable objects in the ArrayList
	 * 
	 * @param g Passed through Graphics Variable
	 */
	public void drawAll(Graphics g) {
		for (Animatable a : gameObjects) {
			a.draw(g);
		}
	}

	public Enemy findNearestEnemy(Point p) {

		Enemy closest = null;
		for (Animatable a : gameObjects) {

			if (a instanceof Enemy) {

				Enemy e = (Enemy) a;

				if (closest == null) {

					closest = e;

				} else {

					Point currentClosestPosition = closest.getLocation();
					Point enemyPosition = e.getLocation();

					double distanceToCurrentClosest = currentClosestPosition.distance(p);
					double distanceToEnemy = enemyPosition.distance(p);

					if (distanceToEnemy < distanceToCurrentClosest) {

						closest = e;
						
					}

				}

			}

		}

		return closest;

	}
}
