package chang.alejandro.client.service.ticket;

import chang.alejandro.shared.domain.TicketData;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>TicketService</code>.
 * @version 1.0 (21/08/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public interface TicketServiceAsync {
	void registerTicket(TicketData ticket, AsyncCallback<TicketData> callback)
			throws IllegalArgumentException;
	
	void getTickets(AsyncCallback<TicketData[]> callback)
			throws IllegalArgumentException;
	
	void dispatchTicket(TicketData ticket, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
