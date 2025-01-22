package com.gyunpang.be.common.util;

import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

public class CommonUtil {

	public static String passwordEncoder(String plainPassword) {
		return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
	}

	public static boolean passwordMatches(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword); // 비밀번호 검증
	}

	public static String makeRandomPassword() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 12);
	}
}
