package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.wavfile.WavFile;

/**
 * @author longman
 * @param samplingRate number of frames per second
 * @param frequency wave frequency	
 * @param duration total duration of recording, used only when writing to WAV file
 * @param validBits number of bits used to write to WAV file, determines the resolution
 * @param numberOfFrames total number of frames in recording, based on duration
 * @param fileName name of WAV file
 */
public class WaveParameters {

	private int duration; 
	
	protected double amplitude;

	protected long numberOfFrames; 

	protected int frequency;
	

	private String fileName = null;

	protected WavFile wavFile = null;

	private int validBits = 16;
	
	protected int samplingRate=44100;
	
	public int getSamplingRate() {
		return samplingRate;
	}
	
	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}
	
	public void setSamplingRate(int samplingRate){
		this.samplingRate=samplingRate;
	}
	public int getDuration() {
		return duration;
	}

	public long getNumberOfFrames() {
		return numberOfFrames;
	}

	public int getFrequency() {
		return frequency;
	}

	public String getFileName() {
		return fileName;
	}
	
	public WavFile getWavFile() {
		return wavFile;
	}
	public void setWavFile(WavFile wavFile){
		this.wavFile=wavFile;
	}

	public int getValidBits() {
		return validBits;
	}
	public void setDuration(int duration){
		
		this.duration = duration;
		this.numberOfFrames = (long) (duration * samplingRate);
	}


	public WaveParameters(int frequency, double amplitude) {
		
		this.frequency = frequency;
		this.amplitude = amplitude;
		setDuration(10);
		
	}

}
