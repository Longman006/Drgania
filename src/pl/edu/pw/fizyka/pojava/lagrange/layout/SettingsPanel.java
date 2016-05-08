package pl.edu.pw.fizyka.pojava.lagrange.layout;

import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class SettingsPanel extends Panel {

	JComboBox<String> waveSelection;
	JSlider amplitude;
	JTextField userFrequency;
	JButton addWaveButton;
	ModelManager model;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SettingsPanel(ModelManager model) {
		
		this.model = model;
		
		int n = WaveTypes.values().length;
		String[] waveTypes = new String[n];
		for(int i = 0 ; i < n ; i++){
			waveTypes[i] = WaveTypes.values()[i].toString();
		}
		
		waveSelection = new JComboBox<String>(waveTypes);
		amplitude = new JSlider();
		userFrequency = new JTextField("Frequency (Hz)");
		addWaveButton = new JButton("Add Wave");
		
		this.setLayout(new MigLayout());
		this.add(new JLabel("Select wave function : "),"wrap,left");
		this.add(waveSelection,"wrap,left,growx");
		this.add(new JLabel("Amplitude"),"wrap,center");
		this.add(amplitude,"wrap,left");
		this.add(new JLabel("Frequency : "),"wrap,left");
		this.add(userFrequency,"growx,wrap");
		this.add(addWaveButton,"left,grow,wrap");
		
		//this.setBackground(Color.RED);
	}

}
