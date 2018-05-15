package board;

import java.awt.Image;

import gameSettings.GameSettings;
import image.SpriteProvider;
import interfacesModel.IBoard;
import interfacesModel.IDisplayable;
import interfacesModel.ISquare;
import interfacesModel.IUnit;
import unit.Unit;
import vector.Vector;

public class Board implements IBoard, IDisplayable {
	private Image		sprite;
	private Vector		position;
	private ISquare[][]	squares;

	public Board(final Vector position) {
		this.setSquares(new ISquare[GameSettings.getBoardHeight()][GameSettings.getBoardWidth()]);
		this.setSprite(SpriteProvider.getBoardSprite());
		this.setPosition(position);
		this.initSquares(GameSettings.getBoardHeight(), GameSettings.getBoardWidth(), GameSettings.getSquaresize());
	}

	public Vector getPosition() {
		return this.position;
	}

	public Image getSprite() {
		return this.sprite;
	}

	public ISquare getSquare(final int line, final int column) {
		return this.squares[line][column];
	}

	public ISquare[][] getSquares() {
		return this.squares;
	}

	public void initSquares(final int maxLines, final int maxColumns, final int squareSize) {
		this.setSquaresFilledLine(0, maxColumns, squareSize, 1);
		for (int i = 1; i < maxLines - 1; i++) {
			this.setSquaresEmptyLine(i, maxColumns);
		}
		this.setSquaresFilledLine(maxLines - 1, maxColumns, squareSize, 2);
	}

	public void manageHoveredUnit(final int line, final int column) {
		// System.out.println("line " + line + ", column " + column);
		if (this.squares[line][column].getUnit() != null) {
			this.squares[line][column].getUnit().useHoveredSprite();
		}
	}

	public void resetAllUnits() {
		for (ISquare[] squaresRow : this.squares) {
			for (ISquare square : squaresRow) {
				IUnit unitTemp = square.getUnit();
				if (unitTemp != null) {
					if (unitTemp.getPlayer() != 0) {
						unitTemp.resetSprite();
					} else {
						square.removeUnit();
					}

				}
			}
		}
	}

	private void setPosition(final Vector position) {
		this.position = position;
	}

	public void setSprite(final Image image) {
		this.sprite = image;
	}

	public void setSquare(final int line, final int column, final ISquare square) {
		this.squares[line][column] = square;
	}

	private void setSquares(final ISquare[][] squares) {
		this.squares = squares;
	}

	public void setSquaresEmptyLine(final int line, final int maxColumns) {
		for (int i = 0; i < maxColumns; i++) {
			this.squares[line][i] = new Square();
		}
	}

	public void setSquaresFilledLine(final int line, final int maxColumns, final int squareSize, final int player) {
		for (int i = 0; i < maxColumns; i++) {
			this.squares[line][i] = new Square(new Unit(player, i * squareSize, line * squareSize));
			/*
			 * System.out.println("player " + player + ",line " + line + ", column " + i +
			 * ", position [" + i * squareSize + "; " + line * squareSize + "]");
			 */
		}
	}

}
