package cmsys.Common;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Time {
	static public String toDate(long timestamp) {
		Date date = new Date(timestamp);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");
		String formattedDate = dateFormat.format(date);
		
		return formattedDate;
	}
	
	static public long timestamp() {
		java.util.Date date= new java.util.Date();
		return new Timestamp(date.getTime()).getTime();
	}
}
