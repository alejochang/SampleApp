package chang.alejandro.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import chang.alejandro.client.widgets.ticket.ITicketCardListener;
import chang.alejandro.client.widgets.ticket.TicketWidget;
import chang.alejandro.shared.domain.TicketData;

import com.google.gwt.user.client.ui.StackPanel;

/**
 * TicketUIMediator implements the Mediator pattern. 
 * It provides interoperability between all the UI subcomponents
 * of the application
 * 
 * @version 1.0 (21/08/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 * 
 */
public class TicketUIMediator {

	/**
	 * A reference to the singleton pattern instance
	 */
	private static TicketUIMediator instance = new TicketUIMediator();

	/**
	 * Ticket card selected listeners list 
	 */	
	private List<ITicketCardListener> ticketCardListeners;

	/**
	 * Reference to the main container
	 */
	private StackPanel tabContainer;

	/**
	 * Reference to the ticket widget
	 */
	private TicketWidget ticketWidget;

	/**
	 * 
	 * @return
	 */
	public static TicketUIMediator getInstance() {
		return TicketUIMediator.instance;
	}

	private TicketUIMediator() {

		this.ticketCardListeners = new ArrayList<ITicketCardListener>();
	}

	public void addITicketCardListener(ITicketCardListener listener) {
		this.ticketCardListeners.add(listener);
	}

	public void removeITicketCardListener(ITicketCardListener listener) {
		this.ticketCardListeners.remove(listener);
	}

	/**Notify when a ticket is selected*/
	public void notifyTicketCardSelected(TicketData ticket) {
		Iterator<ITicketCardListener> iter = this.ticketCardListeners
				.iterator();
		while (iter.hasNext()) {
			iter.next().fillCard(ticket);
		}
	}

	public void registerTabContainer(StackPanel tabContainer) {
		this.tabContainer = tabContainer;
	}

	public void viewTicketCard(TicketData ticket) {
		this.notifyTicketCardSelected(ticket);
	}

	/**Change the stack to be shown in the main view*/
	public void changeStack(int stackIdx) {
		this.tabContainer.showStack(stackIdx);
	}

	public void registerTicketWidget(TicketWidget ticketWidget) {
		this.ticketWidget = ticketWidget;
	}
	
	public void removeTicketFromTicketWidget(TicketData ticket) {
		ticketWidget.removeTicket(ticket);
	}
}
