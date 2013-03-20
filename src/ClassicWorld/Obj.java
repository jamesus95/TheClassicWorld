package ClassicWorld;

import org.newdawn.slick.Image;

public class Obj {
	int x = 0;
	int y = 0;
	int sizeX = 0;
	int sizeY = 0;
	String name = null;
	Image i = null;
	
	public Obj(String name, int x, int y, int sizeX, int sizeY, Image i) {
		this.name = name;
		// will be grid numbers
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.i = i;
	}
	
	// will adjust to pix
	public void draw() {
		i.draw(x, y);
	}
	
	public boolean isIn(float x1, float y1, float sizeX1, float sizeY1) {
		if (x + sizeX >= x1 && x <= x1 + sizeX1 && y + sizeY >= y1 && y <= y1 + sizeY1) {
			return true;
		}
		return false;
	}
	
}
