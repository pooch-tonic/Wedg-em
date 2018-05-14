package wedgem.main;

import Window.Frame;
import game.Game;
import interfacesModel.IBoard;
import interfacesModel.IGame;
import mainController.MainController;

public class WedgemGame {
	private Frame			frame;
	private IGame			game;
	private MainController	controller;

	public WedgemGame() {
		this.initWedgemGame();
		this.play();
	}

	private MainController getController() {
		return this.controller;
	}

	private Frame getFrame() {
		return this.frame;
	}

	private IGame getGame() {
		return this.game;
	}

	private void initWedgemGame() {
		this.setGame(new Game());
		this.setController(new MainController());
		this.setFrame(new Frame(this.getGame().getBoard()));
		this.getFrame().getPanel().repaint();
	}

	private void play() {
		// TODO play method
		while (true) {
			IBoard boardTemp = this.getGame().getBoard();
			this.getController().processMousePosition(boardTemp, this.getFrame().getContentPane().getMousePosition());
			this.getFrame().setBoard(boardTemp);
			this.getFrame().getPanel().repaint();
		}
	}

	private void setController(final MainController controller) {
		this.controller = controller;
	}

	private void setFrame(final Frame frame) {
		this.frame = frame;
	}

	private void setGame(final IGame game) {
		this.game = game;
	}

}
