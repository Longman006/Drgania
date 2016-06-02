package pl.edu.pw.fizyka.pojava.lagrange.charts;

import java.awt.event.ActionEvent;

import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;

public class SuperPositionChart extends CustomDynamicChart {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuperPositionChart(ModelManager model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void updateTitle() {
		super.chart.setTitle("SuperPosition");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		long numberOfUnits = super.tickCount*super.unitsPerTick;
		double time = (double) super.unit.getDecimal()*numberOfUnits;
		
		
		super.series.add(tickCount, model.superposition(time));
		tickCount++;
	}

}
