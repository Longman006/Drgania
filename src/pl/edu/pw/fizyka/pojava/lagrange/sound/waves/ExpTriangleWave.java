package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class ExpTriangleWave extends Wave {

	public ExpTriangleWave(WaveParameters waveParams) {
		super(waveParams);
		this.waveType = WaveTypes.EXPONENTIAL_TRIANGLE;
	}

	@Override
	public double calculateWave(double time) {
		// TODO Auto-generated method stub
		return Math.exp(-Math.abs(2*Math.asin(Math.sin(2 * Math.PI * this.waveParams.getFrequency() * time))/Math.PI));
	}

}
