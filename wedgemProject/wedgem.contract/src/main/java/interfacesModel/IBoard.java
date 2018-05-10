package interfacesModel;

import java.awt.Image;

import vector.Vector;

public interface IBoard {
	public Vector getPosition();

	public Image getSprite();

	public ISquare[][] getSquares();

	public void setSquare(final int line, final int column, final ISquare square);
}
