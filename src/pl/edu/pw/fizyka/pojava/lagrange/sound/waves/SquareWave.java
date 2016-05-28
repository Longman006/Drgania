package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;

public class SquareWave extends Wave {
	
	
	public SquareWave(WaveParameters waveParams) {
		super(waveParams);
		this.waveType = WaveTypes.SQUARE;
	}

	@Override
	public double calculateWave(double time) {

		return this.waveParams.getAmplitude()*
				Math.signum(Math.sin(2 * Math.PI * this.waveParams.getFrequency() * time));
		
	}	
}
