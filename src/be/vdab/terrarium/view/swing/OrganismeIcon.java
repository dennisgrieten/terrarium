package be.vdab.terrarium.view.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import be.vdab.terrarium.model.Organisme;

public class OrganismeIcon extends ImageIcon {

	private static final long serialVersionUID = 1L;

	private Organisme organisme;
	private int levenskracht;
	private int id;

	private static String getPath(Organisme organisme) {
		if (organisme != null) {
			switch (organisme.getClass().getSimpleName()) {
			case "Plant":
				return "images/50x50/plant.png";
			case "Herbivoor":
				return "images/50x50/herbivoor.png";
			case "Carnivoor":
				return "images/50x50/carnivoor.png";
			case "Omnivoor":
				return "images/50x50/omnivoor.png";
			default:
				throw new AssertionError();
			}
		} else {
			return "images/50x50/niets.png";
		}
	}

	public OrganismeIcon(Organisme organisme) {
		super(getPath(organisme));
		this.organisme = organisme;
		if (organisme != null) {
			this.id = organisme.getId();
			this.levenskracht = organisme.getLevenskracht();
		}
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		super.paintIcon(c, g, x, y);
		g.setColor(Color.BLACK);
		if (organisme != null) {
			g.setColor(Color.BLACK);
			int fontSize = g.getFont().getSize();
			g.drawString("" + levenskracht, 1, 1 + fontSize);
			g.drawString("id=" + id, 1, this.getIconHeight()-1);
		}
	}

}
