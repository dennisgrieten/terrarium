package be.vdab.terrarium.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import be.vdab.terrarium.controller.Controller;

public class TerrariumFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Controller controller = new Controller();

	private TerrariumPanel linksPanel, rechtsPanel;

	private final class VolgendeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.dagInit();
			linksPanel.update();
			controller.dagActies();
			rechtsPanel.update();
		}

	}

	private final class SluitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(DISPOSE_ON_CLOSE); // TODO
		}

	}

	public TerrariumFrame() {
		super("Terrarium");
		setLayout(new GridLayout(2, 2));
		linksPanel = new TerrariumPanel();
		add(linksPanel);
		controller.dagActies();
		rechtsPanel = new TerrariumPanel();
		add(rechtsPanel);
		JButton volgendeButton = new JButton("volgende");
		JButton sluitButton = new JButton("sluit");
		add(volgendeButton);
		add(sluitButton);
		volgendeButton.addActionListener(new VolgendeButtonListener());
		sluitButton.addActionListener(new SluitButtonListener());
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
