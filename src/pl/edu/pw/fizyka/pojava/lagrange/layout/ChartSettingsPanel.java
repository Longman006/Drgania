package pl.edu.pw.fizyka.pojava.lagrange.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.charts.CustomDynamicChart;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.Units;

public class ChartSettingsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomDynamicChart chart;
	private JComboBox<Units> unitSelection;
	private Units unit;
	private int numberOfUnits;
	private JButton startStop;
	private JSlider timeDivSelection;
	private JLabel timeDivDisplay;
	private JPanel timeDivSelectionPanel;
	private boolean paused = true;
	
	public ChartSettingsPanel(CustomDynamicChart chart) {
		

		timeDivSelectionPanel = new JPanel(new MigLayout());
		this.timeDivSelection = new JSlider(0, 100, 50);
		this.timeDivDisplay = new JLabel(String.format("%d",timeDivSelection.getValue()));
		timeDivSelectionPanel.add(timeDivDisplay,"wrap,center");
		timeDivSelectionPanel.add(timeDivSelection,"wrap");

		this.setLayout(new MigLayout());
		this.chart = chart;
		this.numberOfUnits = 1;
		this.unitSelection = new JComboBox<Units>(Units.values());
		unitSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				unit = (Units) unitSelection.getSelectedItem();
				chart.setUnit(unit);
				chart.updateChart();
			}
		});
		
		timeDivSelection.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				numberOfUnits = timeDivSelection.getValue();
				timeDivDisplay.setText(String.format("%d",timeDivSelection.getValue()));
			
				ChartSettingsPanel.this.chart.setUnitsPerTick(numberOfUnits);
				ChartSettingsPanel.this.chart.updateChart();
			}
		});
		
		this.startStop = new JButton("Start/Stop");
		this.startStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(paused){
					paused = false;
					chart.start();
				}
				else{
					paused = true;
					chart.stop();
				}
				
			}
		});
		
		this.add(new JLabel("Select time/div : "));
		this.add(timeDivSelectionPanel);
		this.add(unitSelection);
		this.add(startStop,"wrap");
		
		this.unit = (Units) unitSelection.getSelectedItem();
		this.numberOfUnits = timeDivSelection.getValue();
		chart.setUnit(unit);	
		chart.setUnitsPerTick(numberOfUnits);
		chart.updateChart();
		
		
	}
	
}
