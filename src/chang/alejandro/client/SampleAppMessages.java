package chang.alejandro.client;

import com.google.gwt.i18n.client.Messages;


/**
 * Interface that facilitates local-sensitive, compile-time binding of messages
 * supplied by the properties files.
 * 
 * @version 1.0 (21/08/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public interface SampleAppMessages extends Messages {
	
	@Key(value = "title.alert.dialog")    
    /** @return Title for an alert dialog box */
    public String getTitleAlertDialog();

	@Key(value = "message.functionality.disabled")    
    /** @return Message for a functionality disabled */
    public String getMessageFunctionalityDisabled();
	
	@Key(value = "text.ok.button")    
    /** @return Text for an OK button */
    public String getTextOkButton();
	
	@Key(value = "card.standard.code")    
    /** @return Standard code text */
    public String getCardStandardCode();
	
	@Key(value = "card.standard.description")    
    /** @return Standard description text */
    public String getCardStandardDescription();
	
	@Key(value = "card.standard.go.to.card")    
    /** @return Standard go to card text */
    public String getCardStandardGoToCard();
	
	@Key(value = "card.standard.name")    
    /** @return Standard name text */
    public String getCardStandardName();
	
	@Key(value = "card.standard.results")    
    /** @return Standard results text */
    public String getCardStandardResults();
	
	@Key(value = "card.standard.status")    
    /** @return Standard status text */
    public String getCardStandardStatus();
	
	@Key(value = "card.standard.type")    
    /** @return Standard type text */
    public String getCardStandardType();
	
	@Key(value = "card.site.address")    
    /** @return Site address text */
    public String getCardSiteAddress();
	
	@Key(value = "card.tickets")    
    /** @return Tickets text */
    public String getCardTickets();
	
	@Key(value = "button.standard.cancel")    
    /** @return Text for a standard cancel button */
    public String getButtonStandardCancel();
	
	@Key(value = "button.standard.close")    
	/** @return Text for a standard close button */
    public String getButtonStandardClose();
	
	@Key(value = "button.standard.open")    
	/** @return Text for a standard open button */
    public String getButtonStandardOpen();
	
	/**
	 * @param issueId The issue identifier
	 * @return Text for the issue type name.
	 */
	@Key(value = "issue.type.name")
    public String getIssueTypeName(String issueId);
	
	/**
	 * @param issueId The issue identifier
	 * @return Text for the issue type descriptions.
	 */
	@Key(value = "issue.type.desc")
    public String getIssueTypeDesc(String issueId);
	
	
	@Key(value = "ticket.id")    
	/** @return Text for ticket ID field */
    public String getTicketId();
	
	@Key(value = "ticket.date")    
	/** @return Text for ticket date field */
    public String getTicketDate();
	
	@Key(value = "ticket.caller.info")    
	/** @return Text for ticket caller info. field */
    public String getTicketCallerInfo();
	
	@Key(value = "ticket.issue.type")    
	/** @return Text for ticket issue type field */
    public String getTicketIssueType();
	
	@Key(value = "ticket.location")    
	/** @return Text for ticket location field */
    public String getTicketLoctation();
	
	@Key(value = "ticket.device")    
	/** @return Text for ticket device field */
    public String getTicketDevice();
	
	@Key(value = "ticket.urgency.level")    
	/** @return Text for ticket urgency level field */
    public String getTicketUrgencyLevel();
	
	@Key(value = "button.add.ticket")    
    /** @return Text for the add ticket button */
    public String getButtonAddTicket();
	
	@Key(value = "button.dispatch.ticket")    
    /** @return Text for the dispatch ticket button */
    public String getButtonDispatchTicket();
		
	@Key(value = "error.ticket.invalid")    
    /** @return Text for an invalid ticket */
    public String getErrorTicketInvalid();
	
	@Key(value = "ticket.title.creation")    
    /** @return Text for title of the ticket creation stack */
    public String getTicketCreation();
	
	@Key(value = "ticket.title.info.card")    
    /** @return Text for title of the ticket info card stack */
    public String getTicketInfoCard();
	
}
