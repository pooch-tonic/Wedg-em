package interfacesController;

import java.awt.Point;

import interfacesModel.IBoard;

public interface InteractionPerformer {
	public void processMousePosition(final IBoard board, final Point mousePosition, final boolean isDelimiterOn);
}
