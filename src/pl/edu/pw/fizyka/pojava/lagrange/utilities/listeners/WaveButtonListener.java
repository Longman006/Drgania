package pl.edu.pw.fizyka.pojava.lagrange.utilities.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;

import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class WaveButtonListener implements ActionListener {

	JComboBox<String> waveSelection;
	JSlider waveAmplitude;
	JTextField waveFrequency;
	ModelManager model;
 	
	public WaveButtonListener(
			JComboBox<String> waveSelection,
			JSlider waveAmplitude,
			JTextField waveFrequency,
			ModelManager model) {
		
		this.waveSelection = waveSelection;
		this.waveAmplitude = waveAmplitude;
		this.waveFrequency = waveFrequency;
		this.model = model;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int frequency;
		
		try{
			frequency = Integer.parseUnsignedInt(waveFrequency.getText());
			System.out.println("JTextField : an unsigned integer");
		}
		catch(NumberFormatException e){
			System.out.println("JTextField : not a valid integer");
			return;
		}
		
		WaveParameters waveParams = new WaveParameters(
				frequency,
				waveAmplitude.getValue()
				);
		
		
	}
	

}
