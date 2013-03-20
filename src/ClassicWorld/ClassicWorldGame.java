package ClassicWorld;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ClassicWorldGame extends StateBasedGame {

	public static final int MAINMENUSTATE = 0;
	public static final int CLASSICWORLDTOWN = 1;
	public static final int CLASSICWORLDSHOP = 2;
	public static final int CLASSICWORLDINN = 3;
	public static final int CLASSICWORLDROUTEONE = 4;
	public static final int one = 5;
	
	public ClassicWorldGame() throws SlickException {
		super("ClassicWorld");		
	}

	public void initStatesList(GameContainer arg0) throws SlickException {
		Hero hero = new Hero(0,0,new Image("hero.png"),new Image("hero.png"));
		this.addState(new MainMenuState(MAINMENUSTATE));
		this.addState(new TownState(CLASSICWORLDTOWN));
		this.addState(new ShopState(CLASSICWORLDSHOP));
		this.addState(new InnState(CLASSICWORLDINN));
		this.addState(new RouteOneState(CLASSICWORLDROUTEONE, hero));
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new ClassicWorldGame());
        app.setDisplayMode(800, 500, false);
        app.start();
	}

}
