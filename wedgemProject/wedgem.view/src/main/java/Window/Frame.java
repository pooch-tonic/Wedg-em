package Window;

import javax.swing.JFrame;

import gameSettings.GameSettings;
import interfacesModel.IBoard;

public class Frame extends JFrame {

	private static final long	serialVersionUID	= 8629432388334700177L;
	private Panel				panel;
	private IBoard				board;

	public Frame(final IBoard board) {
		this.setBoard(board);
		this.initFrame();
		this.initPanel();
		this.addPanelToFrame();
	}

	private void addPanelToFrame() {
		this.setContentPane(this.getPanel());
	}

	private IBoard getBoard() {
		return this.board;
	}

	private Panel getPanel() {
		return this.panel;
	}

	private void initFrame() {
		this.setTitle("Wedg'em! (alpha)");
		this.setSize(GameSettings.getBoardWidth() * GameSettings.getSquaresize(),
				GameSettings.getBoardHeight() * GameSettings.getSquaresize());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initPanel() {
		this.setPanel(new Panel(this.getBoard()));
	}

	private void setBoard(final IBoard board) {
		this.board = board;
	}

	private void setPanel(final Panel panel) {
		this.panel = panel;
	}

}
