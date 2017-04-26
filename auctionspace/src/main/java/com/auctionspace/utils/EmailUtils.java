package com.auctionspace.utils;

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;

import org.apache.catalina.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.BidModel;
import com.auctionspace.model.ItemsModel;
import com.auctionspace.model.UserModel;

public class EmailUtils {
	private static Logger logger = Logger.getLogger(EmailUtils.class);
	public void send(String to, String itemName, float bidAmount){  
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

			message.setSubject("Bid on " + itemName);    
			message.setText("A new bid of $"+bidAmount+" has been placed on your item " +itemName);    

			//send message  
			Transport.send(message);    
			System.out.println("message sent successfully");    
		} catch (MessagingException e) {throw new RuntimeException(e);}    

	}

	public boolean sendBuyerDetails(String to, ItemsModel itemInfo, BidModel bidInfo, UserModel userInfo) {  
		String from = "email.auctionspace@gmail.com";
logger.info("In sendBuyerDetails");
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
			message.setSubject("Auction Completed: Product " + itemInfo.getItemDisplayName() 
			+ " sold to " + userInfo.getFname() + " " + userInfo.getLname());    
			message.setText("Details of auction\nProduct Name: " + itemInfo.getItemDisplayName() 
			+ "\nProduct Description: " + itemInfo.getDescription() + "\nAuction price: " + bidInfo.getbid_amount() 
			+ "\nBuyer Name: " + userInfo.getFname() + " " + userInfo.getLname() + "\n");    
			//send message  
			Transport.send(message);    
			System.out.println("message sent successfully");
			return true;
		} catch (MessagingException e) {
			return false;
		}    

	}
}
