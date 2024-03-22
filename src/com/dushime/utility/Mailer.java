package com.dushime.utility;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mailer {
	private final String host = "smtp.gmail.com";
    private final String port = "587";
    private final String username = "dushimeconso1234@gmail.com";
    private final String password = "hzpy ahcy vjwb kord";
    private Properties props;
    private Session session;

    public Mailer() {
    	props = new Properties();
    	props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable",true);
//		props.put("mail.debug", true);
//		props.put("mail.smtp.ssl.protocols", "TLSv1.3");
//		props.put("mail.smtp.ssl.ciphersuites", "TLS_AES_128_GCM_SHA256");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
    }
	public boolean sendMessage(String email, String message, String subject) {
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			msg.setSubject(subject);
			msg.setText(message);
			
			Transport.send(msg);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
