package unit;

import java.awt.Image;

import image.SpriteProvider;
import interfacesModel.ISelector;
import interfacesModel.IUnit;
import vector.Vector;

public class Selector implements ISelector, IUnit {
	private Image	sprite;
	private Vector	position;

	public Selector(final Vector position) {
		this.sprite = SpriteProvider.getSelectorSprite();
		this.setPosition(position);
	}

	public int getPlayer() {
		return 0;
	}

	public Vector getPosition() {
		return this.position;
	}

	public Image getSprite() {
		return this.sprite;
	}

	public void resetSprite() {
		// nothing
	}

	public void setPosition(final Vector position) {
		this.position = position;
	}

	public void useHoveredSprite() {
		// nothing
	}

}
