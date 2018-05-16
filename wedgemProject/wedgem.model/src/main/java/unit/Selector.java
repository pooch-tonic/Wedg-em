package unit;

import java.awt.Image;

import gameSettings.GameSettings;
import image.SpriteProvider;
import interfacesModel.ISelector;
import interfacesModel.IUnit;
import vector.Vector;

public class Selector implements ISelector, IUnit {
	private Image	sprite;
	private Vector	position;

	public Selector(final int[] indexes) {
		this.initialize(
				new Vector(indexes[1] * GameSettings.getSquaresize(), indexes[0] * GameSettings.getSquaresize()));
	}

	public Selector(final Vector position) {
		this.initialize(position);
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

	private void initialize(final Vector position) {
		this.sprite = SpriteProvider.getSelectorSprite();
		this.setPosition(position);
	}

	public void resetSprite() {
		// nothing
	}

	public void setPosition(final Vector position) {
		this.position = position;
	}

	public void updatePosition(final int[] indexes) {
		this.setPosition(
				new Vector(indexes[1] * GameSettings.getSquaresize(), indexes[0] * GameSettings.getSquaresize()));
	}

	public void useHoveredSprite() {
		// nothing
	}

}
