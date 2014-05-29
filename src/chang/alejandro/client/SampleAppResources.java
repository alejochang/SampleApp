package chang.alejandro.client;

import com.google.gwt.core.client.GWT;

/**
 * Allows the access to an unique instance of SampleAppMessages
 * 
 * @version 1.0 (20/08/2011)
 * 
 * @author Alejandro Chang (alejochang@gmail.com)
 *
 */
public class SampleAppResources {
	
	static private SampleAppMessages messages = null;

    private SampleAppResources() { }

    static public SampleAppMessages getMessages() {
    	if (messages == null){
    		messages = (SampleAppMessages) GWT.create(SampleAppMessages.class);
    	}
        return messages;
    }

}
