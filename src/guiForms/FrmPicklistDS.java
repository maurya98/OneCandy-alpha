package guiForms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;

public class FrmPicklistDS extends JDialog {

	private static final long serialVersionUID = -5345389861503962205L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmPicklistDS dialog = new FrmPicklistDS(model);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Component initialization
	 */
	private ArrayList<String> arrlist = new ArrayList<String>();
	private JButton btnAdd = new JButton("Add");
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnExportCsv = new JButton("Export CSV");
	private JButton btnImportCSV = new JButton("Import CSV");
	private JButton btnSave = new JButton("Save & Exit");
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel = new JLabel("Add Value");
	JScrollPane scrollPane = new JScrollPane();
	private static DefaultListModel<String> model = new DefaultListModel<>();
	private JLabel msg = new JLabel("");
	private JTextField txtValue;
	JList<String> valueList = new JList<String>(model);

	/**
	 * Create the dialog.
	 */
	public FrmPicklistDS(DefaultListModel listModel) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				btnCancel.doClick();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (!listModel.isEmpty()) {
					model = listModel;
					for (int i = 0; i < listModel.getSize(); i++) {
						arrlist.add(listModel.get(i).toString());
					}
				}
			}
		});

		setTitle("Add Pick List");
		setFont(new Font("Segoe UI", Font.PLAIN, 12));

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 13, 75, 25);
		contentPanel.add(lblNewLabel);

		txtValue = new JTextField();
		txtValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAdd.doClick();
				}
			}
		});
		txtValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtValue.setBounds(95, 14, 210, 25);
		contentPanel.add(txtValue);
		txtValue.setColumns(10);

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});

		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAdd.setBounds(315, 14, 111, 25);
		contentPanel.add(btnAdd);

		msg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		msg.setBounds(10, 224, 416, 25);
		contentPanel.add(msg);
		btnImportCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnImportCSVActionPerformed(e);
			}
		});

		btnImportCSV.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnImportCSV.setBounds(315, 49, 111, 25);
		contentPanel.add(btnImportCSV);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});

		btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnDelete.setBounds(315, 119, 111, 25);
		contentPanel.add(btnDelete);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSaveActionPerformed(e);
			}
		});
		btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnSave.setBounds(315, 154, 111, 25);
		contentPanel.add(btnSave);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e, listModel);
			}
		});
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancel.setBounds(315, 189, 111, 25);
		contentPanel.add(btnCancel);

		btnExportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExportCSVActionPerformed(e);
			}
		});
		btnExportCsv.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnExportCsv.setBounds(315, 84, 111, 25);
		contentPanel.add(btnExportCsv);

		scrollPane.setBounds(10, 49, 295, 165);
		contentPanel.add(scrollPane);
		scrollPane.setViewportView(valueList);

		valueList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	}

	/*
	 * EventHanding
	 */

	// btnAdd
	public void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		String value = txtValue.getText().trim();
		if (value.equals("")) {
			msg.setText("Please Enter Some Value");
			msg.setForeground(Color.RED);
		} else {
			msg.setText("");

			if (arrlist.contains(value.toLowerCase())) {
				msg.setText("Value Already Exists");
				msg.setForeground(Color.RED);
			} else {
				arrlist.add(value.toLowerCase());
				model.addElement(value);
				FrmTaskCreator.pickListCombo.addItem(value);
			}
		}
		txtValue.setText("");
	}

	// Import CSV
	public void btnImportCSVActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.addChoosableFileFilter(new FileNameExtensionFilter("CSV File", "csv"));
		int count = jfc.showOpenDialog(null);
		if (count == JFileChooser.APPROVE_OPTION) {
			Scanner sc;
			try {
				sc = new Scanner(new File(jfc.getSelectedFile().getAbsolutePath()));
				sc.useDelimiter("\n");
				sc.next();
				while (sc.hasNext()) {
					String val = sc.next().trim();
					model.addElement(val);
					FrmTaskCreator.pickListCombo.addItem(val);
				}
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "File Not Found At the path\n" + e1.getMessage());
			}
		}
	}

	// Export CSV
	public void btnExportCSVActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Path path = Paths.get(System.getProperty("user.dir") + "/CSV/PickListData/");
			Files.createDirectories(path);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		File file = new File(System.getProperty("user.dir") + "/CSV/PickListData/DataSectionPickList.csv");
		try {
			if (file.createNewFile()) {
				File newfile = new File(System.getProperty("user.dir") + "/CSV/PickListData/DataSectionPickList.csv");
				PrintWriter pw = new PrintWriter(newfile);
				// header
				pw.append("Values\n");
				for (int i = 0; i < model.getSize(); i++) {
					pw.append(model.elementAt(i).toString() + "\n");
				}
				pw.close();
				JOptionPane.showMessageDialog(rootPane, "CSV Exported successful.");
			} else {
				File newfile = new File(System.getProperty("user.dir") + "/CSV/PickListData/DataSectionPickList.csv");
				PrintWriter pw = new PrintWriter(newfile);
				// header
				pw.append("Values\n");
				for (int i = 0; i < model.getSize(); i++) {
					pw.append(model.elementAt(i).toString() + "\n");
				}
				pw.close();
				JOptionPane.showMessageDialog(rootPane, "CSV Exported successful.");
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	// Delete
	public void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		if (valueList.getSelectedIndices().length > 0) {
			int[] selectedIndices = valueList.getSelectedIndices();
			for (int i = selectedIndices.length - 1; i >= 0; i--) {
				model.removeElementAt(selectedIndices[i]);
				FrmTaskCreator.pickListCombo.removeItemAt(selectedIndices[i]);
			}
		}
	}

	// Save And Exit
	public void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
		FrmTaskCreator.setDataSectionPickList(model);
		arrlist.removeAll(arrlist);
		dispose();
	}

	// Cancel
	public void btnCancelActionPerformed(java.awt.event.ActionEvent evt, DefaultListModel listModel) {
		if (model.getSize() == 0) {
			dispose();
		} else {
			if (listModel.isEmpty()) {
				for (int i = 0; i < model.getSize(); i++) {
					FrmTaskCreator.pickListCombo.removeItem(model.get(i));
				}
				model.removeAllElements();
				arrlist.removeAll(arrlist);
				FrmTaskCreator.setDataSectionPickList(model);
				dispose();
			} else {
				dispose();
			}
		}
	}

}
