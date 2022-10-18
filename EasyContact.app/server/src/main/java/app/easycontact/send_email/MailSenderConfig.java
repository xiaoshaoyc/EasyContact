package app.easycontact.send_email;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailSenderConfig {
    private final Dotenv dotenv = Dotenv.load();
    private final Environment env;
    @Autowired
    public MailSenderConfig(Environment env) {
        this.env = env;
    }
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(dotenv.get("EMAIL_HOST"));
        mailSender.setHost(env.getRequiredProperty("easycontact.email.host"));
        mailSender.setPort(587);

//        mailSender.setUsername(dotenv.get("EMAIL_USERNAME"));
//        mailSender.setPassword(dotenv.get("EMAIL_PASSWORD"));
        mailSender.setUsername(env.getRequiredProperty("easycontact.email.username"));
        mailSender.setPassword(env.getRequiredProperty("easycontact.email.password"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
