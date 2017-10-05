package be.vdab.terrarium.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.vdab.terrarium.controller.Controller;
import be.vdab.terrarium.model.Cel;
import be.vdab.terrarium.model.Organisme;
import be.vdab.terrarium.model.Terrarium;

public class TerrariumPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final ImageIcon nietsIcon = new ImageIcon("images/niets.png");
	private static final ImageIcon plantIcon = new ImageIcon("images/plant.png");
	private static final ImageIcon herbivoorIcon = new ImageIcon("images/herbivoor.png");
	private static final ImageIcon carnivoorIcon = new ImageIcon("images/carnivoor.png");

	private Cel[][] matrix;
	private int hoogte;
	private int breedte;

	private JLabel[][] labels;

	public TerrariumPanel() {
		Terrarium terrarium = new Controller().getTerrarium();
		terrarium.initStartOrganismen();
		matrix = terrarium.getMatrix();
		hoogte = terrarium.getHoogte();
		breedte = terrarium.getBreedte();
		labels = new JLabel[hoogte][breedte];
		setLayout(new GridLayout(hoogte, breedte));
		for (int y = 0; y < hoogte; y++) {
			for (int x = 0; x < breedte; x++) {
				labels[y][x] = new JLabel(nietsIcon);
				add(labels[y][x]);
			}
		}
		update();
	}

	public void update() {
		for (int y = 0; y < hoogte; y++) {
			for (int x = 0; x < breedte; x++) {
				Organisme organisme = matrix[y][x].getOrganisme();
				if (organisme != null) {
					switch (organisme.getClass().getSimpleName()) {
					case "Plant":
						labels[y][x].setIcon(plantIcon);
						break;
					case "Herbivoor":
						labels[y][x].setIcon(herbivoorIcon);
						break;
					case "Carnivoor":
						labels[y][x].setIcon(carnivoorIcon);
						break;
					default:
						break;
					}
				} else {
					labels[y][x].setIcon(nietsIcon);
				}
			}
		}
		repaint();
	}

}
