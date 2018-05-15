package wedgem.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Window.Frame;
import game.Game;
import interfacesModel.IBoard;
import interfacesModel.IGame;
import mainController.MainController;

public class WedgemGame implements MouseListener, MouseMotionListener {
	private Frame			frame;
	private IGame			game;
	private MainController	controller;
	private IBoard			boardTemp;

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
		this.setFrame(new Frame(this.getGame().getBoard()));
		this.getFrame().getContentPane().addMouseListener(this);
		this.getFrame().getContentPane().addMouseMotionListener(this);
		this.getFrame().getPanel().repaint();
	}

	public void mouseClicked(final MouseEvent e) {
		// TODO Auto-generated method stub

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
		this.getController().processMousePosition(this.getBoardTemp(), e.getPoint());
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

}
