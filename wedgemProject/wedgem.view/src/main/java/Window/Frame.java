package Window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;

import gameSettings.GameSettings;
import interfacesModel.IBoard;

public class Frame extends JFrame {

	private static final long	serialVersionUID	= 8629432388334700177L;
	private Panel				panel;
	private IBoard				board;

	public Frame(final IBoard board, final Image delimiterSprite) {
		this.setBoard(board);
		this.initFrame();
		this.initPanel(delimiterSprite);
		this.addPanelToFrame();
	}

	private void addPanelToFrame() {
		this.setContentPane(this.getPanel());
	}

	private IBoard getBoard() {
		return this.board;
	}

	public Panel getPanel() {
		return this.panel;
	}

	private void initFrame() {
		this.setTitle("Wedg'em! (alpha)");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setBackground(Color.BLACK);
		Dimension d = new Dimension(GameSettings.getBoardWidth() * GameSettings.getSquaresize(),
				GameSettings.getBoardHeight() * GameSettings.getSquaresize());
		c.setPreferredSize(d);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
	}

	private void initPanel(final Image delimiterSprite) {
		this.setPanel(new Panel(this.getBoard(), delimiterSprite));
		this.getPanel().setBackground(Color.BLACK);
	}

	public void setBoard(final IBoard board) {
		this.board = board;
	}

	private void setPanel(final Panel panel) {
		this.panel = panel;
	}

}
