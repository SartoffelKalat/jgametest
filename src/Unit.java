
public class Unit extends RectangleShape{
	private boolean isEnemy; 
	private boolean isDead;

	public Unit(int x, int y, int width, int height, boolean isEnemy) {
		this.isEnemy = isEnemy;
		createRectangle(x, y, width, height);
		isDead = false;
	}
	
	public boolean getIsEnemy() {
		return isEnemy;
	}
	
	public boolean collidesWith(int targetX, int targetY) {
		System.out.println(targetX +getWidth() +"/" + getWidth() + "/"  + getX() + "/" + getWidth() + "//" + + getY() + "/" + getHeight() );
		return (targetX + getX() >= getWidth() && targetX <= getWidth() + getX() && targetY+getY() >= getHeight() && targetY <= getHeight() + getY());		
	}
	
	public boolean getIsDead() {
		return isDead;
	}
	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}
	public void kill() {
		isDead = true;
	}

	public void revive() {
		isDead = false;
		
	}
}
