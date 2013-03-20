package ClassicWorld;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

	Image background = null;
	Image play = null;
	Image exit = null;
	int stateID = -1;
	float playScale = 1;
	float exitScale = 1;
	float scaleStep = .0001f;

	public MainMenuState(int stateID) {
		this.stateID = stateID;
	}

	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		background = new Image("cwmain.jpg");
		play = new Image("play.png");
		exit = new Image("exit.png");
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
		background.draw(0,0);
		play.draw(50,300, playScale);
		exit.draw(50,355, exitScale);
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input input = gc.getInput();
		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		boolean insidePlay = false;
		boolean insideExit = false;
		if (mouseX > 50 && mouseX < 200 && mouseY > 300 && mouseY < 355) {
			insidePlay = true;
		} else if (mouseX > 50 && mouseX < 200 && mouseY > 355 && mouseY < 421) {
			insideExit = true;
		} if (insidePlay) {
			if (playScale < 1.05f) {
				playScale += scaleStep * delta;
			} if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sb.enterState(ClassicWorldGame.CLASSICWORLDTOWN);
			}
		} else {
			if (playScale > 1.0f) {
				playScale -= scaleStep * delta;
			} if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				gc.exit();
			}
		} if (insideExit) {
			if (exitScale < 1.05f) {
				exitScale +=  scaleStep * delta;
			}
		} else {
			if (exitScale > 1.0f) {
				exitScale -= scaleStep * delta;
			}
		}
	}

	public int getID() {
		return 0;
	}

}
