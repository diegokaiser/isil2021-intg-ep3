package pe.isil.doctor.integration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Appoinment {

    private String appointmentID;
    private String doctorId;
    private String disease;
    private String detail;
    private LocalDate dateOfAppointment;
    private LocalDate timeOfAppointment;
    private String patientId;
}
