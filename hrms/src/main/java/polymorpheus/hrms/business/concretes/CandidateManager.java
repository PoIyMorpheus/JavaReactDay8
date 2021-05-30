package polymorpheus.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polymorpheus.hrms.business.abstracts.CandidateService;
import polymorpheus.hrms.dataAccess.abstracts.CandidateDao;
import polymorpheus.hrms.entities.concretes.Candidate;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {


    private CandidateDao candidateDao;
    private CanditateCheckManager customerCheckService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
        customerCheckService = new CanditateCheckManager(this.candidateDao);
    }

    @Override
    public void register(Candidate candidate) {

        if (customerCheckService.check(candidate)) {
            candidateDao.save(candidate);
            System.out.println("Kayıt başarılı.");
        }
        else System.out.println("Kayıt başarısız.");

    }

    @Override
    public List<Candidate> getAll() {
        return candidateDao.findAll();
    }
}
