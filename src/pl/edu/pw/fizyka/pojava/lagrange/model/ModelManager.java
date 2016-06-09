package pl.edu.pw.fizyka.pojava.lagrange.model;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveTypes;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.Preset;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.wavfile.WavFile;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.wavfile.WavFileException;
/**
 * @author longman
 * @param samplingRate number of frames per second
 * @param duration total duration of recording, used only when writing to WAV file
 * @param validBits number of bits used to write to WAV file, determines the resolution
 * @param numberOfFrames total number of frames in recording, based on duration
 * @param fileName name of WAV file
 */
public class ModelManager {
	
	private ArrayList<Wave> waves;
	private double scale = 0;
	
	private String fileName = null;
	protected WavFile wavFile = null;
	private int validBits = 16;
	protected int samplingRate=44100;
	int duration=0;
	private long numberOfFrames=0;
	
	public void setDuration(int duration){
		
		this.duration = duration;
		this.numberOfFrames = (long) (duration * samplingRate);
	}
	
	public ModelManager() {
		this.waves = new ArrayList<Wave>();

	}
	
	public void reset(){
		waves = new ArrayList<Wave>();
		
	}
	
	public void deleteWave(Wave waveToDelete){
		Boolean deleted = waves.remove(waveToDelete);
		System.out.println("Deleted : "+deleted);
		reScale();
	}
	
	public void deleteWave(int index){
		 waves.remove(index);
		 reScale();
		
	}
	public void loadPreset(Preset preset){
		waves = preset.getPreset();
		System.out.println("Preset loaded :"+preset);
		System.out.println("Current waves :");
		for(Wave wave : waves.toArray(new Wave[waves.size()])){
			System.out.println(wave);
		}
		reScale();
	}
	private void reScale(){
		
		double scaleTmp= 0;
		for(Wave wave : this.waves){
			
			scaleTmp += wave.getAmplitude();
		}
		this.scale = 1/scaleTmp;
		System.out.println("Scale : "+scale);
		
	}

	public void addWave(WaveParameters waveParams,WaveTypes waveType){
	
		System.out.println("Adding wave  : "+waveType.toString());
		this.waves.add(waveType.getWave(waveParams));
		reScale();
	}
	
	public ArrayList<Wave> getWaves(){
		
		return this.waves;
	}
	
	public Wave[] getWavesArray(){
		
		Wave[] array = waves.toArray(new Wave[waves.size()]);
		return array;
	}
	
	public double superposition(double time){
		
		double displacement = 0;
		for(Wave wave : getWavesArray()){
			
			double waveDisplacement = wave.calculateWave(time);
			 displacement = displacement+ waveDisplacement;
			 
		}

		displacement = displacement*scale;
		return displacement;
	}
	private void generateWavFile(){
		
		WavFile wavFile;
		try {		

			wavFile = WavFile.newWavFile(new File(this.fileName),
					1, // number of channels
					this.numberOfFrames, 
					this.validBits,
					this.samplingRate
				);
			
			this.wavFile = wavFile;
			writeWave();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WavFileException e) {
			e.printStackTrace();
		}
		
		try {
			this.wavFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void writeToFile(String name) {
		this.fileName = name;
		generateWavFile();

	}
	/**
	 * Writes wave to Wav file in 100 frame portions
	 * 	 
	 */
	protected void writeWave(){
		
		int BufforSize = 100;
		double[] buffor = new double[BufforSize];
		long frameCounter = 0;
		int toWrite = 0;
		long remaining = 0;
		
		while(frameCounter < numberOfFrames){
			
			remaining = this.wavFile.getFramesRemaining();
			
			if(remaining > BufforSize){
				toWrite = BufforSize;
			}
			else{
				toWrite = (int) remaining;
			}
			
			for(int i = 0; i < toWrite ; i++, frameCounter++){
				buffor[i] = superposition((double) frameCounter/samplingRate) ;
			}
			
			try {
				
				this.wavFile.writeFrames(buffor, toWrite);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WavFileException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	

}
