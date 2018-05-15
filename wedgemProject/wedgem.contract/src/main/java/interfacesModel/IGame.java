package interfacesModel;

import java.awt.Image;

public interface IGame {
	public IBoard getBoard();

	public Image getDelimiterSprite();

	public void setBoard(final IBoard board);
}
