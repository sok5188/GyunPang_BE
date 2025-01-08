package com.gyunpang.be;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void stringFormat() {
		String template = "<html>" +
			"<head>" +
			"<body>" +
			"<style>" +
			"body { font-family: Arial, sans-serif; background-color: #e0f7e0; color: #2e7d32; }" +
			".container { width: 100%%; max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }"
			+
			"h1 { color: #388e3c; }" +
			"p { color: #388e3c; }" +
			".footer { margin-top: 20px; font-size: 12px; color: #66bb6a; }" +
			"</style>" +
			"</head>" +
			"#;ㄴ;a;a;" +
			"<div class='container'>" +
			"<h1>%s</h1>" +  // 제목
			"<p>%s</p>" +    // 본문
			"<div class='footer'>" +
			"<p>이 메일은 자동 생성된 메일입니다. 본 메일에 대한 답변은 받지 않습니다.</p>" +
			"</div>" +
			"</div>" +
			"</body>" +
			"</html>";

		String format = String.format(template, "title!!", "detail~~");
		System.out.println("format = " + format);
	}
}

// 	+
