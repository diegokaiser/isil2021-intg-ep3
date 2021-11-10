package pe.isil.doctor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pe.isil.doctor.util.Formatter;

@Slf4j
@Service
public class DoctorEventListener {
    private final Formatter formatter;
    private final JmsTemplate jmsTemplate;
    private final String notificacionQueue;

    public DoctorEventListener(Formatter formatter, JmsTemplate jmsTemplate, String notificacionQueue) {
        this.formatter = formatter;
        this.jmsTemplate = jmsTemplate;
        this.notificacionQueue = notificacionQueue;
    }
}
