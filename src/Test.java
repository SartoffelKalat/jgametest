import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Test extends JFrame {
	public static String LEFT = "left";
	public static String RIGHT = "right";
	public static String UP = "up";
	public static String DOWN = "down";
	public static int MOVESPEED_HERO = 5;
	public static int SHOTDELAY_HERO = 15;

	private static final long serialVersionUID = 1L;

	boolean isRunning;
	Unit hero;
	Unit badguy;
	Graphics bbg;
	private BufferedImage backBuffer;
	private static int fps = 60;
	private static int windowWidth = 500;
	private static int windowHeight = 500;
	InputHandler input;
	BulletFactory bf ;
	
	int lastTimeShot = 0;

	public void run() {
		initialize();

		while (isRunning) {
			long time = System.currentTimeMillis();

			update();
			draw();

			time = (1000 / fps) - (System.currentTimeMillis() - time);

			if (time > 0) {
				try {
					Thread.sleep(time);
				} catch (Exception e) {

				}
			}

		}
		setVisible(false);
	}

	void initialize() {

		isRunning = true;
		setTitle("Game");
		setSize(windowWidth, windowHeight);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		hero = new Unit(50, 50, 30, 30, false);
		badguy = new Unit(20, 50, 30, 30, true);
		backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		input = new InputHandler(this);
		bf = new BulletFactory(backBuffer, badguy);

	}

	void update() {
		if (input.isKeyDown(KeyEvent.VK_H)) {
			
			badguy.setX(badguy.getX() + MOVESPEED_HERO);
		}

		if (input.isKeyDown(KeyEvent.VK_RIGHT)) {
			hero.setX(hero.getX() + MOVESPEED_HERO);
		}
		if (input.isKeyDown(KeyEvent.VK_LEFT)) {
			hero.setX(hero.getX() - MOVESPEED_HERO);
		}
		if (input.isKeyDown(KeyEvent.VK_DOWN)) {
			hero.setY(hero.getY() + MOVESPEED_HERO);
		}
		if (input.isKeyDown(KeyEvent.VK_UP)) {
			hero.setY(hero.getY() - MOVESPEED_HERO);
		}
		if (lastTimeShot == 0) {
			if (input.isKeyDown(KeyEvent.VK_D) && input.getLastPressedkey() == KeyEvent.VK_D) {
				bf.addBulletToList(new Bullet(hero.getX(), hero.getY(), LEFT));
			}
			if (input.isKeyDown(KeyEvent.VK_A) && input.getLastPressedkey() == KeyEvent.VK_A) {
				bf.addBulletToList(new Bullet(hero.getX(), hero.getY(), RIGHT));
			}
			if (input.isKeyDown(KeyEvent.VK_W) && input.getLastPressedkey() == KeyEvent.VK_W) {
				bf.addBulletToList(new Bullet(hero.getX(), hero.getY(), UP));
			}
			if (input.isKeyDown(KeyEvent.VK_S) && input.getLastPressedkey() == KeyEvent.VK_S) {
				bf.addBulletToList(new Bullet(hero.getX(), hero.getY(), DOWN));
			}
			lastTimeShot++;
		}
		if (lastTimeShot == SHOTDELAY_HERO) {
			lastTimeShot = 0;
		} else {
			lastTimeShot++;
		}
	}

	void draw() {
		Graphics g = getGraphics();
		bbg = backBuffer.getGraphics();
		
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, windowWidth, windowHeight);

		bbg.setColor(Color.BLACK);
		bbg.drawRect(hero.getX(), hero.getY(), hero.getWidth(), hero.getWidth());
		
		
		
		
		if (!badguy.getIsDead()) {
			bbg.setColor(Color.RED);
			bbg.fillRect(badguy.getX(), badguy.getY(), badguy.getWidth(), badguy.getHeight());
		}
		
		
		bbg = bf.drawAllBullets();
		
		

		g.drawImage(backBuffer, 0, 0, this);

	}

	public static void main(String[] args) {
		Test t = new Test();
		t.run();
		System.exit(0);
	}

	

}
