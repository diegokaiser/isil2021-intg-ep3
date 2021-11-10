package pe.isil.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.doctor.model.Doctor;

@Repository

public interface DoctorRepository extends JpaRepository<Doctor, String> {
}
