package guiForms;

/*
 * Author : Saurabh Kumar Maurya
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.*;

import entityStructure.DataSection;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import net.miginfocom.swing.MigLayout;

public class FrmTaskCreator extends JDialog {

	
	private static final long serialVersionUID = 1L;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmTaskCreator dialog = new FrmTaskCreator();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/****************************************************************************************************************************/
	
	/*
	 * Component Declaration
	 */
	private JButton btnAddDocument = new JButton("Add");
	private JButton btnAddNewDataField = new JButton("Add");
	private JButton btnAddValueToPickList = new JButton("Add Value");
	private JButton btnAdvance = new JButton("Advance");
	private JButton btnBackToDataSection = new JButton("Back");
	private JButton btnBackToTaskNamePanel = new JButton("Back");
	private JButton btnBrowseLocation = new JButton("Browse");
	private JButton btnCancelOnDataSectionPanel = new JButton("Cancel");
	private JButton btnCancelOnDocTypePanel = new JButton("Cancel");
	private JButton btnCancelOnTaskNamePanel = new JButton("Cancel");
	private JButton btnClearDocument = new JButton("Clear");
	private JButton btnDeleteDataField = new JButton("Delete");
	private JButton btnMapFields = new JButton("Map Fields");
	private JButton btnNewButton = new JButton("Task Name");
	private JButton btnNewButton_3 = new JButton("Data Section");
	private JButton btnNewButton_4 = new JButton("Document Type");
	private JButton btnNewButton_5 = new JButton("Image Settings");
	private JButton btnNewButton_6 = new JButton("Export Options");
	private JButton btnNewButton_7 = new JButton("Folder Section");
	private JButton btnNewButton_9 = new JButton("Get Value");
	private JButton btnNextToDataSection = new JButton("Next");
	private JButton btnNextToDocumentTypePanel = new JButton("Next");
	private JButton btnNextToImageSettings = new JButton("Next");
	private JButton btnSetZone = new JButton("Set Zone");
	private JButton btnClearValue = new JButton("Clear");
	
	private final ButtonGroup buttonGroupDoctypeSection = new ButtonGroup();
	
	private JCheckBox chckbxNewCheckBox = new JCheckBox("Enable Encryption");
	private JCheckBox chkCarryForward = new JCheckBox("Carry Forward");
	private JCheckBox chkDefaultValue = new JCheckBox("Default Value");
	private JCheckBox chkFilterFields = new JCheckBox("Filter Fields");
	private JCheckBox chkMandatory = new JCheckBox("Mandatory");
	private JCheckBox chkMandatoryOnDocumentTypePanel = new JCheckBox("Mandatory");
	private JCheckBox chkMultiLine = new JCheckBox("Multi Line");
	private JCheckBox chkPickList = new JCheckBox("Pick List");
	private JCheckBox chkPrimary = new JCheckBox("Primary");
	private JCheckBox chkReadOnly = new JCheckBox("Read Only");
	private JCheckBox chkUnique = new JCheckBox("Unique");
	JCheckBox chkFilterDocument = new JCheckBox("Filter Document");
	
	private static DefaultListModel dataFieldListModel = new DefaultListModel();
	private JList<String> dataFieldList = new JList<String>(dataFieldListModel);
	private JList<String> documentList = new JList<String>();

	private JComboBox<String> associationTypeCombo = new JComboBox<String>();
	private JComboBox<String> dataTypeCombo = new JComboBox<String>();
	private JComboBox<String> folderIdentifierCombo = new JComboBox<String>();
	private JComboBox<String> formatTypecCombo = new JComboBox<String>();
	private JComboBox<String> fromDocCombo = new JComboBox<String>();
	static JComboBox<String> pickListCombo = new JComboBox<String>();
	
	private JLabel lblNewLabel = new JLabel("Task Name");
	private JLabel lblNewLabel_1 = new JLabel("Task Location");
	private JLabel lblNewLabel_10 = new JLabel("y2");
	private JLabel lblNewLabel_11 = new JLabel("Get String");
	private JLabel lblNewLabel_12 = new JLabel("From Doc:");
	private JLabel lblNewLabel_13 = new JLabel("Folder Name:");
	private JLabel lblNewLabel_14 = new JLabel("Folder Identifier");
	private JLabel lblNewLabel_15 = new JLabel("After Every:");
	private JLabel lblNewLabel_16 = new JLabel("x1");
	private JLabel lblNewLabel_16_1 = new JLabel("x2");
	private JLabel lblNewLabel_16_1_1 = new JLabel("y1");
	private JLabel lblNewLabel_16_1_1_1 = new JLabel("y2");
	private JLabel lblNewLabel_2 = new JLabel("Created By:");
	private JLabel lblNewLabel_3 = new JLabel("Datafield Name:");
	private JLabel lblNewLabel_3_1 = new JLabel("Datatype");
	private JLabel lblNewLabel_4 = new JLabel("Document Name:");
	private JLabel lblNewLabel_5 = new JLabel("Format Type:");
	private JLabel lblNewLabel_6 = new JLabel("Association Type");
	private JLabel lblNewLabel_7 = new JLabel("x1");
	private JLabel lblNewLabel_8 = new JLabel("y1");
	private JLabel lblNewLabel_9 = new JLabel("x2");
	
	private JPanel imageSettingPanel = new JPanel();
	private JLayeredPane layeredPane = new JLayeredPane();
	private JPanel panel = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JPanel panel_7 = new JPanel();
	private JPanel panel_8 = new JPanel();
	private JPanel txtGetString = new JPanel();
	private JPanel taskNamePanel = new JPanel();
	private JPanel dataSectionPanel = new JPanel();
	private JPanel docTypePanel = new JPanel();
	private JPanel exportOptionPanel = new JPanel();
	private JPanel folderSectionPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JPanel panel_1 = new JPanel();
	private final JPanel contentPanel = new JPanel();
	
	
	private JRadioButton rdBtnAutoAssociation = new JRadioButton("Auto Association");
	private JRadioButton rdBtnManualAssociation = new JRadioButton("Manual Association");
	
	private JSpinner spinner = new JSpinner();
	
	private JTextField textField_10 = new JTextField();
	private JTextField textField_5 = new JTextField();
	private JTextField textField_6 = new JTextField();
	private JTextField textField_7 = new JTextField();
	private JTextField textField_8 = new JTextField();
	private JTextField textField_9 = new JTextField();
	private JTextField txtCreatedBy = new JTextField();
	private JTextField txtDataFieldName = new JTextField();
	private JTextField txtDefaultValue = new JTextField();
	private JTextField txtDocumentName = new JTextField();
	private JTextField txtTaskLocation = new JTextField();
	private JTextField txtTaskName = new JTextField();
	private JTextField txtValueX1 = new JTextField();
	private JTextField txtValueX2 = new JTextField();
	private JTextField txtValueY1 = new JTextField();
	private JTextField txtValueY2 = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	// End Component Declaration
	
	/*
	 * Variable declaration
	 */
	int flagForUniqueValues=0;
	
	FrmPicklistDS frmPickListDS;
	FrmMappingFilterFields frmMappingFilterFields = new FrmMappingFilterFields();
	FrmAdvanceDS frmAdvanceDS= new FrmAdvanceDS();
	
	DataSection objDataSection;
	static ArrayList<DataSection> dsDataSection = new ArrayList<DataSection>();
	
	static DefaultListModel<String> dataSectionPickList = new DefaultListModel<String>();
	public static DefaultListModel<String> getDataSectionPickList() {
		return dataSectionPickList;
	}
	public static void setDataSectionPickList(DefaultListModel<String> dataSectionPickList) {
		FrmTaskCreator.dataSectionPickList = dataSectionPickList;
	}

	/****************************************************************************************************************************/

	/**
	 * Create the dialog.
	 */
	public FrmTaskCreator() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);

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
		btnBrowseLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

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
		btnCancelOnTaskNamePanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnCancelOnTaskNamePanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelOnTaskNamePanel.setBounds(492, 417, 85, 25);
		taskNamePanel.add(btnCancelOnTaskNamePanel);
		btnNextToDataSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNextToDataSection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNextToDataSection.setBounds(397, 417, 85, 25);
		taskNamePanel.add(btnNextToDataSection);

		layeredPane.add(dataSectionPanel, "name_3263418803800");
		dataSectionPanel.setLayout(null);

		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(184, 10, 393, 284);
		dataSectionPanel.add(panel_2);
		lblNewLabel_3.setBounds(9, 9, 102, 25);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtDataFieldName.setBounds(123, 9, 261, 25);
		txtDataFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtDataFieldName.setColumns(10);
		lblNewLabel_3_1.setBounds(9, 38, 102, 25);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		dataTypeCombo.setBounds(123, 38, 261, 25);
		dataTypeCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		dataTypeCombo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "String", "Int", "Long", "Double", "Short", "Float", "Char", "Date", "Date Time" }));
		pickListCombo.setBounds(123, 67, 159, 26);
		pickListCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		pickListCombo.setEnabled(false);
		btnAddValueToPickList.setBounds(297, 67, 87, 25);
		btnAddValueToPickList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddValuesActionPerformed(e);
			}
		});
		panel_2.setLayout(null);
		btnAddValueToPickList.setFont(UIManager.getFont("Menu.font"));
		panel_2.add(btnAddValueToPickList);
		btnAddValueToPickList.setEnabled(false);
		chkPickList.setBounds(9, 67, 102, 25);
		chkPickList.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				chkPickListItemStateChanged(e);
			}
		});
		chkPickList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkDefaultValue.setBounds(9, 97, 102, 25);
		chkDefaultValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkDefaultValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkDefaultValue.isSelected())
					txtDefaultValue.setEnabled(true);
				else
					txtDefaultValue.setEnabled(false);
			}

		});
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
		btnAddNewDataField.setBounds(297, 247, 87, 25);

		btnAddNewDataField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddNewDataFieldsActionPerformed(e);
			}
		});
		btnAddNewDataField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(btnAddNewDataField);
		btnDeleteDataField.setBounds(196, 247, 86, 25);
		btnDeleteDataField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteDataFieldsActionPerformed(e);
			}
		});
		btnDeleteDataField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(btnDeleteDataField);
		chkMandatory.setBounds(9, 126, 102, 25);
		chkMandatory.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(chkMandatory);
		chkCarryForward.setBounds(123, 128, 99, 25);
		chkCarryForward.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(chkCarryForward);
		chkPrimary.setBounds(9, 157, 102, 25);
		chkPrimary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkPrimary.isSelected()) {
					flagForUniqueValues=1;
					chkUnique.setSelected(false);
					chkUnique.setEnabled(false);
				}
				else {
					flagForUniqueValues=0;
					chkUnique.setEnabled(true);
				}
			}
		});
		chkPrimary.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(chkPrimary);
		chkUnique.setBounds(123, 159, 99, 25);
		chkUnique.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(chkUnique);
		chkReadOnly.setBounds(242, 126, 79, 25);
		chkReadOnly.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(chkReadOnly);
		panel_4.setBounds(9, 188, 375, 55);
		panel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(panel_4);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Additional",
				TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setLayout(null);
		chkFilterFields.setEnabled(false);
		chkFilterFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkFilterFields.isSelected()) {
					btnMapFields.setEnabled(true);
				} else {
					btnMapFields.setEnabled(false);
				}
			}
		});

		chkFilterFields.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chkFilterFields.setBounds(5, 15, 100, 25);
		panel_4.add(chkFilterFields);
		btnMapFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMapFilterActionPerformed(e);
			}
		});
		btnMapFields.setEnabled(false);

		btnMapFields.setBounds(111, 15, 90, 25);
		panel_4.add(btnMapFields);
		btnAdvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdvanceActionPerformed(e);
			}
		});
		btnAdvance.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		btnAdvance.setBounds(211, 15, 90, 25);
		panel_4.add(btnAdvance);
		chkMultiLine.setBounds(242, 157, 77, 25);
		chkMultiLine.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_2.add(chkMultiLine);
		btnClearValue.setBounds(121, 247, 59, 25);
		btnClearValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearDataSectionFields();
			}
		});
		btnClearValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		panel_2.add(btnClearValue);

		btnBackToTaskNamePanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnBackToTaskNamePanel.setMinimumSize(new Dimension(90, 25));
		btnBackToTaskNamePanel.setMaximumSize(new Dimension(90, 25));
		btnBackToTaskNamePanel.setPreferredSize(new Dimension(90, 25));
		btnBackToTaskNamePanel.setBounds(297, 426, 90, 25);
		dataSectionPanel.add(btnBackToTaskNamePanel);

		btnNextToDocumentTypePanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNextToDocumentTypePanel.setMinimumSize(new Dimension(90, 25));
		btnNextToDocumentTypePanel.setMaximumSize(new Dimension(90, 25));
		btnNextToDocumentTypePanel.setPreferredSize(new Dimension(90, 25));
		btnNextToDocumentTypePanel.setBounds(392, 426, 90, 25);
		dataSectionPanel.add(btnNextToDocumentTypePanel);

		btnCancelOnDataSectionPanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelOnDataSectionPanel.setMinimumSize(new Dimension(90, 25));
		btnCancelOnDataSectionPanel.setMaximumSize(new Dimension(90, 25));
		btnCancelOnDataSectionPanel.setPreferredSize(new Dimension(90, 25));
		btnCancelOnDataSectionPanel.setBounds(487, 426, 90, 25);
		dataSectionPanel.add(btnCancelOnDataSectionPanel);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 10, 164, 441);
				
		dataSectionPanel.add(panel_1);
		panel_1.setLayout(null);
		scrollPane.setBounds(10, 10, 144, 421);
				
		panel_1.add(scrollPane);
		dataFieldList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadData();
			}
		});
		
		
		scrollPane.setViewportView(dataFieldList);
				
		dataFieldList.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		layeredPane.add(docTypePanel, "name_3263440855000");
		docTypePanel.setLayout(null);

		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(10, 10, 158, 443);
		docTypePanel.add(panel_3);
		panel_3.setLayout(null);
		scrollPane_1.setBounds(10, 10, 138, 423);
		
		panel_3.add(scrollPane_1);
		scrollPane_1.setViewportView(documentList);

		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(178, 10, 399, 408);
		docTypePanel.add(panel_5);
		panel_5.setLayout(null);

		lblNewLabel_4.setBounds(9, 9, 93, 25);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_5.add(lblNewLabel_4);

		txtDocumentName = new JTextField();
		txtDocumentName.setBounds(117, 9, 272, 25);
		txtDocumentName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_5.add(txtDocumentName);
		txtDocumentName.setColumns(10);

		lblNewLabel_5.setBounds(9, 38, 93, 25);
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_5.add(lblNewLabel_5);

		formatTypecCombo.setBounds(117, 38, 272, 25);
		formatTypecCombo.setToolTipText("This will convert the document into Following type while saving");
		formatTypecCombo.setModel(new DefaultComboBoxModel(new String[] { "jpeg", "png", "pdf", "docx", "tif" }));
		formatTypecCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_5.add(formatTypecCombo);

		lblNewLabel_6.setBounds(11, 96, 90, 29);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_5.add(lblNewLabel_6);

		associationTypeCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		associationTypeCombo.setBounds(117, 98, 272, 25);
		associationTypeCombo.setModel(new DefaultComboBoxModel(new String[] { "Single Page", "Barcode", "Extract from other document" }));
		panel_5.add(associationTypeCombo);

		txtGetString.setBounds(117, 160, 272, 135);
		txtGetString.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.add(txtGetString);
		txtGetString.setLayout(null);

		lblNewLabel_7.setBounds(66, 38, 12, 25);
		lblNewLabel_7.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(lblNewLabel_7);

		lblNewLabel_8.setBounds(66, 67, 12, 25);
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(lblNewLabel_8);

		txtValueX1.setBounds(99, 38, 54, 25);
		txtValueX1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(txtValueX1);
		txtValueX1.setColumns(10);

		txtValueY1.setBounds(99, 67, 54, 25);
		txtValueY1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(txtValueY1);
		txtValueY1.setColumns(10);

		lblNewLabel_9.setBounds(189, 38, 12, 25);
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_9.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtGetString.add(lblNewLabel_9);

		lblNewLabel_10.setBounds(189, 67, 12, 25);
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(lblNewLabel_10);

		txtValueX2.setBounds(215, 38, 46, 25);
		txtValueX2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(txtValueX2);
		txtValueX2.setColumns(10);

		txtValueY2.setBounds(215, 67, 46, 25);
		txtValueY2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(txtValueY2);
		txtValueY2.setColumns(10);

		lblNewLabel_11.setBounds(9, 96, 53, 30);
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(lblNewLabel_11);

		textField_5.setBounds(66, 96, 87, 30);
		txtGetString.add(textField_5);
		textField_5.setColumns(10);

		btnSetZone.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnSetZone.setBounds(182, 99, 80, 25);
		txtGetString.add(btnSetZone);

		lblNewLabel_12.setBounds(7, 8, 55, 25);
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtGetString.add(lblNewLabel_12);

		fromDocCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fromDocCombo.setBounds(66, 9, 195, 25);
		txtGetString.add(fromDocCombo);

		chkMandatoryOnDocumentTypePanel.setBounds(117, 129, 89, 25);
		chkMandatoryOnDocumentTypePanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_5.add(chkMandatoryOnDocumentTypePanel);

		btnAddDocument.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAddDocument.setBounds(299, 373, 90, 25);
		panel_5.add(btnAddDocument);

		btnClearDocument.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnClearDocument.setBounds(199, 373, 90, 25);
		panel_5.add(btnClearDocument);

		rdBtnManualAssociation.setBounds(106, 67, 129, 25);
		buttonGroupDoctypeSection.add(rdBtnManualAssociation);
		rdBtnManualAssociation.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdBtnManualAssociation.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_5.add(rdBtnManualAssociation);

		rdBtnAutoAssociation.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdBtnAutoAssociation.setBounds(243, 67, 135, 25);
		buttonGroupDoctypeSection.add(rdBtnAutoAssociation);
		rdBtnAutoAssociation.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_5.add(rdBtnAutoAssociation);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, 
				new Color(255, 255, 255), new Color(160, 160, 160)), 
				"Additional", TitledBorder.TRAILING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(9, 305, 380, 55);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		
		chkFilterDocument.setBounds(10, 15, 111, 25);
		panel_6.add(chkFilterDocument);
		chkFilterDocument.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JButton mapDocumentFilter = new JButton("Map");
		mapDocumentFilter.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mapDocumentFilter.setBounds(127, 15, 100, 25);
		panel_6.add(mapDocumentFilter);

		btnBackToDataSection.setPreferredSize(new Dimension(90, 25));
		btnBackToDataSection.setMinimumSize(new Dimension(90, 25));
		btnBackToDataSection.setMaximumSize(new Dimension(90, 25));
		btnBackToDataSection.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnBackToDataSection.setBounds(297, 428, 90, 25);
		docTypePanel.add(btnBackToDataSection);

		btnNextToImageSettings.setPreferredSize(new Dimension(90, 25));
		btnNextToImageSettings.setMinimumSize(new Dimension(90, 25));
		btnNextToImageSettings.setMaximumSize(new Dimension(90, 25));
		btnNextToImageSettings.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNextToImageSettings.setBounds(392, 428, 90, 25);
		docTypePanel.add(btnNextToImageSettings);

		btnCancelOnDocTypePanel.setPreferredSize(new Dimension(90, 25));
		btnCancelOnDocTypePanel.setMinimumSize(new Dimension(90, 25));
		btnCancelOnDocTypePanel.setMaximumSize(new Dimension(90, 25));
		btnCancelOnDocTypePanel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelOnDocTypePanel.setBounds(487, 428, 90, 25);
		docTypePanel.add(btnCancelOnDocTypePanel);

		layeredPane.add(imageSettingPanel, "name_3263461841800");

		layeredPane.add(exportOptionPanel, "name_3263484712800");

		layeredPane.add(folderSectionPanel, "name_72167684710700");
		folderSectionPanel.setLayout(null);

		panel_7.setBounds(10, 10, 567, 256);
		folderSectionPanel.add(panel_7);
		panel_7.setLayout(null);

		lblNewLabel_13.setBounds(10, 10, 95, 25);
		panel_7.add(lblNewLabel_13);
		lblNewLabel_13.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_13.setFont(new Font("Segoe UI", Font.PLAIN, 12));

		textField_6 = new JTextField();
		textField_6.setBounds(113, 11, 444, 25);
		panel_7.add(textField_6);
		textField_6.setColumns(10);

		lblNewLabel_14.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_14.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_14.setBounds(10, 45, 95, 25);
		panel_7.add(lblNewLabel_14);

		folderIdentifierCombo
				.setModel(new DefaultComboBoxModel(new String[] { "Blank Page", "Barcode", "After Every" }));
		folderIdentifierCombo.setBounds(113, 46, 444, 23);
		panel_7.add(folderIdentifierCombo);

		lblNewLabel_15.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_15.setBounds(113, 79, 75, 25);
		panel_7.add(lblNewLabel_15);

		spinner.setBounds(198, 79, 50, 25);
		panel_7.add(spinner);

		panel_8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_8.setBorder(
				new TitledBorder(null, "Values for Barcode", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(113, 114, 280, 94);
		panel_7.add(panel_8);
		panel_8.setLayout(null);

		lblNewLabel_16.setBounds(13, 22, 20, 26);
		lblNewLabel_16.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_8.add(lblNewLabel_16);

		lblNewLabel_16_1.setBounds(91, 22, 20, 26);
		lblNewLabel_16_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_8.add(lblNewLabel_16_1);

		lblNewLabel_16_1_1.setBounds(13, 52, 20, 29);
		lblNewLabel_16_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_8.add(lblNewLabel_16_1_1);

		lblNewLabel_16_1_1_1.setBounds(91, 52, 20, 29);
		lblNewLabel_16_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_8.add(lblNewLabel_16_1_1_1);

		textField_7.setBounds(115, 22, 50, 26);
		panel_8.add(textField_7);
		textField_7.setColumns(10);

		textField_8.setBounds(115, 52, 50, 29);
		textField_8.setColumns(10);
		panel_8.add(textField_8);

		textField_9.setBounds(37, 52, 50, 29);
		textField_9.setColumns(10);
		panel_8.add(textField_9);

		textField_10.setBounds(37, 22, 50, 26);
		textField_10.setColumns(10);
		panel_8.add(textField_10);

		btnNewButton_9.setBounds(169, 56, 95, 25);
		btnNewButton_9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_8.add(btnNewButton_9);

		chckbxNewCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		chckbxNewCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(10, 218, 120, 25);
		panel_7.add(chckbxNewCheckBox);

		passwordField = new JPasswordField();
		passwordField.setBounds(136, 218, 257, 25);
		panel_7.add(passwordField);

		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 199, 463);
		contentPanel.add(panel);
		panel.setLayout(null);

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
				folderSectionPanel.setVisible(false);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(false);

			}
		});
		btnNewButton.setBounds(0, 57, 199, 25);
		panel.add(btnNewButton);

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
				folderSectionPanel.setVisible(false);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(0, 87, 199, 25);
		panel.add(btnNewButton_3);

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
				folderSectionPanel.setVisible(false);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(0, 118, 199, 25);
		panel.add(btnNewButton_4);

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
				folderSectionPanel.setVisible(false);
				imageSettingPanel.setVisible(true);
				exportOptionPanel.setVisible(false);
			}
		});
		btnNewButton_5.setBounds(0, 180, 199, 25);
		panel.add(btnNewButton_5);

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
				folderSectionPanel.setVisible(false);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(0, 211, 199, 25);
		panel.add(btnNewButton_6);

		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taskNamePanel.setVisible(false);
				dataSectionPanel.setVisible(false);
				docTypePanel.setVisible(false);
				folderSectionPanel.setVisible(true);
				imageSettingPanel.setVisible(false);
				exportOptionPanel.setVisible(false);
			}
		});
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_7.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_7.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(0, 149, 199, 25);
		panel.add(btnNewButton_7);
	}
	

	/****************************************************************************************************************************/
	
	/*
	 * EvenHandling
	 */
	
	//Adding new Data-fields in Data Section
	@SuppressWarnings("all")
	public void btnAddNewDataFieldsActionPerformed(java.awt.event.ActionEvent evt) {
		
		ArrayList arrPickList = new ArrayList<String>();
		if (txtDataFieldName.getText().equals("")) {
			JOptionPane.showMessageDialog(dataSectionPanel, "Datafield Name cannot be null.");
		} 
		else if(dataFieldListModel.contains(txtDataFieldName.getText())) {
			for(int j=0;j<dsDataSection.size();j++) {
				if(dsDataSection.get(j).getDataFieldName().equalsIgnoreCase(txtDataFieldName.getText())) {
					String strDataFieldName=txtDataFieldName.getText().trim();    
					String strDatatype=dataTypeCombo.getSelectedItem().toString().trim();
					if(chkPickList.isSelected()) {
						DefaultListModel model=getDataSectionPickList();
						for(int i=0;i<model.getSize();i++) {
							arrPickList.add(model.elementAt(i).toString());
						}
					}
					
					String strdefaultValue= "";
					if(chkDefaultValue.isSelected()) {
						strdefaultValue=txtDefaultValue.getText().trim();
					}
					boolean mandatory=chkMandatory.isSelected();
					boolean carryForward=chkCarryForward.isSelected();
					boolean readonly=chkReadOnly.isSelected();
					boolean primary=chkPrimary.isSelected();
					if(chkPrimary.isSelected() && flagForUniqueValues==0) {
						flagForUniqueValues=1;
						chkUnique.setSelected(false);
						chkUnique.setEnabled(false);
					}
					boolean unique=chkUnique.isSelected();
					boolean multiLine=chkMultiLine.isSelected();
					Map<String, ArrayList<String>> filterFieldValues = new LinkedHashMap<String, ArrayList<String>>();
					if(chkFilterFields.isSelected()) {
						
					}
					dsDataSection.get(j).setCarryForward(carryForward);
					dsDataSection.get(j).setDataType(strDatatype);
					dsDataSection.get(j).setDefaultValue(strdefaultValue);
					dsDataSection.get(j).setFilterFields(filterFieldValues);
					dsDataSection.get(j).setMandatory(mandatory);
					dsDataSection.get(j).setMultiLine(multiLine);
					dsDataSection.get(j).setPickListValue(arrPickList);
					dsDataSection.get(j).setPrimary(primary);
					dsDataSection.get(j).setReadOnly(readonly);
					dsDataSection.get(j).setUnique(unique);
					break;
				}
			}
			dataSectionPickList.removeAllElements();
		}
		else{
			String strDataFieldName=txtDataFieldName.getText().trim();    
			String strDatatype=dataTypeCombo.getSelectedItem().toString().trim();
			if(chkPickList.isSelected()) {
				DefaultListModel model=getDataSectionPickList();
				for(int i=0;i<model.getSize();i++) {
					arrPickList.add(model.elementAt(i).toString());
				}
			}
			
			String strdefaultValue= "";
			if(chkDefaultValue.isSelected()) {
				strdefaultValue=txtDefaultValue.getText().trim();
			}
			boolean mandatory=chkMandatory.isSelected();
			boolean carryForward=chkCarryForward.isSelected();
			boolean readonly=chkReadOnly.isSelected();
			boolean primary=chkPrimary.isSelected();
			if(chkPrimary.isSelected() && flagForUniqueValues==0) {
				flagForUniqueValues=1;
				chkUnique.setSelected(false);
				chkUnique.setEnabled(false);
			}
			boolean unique=chkUnique.isSelected();
			boolean multiLine=chkMultiLine.isSelected();
			Map<String, ArrayList<String>> filterFieldValues = new LinkedHashMap<String, ArrayList<String>>();
			if(chkFilterFields.isSelected()) {
				
			}
			objDataSection=new DataSection();
			objDataSection.associateValue(strDataFieldName, strDatatype, arrPickList, strdefaultValue,carryForward, mandatory, readonly, primary, unique, multiLine, filterFieldValues);
			dsDataSection.add(objDataSection);
			dataFieldListModel.addElement(strDataFieldName);
		}	
			clearDataSectionFields();
		
	}
	
	//Delete Data-fields from Data Section
	public void btnDeleteDataFieldsActionPerformed(ActionEvent e) {
		dataFieldListModel.removeElement(txtDataFieldName.getText().trim());
	}
	
	//Toggle CheckBox of PickList
	/*
	 * When pick list is enabled, by default DataType should be string and checkbox such as 
	 * Primary, ReadOnly, MultiLine and Unique should be disabled.
	 * While Filter Field Checkbox should be enable.
	 */
	public void chkPickListItemStateChanged(java.awt.event.ItemEvent evt) {
		if (chkPickList.isSelected()) {
			dataTypeCombo.setEnabled(false);
			pickListCombo.setEnabled(true);
			btnAddValueToPickList.setEnabled(true);
			chkDefaultValue.setEnabled(false); chkDefaultValue.setSelected(false);
			chkPrimary.setEnabled(false);chkPrimary.setSelected(false);
			chkUnique.setEnabled(false);chkUnique.setSelected(false);
			chkMultiLine.setEnabled(false);chkMultiLine.setSelected(false);
			chkFilterFields.setEnabled(true);
			chkReadOnly.setEnabled(false); chkReadOnly.setSelected(false);
			dataTypeCombo.setSelectedItem("String");
		} else {
			dataTypeCombo.setEnabled(true);
			pickListCombo.setEnabled(false);
			btnAddValueToPickList.setEnabled(false);
			chkDefaultValue.setEnabled(true);
			chkPrimary.setEnabled(true);
			chkUnique.setEnabled(true);
			chkMultiLine.setEnabled(true);
			chkFilterFields.setEnabled(false);
			chkReadOnly.setEnabled(true);
		}
	}
	
	//Add Values in Data Section
	public void btnAddValuesActionPerformed(java.awt.event.ActionEvent e) {
		frmPickListDS= new FrmPicklistDS(dataSectionPickList);
		frmPickListDS.setVisible(true);
	}
	
	//Map filter Fields
	public void btnMapFilterActionPerformed(java.awt.event.ActionEvent e) {
		frmMappingFilterFields.setVisible(true);
	}
	public void btnAdvanceActionPerformed(java.awt.event.ActionEvent e) {
		frmAdvanceDS.setVisible(true);
	}
	
	public void txtDataFieldNameKeyTyped(PropertyChangeEvent evt) {
		String sDataFieldName=txtDataFieldName.getText().trim();
		for(int i=0;i<dsDataSection.size();i++) {
		if(sDataFieldName.equals(dsDataSection.get(i).getDataFieldName())) {
			loadData();
		}
			}
	}
	/****************************************************************************************************************************/
	/*
	 * Other function
	 */
	public void clearDataSectionFields() {
		txtDataFieldName.setText("");
		dataTypeCombo.setSelectedIndex(0);
		txtDefaultValue.setText("");
		chkPickList.setSelected(false);
		chkMandatory.setSelected(false);
		chkCarryForward.setSelected(false);
		chkReadOnly.setSelected(false);
		chkPrimary.setSelected(false);
		chkUnique.setSelected(false);
		dataSectionPickList.removeAllElements();
		pickListCombo.removeAllItems();
		chkDefaultValue.setSelected(false);
		chkMultiLine.setSelected(false);
		dataSectionPickList.removeAllElements();
	}
	
	//Get FieldsName with Pick List
	public static Map<String, ArrayList<String>> getDataFieldsWithPickList() {
		Map dataFieldsWithPickList = new LinkedHashMap<String, ArrayList<String>>();
		for(int i=0;i<dsDataSection.size();i++) {
			if(dsDataSection.get(i).getPickListValue().size()>0) {
				dataFieldsWithPickList.put(dsDataSection.get(i).getDataFieldName(), dsDataSection.get(i).getPickListValue());
			}
		}
		return dataFieldsWithPickList;
	}
	
	//load data back to the fields
	public void loadData() {
		String dataFieldName = dataFieldList.getSelectedValue();
		//System.out.println(dataFieldName);
		for(int i=0;i<dsDataSection.size();i++) {
			//System.out.println(dsDataSection.get(i).getDataFieldName());
			if(dsDataSection.get(i).getDataFieldName().equalsIgnoreCase(dataFieldName)) {
				//System.out.println("Inside if");
				txtDataFieldName.setText(dataFieldName);
				dataTypeCombo.setSelectedItem(dsDataSection.get(i).getDataType());
				if(!dsDataSection.get(i).getDefaultValue().equals("")) {
				txtDefaultValue.setText(dsDataSection.get(i).getDefaultValue());
				chkDefaultValue.setSelected(true);
				}
				if(!dsDataSection.get(i).getPickListValue().isEmpty()) {
					chkPickList.setSelected(true);
					for(int j=0;j<dsDataSection.get(i).getPickListValue().size();j++) {
						pickListCombo.addItem(dsDataSection.get(i).getPickListValue().get(j));
						dataSectionPickList.addElement(dsDataSection.get(i).getPickListValue().get(j));
					}
				}
				else {
					pickListCombo.removeAllItems();
					dataSectionPickList.removeAllElements();
				}
				chkMandatory.setSelected(dsDataSection.get(i).isMandatory());
				chkCarryForward.setSelected(dsDataSection.get(i).isCarryForward());
				chkPrimary.setSelected(dsDataSection.get(i).isPrimary());
				chkUnique.setSelected(dsDataSection.get(i).isUnique());
				chkReadOnly.setSelected(dsDataSection.get(i).isReadOnly());
				chkMultiLine.setSelected(dsDataSection.get(i).isMultiLine());
				break;
			}
		}
	}
}
