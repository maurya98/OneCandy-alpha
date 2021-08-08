package customGui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ImageViewer extends JPanel {

	/**
	 * Create the panel.
	 */
	public ImageViewer() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		splitPane.setRightComponent(textArea);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 399, 15);
		panel.add(toolBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 553, 399, 73);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		splitPane.setDividerLocation(400);

	}
}
