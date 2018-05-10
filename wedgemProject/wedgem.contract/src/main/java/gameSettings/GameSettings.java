package gameSettings;

public abstract class GameSettings {

	private static final int	boardWidth	= 10;
	private static final int	boardHeight	= 10;
	private static final int	squareSize	= 64;
	private static final int	borderWidth	= 8;

	public static int getBoardheight() {
		return boardHeight;
	}

	public static int getBoardwidth() {
		return boardWidth;
	}

	public static int getBorderwidth() {
		return borderWidth;
	}

	public static int getSquaresize() {
		return squareSize;
	}
}
