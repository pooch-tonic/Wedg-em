package mainController;

import java.awt.Point;

import gameSettings.GameSettings;
import interfacesModel.IBoard;

public class BoardManager {

	public BoardManager() {
	}

	public int[] getSquareIndexesUnderMouse(final IBoard board, final Point mousePosition) {
		return (new int[] { (int) (mousePosition.getY() / GameSettings.getSquaresize()),
				(int) (mousePosition.getX() / GameSettings.getSquaresize()) });
		// returns [Y = Lines][X = Columns]
	}

	public IBoard resizeHoveredUnit(final IBoard board, final Point mousePosition) {
		int[] hoveredSquareIndexes = this.getSquareIndexesUnderMouse(board, mousePosition);
		// board.getSquares()[hoveredSquareIndexes[0]][hoveredSquareIndexes[1]].getUnit().useHoveredSprite();
		board.manageHoveredUnit(hoveredSquareIndexes[0], hoveredSquareIndexes[1]);
		return board;
	}

	public void selectionStep(final IBoard board, final Point mousePosition) {

	}

}
