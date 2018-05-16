package mainController;

import java.awt.Point;
import java.util.ArrayList;

import gameSettings.GameSettings;
import interfacesModel.IBoard;
import interfacesModel.ISquare;
import interfacesModel.IUnit;
import vector.Vector;

public class BoardManager {
	private int[]			lastSelectedSquareIndexes;
	private int[]			newSelectionIndexes;
	private final Vector[]	wedgingDirections	= { new Vector(-1, -1), new Vector(0, -1), new Vector(1, -1),
			new Vector(-1, 0), /* CENTER VECT */ new Vector(1, 0), new Vector(-1, 1), new Vector(0, 1),
			new Vector(1, 1) };

	public BoardManager() {
		this.setLastSelectedSquareIndexes(new int[2]);
		this.setNewSelectionIndexes(new int[2]);
	}

	private void addIndexesEntry(final int[] indexes, final ArrayList<int[]> wedgedUnitsIndexes) {
		wedgedUnitsIndexes.add(indexes);
	}

	public boolean checkIfMoveAllowed(final IBoard board, final int[] selectedSquareIndexes) {
		if (this.isMouseOnDelimiter(selectedSquareIndexes) && board.getSquare(selectedSquareIndexes).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private void checkIfWedging(final IBoard board, final int[] wedgingUnitIndexes,
			final ArrayList<int[]> wedgedUnitsIndexes) {
		final Vector unitPosition = new Vector(wedgingUnitIndexes[1], wedgingUnitIndexes[0]);
		Vector checkedPosition = new Vector();
		ISquare checkedSquare;
		for (Vector direction : this.getWedgingDirections()) {
			checkedPosition.set(unitPosition.returnAddResult(direction));
			checkedSquare = board.getSquare(checkedPosition.getX().intValue(), checkedPosition.getY().intValue());
			if (!checkedSquare.isEmpty()) {
				int wedgingPlayer = checkedSquare.getUnit().getPlayer();
				if (wedgingPlayer != board.getSquare(wedgingUnitIndexes).getUnit().getPlayer()) {
					this.getWedgedUnitsIndexes(board, wedgingPlayer, unitPosition, direction, wedgedUnitsIndexes);
				}
			}
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

	private void getWedgedUnitsIndexes(final IBoard board, final int wedgingPlayer, final Vector unitPosition,
			final Vector direction, final ArrayList<int[]> wedgedUnitsIndexes) {
		boolean canWedge = false;
		for (int x = unitPosition.getIntX() + direction.getIntX(), y = unitPosition.getIntY()
				+ direction.getIntY(); (x >= 0 && x <= GameSettings.getBoardWidth() && y >= 0
						&& y <= GameSettings.getBoardHeight())
						|| (!canWedge); x += direction.getIntX(), y += direction.getIntY()) {
			if (board.getSquare(x, y).getUnit().getPlayer() == wedgingPlayer) {
				this.addIndexesEntry(new int[] { 0, 0 }, wedgedUnitsIndexes);
			}
		}
	}

	private Vector[] getWedgingDirections() {
		return this.wedgingDirections;
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

	public void wedge(final IBoard board, final int[] wedgingUnitIndexes) {
		ArrayList<int[]> wedgedUnitsIndexes = new ArrayList<int[]>();
		this.checkIfWedging(board, wedgingUnitIndexes, wedgedUnitsIndexes);

	}

}
