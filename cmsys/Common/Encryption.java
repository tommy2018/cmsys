package cmsys.Common;

import java.io.*;
import java.security.*;

public class Encryption {
	public static String sha256(String data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			StringBuilder hash = new StringBuilder();
			byte[] hashedData = digest.digest(data.getBytes("UTF-8"));

			for (byte b : hashedData)
				hash.append(String.format("%02X", b));

			return hash.toString();
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}
}
