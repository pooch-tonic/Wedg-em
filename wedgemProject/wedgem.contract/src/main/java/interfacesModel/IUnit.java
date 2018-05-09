package interfacesModel;

import vector.Vector;

public interface IUnit extends IDisplayable {
	public int getPlayer();

	public Vector getPosition();

	public void setPosition(final Vector position);

	public void wedge();
}
