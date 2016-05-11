package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class SawtoothWave extends Wave {

	public SawtoothWave(WaveParameters waveParams) {
		super(waveParams);
		this.waveType = WaveTypes.SAWTOOTH;
	}

	@Override
	public double calculateWave(double time) {
		
		return 2*Math.asin(Math.sin(2 * Math.PI * this.waveParams.getFrequency() * time))/Math.PI;
	}

}
