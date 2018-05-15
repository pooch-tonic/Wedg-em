package Window;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import interfacesModel.IBoard;
import interfacesModel.ISquare;
import interfacesModel.IUnit;
import vector.Vector;

public class Panel extends JPanel {
	private static final long	serialVersionUID	= 6527399859189638479L;

	private IBoard				board;
	private Image				boardSprite;
	private Image				delimiterSprite;
	private int					xBoard;
	private int					yBoard;
	private boolean				paintDelimiter;
	private Vector				delimiterPosition;

	public Panel(final IBoard board, final Image delimiterSprite) {
		this.setBoard(board);
		this.setDelimiterSprite(delimiterSprite);
		this.setBoardSprite(this.getBoard().getSprite());
		this.setxBoard(this.getBoard().getPosition().getX().intValue());
		this.setyBoard(this.getBoard().getPosition().getY().intValue());
	}

	private void drawBoard(final Graphics g) {
		g.drawImage(this.getBoardSprite(), this.getxBoard(), this.getyBoard(), null);
	}

	private void drawDelimiter(final Graphics g) {
		g.drawImage(this.getDelimiterSprite(), this.getDelimiterPosition().getX().intValue(),
				this.getDelimiterPosition().getY().intValue(), null);
	}

	private void drawUnit(final Graphics g, final IUnit unit) {
		g.drawImage(unit.getSprite(), unit.getPosition().getX().intValue(), unit.getPosition().getY().intValue(), null);
	}

	private void drawUnits(final Graphics g, final ISquare[][] squares) {
		IUnit unitTemp;
		for (ISquare[] squaresRow : squares) {
			for (ISquare square : squaresRow) {
				unitTemp = square.getUnit();
				if (unitTemp != null) {
					this.drawUnit(g, unitTemp);
				}
			}
		}
	}

	private IBoard getBoard() {
		return this.board;
	}

	private Image getBoardSprite() {
		return this.boardSprite;
	}

	private Vector getDelimiterPosition() {
		return this.delimiterPosition;
	}

	private Image getDelimiterSprite() {
		return this.delimiterSprite;
	}

	public boolean getPaintDelimiter() {
		return this.paintDelimiter;
	}

	private int getxBoard() {
		return this.xBoard;
	}

	private int getyBoard() {
		return this.yBoard;
	}

	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		this.drawBoard(g);
		if (this.paintDelimiter) {
			this.drawDelimiter(g);
		}
		this.drawUnits(g, this.getBoard().getSquares());
	}

	private void setBoard(final IBoard board) {
		this.board = board;
	}

	private void setBoardSprite(final Image boardSprite) {
		this.boardSprite = boardSprite;
	}

	private void setDelimiterPosition(final Vector delimiterPosition) {
		this.delimiterPosition = delimiterPosition;
	}

	private void setDelimiterSprite(final Image delimiterSprite) {
		this.delimiterSprite = delimiterSprite;
	}

	public void setPaintDelimiter(final boolean paintDelimiter, final int x, final int y) {
		this.paintDelimiter = paintDelimiter;
		this.setDelimiterPosition(new Vector(x, y));
	}

	private void setxBoard(final int xBoard) {
		this.xBoard = xBoard;
	}

	private void setyBoard(final int yBoard) {
		this.yBoard = yBoard;
	}

}
