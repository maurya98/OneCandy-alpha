package configuration;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import guiForms.OneCandyMain;

public class OneCandy {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//System.out.print(UIManager.getSystemLookAndFeelClassName());
			Font defaultFont = new JLabel().getFont();
			Font defaultTextFieldFond = new JTextField().getFont();
			OneCandyMain.main(args);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Caused due to: " + ex.getCause() + "\n Message: " + ex.getMessage());
		}
	}
}
