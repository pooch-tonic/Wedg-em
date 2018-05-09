package board;

import java.awt.Image;

import interfacesModel.IBoard;
import interfacesModel.IDisplayable;
import interfacesModel.ISquare;
import vector.Vector;

public class Board implements IBoard, IDisplayable {
	private ISquare[][] squares;

	public Board() {
	}

	public Vector getPosition() {
		return null;
	}

	public Image getSprite() {
		return null;
	}

	public ISquare[][] getSquares() {
		return this.squares;
	}

}
