/** This class is a helper class that loads all the necessary resources with given parameters
 * 
 * @author Allen Sekepyan
 * @version 11/14/21
 */

package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ResourceLoader {

	// Fields
	static private ResourceLoader instance;
	private Map<String, BufferedImage> imageMap;
	private Map<String, AnimatablePath> pathMap;

	// Constructor
	private ResourceLoader() {

		HashMap<String, BufferedImage> imageHashMap = new HashMap<>();
		imageMap = imageHashMap;
		HashMap<String, AnimatablePath> pathHashMap = new HashMap<>();
		pathMap = pathHashMap;

	}

	/**
	 * This class gets the backdrop and returns it as a buffered image
	 * 
	 * @param fileName takes in the name of the backdrop file
	 * @return returns the backdrop image
	 */
	public BufferedImage getImage(String fileName) {

		BufferedImage backdrop = null;

		// Load the backdrop using InputStream and the ClassLoader
		try {
			ClassLoader loader = this.getClass().getClassLoader();
			InputStream is = loader.getResourceAsStream("resources/" + fileName);
			backdrop = javax.imageio.ImageIO.read(is);

		} catch (IOException e) {
			System.out.println("Could not load the backdrop.");
			System.exit(0);
		}

		// Check if the backdrop had already been loaded with the same name
		if (imageMap.containsKey(fileName)) {

			BufferedImage image = imageMap.get(fileName);
			return image;
		}

		// If it hasn't been loaded, it loads it and adds it to the map.
		imageMap.put(fileName, backdrop);

		return backdrop;
	}

	/**
	 * This class gets the path and returns it as a path object
	 * 
	 * @param fileName takes in the name of the path file
	 * @return returns the path
	 */
	public AnimatablePath getPath(String fileName) {

		// Load the path using InputStream and the ClassLoader
		ClassLoader loader = this.getClass().getClassLoader();
		Scanner pathScanner = new Scanner(loader.getResourceAsStream("resources/" + fileName));
		AnimatablePath path = new AnimatablePath(pathScanner);

		// Check if the path had already been loaded with the same name
		if (pathMap.containsKey(fileName)) {

			AnimatablePath newPath = pathMap.get(fileName);
			return newPath;
		}

		// If it hasn't been loaded, it loads it and adds it to the map.
		pathMap.put(fileName, path);

		return path;

	}

	public String[] getWave(String fileName) {

		ClassLoader loader = this.getClass().getClassLoader();
		Scanner waveScanner = new Scanner(loader.getResourceAsStream("resources/" + fileName));


		String[] enemyWave = new String[Integer.parseInt(waveScanner.next())];

		int i = 0;

		while (waveScanner.hasNext()) {

			enemyWave[i] = waveScanner.next();
			i++;
		}

		waveScanner.close();

		return enemyWave;

	}

	/**
	 * Creates a singleton
	 * 
	 * @return returns the Resource Loader instance
	 */
	static public ResourceLoader getLoader() {

		if (instance == null)
			instance = new ResourceLoader();

		return instance;
	}

}
