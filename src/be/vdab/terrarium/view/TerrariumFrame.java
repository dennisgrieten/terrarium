package be.vdab.terrarium.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		
		controller.initStartOrganismen();
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
		volgendeButton.setPreferredSize(new Dimension(250,80));
		sluitButton.addActionListener(new SluitButtonListener());
		volgendeButton.setPreferredSize(new Dimension(250,80));
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
