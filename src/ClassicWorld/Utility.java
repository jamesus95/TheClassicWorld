package ClassicWorld;
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class Utility {

	public Utility() {
		// Hello!
	}

	public void enterableBuilding(int x, int y, ArrayList<Obj> list) throws SlickException {
		list.add(new Obj("inn", x, y, 30, 80, new Image("transparent.png")));
		list.add(new Obj("inn", x + 50, y, 30, 80, new Image("transparent.png")));
		list.add(new Obj("inn", x + 30, y, 20, 40, new Image("transparent.png")));
	}

	public Image animateMove(int moveCounter, Image hero) throws SlickException {
		if (moveCounter % 50 < 25) {
			hero.destroy();
			hero = new Image("hero.png");
		} else {
			hero.destroy();
			hero = new Image("hero2.png");
		}
		if (moveCounter > 50) {
			moveCounter = 0;
		}
		return hero;
	}

	public void updateMove(Input i, int delta, Hero hero, ArrayList<Obj> list) throws SlickException {
		boolean inWall = false;
		if (i.isKeyDown(Input.KEY_W)) {
			for (Obj w : list) {
				inWall = w.isIn(hero.getXY().x + 5, hero.getXY().y - hero.getSpeed() * delta, 4, 30);
				if (inWall) {
					break;
				}	
			} 
			if (!inWall) {
				hero.getXY().y -= hero.getSpeed() * delta;
			}
		} 
		inWall = false;
		if (i.isKeyDown(Input.KEY_A)) {
			for (Obj w : list) {
				inWall = w.isIn(hero.getXY().x, hero.getXY().y + 5 - hero.getSpeed() * delta, 9, 30);
				if (inWall) {
					break;
				}
			} 
			if (!inWall) {
				hero.getXY().x -= hero.getSpeed() * delta;
			}
		}
		inWall = false;
		if (i.isKeyDown(Input.KEY_D)) {
			for (Obj w : list) {
				inWall = w.isIn(hero.getXY().x + 5, hero.getXY().y + 5 + hero.getSpeed() * delta, 9, 30);
				if (inWall) {
					break;
				}
			} 
			if (!inWall) {
				hero.getXY().x += hero.getSpeed() * delta;
			}
		}
		inWall = false;
		if (i.isKeyDown(Input.KEY_S)) {
			for (Obj w : list) {
				inWall = w.isIn(hero.getXY().x + 5, hero.getXY().y + 5 + hero.getSpeed() * delta, 4, 35);
				if (inWall) {
					break;
				}
			} 
			if (!inWall) {
				hero.getXY().y += hero.getSpeed() * delta;
			}
		}
		inWall = false;
	}
}
