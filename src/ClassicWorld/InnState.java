package ClassicWorld;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InnState extends BasicGameState {

	Utility u = null;
	int stateID = -1;
	Hero xy = null;
	Image inn = null;
	float herosp = .1f;
	ArrayList<Obj> list = null;
	
	public InnState(int stateID) {
		this.stateID = stateID;
	}
	
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		xy = new Hero(400, 350, new Image("hero.png"));
		inn = new Image("roomBlank.png");
		list = new ArrayList<Obj>();
		u = new Utility();
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics arg2) throws SlickException {
		inn.draw(0,0);
		xy.hero.draw(xy.x, xy.y);
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input i = gc.getInput();
		xy = u.updateMove(i, delta, xy, list);
		if (xy.y > 360) {
			sb.enterState(ClassicWorldGame.CLASSICWORLDTOWN);
		}
	}

	public int getID() {
		return stateID;
	}

}
