package pe.isil.patient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pe.isil.patient.integration.model.Appoinment;
import pe.isil.patient.model.Patient;
import pe.isil.patient.repository.PatientRepository;
import pe.isil.patient.util.Formatter;

@Slf4j
@Service
public class PatientEventListener {

    private final PatientRepository patientRepository;
    private final Formatter formatter;
    private final JmsTemplate jmsTemplate;
    private final String notificacionQueue;

    public PatientEventListener(PatientRepository patientRepository, Formatter formatter, JmsTemplate jmsTemplate, @Value("${app.queue.notificationQueue") String notificacionQueue) {
        this.patientRepository = patientRepository;
        this.formatter = formatter;
        this.jmsTemplate = jmsTemplate;
        this.notificacionQueue = notificacionQueue;
    }

    @JmsListener(destination = "${app.queue.patieneQueue}")
    public void receiveEvent(String message) {
        Appoinment appoinment = formatter.toObject(message, Appoinment.class);
        Patient patient = new Patient(appoinment.getAppointmentID(), appoinment.getDoctorId(), appoinment.getDisease(), appoinment.getDetail(), appoinment.getDateOfAppointment(), appoinment.getTimeOfAppointment(), appoinment.getPatientId());
        patientRepository.save(patient);
        log.info("Se envió mensaje de notificación a la cola {}", notificacionQueue);
    }
}
