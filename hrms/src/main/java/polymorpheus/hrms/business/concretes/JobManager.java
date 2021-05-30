package polymorpheus.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polymorpheus.hrms.business.abstracts.JobCheckService;
import polymorpheus.hrms.business.abstracts.JobService;
import polymorpheus.hrms.dataAccess.abstracts.JobDao;
import polymorpheus.hrms.entities.concretes.Job;

import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDao jobDao;
    private JobCheckService jobCheckService;

    @Autowired
    public JobManager(JobDao jobDao) {
        this.jobDao = jobDao;
        jobCheckService = new JobCheckManager(jobDao);
    }

    @Override
    public List<Job> getAll() {
        return this.jobDao.findAll();
    }

    @Override
    public void add(Job job) {
       if (jobCheckService.check(job)){
           jobDao.save(job);
           System.out.println("Eklendi.");
       }
       else System.out.println("Eklenemedi.");
    }


}
