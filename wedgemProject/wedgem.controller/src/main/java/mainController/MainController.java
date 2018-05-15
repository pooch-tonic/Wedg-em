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

	public IBoard processMousePosition(final IBoard board, final Point mousePosition, final boolean isDelimiterOn) {
		// TODO process executed when mouse position is known
		return this.getBoardManager().resizeHoveredUnit(board, mousePosition);
	}

	private void setBoardManager(final BoardManager boardManager) {
		this.boardManager = boardManager;
	}

}
