package be.vdab.terrarium.view;

import be.vdab.terrarium.be.vdab.be.terrarium.controller.Controller;
import be.vdab.terrarium.model.Terrarium;

import javax.naming.ldap.Control;

public class Console {

	public static void main(String[] args) {
		Controller controller = new Controller();

		System.out.println(controller.getTerrarium().toString());
	}

}
