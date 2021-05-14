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

public class AddPickListValueToDataSection extends JDialog {

	private static final long serialVersionUID = -5345389861503962205L;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtValue;
	private JButton btnExportCsv = new JButton("Export CSV");
	private JCheckBox chkSortList = new JCheckBox("Sort List");
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnSave = new JButton("Save & Exit");
	private JLabel lblNewLabel = new JLabel("Add Value");
	private JButton btnAddToList = new JButton("Add");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnImportCSV = new JButton("Import CSV");
	private JLabel msg = new JLabel("");
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> valueList = new JList<String>(model);
	private ArrayList<String> arrlist = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPickListValueToDataSection dialog = new AddPickListValueToDataSection();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPickListValueToDataSection() {

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
					btnAddToList.doClick();
					txtValue.setText("");
				}
			}
		});
		txtValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtValue.setBounds(95, 14, 210, 25);
		contentPanel.add(txtValue);
		txtValue.setColumns(10);

		btnAddToList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						TaskCreator.pickListCombo.addItem(value);
					}

				}
			}
		});

		btnAddToList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAddToList.setBounds(315, 14, 111, 25);
		contentPanel.add(btnAddToList);

		valueList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		valueList.setBounds(10, 48, 295, 166);
		contentPanel.add(valueList);

		msg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		msg.setBounds(10, 224, 295, 25);
		contentPanel.add(msg);
		btnImportCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
							TaskCreator.pickListCombo.addItem(val);
						}
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "File Not Found At the path\n" + e1.getMessage());
					}
				}
			}
		});

		btnImportCSV.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnImportCSV.setBounds(315, 49, 111, 25);
		contentPanel.add(btnImportCSV);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (valueList.getSelectedIndices().length > 0) {
					int[] selectedIndices = valueList.getSelectedIndices();
					for (int i = selectedIndices.length - 1; i >= 0; i--) {
						model.removeElementAt(selectedIndices[i]);
						TaskCreator.pickListCombo.removeItemAt(selectedIndices[i]);
					}
				}
			}
		});

		btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnDelete.setBounds(315, 119, 111, 25);
		contentPanel.add(btnDelete);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnSave.setBounds(315, 154, 111, 25);
		contentPanel.add(btnSave);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model.getSize()==0) {
					dispose();
				}else {
					for(int i=0;i<model.getSize();i++) {
						TaskCreator.pickListCombo.removeItem(model.get(i));
					}
				dispose();
				}
			}
		});
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancel.setBounds(315, 189, 111, 25);
		contentPanel.add(btnCancel);

		chkSortList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkSortList.setBounds(315, 224, 111, 25);
		contentPanel.add(chkSortList);

		btnExportCsv.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnExportCsv.setBounds(315, 84, 111, 25);
		contentPanel.add(btnExportCsv);
	}

}
