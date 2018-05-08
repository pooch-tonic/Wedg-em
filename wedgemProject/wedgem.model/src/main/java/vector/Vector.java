package vector;

public class Vector {
	private float	x;
	private float	y;

	public Vector() {
		this.setX(0);
		this.setY(0);
	}

	public Vector(final float x, final float y) {
		this.setX(x);
		this.setY(y);
	}

	public Vector(final int x, final int y) {
		this.setX((float) x);
		this.setY((float) y);
	}

	public void add(final float x, final float y) {
		this.set(this.getX() + x, this.getY() + y);
	}

	public void add(final int x, final int y) {
		this.set(this.getX() + x, this.getY() + y);
	}

	public void add(final Vector v) {
		this.set(this.getX() + v.getX(), this.getY() + v.getY());
	}

	public float avoidDivideByZero(final float k) {
		if (k != 0) {
			return k;
		} else {
			return 1;
		}
	}

	public void div(final float k) {
		this.set(this.getX() / this.avoidDivideByZero(k), this.getY() / this.avoidDivideByZero(k));
	}

	public void div(final int k) {
		this.set(this.getX() / this.avoidDivideByZero(k), this.getY() / this.avoidDivideByZero(k));
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	public void mult(final float k) {
		this.set(this.getX() * k, this.getY() * k);
	}

	public void mult(final int k) {
		this.set(this.getX() * k, this.getY() * k);
	}

	public void set(final float x, final float y) {
		this.setX(x);
		this.setY(y);
	}

	public void set(final int x, final int y) {
		this.setX(x);
		this.setY(y);
	}

	private void setX(final float x) {
		this.x = x;
	}

	private void setX(final int x) {
		this.x = x;
	}

	private void setY(final float y) {
		this.y = y;
	}

	private void setY(final int y) {
		this.y = y;
	}

	public void sub(final float x, final float y) {
		this.set(this.getX() - x, this.getY() - y);
	}

	public void sub(final int x, final int y) {
		this.set(this.getX() - x, this.getY() - y);
	}

	public void sub(final Vector v) {
		this.set(this.getX() - v.getX(), this.getY() - v.getY());
	}

}
