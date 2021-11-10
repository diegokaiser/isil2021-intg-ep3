package pe.isil.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.JmsException;
import pe.isil.model.Appoinment;

@SpringBootTest
class CreateAppoinmentEventTest {

    @Autowired
    private CreateAppoinmentEvent createAppoinmentEvent

    @Test
    void sendEvent() {
        Appoinment appoinment = new Appoinment();
        appoinment.setAppointmentID("32d096aa-1982-478d-9bd2-9662f46cfa0e");
        appoinment.setDoctorId("40120835");
        appoinment.setDisease("contractura muscular");
        appoinment.setDetail("el paciente no puede girar la cabeza debido a dolor muscular");
        appoinment.setDateOfAppointment(2020);
        appoinment.setTimeOfAppointment(14:30);
        appoinment.setPatientId("40120835");
        try {
            createAppoinmentEvent.sendEvent(appoinment);
        } catch (JmsException e) {
            e.getMessage();
            System.out.println(e.getMessage());
        }
    }
}
