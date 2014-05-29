/*
 * UrgencyLevel.java
 *
 * 1.0 (21/08/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.shared.domain;

import java.io.Serializable;

/**
 * @version 1.0 (21/08/2011)
 * 
 * Represents the defined ticket urgency levels for the issue ticketing system
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public enum UrgencyLevel implements Serializable {
	
	LOW("Low", "Low level"),
	MEDIUM("Medium", "Medium level"),
	HIGH("High", "High level");
	
	private String name;
	
	private String desc;
	
	private UrgencyLevel(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	/**
	 * Getter of <code>name</code> property.
	 * @return <code>name</code> property value.
	 * @see #name
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Setter of <code>name</code> property.
	 * @param name The <code>name</code> to set.
	 * @see #name
	 */
	public void setName(String name) {
		this.name = name;
	
		return;
	}

	/**
	 * Getter of <code>desc</code> property.
	 * @return <code>desc</code> property value.
	 * @see #desc
	 */
	
	public String getDesc() {
		return desc;
	}

	/**
	 * Setter of <code>desc</code> property.
	 * @param desc The <code>desc</code> to set.
	 * @see #desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	
		return;
	}

}
