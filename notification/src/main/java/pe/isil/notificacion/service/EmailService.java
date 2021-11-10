package pe.isil.notificacion.service;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pe.isil.notificacion.integration.model.Appoinment;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    public EmailService(JavaMailSender javaMailSender, Configuration configuration) {
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }

    public void sendMail(Appoinment appoinment) throws MessagingException, TemplateException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Tu cita");
        helper.setTo(appoinment.getEmail());
        String emailBody = getEmailBody(appoinment);
        helper.setText(emailBody, true);
        javaMailSender.send(mimeMessage);
    }

    private String getEmailBody(Appoinment appoinment) throws IOException, TemplateException {
        Map<String, Object> model = new HashMap<>();
        model.put("account", appoinment);
        StringWriter stringWriter = new StringWriter();
        configuration.getTemplate("email.html").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
