package vector;

public class Vector {
	private Float	x;
	private Float	y;

	public Vector() {
		this.setX(0);
		this.setY(0);
	}

	public Vector(final Float x, final Float y) {
		this.setX(x);
		this.setY(y);
	}

	public Vector(final int x, final int y) {
		this.setX((float) x);
		this.setY((float) y);
	}

	public void add(final Float x, final Float y) {
		this.set(this.getX() + x, this.getY() + y);
	}

	public void add(final int x, final int y) {
		this.set(this.getX() + x, this.getY() + y);
	}

	public void add(final Vector v) {
		this.set(this.getX() + v.getX(), this.getY() + v.getY());
	}

	public float avoidDivideByZero(final Float k) {
		if (k != 0) {
			return k;
		} else {
			return 1;
		}
	}

	public void div(final Float k) {
		this.set(this.getX() / this.avoidDivideByZero(k), this.getY() / this.avoidDivideByZero(k));
	}

	public void div(final int k) {
		this.set(this.getX() / this.avoidDivideByZero((float) k), this.getY() / this.avoidDivideByZero((float) k));
	}

	public Float getX() {
		return this.x;
	}

	public Float getY() {
		return this.y;
	}

	public void mult(final Float k) {
		this.set(this.getX() * k, this.getY() * k);
	}

	public void mult(final int k) {
		this.set(this.getX() * k, this.getY() * k);
	}

	public void set(final Float x, final Float y) {
		this.setX(x);
		this.setY(y);
	}

	public void set(final int x, final int y) {
		this.setX(x);
		this.setY(y);
	}

	private void setX(final Float x) {
		this.x = x;
	}

	private void setX(final int x) {
		this.x = (float) x;
	}

	private void setY(final Float y) {
		this.y = y;
	}

	private void setY(final int y) {
		this.y = (float) y;
	}

	public void sub(final Float x, final Float y) {
		this.set(this.getX() - x, this.getY() - y);
	}

	public void sub(final int x, final int y) {
		this.set(this.getX() - x, this.getY() - y);
	}

	public void sub(final Vector v) {
		this.set(this.getX() - v.getX(), this.getY() - v.getY());
	}

}
