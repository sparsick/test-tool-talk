package com.github.sparsick.test.tool.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MailClient {

    private final JavaMailSender javaMailSender;
    private final Properties properties;
    private final String username;
    private final String password;


    public MailClient(Properties properties, String username, String password) {
        this.properties = properties;
        this.username = username;
        this.password = password;
        this.javaMailSender = createJavaMailSender();
    }

    public void sendMessage(String from, String to, String body) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setText(body);
        javaMailSender.send(message);
    }

    public List<Message> receiveMessages() {
        Session session = Session.getInstance(properties);

        Folder folderInbox = null;
        Store store = null;
        try {
            // connects to the message store
            store = session.getStore("pop3");
            store.connect(username, password);

            // opens the inbox folder
            folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            // fetches new messages from server
            Message[] messages = folderInbox.getMessages();

            return Arrays.asList(messages);
        } catch (NoSuchProviderException ex) {
            System.out.println("No provider for protocol: pop3" );
            throw new RuntimeException(ex);
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store");
            throw new RuntimeException(ex);
        } finally {
            // disconnect
            try {
                if (folderInbox != null) {
                    folderInbox.close(false);
                }
                if (store != null) {
                    store.close();
                }
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private JavaMailSenderImpl createJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        return javaMailSender;
    }
}
