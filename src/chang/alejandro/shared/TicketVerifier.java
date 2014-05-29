package chang.alejandro.shared;

import chang.alejandro.shared.domain.TicketData;

/**
 * Validates that the ticket is valid.
 */
public class TicketVerifier {

	public static boolean isValidTicket(TicketData ticket) {
		boolean isValid = true;
		if (ticket == null) {
			isValid = false;
		}else {
			if (ticket.getCallDate()== null) {
				isValid = false;
			}else if(ticket.getCallerInfo()==null || ticket.getCallerInfo().length() < 1) {
				isValid = false;
			}else if(ticket.getDevice()==null || ticket.getDevice().length() < 1) {
				isValid = false;
			}else if(ticket.getIssue()==null || ticket.getIssue().length() < 1) {
				isValid = false;
			}else if(ticket.getLocation()==null || ticket.getLocation().length() < 1) {
				isValid = false;
			}else if(ticket.getUrgency()==null || ticket.getUrgency().length() < 1) {
				isValid = false;
			}
		}
		return isValid;
	}
}
