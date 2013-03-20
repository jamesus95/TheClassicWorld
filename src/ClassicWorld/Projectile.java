package ClassicWorld;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Projectile {
	float x;
	float y;
	float dx;
	float dy;
	Image bullet = null;
	
	public Projectile(Hero xy, boolean right, boolean forward) throws SlickException {
		x = xy.x;
		y = xy.y;
		bullet = new Image("rock.png");
		if (right && forward) {
			dx = .3f;
			dy = 0;
		} else if (right && !forward) {
			dx = -.3f;
			dy = 0;
		} else if (!right && forward) {
			dx = 0;
			dy = -.3f;
		} else {
			dx = 0;
			dy = .3f;
		}
	}
	
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void draw() {
		bullet.draw(x, y);
	}
	
}
