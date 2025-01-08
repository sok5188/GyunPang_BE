package com.gyunpang.be.service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gyunpang.be.common.CommonCode;
import com.gyunpang.be.common.CustomException;
import com.gyunpang.be.common.util.MailFormatter;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailService {
	@Autowired
	JavaMailSender sender;

	private MimeMessage createMessage(String target, String title, String detail) throws
		MessagingException,
		UnsupportedEncodingException {

		MimeMessage message = sender.createMimeMessage();
		message.addRecipients(Message.RecipientType.TO, target);
		message.setSubject(title);

		String content = String.format(MailFormatter.template, title, detail);
		message.setText(content, "utf-8", "html");

		message.setFrom(new InternetAddress("no.reply@gyunapng.com", "공강구조대"));
		return message;
	}

	public String createCode() {
		String s = UUID.randomUUID().toString();
		return s.substring(0, Math.min(8, s.length()));
	}

	public String sendMessage(String target, String title, String text) {
		String code = createCode();
		try {
			MimeMessage message = createMessage(target, title, text);
			sender.send(message);
		} catch (Exception e) {
			log.error("Fail to send mail, cause:{}, message:{}, trace : {}", e.getCause(), e.getMessage(),
				e.getStackTrace());
			throw new CustomException(CommonCode.MAIL_STATUS_FAIL);
		}
		return code;
	}
}
