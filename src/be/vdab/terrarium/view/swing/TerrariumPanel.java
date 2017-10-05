package be.vdab.terrarium.view.swing;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.vdab.terrarium.controller.Controller;
import be.vdab.terrarium.model.Cel;
import be.vdab.terrarium.model.Terrarium;

public class TerrariumPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int hoogte;
	private int breedte;

	private CelPanel[][] panels;

	public TerrariumPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		Terrarium terrarium = new Controller().getTerrarium();
		hoogte = terrarium.getHoogte();
		breedte = terrarium.getBreedte();
		Cel[][] matrix = terrarium.getMatrix();
		panels = new CelPanel[hoogte][breedte];
		setLayout(new GridLayout(hoogte, breedte));
		for (int y = 0; y < hoogte; y++) {
			for (int x = 0; x < breedte; x++) {
				panels[y][x] = new CelPanel(matrix[y][x]);
				add(panels[y][x]);
			}
		}
		update();
	}

	public void update() {
		for (int y = 0; y < hoogte; y++) {
			for (int x = 0; x < breedte; x++) {
				panels[y][x].update();
			}
		}
		repaint();
	}

}
