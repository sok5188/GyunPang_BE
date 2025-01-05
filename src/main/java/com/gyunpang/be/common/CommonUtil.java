package com.gyunpang.be.common;

import java.util.UUID;

public class CommonUtil {
	public static String passwordEncoder(String plainPassword) {
		//TODO : Need to Encrypt ..
		String encryptedPassword = plainPassword + "enc";
		return encryptedPassword;
	}

	public static String makeRandomPassword() {
		//TODO : Need to make some encrypt
		return UUID.randomUUID().toString();
	}

}
