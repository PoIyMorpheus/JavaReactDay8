package polymorpheus.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polymorpheus.hrms.business.abstracts.EmployerService;
import polymorpheus.hrms.dataAccess.abstracts.EmployerDao;
import polymorpheus.hrms.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmployerCheckManager employerCheckManager;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
        employerCheckManager=new EmployerCheckManager(employerDao);
    }

    @Override
    public void register(Employer employer) {

        if (employerCheckManager.check(employer)){
            employerDao.save(employer);
            System.out.println("Kayıt başarılı.");
        }
        else System.out.println("Kayıt başarısız.");
    }

    @Override
    public List<Employer> getAll() {
        return employerDao.findAll();
    }
}
