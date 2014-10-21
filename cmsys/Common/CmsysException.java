package cmsys.Common;

import java.util.*;

public class CmsysException extends Exception {
	private static final long serialVersionUID = 141383655304811698L;
	private int errorCode;
	static private Map<Integer, String> messages;
	
	public CmsysException(int errorCode) {
		if (messages == null)
			initMessages();
		
		this.errorCode = errorCode;
	}
	
	public String getMessage() {
		return "ERROR: " + messages.get(errorCode);
	}
	
	private void initMessages() {
		messages = new HashMap<Integer, String>();
		
		messages.put(0, "Settings file format incorrect");
		messages.put(1, "Settings file not found");
		messages.put(2, "Unable to load the settings file");
		messages.put(24, "SQL Exception");
		messages.put(31, "Unable to get the file");
		messages.put(32, "Unable to save the file");
	}
}
