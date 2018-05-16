package mainController;

import java.awt.Point;

import gameSettings.GameSettings;
import interfacesModel.IBoard;
import interfacesModel.IUnit;

public class BoardManager {
	private int[]	lastSelectedSquareIndexes;
	private int[]	newSelectionIndexes;

	public BoardManager() {
		this.setLastSelectedSquareIndexes(new int[2]);
		this.setNewSelectionIndexes(new int[2]);
	}

	public boolean checkIfMoveAllowed(final IBoard board, final int[] selectedSquareIndexes) {
		if (this.isMouseOnDelimiter(selectedSquareIndexes) && board.getSquare(selectedSquareIndexes).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public int[] getLastSelectedSquareIndexes() {
		return this.lastSelectedSquareIndexes;
	}

	public int[] getNewSelectionIndexes() {
		return this.newSelectionIndexes;
	}

	public int[] getSquareIndexesUnderMouse(final IBoard board, final Point mousePosition) {
		return (new int[] { mousePosition.y / GameSettings.getSquaresize(),
				mousePosition.x / GameSettings.getSquaresize() });
		// returns [Y = Lines][X = Columns]
	}

	public boolean isMouseOnDelimiter(final int[] hoveredSquareIndexes) {
		if (hoveredSquareIndexes[0] == this.lastSelectedSquareIndexes[0]
				|| hoveredSquareIndexes[1] == this.lastSelectedSquareIndexes[1]) {
			return true;
		} else {
			return false;
		}
	}

	public void moveUnit(final IBoard board, final int[] originIndexes, final int[] targetIndexes) {
		/*
		 * DEBUG
		 *
		 * System.out.println("ORIGIN : LINE :" + originIndexes[0] + ", COLUMN :" +
		 * originIndexes[1]); System.out.println("TARGET : LINE :" + targetIndexes[0] +
		 * ", COLUMN :" + targetIndexes[1]);
		 */

		IUnit movingUnit = board.getSquare(originIndexes).getUnit();
		board.getSquare(targetIndexes).receiveMovingUnit(movingUnit, targetIndexes);
		board.getSquare(originIndexes).removeUnit();
	}

	public void resizeHoveredUnit(final IBoard board, final Point mousePosition) {
		int[] hoveredSquareIndexes = this.getSquareIndexesUnderMouse(board, mousePosition);
		board.manageHoveredUnit(hoveredSquareIndexes);
		this.setLastSelectedSquareIndexes(hoveredSquareIndexes);
	}

	public void selectionStep(final IBoard board, final Point mousePosition) {
		int[] hoveredSquareIndexes = this.getSquareIndexesUnderMouse(board, mousePosition);
		if (this.isMouseOnDelimiter(hoveredSquareIndexes)) {
			board.getSquare(hoveredSquareIndexes).createSelectorIfEmpty(hoveredSquareIndexes);
		}
	}

	private void setLastSelectedSquareIndexes(final int[] lastSelectedSquareIndexes) {
		this.lastSelectedSquareIndexes = lastSelectedSquareIndexes;
	}

	public void setNewSelectionIndexes(final int[] newSelectionIndexes) {
		this.newSelectionIndexes = newSelectionIndexes;
	}

}
