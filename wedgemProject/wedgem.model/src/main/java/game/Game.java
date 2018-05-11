package game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import board.Board;
import interfacesModel.IGame;
import vector.Vector;

public class Game extends Observable implements IGame {
	private ArrayList<Observer>	observers;
	private Board				board;

	public Game() {
		this.setObservers(new ArrayList<Observer>());
		this.setBoard(new Board(new Vector(0, 0)));
	}

	@Override
	public void addObserver(final Observer observer) {
		this.getObservers().add(observer);
	}

	@Override
	public void deleteObserver(final Observer observer) {
		this.getObservers().remove(observer);
	}

	public Board getBoard() {
		return this.board;
	}

	public ArrayList<Observer> getObservers() {
		return this.observers;
	}

	public void setBoard(final Board board) {
		this.board = board;
	}

	private void setObservers(final ArrayList<Observer> observers) {
		this.observers = observers;
	}
}
