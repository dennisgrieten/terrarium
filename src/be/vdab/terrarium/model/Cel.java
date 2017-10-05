package be.vdab.terrarium.model;

import java.util.Objects;

public class Cel {

	private final int y;
	private final int x;

	private Organisme organisme = null;

	public Cel(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public void setOrganisme(Organisme organisme) {
		Terrarium.INSTANCE.getLegeCellen().remove(this);
		this.organisme = organisme;
		this.organisme.setCel(this); // megeven van pointer naar deze cel
	}

	public void unSetOrganisme() {
		Terrarium.INSTANCE.getLegeCellen().add(this);
		this.organisme = null;
	}

	public Organisme getOrganisme() {
		return organisme;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public boolean isLeeg() {
		return organisme == null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Cel cel = (Cel) o;

		if (y != cel.y)
			return false;
		return x == cel.x;
	}

	@Override
	public int hashCode() {
		int result = y;
		result = 31 * result + x;
		return result;
	}

	@Override
	public String toString() {
		return "Cel [y=" + y + ", x=" + x + ", organisme=" + organisme + ", getOrganisme()=" + getOrganisme()
				+ ", getY()=" + getY() + ", getX()=" + getX() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

}
