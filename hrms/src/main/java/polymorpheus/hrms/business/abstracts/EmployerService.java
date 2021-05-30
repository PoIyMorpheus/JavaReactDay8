package polymorpheus.hrms.business.abstracts;

import polymorpheus.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    void register(Employer employer);
    List<Employer> getAll();
}
