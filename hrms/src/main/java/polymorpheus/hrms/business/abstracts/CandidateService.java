package polymorpheus.hrms.business.abstracts;

import polymorpheus.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    void register(Candidate candidate);
    List<Candidate> getAll();
}
