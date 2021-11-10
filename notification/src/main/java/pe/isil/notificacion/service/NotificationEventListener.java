package pe.isil.notificacion.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import pe.isil.notificacion.integration.model.Appoinment;
import pe.isil.notificacion.util.Formatter;

@Slf4j
@Service
public class NotificationEventListener {

    private final EmailService emailService;
    private final Formatter formatter;

    public NotificationEventListener(EmailService emailService, Formatter formatter) {
        this.emailService = emailService;
        this.formatter = formatter;
    }

    @JmsListener(destination = "${app.queue.notificationQueue}")
    public void receiveEvent(String message) {
        Appoinment appoinment = formatter.toObject(message, Appoinment.class);
        try {
            emailService.sendMail(appoinment);
            log.info("Se envió el mail satisfactoriamente");
        } catch (Exception e) {
            log.error("Ocurrió un error al enviar el email, ex: {}", e.getMessage());
        }
    }
}
