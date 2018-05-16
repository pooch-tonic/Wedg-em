package interfacesModel;

public interface ISquare {
	public void createSelectorIfEmpty(final int[] indexes);

	public IUnit getUnit();

	public boolean isEmpty();

	public void placeUnitIfEmpty(final IUnit unit);

	public void receiveMovingUnit(final IUnit movingUnit, final int[] targetIndexes);

	public void removeUnit();
}
