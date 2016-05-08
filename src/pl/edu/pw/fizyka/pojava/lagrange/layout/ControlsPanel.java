package pl.edu.pw.fizyka.pojava.lagrange.layout;


import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;

public class ControlsPanel extends Panel {

	JTextField userFileName;
	JButton SaveFile;
	JButton StartStop;
	ModelManager model;
	
	/**
	 * One column three rows 
	 */
	
	private static final long serialVersionUID = 1L;

	public ControlsPanel(ModelManager model) {

		this.model = model;

		userFileName = new JTextField("FileName");
		SaveFile = new JButton("Save ");
		StartStop = new JButton("Start/Stop");
		
		this.setLayout(new MigLayout());
		
		this.add(new JLabel("File name : "),"left,wrap");
		this.add(userFileName," grow,wrap");
		this.add(SaveFile,"left,wrap");
		this.add(StartStop,"grow,center");
		
		
		//this.setBackground(Color.BLUE);
	}
	
}
