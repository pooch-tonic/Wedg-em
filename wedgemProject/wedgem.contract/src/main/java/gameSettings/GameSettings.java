package gameSettings;

public abstract class GameSettings {
	private static final Float	graphicsScale		= 0.5f;
	private static final int	boardWidth			= 10;
	private static final int	boardHeight			= 10;
	private static final int	defaultSquareSize	= 64;
	private static final int	squareSize			= (int) (defaultSquareSize * graphicsScale);
	private static final int	defaultBorderWidth	= 8;
	private static final int	borderWidth			= (int) (defaultBorderWidth * graphicsScale);
	private static final Float	hoveringResizeScale	= 1.2f;
	private static final String	sprite_p1			= "/unit_black.png";
	private static final String	sprite_p2			= "/unit_white.png";
	private static final String	sprite_board		= "/board.png";
	private static final String	sprite_delimiter	= "/delimiter.png";

	public static int getBoardHeight() {
		return boardHeight;
	}

	public static int getBoardWidth() {
		return boardWidth;
	}

	public static int getBorderWidth() {
		return borderWidth;
	}

	public static Float getGraphicsscale() {
		return graphicsScale;
	}

	public static Float getHoveringresizescale() {
		return hoveringResizeScale;
	}

	public static String getSpriteBoard() {
		return sprite_board;
	}

	public static String getSpriteDelimiter() {
		return sprite_delimiter;
	}

	public static String getSpriteP1() {
		return sprite_p1;
	}

	public static String getSpriteP2() {
		return sprite_p2;
	}

	public static int getSquaresize() {
		return squareSize;
	}

}
