package guiForms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.table.DefaultTableModel;

public class FrmMappingFilterFields extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			FrmMappingFilterFields dialog = new FrmMappingFilterFields();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*****************************************************************************************************************/
	
/*
 * Component Declaration
 */
	JButton btnAdd = new JButton("Add");
	JButton btnNewButton = new JButton(">");
	JButton btnNewButton_1 = new JButton("<");
	JButton btnDelete = new JButton("Delete");
	JButton btnModify = new JButton("Modify");
	JComboBox dataFieldCombo = new JComboBox();
	JComboBox pickListValues = new JComboBox();
	private final JPanel contentPanel = new JPanel();
	JLabel lblNewLabel = new JLabel("Select Field:");
	JLabel lblNewLabel_1 = new JLabel("Picklist Value");
	JScrollPane scrollPane = new JScrollPane();
	JScrollPane scrollPane_1 = new JScrollPane();
	DefaultListModel dlmAllDataField=new DefaultListModel<>();
	private final JList list = new JList(dlmAllDataField);
	DefaultListModel dlmSelectedDataFields = new DefaultListModel();
	private final JList list_1 = new JList(dlmSelectedDataFields);
	
	/*
	 * Variable declaration
	 */
	
	static Map<String,ArrayList<String>> comboValues = new LinkedHashMap<String, ArrayList<String>>();
	static int rows=0;
	DefaultTableModel dtmTableModel;
	private final JTable table = new JTable();
	/******************************************************************************************************************/

	/**
	 * Create the dialog.
	 */

	public FrmMappingFilterFields() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				mappingWindowOpened(e);
			}
		});
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 420, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		dataFieldCombo.setBounds(90, 12, 307, 25);
		dataFieldCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				changeValue(e);
			}
		});
		contentPanel.setLayout(null);

		dataFieldCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(dataFieldCombo);
		lblNewLabel.setBounds(10, 10, 70, 25);

		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(lblNewLabel);
		lblNewLabel_1.setBounds(10, 45, 70, 25);

		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(lblNewLabel_1);
		pickListValues.setBounds(90, 45, 307, 25);

		pickListValues.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(pickListValues);
		scrollPane.setBounds(10, 80, 165, 250);
		contentPanel.add(scrollPane);
		
		scrollPane.setViewportView(list);
		scrollPane_1.setBounds(232, 78, 165, 250);
		contentPanel.add(scrollPane_1);
		
		scrollPane_1.setViewportView(list_1);
		btnNewButton.setBounds(182, 156, 40, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCopyToList2ActionPerformed(e);
			}
		});

		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(btnNewButton);
		btnNewButton_1.setBounds(182, 187, 40, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCopyToList1ActionPerformed(e);
			}
		});

		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(btnNewButton_1);
		btnAdd.setBounds(307, 338, 90, 25);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});

		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(btnAdd);
		btnDelete.setBounds(307, 533, 90, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(btnDelete);
		btnModify.setBounds(207, 338, 90, 25);
		
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModifyActionPerformed(e);
			}
		});
		btnModify.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPanel.add(btnModify);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 374, 387, 149);
		contentPanel.add(scrollPane_2);		
		scrollPane_2.setViewportView(table);
		dtmTableModel = new DefaultTableModel();
		table.setModel(dtmTableModel);
		dtmTableModel.addColumn("DataFields");
		dtmTableModel.addColumn("Value");
		dtmTableModel.addColumn("Associate Fields");
		
	}
	
	/***************************************************************************************************************************************/
	
	/*
	 * Event Handling
	 */
	
	protected void mappingWindowOpened(java.awt.event.WindowEvent e) {
		comboValues = FrmTaskCreator.getDataFieldsWithPickList();
		Iterator iterator= comboValues.entrySet().iterator();
		while(iterator.hasNext()) {
			 Map.Entry<String,ArrayList<String>> entry = (Map.Entry<String,ArrayList<String>>) iterator.next();
			 dataFieldCombo.addItem(entry.getKey());
		}
		for(int i=0;i<FrmTaskCreator.dsDataSection.size();i++) {
			dlmAllDataField.addElement(FrmTaskCreator.dsDataSection.get(i).getDataFieldName());
		}
		
	}
	protected void changeValue(ItemEvent e) {
		String text = dataFieldCombo.getSelectedItem().toString();
		pickListValues.removeAllItems();
		for(int i=0;i<comboValues.get(text).size();i++) {
			pickListValues.addItem(comboValues.get(text).get(i));
		}
	}
	
	public void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		dtmTableModel.addRow(new Object[] {dataFieldCombo.getSelectedItem(),pickListValues.getSelectedItem(),""});
	}
	
	public void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {
		
	}
	
	public void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		
	}
	
	public void btnCopyToList2ActionPerformed(java.awt.event.ActionEvent evt) {
		int [] arrlist1Selected = list.getSelectedIndices();
		for(int i=0;i<arrlist1Selected.length;i++) {
			dlmSelectedDataFields.addElement(dlmAllDataField.elementAt(arrlist1Selected[i]));
		}
		for(int i=0;i<dlmSelectedDataFields.getSize();i++) {
			//System.out.println(arrlist1Selected[0]);
			dlmAllDataField.removeElement(dlmSelectedDataFields.elementAt(i));
		}
	}
	
	public void btnCopyToList1ActionPerformed(java.awt.event.ActionEvent evt) {
		int [] arrlist2Selected=list_1.getSelectedIndices();
		for(int i=0;i<arrlist2Selected.length;i++) {
			dlmAllDataField.addElement(dlmSelectedDataFields.elementAt(arrlist2Selected[i]));
		}
		for(int i=0;i<dlmAllDataField.getSize();i++) {
			dlmSelectedDataFields.removeElement(dlmAllDataField.getElementAt(i));
		}
	}
}
