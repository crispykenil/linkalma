package com.linkalma.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendEmail {

	private static final Logger logger = LoggerFactory
			.getLogger(SendEmail.class);

	@Autowired
	private JavaMailSender javaMailSender;
	 
	@Autowired
	private SimpleMailMessage templateMailMessage;
	 
	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
	    this.javaMailSender = javaMailSender;
	}

	public void setSimpleMailMessage(SimpleMailMessage templateMailMessage) {
	    this.templateMailMessage = templateMailMessage;
	}
	 
	public void sendMail(String from, String to, String subject, String msg) {

	    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

	    simpleMailMessage.setFrom(from);
	    simpleMailMessage.setTo(to);
	    simpleMailMessage.setSubject(subject);
	    simpleMailMessage.setText(msg);
	    javaMailSender.send(simpleMailMessage);
	    logger.info("Email Sent to: "+to);
	}
	 
	public void sendMailWithTemplate(String dear, String content) {         
	       SimpleMailMessage message = new SimpleMailMessage(templateMailMessage);
	       message.setText(String.format( templateMailMessage.getText(), dear, content));
	       javaMailSender.send(message);
	}
	 
	public void sendMailWithAttachment(String dear, String content) {
	      
	       MimeMessage message = javaMailSender.createMimeMessage();
	  
	       try{
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	  
	        helper.setFrom(templateMailMessage.getFrom());
	        helper.setTo(templateMailMessage.getTo());
	        helper.setSubject(templateMailMessage.getSubject());
	        helper.setText(String.format(
	                templateMailMessage.getText(), dear, content));
	  
	        FileSystemResource file = new FileSystemResource("C:\\hello\\java.txt");
	        helper.addAttachment(file.getFilename(), file);
	  
	         }catch (MessagingException e) {
	        throw new MailParseException(e);
	         }
	       javaMailSender.send(message);
	         }

	/**
	 * @return the javaMailSender
	 */
	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	/**
	 * @param javaMailSender the javaMailSender to set
	 */
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * @return the templateMailMessage
	 */
	public SimpleMailMessage getTemplateMailMessage() {
		return templateMailMessage;
	}

	/**
	 * @param templateMailMessage the templateMailMessage to set
	 */
	public void setTemplateMailMessage(SimpleMailMessage templateMailMessage) {
		this.templateMailMessage = templateMailMessage;
	}
}
