package be.vdab.terrarium.model;

public class TerrariumPrint {

	public static void main(String[] args) {
		Terrarium.INSTANCE.initStartOrganismen();
		System.out.println(Terrarium.INSTANCE);
	}

}
