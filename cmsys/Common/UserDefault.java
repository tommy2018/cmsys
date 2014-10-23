package cmsys.Common;

import java.util.*;

public class UserDefault {
	private static UserDefault userDefault;
	private Map<String, Object> map;
	
	private UserDefault() {
		map = new HashMap<String, Object>();
	}
	
	public static UserDefault getInstance() {
		if (userDefault == null)
			userDefault = new UserDefault();
		return userDefault;
	}
	
	public Object getObj(String key) {
		return map.get(key); 
	}
	
	public void putObj(String key, Object obj) {
		map.put(key,  obj);
	}
}
