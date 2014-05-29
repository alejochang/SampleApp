package chang.alejandro.shared.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class TicketData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4647421193344914820L;

	@Id
	private Long id;
	
	private Date callDate;
	
	private String callerInfo;
	
	private String issue;
	
	private String location;
	
	private String device;
	
	private String urgency;
	
	/**
	 * Getter of <code>id</code> property.
	 * @return <code>id</code> property value.
	 * @see #id
	 */
	
	public Long getId() {
		return id;
	}

	/**
	 * Setter of <code>id</code> property.
	 * @param id The <code>id</code> to set.
	 * @see #id
	 */
	public void setId(Long id) {
		this.id = id;
	
		return;
	}

	/**
	 * Getter of <code>callDate</code> property.
	 * @return <code>callDate</code> property value.
	 * @see #callDate
	 */
	
	public Date getCallDate() {
		return callDate;
	}

	/**
	 * Setter of <code>callDate</code> property.
	 * @param callDate The <code>callDate</code> to set.
	 * @see #callDate
	 */
	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	
		return;
	}

	/**
	 * Getter of <code>callerInfo</code> property.
	 * @return <code>callerInfo</code> property value.
	 * @see #callerInfo
	 */
	
	public String getCallerInfo() {
		return callerInfo;
	}

	/**
	 * Setter of <code>callerInfo</code> property.
	 * @param callerInfo The <code>callerInfo</code> to set.
	 * @see #callerInfo
	 */
	public void setCallerInfo(String callerInfo) {
		this.callerInfo = callerInfo;
	
		return;
	}

	/**
	 * Getter of <code>issue</code> property.
	 * @return <code>issue</code> property value.
	 * @see #issue
	 */
	
	public String getIssue() {
		return issue;
	}

	/**
	 * Setter of <code>issue</code> property.
	 * @param issue The <code>issue</code> to set.
	 * @see #issue
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	
		return;
	}

	/**
	 * Getter of <code>location</code> property.
	 * @return <code>location</code> property value.
	 * @see #location
	 */
	
	public String getLocation() {
		return location;
	}

	/**
	 * Setter of <code>location</code> property.
	 * @param location The <code>location</code> to set.
	 * @see #location
	 */
	public void setLocation(String location) {
		this.location = location;
	
		return;
	}

	/**
	 * Getter of <code>device</code> property.
	 * @return <code>device</code> property value.
	 * @see #device
	 */
	
	public String getDevice() {
		return device;
	}

	/**
	 * Setter of <code>device</code> property.
	 * @param device The <code>device</code> to set.
	 * @see #device
	 */
	public void setDevice(String device) {
		this.device = device;
	
		return;
	}

	/**
	 * Getter of <code>urgency</code> property.
	 * @return <code>urgency</code> property value.
	 * @see #urgency
	 */
	
	public String getUrgency() {
		return urgency;
	}

	/**
	 * Setter of <code>urgency</code> property.
	 * @param urgency The <code>urgency</code> to set.
	 * @see #urgency
	 */
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	
		return;
	}
}
