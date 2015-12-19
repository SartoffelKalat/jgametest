import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

public class BulletFactory extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Bullet> bulletList;
	private Graphics bbg;
	private Unit badguy;
	public static int SHOTSPEED_HERO = 3;
	

	public BulletFactory(BufferedImage backBuffer, Unit badguy) {
		bulletList = new ArrayList<Bullet>();
		
		bbg = backBuffer.getGraphics();
		this.badguy = badguy;
	}

	public void createBullet(Bullet bullet) {
		this.addBulletToList(bullet);
	}

	public void addBulletToList(Bullet bullet) {
		bulletList.add(bullet);
	}

	public Graphics drawAllBullets() {
		for (Iterator<Bullet> iterator = bulletList.iterator(); iterator.hasNext();) {
			Bullet bullet = iterator.next();
			System.out.println(bullet.getX() + "/" + bullet.getY());

			switch (bullet.getDirection()) {
			case ("left"):
				bullet.setX(bullet.getX() + SHOTSPEED_HERO);
				break;
			case ("right"):
				bullet.setX(bullet.getX() - SHOTSPEED_HERO);
				break;
			case ("up"):
				bullet.setY(bullet.getY() - SHOTSPEED_HERO);
				break;
			case ("down"):
				bullet.setY(bullet.getY() + SHOTSPEED_HERO);
				break;
			}

			Rectangle rect = bullet.getRectangle();
			bbg.setColor(Color.BLUE);
			bbg.fillRect((int) rect.getX() + 5, (int) rect.getY() + 5, (int) rect.getWidth(), (int) rect.getHeight());
			if (badguy.collidesWith(bullet.getX(), bullet.getY()) && badguy.getIsDead() == false) {
				System.out.println("hit");
				iterator.remove();
				badguy.kill();
			}
			
		}
		return bbg;
	}

}
