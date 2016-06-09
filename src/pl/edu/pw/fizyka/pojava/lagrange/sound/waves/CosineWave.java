package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public class CosineWave extends Wave {

	public CosineWave(WaveParameters waveParams) {
		super(waveParams);
		this.waveType = WaveTypes.COSINE;
		
	}

	@Override
	public double calculateWave(double time) {
		
		return Math.cos(2 * Math.PI * this.waveParams.getFrequency() * time)*
				this.waveParams.getAmplitude();
		
	}

}
