package pl.edu.pw.fizyka.pojava.lagrange.layout;

import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.DefaultXYDataset;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class ChartsPanel extends Panel {

	
	/**
	 * 
	 */
	private ModelManager model;
	private int numOfSideCharts=2;
	private ArrayList<JComboBox<String>> waveDisplaySelection;
	
	private ChartPanel mainChart = new ChartPanel(ChartFactory.createXYLineChart(
			"main chart",
			"xAxis",
			"yAxis",
			new DefaultXYDataset()));
	private ChartPanel sideChart1 = new ChartPanel(ChartFactory.createXYLineChart(
			"side chart 1",
			"xAxis",
			"yAxis",
			new DefaultXYDataset()));
	
	private ChartPanel sideChart2 = new ChartPanel(ChartFactory.createXYLineChart(
			"side chart 2",
			"xAxis",
			"yAxis",
			new DefaultXYDataset()));
	
	private static final long serialVersionUID = 1L;

	public ChartsPanel(ModelManager model) {
		
		this.model = model;
		waveDisplaySelection = new ArrayList<JComboBox<String>>();
		
		for(int ii = 0; ii < numOfSideCharts; ii++){
			waveDisplaySelection.add(new JComboBox<String>());
		}
	 		
		this.setLayout(new MigLayout());
		
		this.add(mainChart, "wrap, center , growx");
		
		this.add(sideChart1, "wrap, center , growx");
		this.add(new JLabel("Select wave : "),"left,split 2");
		this.add(waveDisplaySelection.get(0),"wrap , left ");
		
		this.add(sideChart2, "wrap, center , growx");
		this.add(new JLabel("Select wave : "),"left,split 2");
		this.add(waveDisplaySelection.get(1),"wrap , left ");

	}
	public void DisplayChartOptions(){
		
		Wave[] waves = model.getCurrentWaveArray();
		
		for(int ii = 0; ii < this.waveDisplaySelection.size(); ii++){
			waveDisplaySelection.get(ii).addItem(waves[ii].toString()+ii);
		}
	}

}
