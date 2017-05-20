package com.lyj.user.utils;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 此类负责发送邮件，提供静态方法sendMail
 *
 * @author Rabit
 *
 */
public class SendMailUnitl {
	/**
	 * @author Rabit
	 * @param to :收件人的邮箱地址
	 * @param code :提供64位激活码
	 */

	public static void senMail(String to,String code) {
		// 获取连接对象
		Properties properties = new Properties();
		try {
			MailSSLSocketFactory sfFactory=new MailSSLSocketFactory();
			sfFactory.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sfFactory);
			properties.setProperty("mail.smtp.host", "smtp.qq.com");
			properties.setProperty("mail.smtp.auth", "true");
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}

		Session session = Session.getInstance(properties,new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("794933224@qq.com", "atwmwywowofhbbfi");
			}
		});
		// 创建邮件对象
		Message message = new MimeMessage(session);
		try {
			// 设置发件人
			message.setFrom(new InternetAddress("794933224@qq.com"));
			// 设置收件人
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// 设置标题
			message.setSubject("来自阅读伴侣的官方激活邮件");
			// 设置邮件的内容
			message.setContent("<h1>阅读伴侣的官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://localhost:8082/lengdingbook/active.action?code="+code+"'>http://localhost:8082/lengdingbook/active.action?code="+code+"</a></h3>",
					"text/html;charset=UTF-8");
			// 发送邮件
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}