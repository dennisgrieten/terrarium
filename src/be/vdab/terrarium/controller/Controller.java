package be.vdab.terrarium.controller;

import be.vdab.terrarium.model.Terrarium;

public class Controller {
    public void doeVolgendeIteratie() {

    }

    public Terrarium getTerrarium() {
        Terrarium.INSTANCE.initStartOrganismen();
        return Terrarium.INSTANCE;
    }
}
