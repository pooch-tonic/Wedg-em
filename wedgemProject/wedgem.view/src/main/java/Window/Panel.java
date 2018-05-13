package Window;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import interfacesModel.IBoard;

public class Panel extends JPanel {
	private static final long	serialVersionUID	= 6527399859189638479L;

	private Image				boardSprite;

	public Panel(final IBoard board) {
		this.setBoardSprite(board.getSprite());
	}

	private Image getBoardSprite() {
		return this.boardSprite;
	}

	@Override
	public void paintComponent(final Graphics g) {
		g.drawImage(this.getBoardSprite(), 0, 0, null);
	}

	private void setBoardSprite(final Image boardSprite) {
		this.boardSprite = boardSprite;
	}

}
