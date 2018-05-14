package mainController;

import java.awt.Point;

import interfacesController.InteractionPerformer;

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

	public void processMousePosition(final Point mouseposition) {
		// TODO Auto-generated method stub

	}

	private void setBoardManager(final BoardManager boardManager) {
		this.boardManager = boardManager;
	}

	private void setUnitManager(final UnitManager unitManager) {
		this.unitManager = unitManager;
	}

}
