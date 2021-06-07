package guiForms;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import java.awt.AWTKeyStroke;

import customGui.ButtonTabComponent;
import customGui.DocumentViewer;

import javax.swing.border.EmptyBorder;

public class OneCandyMain {
	/*
	 * Component Declaration
	 */
	private JFrame frame;
	final JMenuBar menuBar = new JMenuBar();
	final JMenu mnuFiles = new JMenu("File");
	final JMenuItem mnuItemNewTask = new JMenuItem("New Task");
	final JMenu mnuEdit = new JMenu("Edit");
	final JMenu mnuView = new JMenu("View");
	final JMenuItem mnuItemNavigator = new JMenuItem("Navigator");
	final JMenuItem mnuItemServices = new JMenuItem("Services");
	final JToolBar mainToolBar = new JToolBar();
	final JToolBar bottomToolBar = new JToolBar();
	final static JPanel fieldsPanel = new JPanel();
	final static JPanel documentTypePanel = new JPanel();
	final static JTabbedPane leftPanel = new JTabbedPane();
	final static JLayeredPane rightPanel = new JLayeredPane();
	final static JSplitPane centerPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, fieldsPanel, documentTypePanel);
	final static JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, centerPanel);
	public final static JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane, rightPanel);
	private final JPanel navigator = new JPanel();
	private final JPanel services = new JPanel();
	private final JButton btnDeleteTask = new JButton("");
	JPanel pdfViewerPanel = new JPanel();
	private final JButton btnSaveTask = new JButton("");
	JTabbedPane imageViewerPanel = new JTabbedPane(JTabbedPane.TOP);

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
	public OneCandyMain() throws Exception {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
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
		mnuFiles.setToolTipText("File");
		menuBar.add(mnuFiles);
		mnuItemNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmTaskCreator frmTaskCreator = new FrmTaskCreator();
				frmTaskCreator.setVisible(true);
			}
		});
		mnuFiles.add(mnuItemNewTask);
		menuBar.add(mnuEdit);
		menuBar.add(mnuView);

		leftPanel.setVisible(false);
		mnuItemNavigator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leftPanel.addTab("Navigator", navigator);
				leftPanel.setTabComponentAt(leftPanel.getTabCount() - 1, new ButtonTabComponent(leftPanel));
				leftPanel.setVisible(true);
				splitPane.setDividerLocation(300);
				splitPane2.setDividerLocation(800);
			}
		});

		mnuView.add(mnuItemNavigator);
		mnuItemServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leftPanel.addTab("Services", services);
				leftPanel.setTabComponentAt(leftPanel.getTabCount() - 1, new ButtonTabComponent(leftPanel));
				leftPanel.setVisible(true);
				splitPane.setDividerLocation(300);
				splitPane2.setDividerLocation(800);
			}
		});
		mnuView.add(mnuItemServices);
		frame.getContentPane().add(mainToolBar, BorderLayout.NORTH);
		btnSaveTask.setIcon(new ImageIcon("D:\\EclipseWorkSpace\\OneCandy-alpha\\icons\\icons8_save_24px_1.png"));
		btnSaveTask.setAlignmentX(Component.CENTER_ALIGNMENT);

		mainToolBar.add(btnSaveTask);
		btnDeleteTask.setIcon(new ImageIcon("D:\\EclipseWorkSpace\\OneCandy-alpha\\icons\\icons8_multiply_24px.png"));
		btnDeleteTask.setActionCommand("");

		mainToolBar.add(btnDeleteTask);
		frame.getContentPane().add(bottomToolBar, BorderLayout.SOUTH);
		
		splitPane.setDividerLocation(300);
		splitPane2.setDividerLocation(500);
		centerPanel.setDividerLocation(300);
		centerPanel.setMinimumSize(new Dimension(400, 500));
		rightPanel.setMinimumSize(new Dimension(600, 500));
		rightPanel.setLayout(new BorderLayout(0, 0));
		rightPanel.add(imageViewerPanel, BorderLayout.NORTH);
		pdfViewerPanel = DocumentViewer.documentViewer("");
		rightPanel.add(pdfViewerPanel);
		frame.getContentPane().add(splitPane2, BorderLayout.CENTER);

	}

	/*
	 * Enter file
	 */
	public void setDocumentToPanel(File file) {
		try {
			if (file.getAbsolutePath().endsWith("pdf")) {
				System.out.print(file.getAbsolutePath());
				pdfViewerPanel = DocumentViewer.documentViewer(file.getAbsolutePath());
				pdfViewerPanel.setVisible(true);
				imageViewerPanel.setVisible(false);
			}else {
				imageViewerPanel.setVisible(true);
				pdfViewerPanel.setVisible(false);
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
