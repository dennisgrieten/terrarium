package be.vdab.terrarium.controller;

import be.vdab.terrarium.model.Terrarium;

public class Controller {
	Terrarium terra = Terrarium.INSTANCE;

    public Terrarium getTerrarium() {
        return Terrarium.INSTANCE;
    }
    
    public void initStartOrganismen() {
    	Terrarium.INSTANCE.initStartOrganismen();
    }
}
