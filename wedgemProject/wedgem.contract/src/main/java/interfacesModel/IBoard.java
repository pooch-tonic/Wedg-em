package interfacesModel;

import java.awt.Image;

import vector.Vector;

public interface IBoard {
	public Vector getPosition();

	public Image getSprite();

	public ISquare getSquare(final int line, final int column);

	public ISquare getSquare(final int[] indexes);

	public ISquare[][] getSquares();

	public void manageHoveredUnit(final int line, final int column);

	public void manageHoveredUnit(final int[] indexes);

	public void resetAllUnits();

	public void setSquare(final int line, final int column, final ISquare square);
}
