package board;

import interfacesModel.IButton;
import interfacesModel.ISquare;
import interfacesModel.IUnit;

public class Square implements ISquare, IButton {
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

	public void ifHovered() {
		// TODO Auto-generated method stub

	}

	public void ifPressed() {
		// TODO Auto-generated method stub

	}

	public void placeUnitIfEmpty(final IUnit unit) {
		if (this.getUnit() == null) {
			this.setUnit(unit);
		}
	}

	private void removeUnit() {
		this.setUnit(null);
	}

	private void setUnit(final IUnit unit) {
		this.unit = unit;
	}

}
