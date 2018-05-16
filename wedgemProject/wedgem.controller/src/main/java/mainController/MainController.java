package mainController;

import java.awt.Point;

import interfacesController.InteractionPerformer;
import interfacesModel.IBoard;

public class MainController implements InteractionPerformer {
	private BoardManager boardManager;

	public MainController() {
		this.setBoardManager(new BoardManager());
	}

	public BoardManager getBoardManager() {
		return this.boardManager;
	}

	public void processMousePosition(final IBoard board, final Point mousePosition, final boolean isDelimiterOn) {
		// TODO process executed when mouse position is known
		if (isDelimiterOn) {
			this.getBoardManager().selectionStep(board, mousePosition);
		} else {
			this.getBoardManager().resizeHoveredUnit(board, mousePosition);
		}

	}

	public void processNewSelection(final IBoard board, final int[] selectedSquareIndexes) {

		/*
		 * DEBUG
		 *
		 * System.out.println("CLICK BEFORE MOVE :  LINE " + selectedSquareIndexes[0] +
		 * ", COLUMN " + selectedSquareIndexes[1]);
		 */

		if (this.getBoardManager().checkIfMoveAllowed(board, selectedSquareIndexes)) {

			/*
			 * DEBUG
			 *
			 * System.out.println("MOVE");
			 */
			this.getBoardManager().moveUnit(board, this.getBoardManager().getLastSelectedSquareIndexes(),
					selectedSquareIndexes);
			this.getBoardManager().wedge(board, selectedSquareIndexes);
		}
	}

	private void setBoardManager(final BoardManager boardManager) {
		this.boardManager = boardManager;
	}

}
