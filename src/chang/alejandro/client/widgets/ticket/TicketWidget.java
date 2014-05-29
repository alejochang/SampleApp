package chang.alejandro.client.widgets.ticket;

import java.util.Date;

import chang.alejandro.client.SampleAppMessages;
import chang.alejandro.client.SampleAppResources;
import chang.alejandro.client.TicketUIMediator;
import chang.alejandro.client.service.ticket.TicketServiceAsync;
import chang.alejandro.client.util.FailureCallback;
import chang.alejandro.client.util.FailureCallback.AlertDialogBox;
import chang.alejandro.shared.TicketVerifier;
import chang.alejandro.shared.domain.IssueType;
import chang.alejandro.shared.domain.TicketData;
import chang.alejandro.shared.domain.UrgencyLevel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @version 1.0 (19/10/2007)
 * @author Alejandro Chang (alejochang@gmail.com)
 */

public class TicketWidget extends Composite {

	private final TicketServiceAsync ticketService;

	private Tree ticketsTree;

	private TreeItem rootTicketsItem;

	private DateLabel dateLabel;

	private ListBox comboBoxIssueType;

	private ListBox comboBoxUrgencyLevel;

	private TextBox textBoxLocation;

	private TextBox textBoxDevice;

	private TextBox textBoxCallerInfo;
	
	private boolean isOdd;

	public TicketWidget(TicketServiceAsync theTicketService) {
		this.ticketService = theTicketService;
		
		SampleAppMessages resources =  SampleAppResources.getMessages();

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);

		Label lblDate = new Label(resources.getTicketDate());
		lblDate.setStyleName("formFieldBold");
		flexTable.setWidget(0, 0, lblDate);

		dateLabel = new DateLabel();
		dateLabel.setStyleName("formFieldBold");
		dateLabel.setValue(new Date());
				
		flexTable.setWidget(0, 1, dateLabel);

		Label lblType = new Label(resources.getTicketIssueType());
		lblType.setStyleName("formFieldBold");
		flexTable.setWidget(1, 0, lblType);

		comboBoxIssueType = new ListBox();
		
		comboBoxIssueType.addItem(IssueType.TYPE_1.getName(), IssueType.TYPE_1.getId());
		
		comboBoxIssueType.addItem(IssueType.TYPE_2.getName(), IssueType.TYPE_2.getId());
		
		comboBoxIssueType.addItem(IssueType.TYPE_3.getName(), IssueType.TYPE_3.getId());
		
		flexTable.setWidget(1, 1, comboBoxIssueType);

		Label lblUrgency = new Label(resources.getTicketUrgencyLevel());
		lblUrgency.setStyleName("formFieldBold");
		flexTable.setWidget(2, 0, lblUrgency);

		comboBoxUrgencyLevel = new ListBox();
		
		comboBoxUrgencyLevel.addItem(UrgencyLevel.LOW.getName(), String.valueOf(UrgencyLevel.LOW.ordinal()));
		
		comboBoxUrgencyLevel.addItem(UrgencyLevel.MEDIUM.getName(), String.valueOf(UrgencyLevel.MEDIUM.ordinal()));
		
		comboBoxUrgencyLevel.addItem(UrgencyLevel.HIGH.getName(), String.valueOf(UrgencyLevel.HIGH.ordinal()));
		
		flexTable.setWidget(2, 1, comboBoxUrgencyLevel);

		Label lblSite = new Label(resources.getTicketLoctation());
		lblSite.setStyleName("formFieldBold");
		flexTable.setWidget(3, 0, lblSite);

		Button btnAddTicket = new Button(resources.getButtonAddTicket());
		AddTicketButtonHandler hndlr = new AddTicketButtonHandler();
		btnAddTicket.addClickHandler(hndlr);
		btnAddTicket.addKeyUpHandler(hndlr);
		flexTable.setWidget(0, 2, btnAddTicket);

		textBoxLocation = new TextBox();
		flexTable.setWidget(3, 1, textBoxLocation);

		Label lblDevice = new Label(resources.getTicketDevice());
		lblDevice.setStyleName("formFieldBold");
		flexTable.setWidget(4, 0, lblDevice);

		textBoxDevice = new TextBox();
		flexTable.setWidget(4, 1, textBoxDevice);

		Label lblNewLabel = new Label(resources.getTicketCallerInfo());
		lblNewLabel.setStyleName("formFieldBold");
		flexTable.setWidget(5, 0, lblNewLabel);

		textBoxCallerInfo = new TextBox();
		flexTable.setWidget(5, 1, textBoxCallerInfo);
		flexTable.getCellFormatter().setVerticalAlignment(0, 2,
				HasVerticalAlignment.ALIGN_BOTTOM);
		flexTable.getFlexCellFormatter().setRowSpan(0, 2, 6);
		FlexTableHelper.fixRowSpan(flexTable);

		ticketsTree = new Tree();
		verticalPanel.add(ticketsTree);

		Label tktLabel = new Label(SampleAppResources.getMessages()
				.getCardTickets());
		tktLabel.setStyleName("formFieldBold");

		rootTicketsItem = new TreeItem(tktLabel);

		ticketsTree.addItem(rootTicketsItem);

		rootTicketsItem.setWidth("100%");

		ticketsTree.setWidth("100%");
		
		TicketUIMediator.getInstance().registerTicketWidget(this);

		loadTickets();
	}
	
	class AddTicketButtonHandler implements ClickHandler, KeyUpHandler {
		/**
		 * Fired when the user clicks on the add ticket button.
		 */
		public void onClick(ClickEvent event) {
			registerTicket();
		}

		/**
		 * Fired when the user types the enter key.
		 */
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				registerTicket();
			}
		}

		/**
		 * Send the ticket to the server.
		 */
		private void registerTicket() {
			TicketData tkt = new TicketData();
			tkt.setCallDate(dateLabel.getValue());
			tkt.setIssue(comboBoxIssueType.getItemText(comboBoxIssueType.getSelectedIndex()));
			tkt.setUrgency(comboBoxUrgencyLevel.getItemText(comboBoxUrgencyLevel.getSelectedIndex()));
			tkt.setLocation(textBoxLocation.getText());
			tkt.setDevice(textBoxDevice.getText());
			tkt.setCallerInfo(textBoxCallerInfo.getText());
			
			if (!TicketVerifier.isValidTicket(tkt)) {
				AlertDialogBox alert = new AlertDialogBox(SampleAppResources.getMessages().getErrorTicketInvalid());
				
				alert.center();
				alert.getCloseButton().setFocus(true);
				alert.show();
				
				return;
			}
			
			
			ticketService.registerTicket(tkt, new FailureCallback<TicketData>() {			

			@Override
			public void onFailure(Throwable theCaught) {
				this.showFailureMessage(theCaught);
				return;
			}

			@Override
			public void onSuccess(TicketData tkn) {
				isOdd = true;
				if (tkn != null) {

					TreeItem tI = new TreeItem(new TicketInfoRow(tkn, new ViewCardHandler(tkn),  isOdd));
					tI.setUserObject(tkn);
					rootTicketsItem.addItem(tI);
					rootTicketsItem.setState(true);
					isOdd = !isOdd;
				}
				
				clearFields();
				return;
			}
		});
		}
	}

	public void loadTickets() {
		this.ticketService.getTickets(new FailureCallback<TicketData[]>() {

			@Override
			public void onFailure(Throwable theCaught) {
				this.showFailureMessage(theCaught);
				return;
			}

			@Override
			public void onSuccess(TicketData[] theResult) {
				int idx = 0;
				boolean isOdd = true;
				while (theResult != null && theResult.length > idx) {

					TicketData tkn = theResult[idx];
					TreeItem tI = new TreeItem(new TicketInfoRow(tkn, new ViewCardHandler(tkn),  isOdd));
					tI.setUserObject(tkn);
					rootTicketsItem.addItem(tI);
					rootTicketsItem.setState(true);
					idx++;
					isOdd = !isOdd;
				}
				clearFields();
				return;
			}
		});
	}
	
	public void clearFields() {
		dateLabel.setValue(new Date());
		comboBoxIssueType.setSelectedIndex(0);
		comboBoxUrgencyLevel.setSelectedIndex(0);
		textBoxLocation.setText("");
		textBoxDevice.setText("");
		textBoxCallerInfo.setText("");
	}
	
	class ViewCardHandler implements ClickHandler{
		
		private TicketData ticket;
		
		public ViewCardHandler(TicketData ticket) {
			this.ticket = ticket;
		}

		public void onClick(ClickEvent event) {
			TicketUIMediator.getInstance().notifyTicketCardSelected(this.ticket);
			TicketUIMediator.getInstance().changeStack(1);
		}
		
	}
	
	public void removeTicket(TicketData ticket) {
		int idx = 0;
		boolean tktRemoved = false;
		TreeItem item = null;
		TicketData tmpTkt = null;
		
		while(!tktRemoved && this.rootTicketsItem.getChildCount() > idx) {
			item = this.rootTicketsItem.getChild(idx);
			if(item.getUserObject() instanceof TicketData) {
				tmpTkt = (TicketData)item.getUserObject();
				if(ticket!= null && ticket.getId().equals(tmpTkt.getId())) {
					tktRemoved = true;
				}
			}
		}
		
		if(tktRemoved && item!= null) {
			this.rootTicketsItem.removeItem(item);
		}
		
		clearFields();
	}
}