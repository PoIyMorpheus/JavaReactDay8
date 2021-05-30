package polymorpheus.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import polymorpheus.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
}
