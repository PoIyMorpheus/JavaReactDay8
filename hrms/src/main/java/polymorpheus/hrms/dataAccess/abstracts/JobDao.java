package polymorpheus.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import polymorpheus.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job,Integer> {

}
