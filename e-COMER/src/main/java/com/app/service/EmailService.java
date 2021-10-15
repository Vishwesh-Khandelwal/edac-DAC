package com.app.service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	public String sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		System.out.println("Hiii");

		message.setFrom("vishweshk48@gmail.com");
		message.setTo("vineetonline94@gmail.com");
		message.setSubject("Hall Ticket for Online Examination");
		message.setText(
				"This is your automatically generated hall ticket for the upcoming online exam.Have one copy for of this during the examination "
						+ "to avoid any problems during verification");

	 	javaMailSender.send(message);
		System.out.println("Hello");
		return "Mail sent successfully";
	}

	public String sendEmailwithAttachment() {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();

			MimeMessageHelper messageHelper = new MimeMessageHelper(message);

			messageHelper.setFrom("vishweshkhandelwal551@gmail.com");
			messageHelper.setTo("vineetonline94@gmail.com");
			messageHelper.setSubject("Hall Ticket for Online Examination");
			messageHelper.setText(
					"This is your automatically generated hall ticket for the upcoming online exam.Have one copy for of this during the examination \"\r\n"
							+ "to avoid any problems during verification");

			File file = new File("A:/cdac/hallticket.txt");

			messageHelper.addAttachment(file.getName(), file);

			javaMailSender.send(message);
			System.out.println("With Attachment");
			return "Mail sent successfully";

		} catch (Exception e) {
			return "Mail sent failed";
		}
	}
}
