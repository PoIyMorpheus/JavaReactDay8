package polymorpheus.hrms.business.abstracts;

import polymorpheus.hrms.entities.concretes.Job;

public interface JobCheckService {
    boolean isJobAlreadyExists(Job job);
    boolean check(Job job);
}
