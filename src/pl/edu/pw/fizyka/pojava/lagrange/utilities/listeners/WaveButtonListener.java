package pl.edu.pw.fizyka.pojava.lagrange.utilities.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class WaveButtonListener implements ActionListener {

	JComboBox<WaveTypes> waveSelection;
	JSlider waveAmplitude;
	JTextField waveFrequency;
	ModelManager model;
 	
	/**
	 * @param waveSelection
	 * @param waveAmplitude
	 * @param waveFrequency
	 * @param model
	 */
	public WaveButtonListener(
			JComboBox<WaveTypes> waveSelection,
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
		
		WaveTypes waveType = (WaveTypes) waveSelection.getSelectedItem(); 
		
		if(dialogWindow(waveParams,waveType)){;
			model.addWave(waveParams,waveType);
		}
		

		
		
		
		
	}
	private boolean dialogWindow(WaveParameters waveParams, WaveTypes waveType){
		
		String message = "Add +"+waveType.toString()+" wave \n"+
				"Frequency : "+waveParams.getFrequency()+"\n"+
				"Amplitude : "+waveParams.getAmplitude();
		int answer = JOptionPane.showConfirmDialog(
				null,
				message,
				"Confirm Window",
				JOptionPane.YES_NO_OPTION);
				
		if(answer == JOptionPane.YES_OPTION){
			return true;
		}
		
		return false;
	}

}
