package pl.edu.pw.fizyka.pojava.lagrange.layout;


import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.charts.DynamicChart;
import pl.edu.pw.fizyka.pojava.lagrange.charts.PeriodChart;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.SineWave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;

public class ChartsPanel extends JPanel {

	

	private ModelManager model;

	
	private static final long serialVersionUID = 1L;

	
	/**
	 * @param model
	 */
	public ChartsPanel(ModelManager model) {
		
		this.model = model;
		
		this.setLayout(new MigLayout());
		this.add(new PeriodChart(model),"wrap,center,growx");
		this.add(new DynamicChart(new SineWave(new WaveParameters(
				1, // frequency 
				1   // Amplitude
			))),"wrap");
		
	}


}
