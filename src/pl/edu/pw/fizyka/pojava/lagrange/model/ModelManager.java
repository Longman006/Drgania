package pl.edu.pw.fizyka.pojava.lagrange.model;
import java.util.ArrayList;


import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.WaveParameters;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveTypes;
public class ModelManager {
	
	private ArrayList<Wave> waves;
	private double scale = 0;
	
	public ModelManager() {
		
		this.waves = new ArrayList<Wave>();
		
	}
	
	public void reset(){
		
		waves = new ArrayList<Wave>();
		
	}
	

	public void addWave(WaveParameters waveParams,WaveTypes waveType){
	
		System.out.println("Adding wave  : "+waveType.toString());
		this.waves.add(waveType.getWave(waveParams));
		double scaleTmp= 0;
		for(Wave wave : this.waves){
			
			scaleTmp += wave.getAmplitude();
		}
		this.scale = 1/scaleTmp;
		System.out.println("Scale : "+scale);
		
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
	
	

}
