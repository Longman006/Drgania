package pl.edu.pw.fizyka.pojava.lagrange.layout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import pl.edu.pw.fizyka.pojava.lagrange.model.ModelManager;
import pl.edu.pw.fizyka.pojava.lagrange.sound.waves.Wave;
import pl.edu.pw.fizyka.pojava.lagrange.utilities.WaveSelection;

public class DeleteWavePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ModelManager model;
	private WaveSelection waveSelection;
	private JButton delete;
	
	public DeleteWavePanel(ModelManager model) {
		this.setLayout(new MigLayout());
		this.model = model;
		this.delete = new JButton("Delete");
		waveSelection = new WaveSelection(this.model);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Wave wave = (Wave) waveSelection.getSelectedItem();
				model.deleteWave(wave);
				waveSelection.updateBox();
				
			}
		});
		
		this.add(new JLabel("Select wave to delete: "),"wrap");
		this.add(waveSelection,"wrap,grow");
		this.add(delete, "growx,growy");
		
	}


}
