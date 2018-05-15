package interfacesController;

import java.awt.Point;

import interfacesModel.IBoard;

public interface InteractionPerformer {
	public IBoard processMousePosition(final IBoard board, final Point mousePosition, final boolean isDelimiterOn);
}
