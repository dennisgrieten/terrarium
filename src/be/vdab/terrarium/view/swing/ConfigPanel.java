package be.vdab.terrarium.view.swing;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.vdab.terrarium.controller.Controller;

public class ConfigPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int hoogte;
	private int breedte;
	private int aantalNieuwePlantenPerDag;
	private int aantalPlantenBijStart;
	private int aantalHerbivorenBijStart;
	private int aantalCarnivorenBijStart;

	public ConfigPanel() {
		Controller controller = new Controller();

		JTextField hoogteField = new JTextField(5);
		JTextField breedteField = new JTextField(5);
		JTextField aantalNieuwePlantenPerDagField = new JTextField(5);
		JTextField aantalPlantenBijStartField = new JTextField(5);
		JTextField aantalHerbivorenBijStartField = new JTextField(5);
		JTextField aantalCarnivorenBijStartField = new JTextField(5);

		JPanel configPanel = new JPanel();
		configPanel.setLayout(new GridLayout(6, 2));
		configPanel.add(new JLabel("hoogte:"));
		configPanel.add(hoogteField);
		configPanel.add(new JLabel("breedte:"));
		configPanel.add(breedteField);
		configPanel.add(new JLabel("aantal nieuwe planten per dag:"));
		configPanel.add(aantalNieuwePlantenPerDagField);
		configPanel.add(new JLabel("aantal planten bij start:"));
		configPanel.add(aantalPlantenBijStartField);
		configPanel.add(new JLabel("aantal herbivoren bij start:"));
		configPanel.add(aantalHerbivorenBijStartField);
		configPanel.add(new JLabel("aantal carnivoren bij start:"));
		configPanel.add(aantalCarnivorenBijStartField);

		boolean verkeerdeInvoer = false;
		do {

			int result = JOptionPane.showConfirmDialog(null, configPanel, "INGAVE FLEXIBELE GEGEVENS TERRARIUM:",
					JOptionPane.DEFAULT_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				hoogte = Integer.parseInt(hoogteField.getText());
				breedte = Integer.parseInt(breedteField.getText());
				aantalNieuwePlantenPerDag = Integer.parseInt(aantalNieuwePlantenPerDagField.getText());
				aantalPlantenBijStart = Integer.parseInt(aantalPlantenBijStartField.getText());
				aantalHerbivorenBijStart = Integer.parseInt(aantalHerbivorenBijStartField.getText());
				aantalCarnivorenBijStart = Integer.parseInt(aantalCarnivorenBijStartField.getText());
			}

			String errorMessage = "";
			if (!controller.isValideHoogte(hoogte)) {
				verkeerdeInvoer = true;
				errorMessage += "De hoogte is fout. Min. 6 en max. 25.\n";
			}
			if (!controller.isValideBreedte(hoogte, breedte)) {
				verkeerdeInvoer = true;
				errorMessage += "De breedte is fout. Min. 6 en max. 25. Bovendien breedta <= hoogte.\n";
			}
			if (!controller.isValideAantalNieuwePlanten(aantalNieuwePlantenPerDag)) {
				verkeerdeInvoer = true;
				errorMessage += "Het aantal nieuwe planten per dag is fout. Min. 1 en max. 5% van aantal cellen.\n";
			}
			
			if (!controller.isValideAantalOrganismen(aantalPlantenBijStart,aantalHerbivorenBijStart,aantalCarnivorenBijStart)) {
				verkeerdeInvoer = true;
				errorMessage += "Er is een fout betreft het aantal organismen bij start is fout.\n Min. 2 en de som van alle organismen mag max. 50% van de cellen zijn.\n";
			}


			if (verkeerdeInvoer) {
				JOptionPane.showMessageDialog(configPanel, errorMessage, "Ingegeven data is foutief. ", JOptionPane.ERROR_MESSAGE);
			}

		} while (verkeerdeInvoer);

	}

	public int getHoogte() {
		return hoogte;
	}

	public int getBreedte() {
		return breedte;
	}

	public int getAantalNieuwePlantenPerDag() {
		return aantalNieuwePlantenPerDag;
	}

	public int getAantalPlantenBijStart() {
		return aantalPlantenBijStart;
	}

	public int getAantalHerbivorenBijStart() {
		return aantalHerbivorenBijStart;
	}

	public int getAantalCarnivorenBijStart() {
		return aantalCarnivorenBijStart;
	}

}
