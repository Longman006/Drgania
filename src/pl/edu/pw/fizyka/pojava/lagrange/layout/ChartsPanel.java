package pl.edu.pw.fizyka.pojava.lagrange.layout;


import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.charts.SingleWaveChart;
import pl.edu.pw.fizyka.pojava.lagrange.charts.SuperPositionChart;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;



public class ChartsPanel extends JPanel {

	

	private ModelManager model;
	private SingleWaveChart singleWaveChart;
	private ChartSettingsPanel chartSettingsPanel;
	private SuperPositionChart superPositionChart;

	
	private static final long serialVersionUID = 1L;

	
	/**
	 * @param model
	 */
	public ChartsPanel(ModelManager model) {
		
		this.model = model;
		this.superPositionChart = new SuperPositionChart(this.model);
		this.singleWaveChart=new SingleWaveChart(model);
		this.chartSettingsPanel = new ChartSettingsPanel(singleWaveChart);
		
		this.setLayout(new MigLayout());
		this.add(singleWaveChart,"wrap");
		this.add(chartSettingsPanel, "growx,wrap");
		this.add(superPositionChart, "wrap");
		this.add(new ChartSettingsPanel(superPositionChart), "growx,wrap");
	}


}
