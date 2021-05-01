package guiForms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import customGui.ButtonTabComponent;

public class OneCandyMain {
	/*
	 * Component Declaration
	 */
	private JFrame frame;
	final JMenuBar menuBar = new JMenuBar();
	final JMenu mnuFiles = new JMenu("Files");
	final JMenuItem mnuItemNewTask = new JMenuItem("New Task");
	final JMenu mnuEdit = new JMenu("Edit");
	final JMenu mnuView = new JMenu("View");
	final JMenuItem mnuItemNavigator = new JMenuItem("Navigator");
	final JMenuItem mnuItemServices = new JMenuItem("Services");
	final JToolBar mainToolBar = new JToolBar();
	final JButton btnNewButton = new JButton("Sample Button");
	final JToolBar bottomToolBar = new JToolBar();
	final JPanel fieldsPanel = new JPanel();
	final JPanel documentTypePanel = new JPanel();
	final JTabbedPane leftPanel = new JTabbedPane();
	final JLayeredPane rightPanel = new JLayeredPane();
	final JSplitPane centerPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, fieldsPanel, documentTypePanel);
	final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, centerPanel);
	final JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane, rightPanel);
	private final JPanel navigator = new JPanel();
	private final JPanel services = new JPanel();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OneCandyMain window = new OneCandyMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public OneCandyMain() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		frame.setBounds(100, 100, 1052, 659);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		menuBar.add(mnuFiles);
		mnuFiles.add(mnuItemNewTask);
		menuBar.add(mnuEdit);
		menuBar.add(mnuView);

		leftPanel.setVisible(false);
		mnuItemNavigator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leftPanel.addTab("Navigator", navigator);
				leftPanel.setTabComponentAt(0, new ButtonTabComponent(leftPanel));
				leftPanel.setVisible(true);
				splitPane.setDividerLocation(300);
				splitPane2.setDividerLocation(700);
			}
		});

		mnuView.add(mnuItemNavigator);
		mnuItemServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leftPanel.addTab("Services", services);
				leftPanel.setTabComponentAt(1, new ButtonTabComponent(leftPanel));
				leftPanel.setVisible(true);
				splitPane.setDividerLocation(300);
				splitPane2.setDividerLocation(700);
			}
		});
		mnuView.add(mnuItemServices);
		frame.getContentPane().add(mainToolBar, BorderLayout.NORTH);
		mainToolBar.add(btnNewButton);
		frame.getContentPane().add(bottomToolBar, BorderLayout.SOUTH);
		splitPane.setDividerLocation(300);
		splitPane2.setDividerLocation(500);
		centerPanel.setDividerLocation(300);
		centerPanel.setMinimumSize(new Dimension(400, 500));
		rightPanel.setMinimumSize(new Dimension(600, 500));
		rightPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		rightPanel.add(panel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		rightPanel.add(tabbedPane, BorderLayout.NORTH);
		frame.getContentPane().add(splitPane2, BorderLayout.CENTER);

	}
}
