package com.auctionspace.utils;

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.BidModel;
import com.auctionspace.model.ItemsModel;
import com.auctionspace.model.UserModel;

//import com.auctionspace.model.ItemsModel;    

public class EmailUtils {
	@Autowired
	public ItemsDao itemService;	
	@Autowired
	public ManageUsersDao userService;
	@Autowired
	public BidDao bidService;

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


	public void sendBuyerDetails(int itemId){  
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

			//get the seller email id from seller name
			String to = userService.getUserEmailId(itemService.getSeller(itemId));

			//get item details from the item table
			ItemsModel itemInfo = itemService.getItemDetails(Integer.toString(itemId));

			//get username from the bid table
			BidModel bidInfo = bidService.getWinningBid(itemId);

			//get the buyer details from the bid table
			UserModel userInfo = userService.getUserDetails(bidInfo.getusername());

			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    

			message.setSubject("Auction Completed: Product " + itemInfo.getItemDisplayName() + " sold to " + userInfo.getFname() + " " + userInfo.getLname());    
			message.setText("Details of auction\nAuction price: " 
					+ bidInfo.getbid_amount() + "\nBuyer Name: " + userInfo.getFname() + " " + userInfo.getLname() + "\n");    

			//send message  
			Transport.send(message);    
			System.out.println("message sent successfully");    
		} catch (MessagingException e) {throw new RuntimeException(e);}    

	} 

}
