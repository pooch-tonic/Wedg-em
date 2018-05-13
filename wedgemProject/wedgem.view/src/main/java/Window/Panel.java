package Window;

import java.awt.Image;

import javax.swing.JPanel;

import interfacesModel.IBoard;

public class Panel extends JPanel {
	private static final long	serialVersionUID	= 6527399859189638479L;

	private Image				boardSprite;

	public Panel(final IBoard board) {
		this.setBoardSprite(board.getSprite());
	}

	public Image getBoardSprite() {
		return this.boardSprite;
	}

	public void setBoardSprite(final Image boardSprite) {
		this.boardSprite = boardSprite;
	}

}
