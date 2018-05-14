package Window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import gameSettings.GameSettings;
import interfacesModel.IBoard;

public class Frame extends JFrame implements MouseListener, MouseMotionListener {

	private static final long	serialVersionUID	= 8629432388334700177L;
	private Panel				panel;
	private IBoard				board;
	private boolean				isMouseInFrame;

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
		this.getContentPane().addMouseMotionListener(this);
		this.getContentPane().addMouseListener(this);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
	}

	private void initPanel() {
		this.setPanel(new Panel(this.getBoard()));
		this.getPanel().setBackground(Color.BLACK);
	}

	public boolean isMouseInFrame() {
		return this.isMouseInFrame;
	}

	public void mouseClicked(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(final MouseEvent e) {
		this.setMouseInFrame(true);
	}

	public void mouseExited(final MouseEvent e) {
		this.setMouseInFrame(false);
	}

	public void mouseMoved(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(final MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void setBoard(final IBoard board) {
		this.board = board;
	}

	private void setMouseInFrame(final boolean isMouseInFrame) {
		this.isMouseInFrame = isMouseInFrame;
	}

	private void setPanel(final Panel panel) {
		this.panel = panel;
	}

}
