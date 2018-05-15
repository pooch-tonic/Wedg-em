package interfacesModel;

import java.awt.Image;

import vector.Vector;

public interface IUnit {
	public int getPlayer();

	public Vector getPosition();

	public Image getSprite();

	public void resetSprite();

	public void setPosition(final Vector position);

	public void useHoveredSprite();
}
