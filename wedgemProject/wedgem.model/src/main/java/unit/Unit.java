package unit;

import java.awt.Image;

import interfacesModel.IButton;
import interfacesModel.IDisplayable;
import interfacesModel.IUnit;
import vector.Vector;

public class Unit implements IUnit, IButton, IDisplayable {
	private int		player;
	private Image	sprite;
	private Vector	position;

	public Unit() {
		this.setPlayer(0);
		this.setPosition(null);
		this.setSprite(null);
	}

	public Unit(final int player, final int x, final int y) {
		this.setPlayer(player);
		this.setSprite(null);
		this.setPosition(new Vector(x, y));
		this.setSpriteByPlayer(player);
	}

	public Unit(final int player, final Vector position) {
		this.setPlayer(player);
		this.setPosition(position);
	}

	public int getPlayer() {
		return this.player;
	}

	public Vector getPosition() {
		return this.position;
	}

	public Image getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	public void ifHovered() {
		// TODO Auto-generated method stub

	}

	public void ifPressed() {
		// TODO Auto-generated method stub

	}

	public void loadImage(final String imageName) {
		// TODO Auto-generated method stub

	}

	public void setPlayer(final int player) {
		this.player = player;
	}

	public void setPosition(final Vector position) {
		this.position = position;
	}

	public void setSprite(final Image sprite) {
		this.sprite = sprite;
	}

	public void wedge() {
		// TODO Auto-generated method stub

	}

}
