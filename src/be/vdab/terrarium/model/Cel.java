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
		this.organisme = organisme;
		this.organisme.setCel(this); // megeven van pointer naar deze cel
		Terrarium.INSTANCE.getLegeCellen().remove(this);
	}

	public void unSetOrganisme() {
		this.organisme = null;
		Terrarium.INSTANCE.getLegeCellen().add(this);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Cel) {
			Cel other = (Cel) obj;
			return y == other.y && x == other.x && Objects.equals(organisme, other.organisme);
		} else {
			return false;
		}
	}

	public boolean isLeeg() {
		return organisme == null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, organisme);
	}

	@Override
	public String toString() {
		return "Cel [y=" + y + ", x=" + x + ", organisme=" + organisme + ", getOrganisme()=" + getOrganisme()
				+ ", getY()=" + getY() + ", getX()=" + getX() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

}
