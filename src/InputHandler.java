import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
	boolean[] keys;
	int lastPressedKey;

	public InputHandler(Component c) {
		keys = new boolean[256];
		c.addKeyListener(this);
	}

	public boolean isKeyDown(int keyCode) {
		if (keyCode > 0 && keyCode < 256) {

			return keys[keyCode];
		}

		return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keys[e.getKeyCode()] = true;
		
		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S )
			lastPressedKey = e.getKeyCode();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256 ) {
			keys[e.getKeyCode()] = false;
		}
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	 public int getLastPressedkey() {
		 return lastPressedKey;
	 }
	 

}
