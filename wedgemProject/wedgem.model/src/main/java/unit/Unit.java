package unit;

import java.awt.Image;

import gameSettings.GameSettings;
import image.SpriteProvider;
import interfacesModel.IButton;
import interfacesModel.IDisplayable;
import interfacesModel.IUnit;
import vector.Vector;

public class Unit implements IUnit, IButton, IDisplayable {
	private int		player;
	private Image	sprite;			// normal state
	private Image	hoveredSprite;	// hovered state
	private Vector	position;
	private Vector	hoveredPosition;

	public Unit() {
		this.setPlayer(0);
		this.setPosition(null);
		this.setSprite(null);
		this.setHoveredSprite(null);
	}

	public Unit(final int player, final int x, final int y) {
		this.setPlayer(player);
		this.setSprite(SpriteProvider.getSpriteByPlayer(player));
		this.setHoveredSprite(this.getSprite().getScaledInstance(
				Math.round(this.getSprite().getWidth(null) * GameSettings.getHoveringresizescale()),
				Math.round(this.getSprite().getHeight(null) * GameSettings.getHoveringresizescale()),
				Image.SCALE_SMOOTH));
		this.setPosition(new Vector(x, y));
		this.setHoveredPosition(this.calculateHoveredPosition());
	}

	public Unit(final int player, final Vector position) {
		this.setPlayer(player);
		this.setPosition(position);
	}

	private Vector calculateHoveredPosition() {
		final int difference = this.getHoveredSprite().getWidth(null) - this.getHoveredSprite().getHeight(null);
		return (new Vector(this.getPosition().getX() - difference, this.getPosition().getY() - difference));
	}

	public Vector getHoveredPosition() {
		return this.hoveredPosition;
	}

	public Image getHoveredSprite() {
		return this.hoveredSprite;
	}

	public int getPlayer() {
		return this.player;
	}

	public Vector getPosition() {
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

	private void setHoveredPosition(final Vector hoveredPosition) {
		this.hoveredPosition = hoveredPosition;
	}

	public void setHoveredSprite() {
		this.setSprite(this.getHoveredSprite());
	}

	private void setHoveredSprite(final Image hoveredSprite) {
		this.hoveredSprite = hoveredSprite;
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

}
