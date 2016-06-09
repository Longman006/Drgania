package pl.edu.pw.fizyka.pojava.lagrange.utilities;



import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;

public class WaveSelection extends JComboBox<Wave> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ModelManager model;
	private DefaultComboBoxModel<Wave> boxModel;

	
	public WaveSelection(ModelManager model){
		this.model = model;
		
		this.boxModel = new DefaultComboBoxModel<Wave>();
		this.setModel(boxModel);
		this.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				System.out.println("PopupBecameVisible");
				updateBox();
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void updateBox() {
		boxModel.removeAllElements();
		for(Wave wave : model.getWavesArray()){
			boxModel.addElement(wave);
		}
		
	}

}