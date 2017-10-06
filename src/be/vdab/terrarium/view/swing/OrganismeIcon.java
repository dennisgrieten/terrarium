package be.vdab.terrarium.view.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import be.vdab.terrarium.model.Organisme;

public class OrganismeIcon extends ImageIcon {

	private static final long serialVersionUID = 1L;
	
	private final Organisme organisme;
	
	private static String getPath(Organisme organisme) {
		if (organisme != null) {
			switch(organisme.getClass().getSimpleName()) {
			case "Plant": return "images/50x50/plant.png";
			case "Herbivoor": return "images/50x50/herbivoor.png";
			case "Carnivoor": return "images/50x50/carnivoor.png";
			default: throw new AssertionError();
			}			
		} else {
			return "images/50x50/niets.png";
		}
	}
	
	public OrganismeIcon(Organisme organisme) {
		super(getPath(organisme));
		this.organisme = organisme;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		super.paintIcon(c, g, x, y);
		g.setColor(Color.BLACK);
		if (organisme != null) {
			g.setColor(Color.BLACK);
			g.drawString("" + organisme.getLevenskracht(), 1, 1 + g.getFont().getSize());
		}
	}

}
