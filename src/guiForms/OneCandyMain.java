package guiForms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	final JToolBar quickAccessToolBar = new JToolBar();
	final JToolBar bottomToolBar = new JToolBar();
	final JPanel fieldsPanel=new JPanel();
	final JPanel documentTypePanel=new JPanel();
	final JPanel leftPanel=new JPanel();
	final JLayeredPane rightPanel=new JLayeredPane();
	final SwingController controller = new SwingController();
	final SwingViewBuilder factory = new SwingViewBuilder(controller);
	final JPanel viewComponentPanel = factory.buildViewerPanel();
	final JSplitPane centerPanel=new JSplitPane(JSplitPane.VERTICAL_SPLIT,fieldsPanel,documentTypePanel);
	final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,centerPanel);
	final JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitPane,rightPanel);
	
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
		
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);		
		menuBar.add(mnuFiles);		
		mnuFiles.add(mnuItemNewTask);		
		menuBar.add(mnuEdit);		
		menuBar.add(mnuView);		
		leftPanel.setVisible(false);
		mnuItemNavigator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leftPanel.setVisible(true);
				splitPane.setDividerLocation(300);
			}
		});
		mnuView.add(mnuItemNavigator);		
		mnuView.add(mnuItemServices);		
		frame.getContentPane().add(mainToolBar, BorderLayout.NORTH);
		mainToolBar.add(btnNewButton);
		quickAccessToolBar.setFloatable(false);
		quickAccessToolBar.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(quickAccessToolBar, BorderLayout.WEST);
		frame.getContentPane().add(bottomToolBar, BorderLayout.SOUTH);	
		//frame.getContentPane().add(rightPanel,BorderLayout.CENTER);
		splitPane.setDividerLocation(300);
		splitPane2.setDividerLocation(500);
		centerPanel.setDividerLocation(400);

		frame.getContentPane().add(viewComponentPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		rightPanel.add(viewComponentPanel);
		viewComponentPanel.setVisible(true);
		rightPanel.setVisible(true);
		
		controller.getDocumentViewController().setAnnotationCallback(new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));
		controller.openDocument("D://Documents//1616110182.pdf");
		frame.getContentPane().add(viewComponentPanel, BorderLayout.CENTER);
		frame.getContentPane().add(splitPane2, BorderLayout.CENTER);
		
	}
}
