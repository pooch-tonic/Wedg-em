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
	private Image	normalSprite;
	private Image	hoveredSprite;	// hovered state
	private Vector	position;
	private Vector	normalPosition;
	private Vector	hoveredPosition;
	private boolean	isResized;

	public Unit() {
		this.setPlayer(0);
		this.setPosition(null);
		this.setSprite(null);
		this.setHoveredSprite(null);
	}

	public Unit(final int player, final int line, final int column) {
		this.initialize(player, new Vector(column * GameSettings.getSquaresize(), line * GameSettings.getSquaresize()));
	}

	public Unit(final int player, final int[] indexes) {
		this.initialize(player,
				new Vector(indexes[1] * GameSettings.getSquaresize(), indexes[0] * GameSettings.getSquaresize()));
	}

	public Unit(final int player, final Vector position) {
		this.initialize(player, position);
	}

	private Vector calculateHoveredPosition() {
		final int difference = (this.getHoveredSprite().getWidth(null) - this.getNormalSprite().getWidth(null)) / 2;
		return (new Vector(this.getNormalPosition().getX() - difference, this.getNormalPosition().getY() - difference));
	}

	public Vector getHoveredPosition() {
		return this.hoveredPosition;
	}

	public Image getHoveredSprite() {
		return this.hoveredSprite;
	}

	public Vector getNormalPosition() {
		return this.normalPosition;
	}

	public Image getNormalSprite() {
		return this.normalSprite;
	}

	public int getPlayer() {
		return this.player;
	}

	public Vector getPosition() {
		return this.position;
	}

	private Image getScaledUnit() {
		return this.getNormalSprite().getScaledInstance(
				Math.round(this.getNormalSprite().getWidth(null) * GameSettings.getHoveringresizescale()),
				Math.round(this.getNormalSprite().getHeight(null) * GameSettings.getHoveringresizescale()),
				Image.SCALE_SMOOTH);
	}

	public Image getSprite() {
		// TODO Auto-generated method stub
		return this.sprite;
	}

	public void initialize(final int player, final Vector position) {
		this.setPlayer(player);
		this.setNormalSprite(SpriteProvider.getSpriteByPlayer(player));
		this.setHoveredSprite(this.getScaledUnit());
		this.setNormalPosition(position);
		this.setHoveredPosition(this.calculateHoveredPosition());
		this.setSprite(this.getNormalSprite());
		this.setPosition(this.getNormalPosition());
	}

	public boolean isHoverable() {
		return true;
	}

	public boolean isPressable() {
		return true;
	}

	public boolean isResized() {
		return this.isResized;
	}

	public void resetSprite() {
		if (this.isResized()) {
			this.setResized(false);
			this.setSprite(this.getNormalSprite());
			this.setPosition(this.getNormalPosition());
		}
	}

	private void setHoveredPosition(final Vector hoveredPosition) {
		this.hoveredPosition = hoveredPosition;
	}

	private void setHoveredSprite(final Image hoveredSprite) {
		this.hoveredSprite = hoveredSprite;
	}

	private void setNormalPosition(final Vector normalPosition) {
		this.normalPosition = normalPosition;
	}

	private void setNormalSprite(final Image normalSprite) {
		this.normalSprite = normalSprite;
	}

	public void setPlayer(final int player) {
		this.player = player;
	}

	public void setPosition(final Vector position) {
		this.position = position;
	}

	private void setResized(final boolean isResized) {
		this.isResized = isResized;
	}

	public void setSprite(final Image sprite) {
		this.sprite = sprite;
	}

	public void updatePosition(final int[] indexes) {
		this.setPosition(
				new Vector(indexes[1] * GameSettings.getSquaresize(), indexes[0] * GameSettings.getSquaresize()));
		this.setNormalPosition(this.getPosition());
		this.setHoveredPosition(this.calculateHoveredPosition());
	}

	public void useHoveredSprite() {
		if (!this.isResized()) {
			this.setResized(true);
			this.setSprite(this.getHoveredSprite());
			this.setPosition(this.getHoveredPosition());
		}
	}

}
