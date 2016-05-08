package pl.edu.pw.fizyka.pojava.lagrange.utilities;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LFChooser extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel chooseLFPanel = new JPanel();
	JFrame frameReference;
	
	public LFChooser(JFrame parrentFrame) {
		
		frameReference = parrentFrame;
        chooseLFPanel.setLayout(new FlowLayout());
        
        final UIManager.LookAndFeelInfo[] installedLF = UIManager.getInstalledLookAndFeels();
        String[] installedLookandFeelsNames = new String[installedLF.length];
        
        for (int i=0;i<installedLF.length;i++) {
            installedLookandFeelsNames[i] = installedLF[i].getName();
          }
        
        final JComboBox<String> chooseLFComboBox = new JComboBox<String>(installedLookandFeelsNames);
        chooseLFComboBox.setSelectedItem(UIManager.getLookAndFeel().getName());
        chooseLFComboBox.addActionListener(new ActionListener() {

			@Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int selectedLFIndex = chooseLFComboBox.getSelectedIndex();
                    UIManager.setLookAndFeel (installedLF[selectedLFIndex].getClassName());
                    SwingUtilities.updateComponentTreeUI(frameReference);
                }catch (Exception e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(frameReference, "fatal error");
                }
            }
        	
        });
        add(chooseLFComboBox);
	}
	
}