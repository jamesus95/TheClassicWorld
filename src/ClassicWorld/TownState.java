package ClassicWorld;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class TownState extends BasicGameState {
	Hero hero = null;
	int moveCounter;
	int stateID = -1;
	Image backdrop = null;
	Image bush = null;
	Image inn = null;
	Image shop = null;
	Image grass = null;
	Image wheat = null;
	Image bunTest = null;
	int bunCount = 0;
	ArrayList<Obj> list = null;
	Utility u = null;

	public TownState(int stateID) throws SlickException {
		this.stateID = stateID;
		hero = new Hero(40,250,new Image("Hero.png"));
	}

	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		backdrop = new Image("backdropMain.png");
		bush = new Image("bush.png");
		inn = new Image("house.png");
		shop = new Image("house.png");
		grass = new Image("grass.png");
		wheat = new Image("wheat.png");
		bunTest = new Image("bunny.png");
		u = new Utility();
		list = new ArrayList<Obj>();
		Image bush = new Image("bush.png");
		for (int i = 0; i < 800; i += 20) {
			list.add(new Obj("bush", i, 0, 20, 20, bush));
		}
		for (int i = 0; i < 380; i += 20) {
			list.add(new Obj("bush", i + 420, 480, 20, 20, bush));
			list.add(new Obj("bush", i, 480, 20, 20, bush));
		}
		for (int i = 0; i < 500; i += 20) {
			list.add(new Obj("bush", 0, i, 20, 20, bush));
			list.add(new Obj("bush", 780, i, 20, 20, bush));
		}
		list.add(new Obj("house", 200, 120, 80, 80, new Image("house.png")));
		list.add(new Obj("house", 620, 140, 80, 80, new Image("house.png")));
		list.add(new Obj("house", 280, 360, 80, 80, new Image("house.png")));
		list.add(new Obj("signInn", 590, 360, 20, 20, new Image("signInn.png")));
		list.add(new Obj("signShop", 190, 360, 20, 20, new Image("signShop.png")));
		list.add(new Obj("crateEmpty", 50, 60, 20, 20, new Image("crateEmpty.png")));
		list.add(new Obj("crateFruit", 50, 80, 20, 20, new Image("crateFruit.png")));
		list.add(new Obj("crateFruit", 70, 80, 20, 20, new Image("crateFruit.png")));
		list.add(new Obj("crateFruit", 700, 190, 20, 20, new Image("crateFruit.png")));
		list.add(new Obj("barrel", 400, 80, 20, 20, new Image("barrel.png")));
		list.add(new Obj("barrel", 460, 130, 20, 20, new Image("barrel.png")));
		list.add(new Obj("barrel", 460, 150, 20, 20, new Image("barrel.png")));
		list.add(new Obj("treasure", 700, 400, 20, 20, new Image("treasure.png")));
		list.add(new Obj("treasureChest", 700, 430, 40, 20, new Image("treasureChest.png")));
		for (int i = 640; i < 760; i += 20) {
			list.add(new Obj("fenceHorizontal", i, 380, 20, 20, new Image("fenceHorizontal.png")));
			list.add(new Obj("fenceHorizontal", i, 460, 20, 20, new Image("fenceHorizontal.png")));
		}
		for (int i = 400; i < 460; i += 20) {
			list.add(new Obj("fenceVertical", 640, i, 20, 20, new Image("fenceVertical.png")));
			list.add(new Obj("fenceVerticalal", 740, i, 20, 20, new Image("fenceVertical.png")));
		}
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
		backdrop.draw(0,0);
		/*for (Obj w : list) {
			w.draw();
		}
		inn.draw(500,300);
		u.enterableBuilding(500, 300, list);
		shop.draw(100, 300);
		u.enterableBuilding(100, 300, list);
		for (int i = 320; i < 460; i+=20) {
			for (int j = 100; j < 240; j+=20) {
				wheat.draw(i, j);
			}
		}
		for (int i = 660; i < 760; i += 20) {
			grass.draw(i, 250);
		}
		for (int i = 60; i < 160; i += 20) {
			grass.draw(i, 180);
		}
		grass.draw(300, 40);
		grass.draw(650, 60);
		grass.draw(670, 60);
		grass.draw(650, 90);*/
		hero.hero.draw(hero.x, hero.y);/*
		if (bunCount % 50 < 25) {
			bunTest.destroy();
			bunTest = new Image("bunny.png");
		} else {
			bunTest.destroy();
			bunTest = new Image("bunny2.png");
		}
		bunCount++;
		bunTest.draw(220, 80);*/
		for (Obj j: list) {
			j.draw();
		}
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input i = gc.getInput();
		hero = u.updateMove(i, delta, hero, list);
		// 500,300 inn
		if (hero.x > 530 && hero.x < 550 && hero.y > 340 && hero.y < 360) {
			sb.enterState(ClassicWorldGame.CLASSICWORLDINN);
		}
		// shop
		if (hero.x > 130 && hero.x < 150 && hero.y > 340 && hero.y < 360) {
			sb.enterState(ClassicWorldGame.CLASSICWORLDSHOP);
		}
		if (hero.x < 420 && hero.x > 380 && hero.y > 495) {
			hero.x = 400;
			hero.y = 0;
			sb.enterState(ClassicWorldGame.CLASSICWORLDROUTEONE);
		}
	}

	public int getID() {
		return stateID;
	}
	
	public Hero getHero() {
		return hero;
	}

}
