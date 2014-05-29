/*
 * IssueType.java
 *
 * 1.0 (21/08/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.shared.domain;

import java.io.Serializable;

import chang.alejandro.client.SampleAppResources;

/**
 * @version 1.0 (21/08/2011)
 * 
 * Represents the defined issue types for the issue ticketing system
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public enum IssueType implements Serializable {
	
	TYPE_1("1"),
	TYPE_2("2"),
	TYPE_3("3");
	
	private String id;
	
	private String name;
	
	private String desc;
	
	
	private IssueType(String id) {
		this.id = id;
		this.name = SampleAppResources.getMessages().getIssueTypeName(id);
		this.desc = SampleAppResources.getMessages().getIssueTypeDesc(id);
	}

	/**
	 * Getter of <code>id</code> property.
	 * @return <code>id</code> property value.
	 * @see #id
	 */
	
	public String getId() {
		return id;
	}

	/**
	 * Setter of <code>id</code> property.
	 * @param id The <code>id</code> to set.
	 * @see #id
	 */
	public void setId(String id) {
		this.id = id;
	
		return;
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
