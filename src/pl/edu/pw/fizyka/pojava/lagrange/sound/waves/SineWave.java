package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class SineWave extends Wave {

	public SineWave(WaveParameters waveParams) {
		super(waveParams);
		this.waveType = WaveTypes.SINE;
	}

	@Override
	public double calculateWave(double time) {
		
		return Math.sin(2 * Math.PI * this.waveParams.getFrequency() * time);
		
	}

}
