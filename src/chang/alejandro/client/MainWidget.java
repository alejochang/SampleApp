package chang.alejandro.client;

import chang.alejandro.client.service.ticket.TicketServiceAsync;
import chang.alejandro.client.widgets.ticket.TicketCardInfoWidget;
import chang.alejandro.client.widgets.ticket.TicketWidget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @version 1.0 (20/08/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 * 
 * 
 */
public class MainWidget extends Composite {

	private final StackPanel mainPanel;
	
	private final TicketServiceAsync ticketService;

	public MainWidget(TicketServiceAsync theTicketService) {
		
		this.ticketService = theTicketService;

		this.mainPanel = new StackPanel();
		
		this.initWidget(this.mainPanel);
		
		this.buildWidget();
	}

	public void buildWidget() {
		
		Widget ticketCaptureWidget = new TicketWidget(ticketService);

		Widget monitoringWidget = new TicketCardInfoWidget(ticketService);
		
		this.mainPanel.add(ticketCaptureWidget, SampleAppResources.getMessages().getTicketCreation());
		
		this.mainPanel.add(monitoringWidget, SampleAppResources.getMessages().getTicketInfoCard());

		this.mainPanel.addStyleName("basePanelStyle");
		
		TicketUIMediator.getInstance().registerTabContainer(this.mainPanel);

	}
}
