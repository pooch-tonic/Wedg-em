package board;

import interfacesModel.ISquare;
import interfacesModel.IUnit;
import unit.Selector;

public class Square implements ISquare {
	private IUnit unit;

	public Square() {
		this.setUnit(null);
	}

	public Square(final IUnit unit) {
		this.setUnit(unit);
	}

	public void createSelectorIfEmpty(final int[] indexes) {
		if (this.isEmpty()) {
			this.setUnit(new Selector(indexes));
		}
	}

	public IUnit getUnit() {
		return this.unit;
	}

	public boolean isEmpty() {
		if (this.getUnit() == null) {
			return true;
		} else if (this.getUnit().getPlayer() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void placeUnitIfEmpty(final IUnit unit) {
		if (this.isEmpty()) {
			this.setUnit(unit);
		}
	}

	public void receiveMovingUnit(final IUnit movingUnit, final int[] targetIndexes) {
		this.setUnit(movingUnit);
		this.getUnit().updatePosition(targetIndexes);
	}

	public void removeUnit() {
		this.setUnit(null);
	}

	private void setUnit(final IUnit unit) {
		this.unit = unit;
	}

}
