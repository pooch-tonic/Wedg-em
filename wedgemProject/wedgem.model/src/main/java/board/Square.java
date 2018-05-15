package board;

import interfacesModel.ISquare;
import interfacesModel.IUnit;

public class Square implements ISquare {
	private IUnit unit;

	public Square() {
		this.setUnit(null);
	}

	public Square(final IUnit unit) {
		this.setUnit(unit);
	}

	public IUnit getUnit() {
		return this.unit;
	}

	public void placeUnitIfEmpty(final IUnit unit) {
		if (this.getUnit() == null) {
			this.setUnit(unit);
		}
	}

	public void removeUnit() {
		this.setUnit(null);
	}

	private void setUnit(final IUnit unit) {
		this.unit = unit;
	}

}
