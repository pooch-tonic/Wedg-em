package wedgem.main;

import Window.Frame;
import game.Game;
import interfacesModel.IGame;

public class WedgemGame {
	private Frame	frame;
	private IGame	game;

	public WedgemGame() {
		this.initWedgemGame();
	}

	public Frame getFrame() {
		return this.frame;
	}

	private IGame getGame() {
		return this.game;
	}

	private void initWedgemGame() {
		this.setGame(new Game());
		this.setFrame(new Frame(this.getGame().getBoard()));
	}

	public void play() {
		// TODO play method
	}

	public void setFrame(final Frame frame) {
		this.frame = frame;
	}

	private void setGame(final IGame game) {
		this.game = game;
	}

}
