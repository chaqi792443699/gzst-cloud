package cn.gov.gzst.admin.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dict implements Serializable {

	/** 键值名称 */
	private String label;
	/** 值 */
	private String value;
	private String code;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
