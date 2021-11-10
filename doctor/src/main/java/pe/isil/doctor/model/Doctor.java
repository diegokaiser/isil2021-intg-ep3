package pe.isil.doctor.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Doctor {

    @Id
    private String firstName;
    private String lastName;
    private String licenseNo;
    private String specialty;
}
