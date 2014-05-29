/*
 * DataTestController.java
 *
 * 1.0 (21/08/2011)
 *
 * Alejandro Chang (alejochang@gmail.com) 
 */

package chang.alejandro.server.utils;

import chang.alejandro.shared.domain.TicketData;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * @version 1.0 (21/08/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public class DataTestController {
 
    public static void registerDomainClasses() {
    	ObjectifyService.register(TicketData.class);
	}
	
	public static Objectify getDataStore() {
		return ObjectifyService.begin();
	}
}
