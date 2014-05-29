package chang.alejandro.client.service.ticket;

import chang.alejandro.shared.domain.TicketData;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC ticket service.
 * @version 1.0 (21/08/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
@RemoteServiceRelativePath("ticket")
public interface TicketService extends RemoteService {
	
	TicketData registerTicket(TicketData ticket) throws IllegalArgumentException;
	
	TicketData[] getTickets()
			throws IllegalArgumentException;
	
	String dispatchTicket(TicketData ticket)
			throws IllegalArgumentException;
	
	
}
