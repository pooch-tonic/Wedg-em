package gameSettings;

public abstract class GameSettings {

	private static final int	boardWidth		= 10;
	private static final int	boardHeight		= 10;
	private static final int	squareSize		= 64;
	private static final int	borderWidth		= 8;
	private static final String	sprite_p1		= "/unit_black.png";
	private static final String	sprite_p2		= "/unit_white.png";
	private static final String	sprite_board	= "/board.png";

	public static int getBoardHeight() {
		return boardHeight;
	}

	public static int getBoardWidth() {
		return boardWidth;
	}

	public static int getBorderWidth() {
		return borderWidth;
	}

	public static String getSpriteBoard() {
		return sprite_board;
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
