package wedgem.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Window.Frame;
import game.Game;
import gameSettings.GameSettings;
import interfacesModel.IBoard;
import interfacesModel.IGame;
import mainController.MainController;

public class WedgemGame implements MouseListener, MouseMotionListener {
	private Frame			frame;
	private IGame			game;
	private MainController	controller;
	private IBoard			boardTemp;
	private boolean			isDelimiterOn;

	public WedgemGame() {
		this.initWedgemGame();
		this.play();
	}

	private IBoard getBoardTemp() {
		return this.boardTemp;
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
		this.setBoardTemp(this.getGame().getBoard());
		this.setFrame(new Frame(this.getGame().getBoard(), this.getGame().getDelimiterSprite()));
		this.getFrame().getContentPane().addMouseListener(this);
		this.getFrame().getContentPane().addMouseMotionListener(this);
		this.getFrame().getPanel().repaint();
		this.setIsDelimiterOn(false);
	}

	public boolean isDelimiterOn() {
		return this.isDelimiterOn;
	}

	public void mouseClicked(final MouseEvent e) {
		int[] indexes = this.getController().getBoardManager().getSquareIndexesUnderMouse(this.getBoardTemp(),
				e.getPoint());
		if (this.isDelimiterOn()) {
			this.getController().processNewSelection(this.getBoardTemp(), indexes);
			this.toggleDelimiter(indexes);
		} else if (!this.getBoardTemp().getSquare(indexes).isEmpty()) {
			this.toggleDelimiter(indexes);
		}
	}

	public void mouseDragged(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(final MouseEvent e) {
		this.getBoardTemp().resetAllUnits();
		this.getController().processMousePosition(this.getBoardTemp(), e.getPoint(), this.isDelimiterOn());
	}

	public void mousePressed(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void play() {
		// TODO play method
		while (true) {
			this.setBoardTemp(this.getGame().getBoard());
			this.getFrame().setBoard(this.boardTemp);
			this.getFrame().getPanel().repaint();
		}
	}

	private void setBoardTemp(final IBoard boardTemp) {
		this.boardTemp = boardTemp;
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

	private void setIsDelimiterOn(final boolean toggleDelimiter) {
		this.isDelimiterOn = toggleDelimiter;
	}

	private void toggleDelimiter(final int[] indexes) {
		int x = indexes[1] * GameSettings.getSquaresize();
		int y = indexes[0] * GameSettings.getSquaresize();
		if (this.isDelimiterOn()) {
			this.getFrame().getPanel().setPaintDelimiter(false, x, y);
			this.setIsDelimiterOn(false);
		} else {
			this.getFrame().getPanel().setPaintDelimiter(true, x, y);
			this.setIsDelimiterOn(true);
		}

	}

}
