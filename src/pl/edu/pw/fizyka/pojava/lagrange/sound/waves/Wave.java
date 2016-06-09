package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

public abstract class Wave {
	
	protected WaveParameters waveParams;
	protected WaveTypes waveType;
	
	Wave(WaveParameters waveParams){
		waveType=null;
		this.waveParams=waveParams;
	}
	
	
	/**
	 * @param time 
	 * @return returns the displacement of wave function in given time with values ranging from -1 to 1
	 */
	public abstract double calculateWave(double time);
	
	public double getAmplitude(){
		return this.waveParams.getAmplitude();
	}
	
	
	@Override
	public String toString(){
		return this.waveType.toString()+waveParams.getFrequency();	
	}
	
	public int getFrequency(){
		return waveParams.getFrequency();
	}

	
	
}

