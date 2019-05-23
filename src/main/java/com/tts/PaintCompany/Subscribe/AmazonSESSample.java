package com.tts.PaintCompany.Subscribe;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class AmazonSESSample {
	


    public void sendEmail(Subscriber subscriber1) throws Exception {	

        // Replace sender@example.com with your "From" address.
        // This address must be verified.
        final String FROM = "paintcompanytest@gmail.com";
        final String FROMNAME = "JNL Paint Company";
    	
        // Replace recipient@example.com with a "To" address. If your account 
        // is still in the sandbox, this address must be verified.
        
        String TO = subscriber1.getEmail();
        
        // Replace smtp_username with your Amazon SES SMTP user name.
        final String SMTP_USERNAME = "AKIA3NM5EGPFXEO3JXUU";
        
        // Replace smtp_password with your Amazon SES SMTP password.
        final String SMTP_PASSWORD = "BAKgj/yF30ftZbjwwcUY0Lfyr8tTNfhn77GH7HCTfhiX";
        
        // The name of the Configuration Set to use for this message.
        // If you comment out or remove this variable, you will also need to
        // comment out or remove the header below.
        //static final String CONFIGSET = "ConfigSet";
        
        // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
        // See https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
        // for more information.
        final String HOST = "email-smtp.us-east-1.amazonaws.com";
        
        // The port you will connect to on the Amazon SES SMTP endpoint. 
        final int PORT = 587;
        
        final String SUBJECT = "Thank you for Subscribing!";
        
        final String BODY = String.join(
        	    System.getProperty("line.separator"),
        	    "<h1>Thank you for Subscribing!</h1>",
        	    "<p>You have successfully subscribed to JNL Paint Company. Be on the lookout for offers. " 
        	
        	);

        // Create a Properties object to contain connection configuration information.
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties. 
    	Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");
        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
       // msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
            
        // Create a transport.
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
            System.out.println("Sending...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }
}
