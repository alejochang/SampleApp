package chang.alejandro.server;

import chang.alejandro.client.service.ticket.TicketService;
import chang.alejandro.server.utils.DataTestController;
import chang.alejandro.shared.TicketVerifier;
import chang.alejandro.shared.domain.TicketData;

import com.google.appengine.api.datastore.QueryResultIterable;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TicketServiceImpl extends RemoteServiceServlet implements
		TicketService {
	
	static{
		DataTestController.registerDomainClasses();
	}

	public TicketData registerTicket(TicketData ticket)
			throws IllegalArgumentException {
		
		if (!TicketVerifier.isValidTicket(ticket)) {
			// If the ticket is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"The ticket information is invalid");
		}	
			
		DataTestController.getDataStore().put(ticket);
		
		return ticket;
	}

	public TicketData[] getTickets() throws IllegalArgumentException {
		
		Objectify dS = DataTestController.getDataStore();
		
		QueryResultIterable<Key<TicketData>> iterableKeys = dS.query(TicketData.class).fetchKeys();
		
		if(iterableKeys!= null && iterableKeys.iterator().hasNext()) {
//			return dS.get(iterableKeys).values().toArray(new TicketData[0]);
			dS.delete(iterableKeys);
			return null;
		}else {
			return null;
		}
	}

	public String dispatchTicket(TicketData ticket)
			throws IllegalArgumentException {
		String result = "Success";
		try {
			DataTestController.getDataStore().delete(
				    new Key<TicketData>(TicketData.class, ticket.getId()));	
		}catch (Exception e) {
			result = e.getMessage();
		}
		
		return result;
		
	}	
}
