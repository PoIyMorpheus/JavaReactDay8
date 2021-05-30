package polymorpheus.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import polymorpheus.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
}
