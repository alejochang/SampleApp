
package chang.alejandro.client.widgets.ticket;

import chang.alejandro.shared.domain.TicketData;

import com.google.gwt.user.client.EventListener;

/**
 * @version 1.0 (21/08/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public interface ITicketCardListener extends EventListener {
    public void fillCard(TicketData ticket);
}
