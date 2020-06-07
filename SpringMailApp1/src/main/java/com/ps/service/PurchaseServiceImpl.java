package com.ps.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private JavaMailSender sender;

	@Override
	public String purchase(String[] items, float[] prices, String toMail) throws Exception {
		float total=0.0f;
		String msg=null;
		String status=null;
		//calc bill amount
		for(int i=0;i<prices.length;++i) {
			total+=prices[i];
		}
		//prepare msg
		msg=Arrays.deepToString(items)+" are purchased having bill Amount "+total+" with order id "+new Random().nextInt(100000);
		status=sendEmail(msg, toMail);
		return msg+" ------> "+status;
	}
	
	private String sendEmail(String msg,String toMail)throws Exception{
		MimeMessageHelper helper=null;
		MimeMessage message=null;
		
		//prepare Email messages
		message=sender.createMimeMessage();
		helper=new MimeMessageHelper(message,true);
		helper.setFrom(new InternetAddress("pravinkr98@gmail.com"));
		helper.setTo(new InternetAddress(toMail));
		helper.setSubject("Your friend message, it is very important");
		helper.setText(msg);
		helper.setSentDate(new Date());
		helper.addAttachment("friend.jpg", new ClassPathResource("friend.jpg"));
		sender.send(message);
		return "mail has been delivered";
		
	}

}
