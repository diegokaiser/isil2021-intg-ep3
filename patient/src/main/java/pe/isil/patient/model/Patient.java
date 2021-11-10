package pe.isil.patient.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Patient {

    @Id
    private String patientId;
    private String firstName;
    private String lastName;
    private String email;
    private Double weight;
    private Double height;
    private String personalDisease;
    private String bloodType;
}
