package pl.edu.pw.fizyka.pojava.lagrange.sound.waves;

import java.io.File;
import java.io.IOException;

import pl.edu.pw.fizyka.pojava.lagrange.utilities.wavfile.WavFile;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.wavfile.WavFileException;
public abstract class Wave {
	
	private WaveParameters waveParams;
	
	Wave(WaveParameters waveParams){
		
		this.waveParams=waveParams;
	}
	
	
	/**
	 * @param frequency
	 * @param time 
	 * @return returns the displacement of wave function in given time with values ranging from -1 to 1
	 */
	protected abstract double calculateWave(int frequency, double time);
	
	public void generateWavFile(){
		
		WavFile wavFile;
		try {		

			wavFile = WavFile.newWavFile(new File(waveParams.getFileName()),
					1, // number of channels
					waveParams.getNumberOfFrames(), 
					waveParams.getValidBits(),
					waveParams.getSamplingRate());
			
			waveParams.setWavFile(wavFile);
			writeWave();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WavFileException e) {
			e.printStackTrace();
		}
		
		try {
			waveParams.getWavFile().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		return waveParams.getWaveType().toString();	
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
		
		while(frameCounter < waveParams.getNumberOfFrames()){
			
			remaining = waveParams.getWavFile().getFramesRemaining();
			
			if(remaining > BufforSize){
				toWrite = BufforSize;
			}
			else{
				toWrite = (int) remaining;
			}
			
			for(int i = 0; i < toWrite ; i++, frameCounter++){
				buffor[i] = calculateWave(waveParams.getFrequency(), (double) frameCounter/waveParams.getSamplingRate()) ;
			}
			
			try {
				
				waveParams.getWavFile().writeFrames(buffor, toWrite);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WavFileException e) {
				e.printStackTrace();
			}
			
		}
	}
}

