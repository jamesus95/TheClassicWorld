package ClassicWorld;

import org.newdawn.slick.Image;

public class Hero {
	private FloatPoint xy;
	private float speed;
	private Image hero;
	private Image hero2;
	int moveCounter;

	public Hero(float x, float y, Image hero, Image hero2) {
		this.xy = new FloatPoint(x,y);
		speed = .2f;
		this.hero = hero;
		this.hero2 = hero2;
		moveCounter = 0;
	}

	public Image getMoveImage() {
		moveCounter++;
		if (moveCounter > 20) {
			moveCounter = 0;
		}
		if (moveCounter < 10) {
			return hero;
		} else {
			return hero2;
		}
	}
	
	public FloatPoint getXY() {
		return xy;
	}
	
	public float getSpeed() {
		return speed;
	}

}
