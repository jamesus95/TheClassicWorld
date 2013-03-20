package ClassicWorld;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ShopState extends BasicGameState {

	int stateID = -1;
	Image background = null;
	Hero xy = null;
	float herosp = .1f;
	Utility u = null;
	ArrayList<Obj> list = null;

	public ShopState(int stateID) {
		this.stateID = stateID;
	}

	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		background = new Image("roomBlank.png");
		xy = new Hero(400, 350, new Image("hero.png"));
		u = new Utility();
		list = new ArrayList<Obj>();
		for (int i = 0; i < 320; i += 20) {
			list.add(new Obj("Barrel", 250 + i, 120, 20, 20, new Image("barrel.png")));
		}
		for (int i = 0; i < 220; i += 20) {
			list.add(new Obj("Fruit Crate", 250, 140 + i, 20, 20, new Image("crateFruit.png")));
			list.add(new Obj("Wall Crate", 550, 140 + i, 20, 20, new Image("crateWall.png")));
		}
		for (int i = 0; i < 140; i += 20) {
			list.add(new Obj("Fruit Crate", 250 + i, 340, 20, 20, new Image("crateFruit.png")));
			list.add(new Obj("Wall Crate", 430 + i, 340, 20, 20, new Image("crateWall.png")));
		}
		list.add(new Obj("TREASURE", 400, 140, 40, 20, new Image("treasureChest.png")));
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
		background.draw(0,0);
		xy.hero.draw(xy.x, xy.y);
		for (Obj w : list) {
			w.draw();
		}
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input i = gc.getInput();
		xy = u.updateMove(i, delta, xy, list);
		if (xy.y > 360) {
			sb.enterState(ClassicWorldGame.CLASSICWORLDTOWN);
		}
		if (xy.x > 395 && xy.x < 445 && xy.y > 135 && xy.y < 165) {
			System.out.println("TREASURE!!!!!!!!!");
		}
	}

	public int getID() {
		return stateID;
	}

}
