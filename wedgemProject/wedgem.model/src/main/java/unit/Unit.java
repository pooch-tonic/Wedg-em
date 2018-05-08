package unit;

import vector.Vector;

public class Unit {
	private int		player;
	private Vector	position;

	public Unit() {
		this.setPlayer(0);
		this.setPosition(null);
	}

	public Unit(final int player, final Vector position) {

	}

	public int getPlayer() {
		return this.player;
	}

	public Vector getPosition() {
		return this.position;
	}

	public void setPlayer(final int player) {
		this.player = player;
	}

	public void setPosition(final Vector position) {
		this.position = position;
	}

}
