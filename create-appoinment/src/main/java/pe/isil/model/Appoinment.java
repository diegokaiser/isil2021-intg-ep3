package pe.isil.model;

import lombok.*;

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
