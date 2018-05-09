package board;

import interfacesModel.ISquare;
import interfacesModel.IUnit;
import unit.Unit;

public class Square implements ISquare {
	private Unit unit;

	public Square() {
		// TODO Auto-generated constructor stub
	}

	public IUnit getUnit() {
		return this.unit;
	}

	public void placeUnitIfEmpty(final IUnit unit) {
		// TODO Auto-generated method stub

	}

}
