package pl.edu.pw.fizyka.pojava.lagrange.layout;


import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;

public class ControlsPanel extends Panel {

	JTextField userFileName;
	JTextField duration;
	JButton saveFile;
	JButton reset;
	ModelManager model;
	
	/**
	 * One column three rows 
	 */
	
	private static final long serialVersionUID = 1L;

	public ControlsPanel(ModelManager model) {

		this.model = model;

		duration = new JTextField("Recording duration (s)");
		userFileName = new JTextField("FileName");
		saveFile = new JButton("Save ");
		reset = new JButton("Reset");
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.reset();
				
			}
		});
		
		saveFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = "";
				int recordingDuration = 0;
				try{
					name = userFileName.getText();
				}
				catch(Exception e1){
					System.out.println("Not a valid File name:"+e1);
					return;
				}
				try{
					recordingDuration =  Integer.parseUnsignedInt(duration.getText());
				}
				catch(Exception e2){
					System.out.println("Not a valid integer : "+e2);
					return;
				}
				model.setDuration(recordingDuration);
				model.writeToFile(name);
				
			}
		});
		
		this.setLayout(new MigLayout());
		
		this.add(new JLabel("File name : "),"left,wrap");
		this.add(userFileName," grow,wrap");
		this.add(new JLabel("File duration (s) :"),"left,wrap");
		this.add(duration,"grow,wrap");
		this.add(saveFile,"left,wrap");
		this.add(reset,"grow,center");
		
		
		
		//this.setBackground(Color.BLUE);
	}
	
}
