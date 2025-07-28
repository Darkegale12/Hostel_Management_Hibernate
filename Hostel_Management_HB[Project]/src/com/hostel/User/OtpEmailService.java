package com.hostel.User;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class OtpEmailService {

    private static final String fromEmail = "vishwajeetmore2023.comp@mmcoe.edu.in"; 
    private static final String appPassword = "tcvo hisd jlwj nhki"; 

    // 🔹 Generates a 4-digit OTP
    public static String generateOtp() {
        return String.valueOf(1000 + new Random().nextInt(9000)); 
    }

    // 🔹 Sends OTP to given email
    public static void sendOtpEmail(String toEmail, String otp) {
        Properties props = getMailProperties();

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Your Hostel Registration OTP");
            message.setText("Hello,\n\nYour OTP for Hostel Registration is: " + otp + "\n\n- Hostel Admin");
            Transport.send(message);
            System.out.println("✅ OTP sent to email: " + toEmail);
        } catch (MessagingException e) {
            System.out.println("❌ Failed to send OTP.");
            e.printStackTrace();
        }
    }

    // 🔹 Sends PDF with rules to the user
    public static void sendRulesPdfEmail(String toEmail, String username, String pdfFilePath) {
        Properties props = getMailProperties();

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("📄 Hostel Rules & Regulations Document");

            // Email Body Part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello " + username + ",\n\nPlease find attached the Hostel Rules & Regulations PDF.\n\nRegards,\nHostel Admin");

            // PDF Attachment Part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(pdfFilePath));

            // Combine both into multipart
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("✅ Rules PDF sent to email: " + toEmail);
        } catch (Exception e) {
            System.out.println("❌ Failed to send PDF.");
            e.printStackTrace();
        }
    }

    // 🔹 Reusable method for common mail properties
    private static Properties getMailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");  
        props.put("mail.smtp.port", "587");             
        props.put("mail.smtp.auth", "true");            
        props.put("mail.smtp.starttls.enable", "true"); 
        return props;
    }
}
