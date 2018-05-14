package mainController;

import java.awt.Point;

import interfacesController.InteractionPerformer;
import interfacesModel.IBoard;

public class MainController implements InteractionPerformer {
	private BoardManager	boardManager;
	private UnitManager		unitManager;

	public MainController() {
		this.setBoardManager(new BoardManager());
		this.setUnitManager(new UnitManager());
	}

	public BoardManager getBoardManager() {
		return this.boardManager;
	}

	public UnitManager getUnitManager() {
		return this.unitManager;
	}

	public void processMousePosition(final IBoard board, final Point mousePosition) {
		// TODO process executed when mouse position is known
		this.getBoardManager().resizeHoveredUnit(board, mousePosition);
	}

	private void setBoardManager(final BoardManager boardManager) {
		this.boardManager = boardManager;
	}

	private void setUnitManager(final UnitManager unitManager) {
		this.unitManager = unitManager;
	}

}
