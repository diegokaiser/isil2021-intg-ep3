package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pe.isil.config.CreateAppoinmentProperties;
import pe.isil.model.Appoinment;
import pe.isil.util.Formatter;

@Slf4j
@Service
public class CreateAppoinmentEvent {
    private final JmsTemplate jmsTemplate;
    private final Formatter formatter;
    private final CreateAppoinmentProperties props;

    public CreateAppoinmentEvent(JmsTemplate jmsTemplate, Formatter formatter, CreateAppoinmentProperties props) {
        this.jmsTemplate = jmsTemplate;
        this.formatter = formatter;
        this.props = props;
    }

    public void sendEvent(Appoinment appoinment) {

        final String appoinmentString = formatter.toSting(appoinment);
        jmsTemplate.convertAndSend(props.getCreateAppoinmentQueue(), appoinmentString);
        log.info("Se envió un mensaje a la cola ["+props.getCreateAppoinmentQueue()+"]");
    }
}
