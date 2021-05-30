package polymorpheus.hrms.business.concretes;

import polymorpheus.hrms.business.abstracts.JobCheckService;
import polymorpheus.hrms.dataAccess.abstracts.JobDao;
import polymorpheus.hrms.entities.concretes.Job;

public class JobCheckManager implements JobCheckService {
    private JobDao jobDao;

    public JobCheckManager(JobDao jobDao) {
        this.jobDao = jobDao;

    }

    @Override
    public boolean isJobAlreadyExists(Job job) {
        boolean result=false;

        for (Job aJob: jobDao.findAll()){
            if (job.getJobId()==aJob.getJobId()){
                result=true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean check(Job job) {
        boolean result=true;

        if (isJobAlreadyExists(job)){
            System.out.println("Bu iş pozisyonu zaten var.");
            result=false;
        }
        return result;
    }
}
