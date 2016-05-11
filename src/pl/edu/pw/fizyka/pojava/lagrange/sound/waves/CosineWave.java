package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class CosineWave extends Wave {

	public CosineWave(WaveParameters waveParams) {
		super(waveParams);
		this.waveType = WaveTypes.COSINE;
		
	}

	@Override
	public double calculateWave(double time) {
		
		return Math.cos(2 * Math.PI * this.waveParams.getFrequency() * time);
		
	}

}
