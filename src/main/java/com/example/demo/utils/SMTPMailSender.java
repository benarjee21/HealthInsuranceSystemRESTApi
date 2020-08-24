package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.demo.domains.HISOfficer;


@Component
public class SMTPMailSender {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public boolean sendMail(String to,String subject,String body) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);
			javaMailSender.send(msg);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
		
	}
	
	public boolean infoSendMail(HISOfficer officer)  {
	
			MimeMessage meMiMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeHelp = new MimeMessageHelper(meMiMsg);
			try {
				mimeHelp.setTo("kanuribenarjee@gmail.com");//for testing
				//mimeHelp.setTo(officer.getEmail());
				mimeHelp.setText(emailBody(officer),true);
				mimeHelp.setSubject("Activate your Account");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("catched");
			}
			
			javaMailSender.send(meMiMsg);
			return true;
		
		//return false;
		
		
	}
	
	public String emailBody(HISOfficer officer) throws IOException  {
		StringBuffer br = new StringBuffer();
		FileReader file = new FileReader("SEND-EMAIL-TEMPLATE.txt");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		 while(line!=null) {
			 br.append(line);
			 line = reader.readLine();
		 }
		reader.close();
		String mailBody = br.toString();
		mailBody = mailBody.replace("{FNAME}", officer.getFName());
		mailBody = mailBody.replace("{LNAME}", officer.getLName());
		mailBody = mailBody.replace("{EMAIL}", officer.getEmail());
		mailBody = mailBody.replace("{TEMP-PWD}",officer.getPassword());
		
		return mailBody;
		
	}

}
