package polymorpheus.hrms.business.abstracts;

import polymorpheus.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {
    List<Job> getAll();
    void add(Job job);
}
