package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;
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
	
	protected int amplitude;

	protected long numberOfFrames; 

	protected int frequency;
	
	protected WaveTypes waveType;

	private String fileName = null;

	protected WavFile wavFile = null;

	private int validBits = 16;
	
	protected int samplingRate=44100;
	
	public int getSamplingRate() {
		return samplingRate;
	}
	
	public int getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(int amplitude) {
		this.amplitude = amplitude;
	}

	public WaveTypes getWaveType() {
		return waveType;
	}

	public void setWaveType(WaveTypes waveType) {
		this.waveType = waveType;
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


	public WaveParameters(int frequency, int amplitude,WaveTypes waveType) {
		
		this.frequency = frequency;
		this.amplitude = amplitude;
		this.waveType = waveType;
		setDuration(10);
		
	}

}
