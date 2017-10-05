package be.vdab.terrarium.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import be.vdab.terrarium.model.Cel;
import be.vdab.terrarium.model.Organisme;

public class CelPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final ImageIcon nietsIcon = new ImageIcon("images/niets.png");
	private static final ImageIcon plantIcon = new ImageIcon("images/plant.png");
	private static final ImageIcon herbivoorIcon = new ImageIcon("images/herbivoor.png");
	private static final ImageIcon carnivoorIcon = new ImageIcon("images/carnivoor.png");

	private final JLabel upLabel = new JLabel();
	private final JLabel midLabel = new JLabel();
	private final JLabel downLabel = new JLabel();

	private final Cel cel;

	public CelPanel(Cel cel) {
		this.cel = cel;
		setBorder(LineBorder.createBlackLineBorder());
		setLayout(new GridLayout(3, 1));
		add(upLabel);
		add(midLabel);
		add(downLabel);
		update();
	}

	public void update() {
		Organisme organisme = cel.getOrganisme();
		if (organisme != null) {
			upLabel.setText("" + organisme.getLevenskracht());
			switch (organisme.getClass().getSimpleName()) {
			case "Plant":
				midLabel.setIcon(plantIcon);
				break;
			case "Herbivoor":
				midLabel.setIcon(herbivoorIcon);
				break;
			case "Carnivoor":
				midLabel.setIcon(carnivoorIcon);
				break;
			default:
				break;
			}
			downLabel.setText("" + organisme.getId());
		} else {
			upLabel.setText("*****");
			midLabel.setIcon(nietsIcon);
			downLabel.setText("*****");
		}
		repaint();
	}

}
