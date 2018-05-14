package button;

import java.awt.Image;

import interfacesModel.IButton;
import interfacesModel.IDisplayable;
import vector.Vector;

public abstract class Button implements IButton, IDisplayable {
	private Image	sprite;
	private Vector	position;

	public Button() {
		// TODO Auto-generated constructor stub
	}

	public Vector getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	public Image getSprite() {
		// TODO Auto-generated method stub
		return this.sprite;
	}

	public boolean isHoverable() {
		return true;
	}

	public boolean isPressable() {
		return true;
	}

	public void setPositon(final Vector position) {

	}

	public void setSprite(final Vector position) {

	}

}
