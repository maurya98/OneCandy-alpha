package guiForms;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TaskCreator extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTaskName;
	private JTextField txtTaskLocation = new JTextField();
	JButton btnBrowseLocation = new JButton("Browse");
	private JTextField txtCreatedBy = new JTextField();
	private JTextField txtDataFieldName = new JTextField();
	private JTextField txtDefaultValue;
	JLayeredPane layeredPane = new JLayeredPane();
	JPanel taskNamePanel = new JPanel();
	JLabel lblNewLabel = new JLabel("Task Name");
	JLabel lblNewLabel_1 = new JLabel("Task Location");
	JLabel lblNewLabel_2 = new JLabel("Created By:");
	JButton btnCancelOnTaskNamePanel = new JButton("Cancel");
	JButton btnNextToDataSection = new JButton("Next");
	JPanel dataSectionPanel = new JPanel();
	JPanel panel_1 = new JPanel();
	JList list = new JList();
	JPanel panel_2 = new JPanel();
	JLabel lblNewLabel_3 = new JLabel("Datafield Name:");
	JLabel lblNewLabel_3_1 = new JLabel("Datatype");
	JComboBox<String> dataTypeCombo = new JComboBox<String>();
	JComboBox<String> pickListCombo = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TaskCreator dialog = new TaskCreator();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TaskCreator() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		layeredPane.setBounds(199, 0, 587, 463);
		contentPanel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		taskNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane.add(taskNamePanel, "name_3263397059100");
		taskNamePanel.setLayout(null);

		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 145, 85, 25);
		taskNamePanel.add(lblNewLabel);

		txtTaskName = new JTextField();
		txtTaskName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtTaskName.setBounds(107, 150, 353, 25);
		taskNamePanel.add(txtTaskName);
		txtTaskName.setColumns(10);

		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 188, 85, 25);
		taskNamePanel.add(lblNewLabel_1);

		txtTaskLocation.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtTaskLocation.setBounds(107, 188, 353, 25);
		taskNamePanel.add(txtTaskLocation);
		txtTaskLocation.setColumns(10);

		btnBrowseLocation.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnBrowseLocation.setBounds(470, 187, 107, 25);
		taskNamePanel.add(btnBrowseLocation);

		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 230, 85, 25);
		taskNamePanel.add(lblNewLabel_2);

		txtCreatedBy.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCreatedBy.setBounds(107, 227, 353, 25);
		taskNamePanel.add(txtCreatedBy);
		txtCreatedBy.setColumns(10);

		btnCancelOnTaskNamePanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelOnTaskNamePanel.setBounds(492, 417, 85, 25);
		taskNamePanel.add(btnCancelOnTaskNamePanel);

		btnNextToDataSection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNextToDataSection.setBounds(397, 417, 85, 25);
		taskNamePanel.add(btnNextToDataSection);

		layeredPane.add(dataSectionPanel, "name_3263418803800");
		dataSectionPanel.setLayout(null);

		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(20, 10, 154, 443);
		dataSectionPanel.add(panel_1);
		panel_1.setLayout(null);

		list.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		list.setBounds(10, 10, 134, 423);
		panel_1.add(list);

		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(184, 10, 393, 284);
		dataSectionPanel.add(panel_2);

		lblNewLabel_3.setBounds(9, 9, 110, 25);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		txtDataFieldName.setBounds(123, 9, 261, 25);
		txtDataFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtDataFieldName.setColumns(10);

		lblNewLabel_3_1.setBounds(9, 38, 110, 25);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		dataTypeCombo.setBounds(123, 38, 261, 25);
		dataTypeCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		dataTypeCombo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "String", "Int", "Long", "Double", "Short", "Float", "Char", "Date", "Date Time" }));

		pickListCombo.setBounds(123, 67, 160, 25);
		pickListCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pickListCombo.setEnabled(false);
		panel_2.setLayout(null);

		JButton btnAddValueToPickList = new JButton("Add Value");
		btnAddValueToPickList.setBounds(294, 67, 90, 25);
		btnAddValueToPickList.setFont(UIManager.getFont("Menu.font"));
		panel_2.add(btnAddValueToPickList);
		btnAddValueToPickList.setEnabled(false);

		JCheckBox chkPickList = new JCheckBox("Pick List");
		chkPickList.setBounds(9, 67, 110, 25);
		chkPickList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkPickList.isSelected()) {
					dataTypeCombo.setEnabled(false);
					pickListCombo.setEnabled(true);
					btnAddValueToPickList.setEnabled(true);
				} else {
					dataTypeCombo.setEnabled(true);
					pickListCombo.setEnabled(false);
					btnAddValueToPickList.setEnabled(false);
				}
			}
		});
		chkPickList.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		JCheckBox chkDefaultValue = new JCheckBox("Default Value");
		chkDefaultValue.setBounds(9, 97, 110, 25);
		chkDefaultValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkDefaultValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkDefaultValue.isSelected())
					txtDefaultValue.setEnabled(true);
				else
					txtDefaultValue.setEnabled(false);
			}

		});

		txtDefaultValue = new JTextField();
		txtDefaultValue.setBounds(123, 97, 261, 25);
		txtDefaultValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtDefaultValue.setColumns(10);
		txtDefaultValue.setEnabled(false);
		panel_2.add(lblNewLabel_3);
		panel_2.add(txtDataFieldName);
		panel_2.add(lblNewLabel_3_1);
		panel_2.add(dataTypeCombo);
		panel_2.add(chkPickList);
		panel_2.add(pickListCombo);
		panel_2.add(chkDefaultValue);
		panel_2.add(txtDefaultValue);

		JButton btnAddNewDataField = new JButton("Add");
		btnAddNewDataField.setBounds(293, 249, 90, 25);
		btnAddNewDataField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(btnAddNewDataField);

		JButton btnDeleteDataField = new JButton("Delete");
		btnDeleteDataField.setBounds(191, 249, 90, 25);
		btnDeleteDataField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(btnDeleteDataField);

		JCheckBox chkMandatory = new JCheckBox("Mandatory");
		chkMandatory.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkMandatory.setBounds(9, 126, 100, 25);
		panel_2.add(chkMandatory);

		JCheckBox chkCarryForward = new JCheckBox("Carry Forward");
		chkCarryForward.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkCarryForward.setBounds(123, 128, 100, 25);
		panel_2.add(chkCarryForward);

		JCheckBox chkPrimary = new JCheckBox("Primary");
		chkPrimary.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkPrimary.setBounds(9, 153, 100, 25);
		panel_2.add(chkPrimary);

		JCheckBox chkUnique = new JCheckBox("Unique");
		chkUnique.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkUnique.setBounds(123, 155, 100, 25);
		panel_2.add(chkUnique);

		JCheckBox chkReadOnly = new JCheckBox("Read Only");
		chkReadOnly.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkReadOnly.setBounds(236, 126, 100, 25);
		panel_2.add(chkReadOnly);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(9, 184, 374, 55);
		panel_2.add(panel_4);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Additional",
				TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setLayout(null);

		JCheckBox chkFilterFields = new JCheckBox("Filter Fields");
		chkFilterFields.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkFilterFields.setBounds(5, 15, 100, 25);
		panel_4.add(chkFilterFields);

		JButton btnMapFields = new JButton("Map Fields");
		btnMapFields.setBounds(111, 15, 90, 25);
		panel_4.add(btnMapFields);

		JButton btnAdvance = new JButton("Advance");
		btnAdvance.setBounds(211, 15, 90, 25);
		panel_4.add(btnAdvance);

		JCheckBox chkMultiLine = new JCheckBox("Multi Line");
		chkMultiLine.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkMultiLine.setBounds(236, 153, 100, 25);
		panel_2.add(chkMultiLine);

		JButton btnBackToTaskNamePanel = new JButton("Back");
		btnBackToTaskNamePanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnBackToTaskNamePanel.setMinimumSize(new Dimension(90, 25));
		btnBackToTaskNamePanel.setMaximumSize(new Dimension(90, 25));
		btnBackToTaskNamePanel.setPreferredSize(new Dimension(90, 25));
		btnBackToTaskNamePanel.setBounds(297, 426, 90, 25);
		dataSectionPanel.add(btnBackToTaskNamePanel);

		JButton btnNextToDocumentTypePanel = new JButton("Next");
		btnNextToDocumentTypePanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNextToDocumentTypePanel.setMinimumSize(new Dimension(90, 25));
		btnNextToDocumentTypePanel.setMaximumSize(new Dimension(90, 25));
		btnNextToDocumentTypePanel.setPreferredSize(new Dimension(90, 25));
		btnNextToDocumentTypePanel.setBounds(392, 426, 90, 25);
		dataSectionPanel.add(btnNextToDocumentTypePanel);

		JButton btnCancelOnDataSectionPanel = new JButton("Cancel");
		btnCancelOnDataSectionPanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelOnDataSectionPanel.setMinimumSize(new Dimension(90, 25));
		btnCancelOnDataSectionPanel.setMaximumSize(new Dimension(90, 25));
		btnCancelOnDataSectionPanel.setPreferredSize(new Dimension(90, 25));
		btnCancelOnDataSectionPanel.setBounds(487, 426, 90, 25);
		dataSectionPanel.add(btnCancelOnDataSectionPanel);

		JPanel docTypePanel = new JPanel();
		layeredPane.add(docTypePanel, "name_3263440855000");

		JPanel imageSettingPanel = new JPanel();
		layeredPane.add(imageSettingPanel, "name_3263461841800");

		JPanel exportOptionPanel = new JPanel();
		layeredPane.add(exportOptionPanel, "name_3263484712800");

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 199, 463);
		contentPanel.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Task Name");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taskNamePanel.setVisible(true);
				dataSectionPanel.setVisible(false);
				docTypePanel.setVisible(false);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 57, 199, 25);
		panel.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("Data Section");
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taskNamePanel.setVisible(false);
				dataSectionPanel.setVisible(true);
				docTypePanel.setVisible(false);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(0, 87, 199, 25);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Document Type");
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taskNamePanel.setVisible(false);
				dataSectionPanel.setVisible(false);
				docTypePanel.setVisible(true);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(0, 118, 199, 25);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Image Settings");
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taskNamePanel.setVisible(false);
				dataSectionPanel.setVisible(false);
				docTypePanel.setVisible(false);
				imageSettingPanel.setVisible(true);
				exportOptionPanel.setVisible(false);
			}
		});
		btnNewButton_5.setBounds(0, 180, 199, 25);
		panel.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Export Options");
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_6.setBorder(null);
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taskNamePanel.setVisible(false);
				dataSectionPanel.setVisible(false);
				docTypePanel.setVisible(false);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(0, 211, 199, 25);
		panel.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Folder Section");
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_7.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_7.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(0, 149, 199, 25);
		panel.add(btnNewButton_7);
	}
}
