package chang.alejandro.client.widgets.ticket;

import chang.alejandro.client.SampleAppMessages;
import chang.alejandro.client.SampleAppResources;
import chang.alejandro.client.TicketUIMediator;
import chang.alejandro.client.service.ticket.TicketServiceAsync;
import chang.alejandro.client.util.FailureCallback;
import chang.alejandro.shared.TicketVerifier;
import chang.alejandro.shared.domain.TicketData;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @version 1.0 (19/10/2007)
 * @author Alejandro Chang (alejandro.chang@smartmatic.com)
 */

public class TicketCardInfoWidget extends Composite implements ITicketCardListener{


	private DateLabel dateLabel;
	private Label issueTypeResultLbl;
	private Label urgencyLevelResultLbl;
	private Label locationResultLbl;
	private Label deviceResultLbl;
	private Label callerInfoResultLbl;
	private Button dispatchTicketBtn;

	private TicketServiceAsync ticketService;
	private TicketData ticket;

	public TicketCardInfoWidget(TicketServiceAsync ticketService) {
		
		this.ticketService = ticketService;
		
		SampleAppMessages resource = SampleAppResources.getMessages();
				
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		
		Label lblDate = new Label(resource.getTicketDate());
		flexTable.setWidget(1, 0, lblDate);
		
		dateLabel = new DateLabel();
		flexTable.setWidget(1, 1, dateLabel);
		
		Label lblNewLabel_3 = new Label(resource.getTicketIssueType());
		flexTable.setWidget(2, 0, lblNewLabel_3);
		
		issueTypeResultLbl = new Label("");
		flexTable.setWidget(2, 1, issueTypeResultLbl);
		
		Label urgencyLevelLbl = new Label(resource.getTicketUrgencyLevel());
		flexTable.setWidget(3, 0, urgencyLevelLbl);
		
		urgencyLevelResultLbl = new Label("");
		flexTable.setWidget(3, 1, urgencyLevelResultLbl);
		
		Label locationLbl = new Label(resource.getTicketLoctation());
		flexTable.setWidget(4, 0, locationLbl);
		
		locationResultLbl = new Label("");
		flexTable.setWidget(4, 1, locationResultLbl);
		
		Label deviceLbl = new Label(resource.getTicketDevice());
		flexTable.setWidget(5, 0, deviceLbl);
		
		deviceResultLbl = new Label("");
		flexTable.setWidget(5, 1, deviceResultLbl);
		
		Label callerInfoLbl = new Label(resource.getTicketCallerInfo());
		flexTable.setWidget(6, 0, callerInfoLbl);
		
		callerInfoResultLbl = new Label("");
		flexTable.setWidget(6, 1, callerInfoResultLbl);
		
		dispatchTicketBtn = new Button(resource.getButtonDispatchTicket());
		flexTable.setWidget(6, 2, dispatchTicketBtn);
		flexTable.getCellFormatter().setVerticalAlignment(6, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		FlexTableHelper.fixRowSpan(flexTable);
		
		dispatchTicketBtn.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				if(TicketVerifier.isValidTicket(ticket)) {
					TicketCardInfoWidget.this.ticketService.dispatchTicket(ticket, new FailureCallback<String>() {

						@Override
						public void onSuccess(String theResult) {
							
							TicketUIMediator.getInstance().removeTicketFromTicketWidget(ticket);
							clearFields();
							TicketUIMediator.getInstance().changeStack(0);
							return;
						}
						
					});	
				}
			}
		});
		
		TicketUIMediator.getInstance().addITicketCardListener(this);
	}


	public void fillCard(TicketData ticket) {
		if(TicketVerifier.isValidTicket(ticket)) {
			this.ticket = ticket;
			this.dateLabel.setValue(ticket.getCallDate());
			this.issueTypeResultLbl.setText(ticket.getIssue());
			this.urgencyLevelResultLbl.setText(ticket.getUrgency());
			this.locationResultLbl.setText(ticket.getLocation());
			this.deviceResultLbl.setText(ticket.getDevice());
			this.callerInfoResultLbl.setText(ticket.getCallerInfo());
		}else {
//			Error handling
			clearFields();
		}
		
		return;
		
	}
	
	public void clearFields() {
		this.dateLabel.setValue(null);
		this.issueTypeResultLbl.setText("");
		this.urgencyLevelResultLbl.setText("");
		this.locationResultLbl.setText("");
		this.deviceResultLbl.setText("");
		this.callerInfoResultLbl.setText("");
	}
}
