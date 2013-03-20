package ClassicWorld;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class RouteOneState extends BasicGameState {

	int stateID = -1;
	Utility u = null;
	Hero xy = null;
	Image background = null;
	float herosp = .2f;
	ArrayList<Obj> list = null;
	ArrayList<Projectile> bullets = null;

	public RouteOneState(int stateID, Hero h) {
		this.stateID = stateID;
		xy = h;
	}

	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		u = new Utility();
		//xy = new Hero(400, 0, new Image("hero.png"));
		list = new ArrayList<Obj>();
		bullets = new ArrayList<Projectile>();
		background = new Image("backdropMain.png");
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
		background.draw(0, 0);
		xy.hero.draw(xy.x, xy.y);
		for (Projectile p : bullets) {
			p.draw();
		}
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input i = gc.getInput();
		xy = u.updateMove(i, delta, xy, list);
		if (i.isKeyPressed(Input.KEY_UP)) {
			bullets.add(new Projectile(xy, false, true));
		}
		if (i.isKeyPressed(Input.KEY_DOWN)) {
			bullets.add(new Projectile(xy, false, false));
		}
		if (i.isKeyPressed(Input.KEY_LEFT)) {
			bullets.add(new Projectile(xy, true, false));
		}
		if (i.isKeyPressed(Input.KEY_RIGHT)) {
			bullets.add(new Projectile(xy, true, true));
		}
		for (Projectile p : bullets) {
			p.update();
		}
	}

	public int getID() {
		return stateID;
	}

}
