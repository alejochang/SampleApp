package chang.alejandro.client;

import chang.alejandro.client.service.ticket.TicketService;
import chang.alejandro.client.service.ticket.TicketServiceAsync;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SampleApp implements EntryPoint {
	
	/**
	 * Create a remote service proxy to talk to the server-side service.
	 */
	private final TicketServiceAsync ticketService = GWT
			.create(TicketService.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		
		MainWidget mW = new MainWidget(this.ticketService);

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("mainArea");
		rootPanel.add(mW);
	}
}
