package configuration;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import guiForms.OneCandyMain;

public class OneCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			System.out.print(UIManager.getSystemLookAndFeelClassName());
			OneCandyMain.main(args);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Caused due to: " + ex.getCause() + "\n Message: " + ex.getMessage());
		}

	}

}
