

public class Bullet extends RectangleShape{

	private String direction;
	


	Bullet(int x, int y, String direction) {
		
		this.direction = direction;
		
		createRectangle(x, y, 20 , 20);
	}

	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

}
