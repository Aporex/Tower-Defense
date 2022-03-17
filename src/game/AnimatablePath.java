//Allen Sekepyan, 11/1/2021. This class will create a path for the GameView.
package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

import java.util.Scanner;

public class AnimatablePath {
	private int size = 42;
	private int[] xCoord = new int[size];
	private int[] yCoord = new int[size];
	List<Point> path;

	/**
	 * This class will scan the coordinates from the path.txt file and then put them
	 * into arrays.
	 * 
	 * @param pathScanner is the scanner of the file of path.txt
	 */
	public AnimatablePath(Scanner pathScanner) {

		path = new ArrayList<Point>();
//		int size = pathScanner.nextInt();
//		for (int count = 0; count < size; count++)
//			path.add(new Point(pathScanner.nextInt(), pathScanner.nextInt()));

		for (int pos = 0; pathScanner.hasNext(); pos++) {
			xCoord[pos] = pathScanner.nextInt();
			yCoord[pos] = pathScanner.nextInt();

			path.add(new Point(xCoord[pos], yCoord[pos]));

		}

	}

	/**
	 * This class uses the distance formula to get the length between a pair of
	 * points.
	 * 
	 * @param x1 First x value
	 * @param x2 Second x value
	 * @param y1 First y value
	 * @param y2 Second y value
	 * @return length the calculated distance between the two points.
	 */
	public double getLength(double x1, double x2, double y1, double y2) {

		double length = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
		return length;
	}

	/**
	 * This method will get an array of segments and their respective lengths and
	 * return the length from the respective segment given a position
	 * 
	 * @param pos the segment of the array we want the length for.
	 * @return the length for the segment we are given.
	 */
	public double getSegment(int pos) {

		int count = 0;
		double[] segment = new double[size];

		while (count < size - 1) {
			segment[count] = getLength(xCoord[count], xCoord[count + 1], yCoord[count], yCoord[count + 1]);
			count++;
		}

		return segment[pos];
	}

	/**
	 * This class will calculate the total length of the entire path
	 * 
	 * @return totalLength of path
	 */
	public double getTotalLength() {

		double totalLength = 0;

		for (int i = 0; i < size - 1; i++) {
			totalLength += getSegment(i);
		}

		return totalLength;
	}

	/**
	 * This method will draw lines across the path on the path.jpg image.
	 * 
	 * @param g the graphics the method is given.
	 */
	public void draw(Graphics g) {

		for (int i = 0; i < size - 1; i++) {
			g.drawLine(xCoord[i], yCoord[i], xCoord[i + 1], yCoord[i + 1]);

		}

	}

	/**
	 * This class will return the point that the timer moves around with the
	 * percentage.
	 * 
	 * @param percentage is how far the circle or enemy has moved on the path.
	 * @return p the point that the enemy is at on the path.
	 */

	public Point getPathPosition(double percentage) {

		double x1 = 0;
		double y1 = 0;
		double x2 = 0;
		double y2 = 0;
		double per = 0;
		double totalLength = getTotalLength();
		double distFromStart = (totalLength * percentage);
		double remainingDist = distFromStart;

		for (int pos = 0; pos < size - 1; pos++) {

			if (remainingDist < getSegment(pos)) {

				x1 = xCoord[pos];
				y1 = yCoord[pos];
				x2 = xCoord[pos + 1];
				y2 = yCoord[pos + 1];
				per = remainingDist / getSegment(pos);
				double xDistance = ((x1 * (1 - per)) + (x2 * per));
				double yDistance = ((y1 * (1 - per)) + (y2 * per));

				x1 = xDistance;
				y1 = yDistance;

				break;
			}
			remainingDist = remainingDist - getSegment(pos);
		}

		Point p = new Point((int) x1, (int) y1);
		return p;
	}

	public double distanceToNearestPathNode(Point p) {

		double shortest = path.get(0).distance(p);

		for (Point q : path) {

			double distance = p.distance(q);
			if (distance < shortest)
				shortest = distance;

		}

		return shortest;

	}

}
