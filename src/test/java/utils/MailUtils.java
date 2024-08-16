package utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.ITestResult;

public class MailUtils {

	public static void sendMail(ITestResult result, String filePath) throws MessagingException {

		// String receipientTo[] = { MailConfigLoader.getInstance().getToRecipent(),
		// MailConfigLoader.getInstance().getToRecipentOne(),
		// MailConfigLoader.getInstance().getToRecipentTwo(),
		// MailConfigLoader.getInstance().getToRecipentThree() };

		String splitString = ConfigLoader.getMailProperty("toMailUsers");

		String[] splitArray = splitString.split(",");

		for (String user : splitArray) {

			String receipientTo[] = { user };

			InternetAddress[] toaddress = new InternetAddress[receipientTo.length];
			for (int i = 0; i < receipientTo.length; i++) {
				toaddress[i] = new InternetAddress(receipientTo[i]);
			}

			// Sender's Mail id

			String senderFrom = ConfigLoader.getMailProperty("fromMail");
			// Path of PDF test report

			String path = filePath;
			Properties prop = System.getProperties();

			// Setting up smtp host
			prop.setProperty("mail.smtp.host", "smtp.gmail.com");

			// Creating a new session for smtp
			Session session = Session.getDefaultInstance(prop);

			MimeMessage msg = new MimeMessage(session);

			// Instance of From Internet address
			InternetAddress frmAddress = new InternetAddress(senderFrom);

			// Setting up sender's address
			msg.setFrom(frmAddress);

			// Setting up recipient's address
			msg.addRecipients(Message.RecipientType.TO, toaddress);

			// Setting email's subject
			msg.setSubject("Automation Test Failure | WoodBlocx | Dev");

			BodyPart msgBody = new MimeBodyPart();

			// Setting email's message body
			msgBody.setText("Failed tests with Screenshot  " + result.getTestClass().getRealClass().getSimpleName()
					+ "_" + result.getMethod().getMethodName());

			// Instance of second part
			Multipart multiPart = new MimeMultipart();

			multiPart.addBodyPart(msgBody);

			// Another mail body
			msgBody = new MimeBodyPart();

			// path of screenshot saved
			DataSource source = new FileDataSource(path);

			DataHandler dataHandler = new DataHandler(source);

			msgBody.setDataHandler(dataHandler);

			msgBody.setFileName(path);

			multiPart.addBodyPart(msgBody);

			msg.setContent(multiPart);

			// Authentication and connection establishment to the sender's mail
			Transport transport = session.getTransport("smtps");

			transport.connect("smtp.gmail.com", 465, ConfigLoader.getMailProperty("mailUser"),
					ConfigLoader.getMailProperty("mailPass"));
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("mail sent to " + user);

		}
	}

}
