package com.auctionspace.utils;

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;

import com.auctionspace.model.ItemsModel;    

public class EmailUtils {

	public void send(String to, ItemsModel item){  
		
		String from = "email.auctionspace@gmail.com";
		String password = "Qrrv159+";
		
		//Get properties object    
		Properties props = new Properties();    
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465");    
		
		//get Session   
		Session session = Session.getDefaultInstance(props,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(from,password);  
			}    
		});    
		//compose message    
		try {    
			MimeMessage message = new MimeMessage(session);    
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
			message.setSubject("Your product is sold.");    
			message.setText(item.getItemDisplayName() + "is sold.");    
			//send message  
			Transport.send(message);    
			System.out.println("message sent successfully");    
		} catch (MessagingException e) {throw new RuntimeException(e);}    

	} 
	
}
