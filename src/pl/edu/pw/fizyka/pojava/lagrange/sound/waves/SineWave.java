package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public class SineWave extends Wave {

	public SineWave(WaveParameters waveParams) {
		super(waveParams);
		this.waveType = WaveTypes.SINE;
	}

	@Override
	public double calculateWave(double time) {
		
		Double displacement = this.waveParams.getAmplitude()*
				Math.sin(2 * Math.PI * this.waveParams.getFrequency() * time);
		return displacement;
		
	}

}
