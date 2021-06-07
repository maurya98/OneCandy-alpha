package entityStructure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataSection {
	private String sDataFieldName;
	private String sDataType;
	private ArrayList<String> arrLPickListValue;
	private String sDefaultValue;
	private boolean bMandatory;
	private boolean bCarryForward;
	private boolean bReadOnly;
	private boolean bPrimary;
	private boolean bUnique;
	private boolean bMultilLine;
	private Map<String, ArrayList<String>> mFilterFields;
	Map<String, Object> dsDataSection = new LinkedHashMap<String, Object>();
	
	public void associateValue(String sDataFieldName, String sDataType, ArrayList<String> arrLPickListValue, String sDefaultValue, boolean bCarryForward,
			boolean bMandatory, boolean bReadOnly, boolean bPrimary, boolean bUnique, boolean bMultilLine, Map<String, ArrayList<String>> mFilterFields) {
		this.sDataFieldName = sDataFieldName;
		this.sDataType=sDataType;
		this.arrLPickListValue=arrLPickListValue;
		this.sDefaultValue=sDefaultValue;
		this.bMandatory=bMandatory;
		this.bCarryForward=bCarryForward;
		this.bReadOnly=bReadOnly;
		this.bPrimary=bPrimary;
		this.bUnique=bUnique;
		this.bMultilLine=bMultilLine;
		this.mFilterFields=mFilterFields;
		
	}

	public String getDataFieldName() {
		return sDataFieldName;
	}

	public void setDataFieldName(String sDataFieldName) {
		this.sDataFieldName = sDataFieldName;
	}

	public String getDataType() {
		return sDataType;
	}

	public void setDataType(String sDataType) {
		this.sDataType = sDataType;
	}

	public ArrayList<String> getPickListValue() {
		return arrLPickListValue;
	}

	public void setPickListValue(ArrayList<String> arrLPickListValue) {
		this.arrLPickListValue = arrLPickListValue;
	}

	public String getDefaultValue() {
		return sDefaultValue;
	}

	public void setDefaultValue(String sDefaultValue) {
		this.sDefaultValue = sDefaultValue;
	}

	public boolean isMandatory() {
		return bMandatory;
	}

	public void setMandatory(boolean bMandatory) {
		this.bMandatory = bMandatory;
	}

	public boolean isCarryForward() {
		return bCarryForward;
	}

	public void setCarryForward(boolean bCarryForward) {
		this.bCarryForward = bCarryForward;
	}

	public boolean isReadOnly() {
		return bReadOnly;
	}

	public void setReadOnly(boolean bReadOnly) {
		this.bReadOnly = bReadOnly;
	}

	public boolean isPrimary() {
		return bPrimary;
	}

	public void setPrimary(boolean bPrimary) {
		this.bPrimary = bPrimary;
	}

	public boolean isUnique() {
		return bUnique;
	}

	public void setUnique(boolean bUnique) {
		this.bUnique = bUnique;
	}

	public boolean isMultiLine() {
		return bMultilLine;
	}

	public void setMultiLine(boolean bMultilLine) {
		this.bMultilLine = bMultilLine;
	}

	public Map<String, ArrayList<String>> getFilterFields() {
		return mFilterFields;
	}

	public void setFilterFields(Map<String, ArrayList<String>> mFilterFields) {
		this.mFilterFields = mFilterFields;
	}

	public Map<String, Object> getDataSection() {
		return dsDataSection;
	}

	public void setDataSection(Map<String, Object> dsDataSection) {
		this.dsDataSection = dsDataSection;
	}

}
