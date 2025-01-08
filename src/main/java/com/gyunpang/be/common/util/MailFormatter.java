package com.gyunpang.be.common.util;

public class MailFormatter {
	public static String template = "<html>" +
		"<head>" +
		"<style>" +
		"body { font-family: Arial, sans-serif; background-color: #e0f7e0; color: #2e7d32; }" +
		".container { width: 100%%; max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }"
		+
		"h1 { color: #388e3c; }" +
		"p { color: #388e3c; }" +
		".footer { margin-top: 20px; font-size: 12px; color: #66bb6a; }" +
		"</style>" +
		"</head>" +
		"<body>" +
		"<div class='container'>" +
		"<h1>%s</h1>" +  // 제목
		"<p>%s</p>" +    // 본문
		"<div class='footer'>" +
		"<p>이 메일은 자동 생성된 메일입니다. 본 메일에 대한 답변은 받지 않습니다.</p>" +
		"</div>" +
		"</div>" +
		"</body>" +
		"</html>";

	public static String authTemplate = "Gyunpang 인증 코드 입니다 아래 코드를 입력 칸에 넣어주세요\n 코드 : %s";
	public static String authTitle = "Gyunpang 인증 코드 입니다";

	public static String findPasswordTemplate = "Gyunpang 비밀번호 초기화 안내 메일입니다.\n아래 비밀번호로 로그인 후 비밀번호를 꼭 변경해주세요\n 임시 비밀번호 : %s";
	public static String findPasswordTitle = "Gyunpang 비밀번호 초기화 안내";

}
