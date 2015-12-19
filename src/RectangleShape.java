import java.awt.Rectangle;

public class RectangleShape {
	private Rectangle rect;
	
	public void createRectangle(int x, int y, int height, int width) {
		 rect = new Rectangle(x, y, height, width);
	}

	public int getX() {
		return rect.x;
	}

	public int getY() {
		return rect.y;
	}

	public void setY(int y) {
		rect.y = y;
	}

	public void setX(int x) {
		rect.x = x;
	}

	public Rectangle getRectangle() {
		return rect;
	}

	public void setRectangle(Rectangle rect) {
		this.rect = rect;

	}
	public int getHeight() {
		return (int) rect.getHeight();
	}

	public int getWidth() {
		return  (int) rect.getWidth();
	}
	public void drawShape() {
		
	}
}
