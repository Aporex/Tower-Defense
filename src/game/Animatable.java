/** This interface stores the functions all Animatable objects must contain
 * 
 * @author Allen Sekepyan
 * @version 11/14/21
 */

package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

public interface Animatable {
	public void update(double timeElapsed);

	public void draw(Graphics g);
}
