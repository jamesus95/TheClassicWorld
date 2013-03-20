package ClassicWorld;

import java.util.HashMap;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class GridGameState extends BasicGameState {
	
	private int stateID = -1;
	private TiledMap map;
	private HashMap<String, Image> images;
	private Hero hero;
	private Utility util;
	// save properties of tiles in some data structure in init
	// render it
	// laugh and have a beer
	
	public GridGameState(int stateID, Hero hero, HashMap<String, Image> images, TiledMap map) {
		this.stateID = stateID;
		this.hero = hero;
		this.images = images;
		this.map = map;
	}

	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		util = new Utility();
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {

	}

	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		
	}

	public int getID() {
		return stateID;
	}

}
