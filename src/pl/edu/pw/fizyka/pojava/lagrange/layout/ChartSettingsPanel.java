package pl.edu.pw.fizyka.pojava.lagrange.layout;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.charts.CustomDynamicChart;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;

import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.Units;

public class ChartSettingsPanel extends JPanel {
	
	private CustomDynamicChart chart;
	private JComboBox<Units> unitSelection;
	private JTextField textField;
	private Units unit;
	private int numberOfUnits;
	private JButton startStop;
	private boolean paused = true;
	
	public ChartSettingsPanel(CustomDynamicChart chart) {
		
		this.setLayout(new MigLayout());
		this.chart = chart;
		chart.updateChart();
		this.numberOfUnits = 1;
		this.unit = Units.MILLI;
		this.unitSelection = new JComboBox<Units>(Units.values());
		unitSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				unit = (Units) unitSelection.getSelectedItem();
				chart.setUnit(unit);
				chart.updateChart();
			}
		});
		this.textField = new JTextField("Number of units");
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
				 numberOfUnits = Integer.parseUnsignedInt(textField.getText());
					System.out.println("JTextField : an unsigned integer");
				}
				catch(NumberFormatException e1){
					System.out.println("JTextField : not a valid integer");
					return;
				}
				
				chart.setUnitsPerTick(numberOfUnits);
				chart.updateChart();
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
		this.add(textField);
		this.add(unitSelection);
		this.add(startStop,"wrap");
		
		
		
		
	}
	
}
