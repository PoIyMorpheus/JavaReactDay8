package polymorpheus.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import polymorpheus.hrms.business.abstracts.JobAdvertisementCheckService;
import polymorpheus.hrms.business.abstracts.JobAdvertisementService;
import polymorpheus.hrms.dataAccess.abstracts.JobAdvertisementDao;
import polymorpheus.hrms.entities.concretes.JobAdvertisement;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;
    private JobAdvertisementCheckService jobAdvertisementCheckService;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        jobAdvertisementCheckService = new JobAdvertisementCheckManager(jobAdvertisementDao);
    }

    @Override
    public void postJob(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDao.save(jobAdvertisement);
    }

    @Override
    public List<JobAdvertisement> getAllActive() {
        ArrayList<JobAdvertisement> activeAdvertisements=new ArrayList<>();

        for (JobAdvertisement jobAdvertisement: jobAdvertisementDao.findAll()){
            if (jobAdvertisement.isActive()){
                activeAdvertisements.add(jobAdvertisement);
            }
        }

        return activeAdvertisements;
    }

    @Override
    public List<JobAdvertisement> getAllActiveSortedByDate() {
        Sort sort = Sort.by(Sort.Direction.ASC,"ApplicationDeadline");
        List<JobAdvertisement> sortedAdvertisements = jobAdvertisementDao.findAll(sort);

        ArrayList<JobAdvertisement> activeAdvertisements=new ArrayList<>();

        for (JobAdvertisement jobAdvertisement: sortedAdvertisements){
            if (jobAdvertisement.isActive()){
                activeAdvertisements.add(jobAdvertisement);
            }
        }

        return activeAdvertisements;

    }

    @Override
    public List<JobAdvertisement> getByCompany(String company) {
        ArrayList<JobAdvertisement> advertisements=new ArrayList<>();

        for (JobAdvertisement jobAdvertisement: jobAdvertisementDao.findAll()){
            if (jobAdvertisement.isActive() && company.equalsIgnoreCase(jobAdvertisement.getCompany())){
                advertisements.add(jobAdvertisement);
            }
        }

        return advertisements;
    }

    @Override
    public void closeJobAdvertisementById(int id) {
        if (jobAdvertisementCheckService.isIdAlreadyExists(id)){

            JobAdvertisement jobAdvertisement=jobAdvertisementDao.findById(id).get();
            jobAdvertisementDao.delete(jobAdvertisement);

            jobAdvertisement.setActive(false);
            jobAdvertisement.setId(id);

            jobAdvertisementDao.save(jobAdvertisement);

        }
    }

    @Override
    public void openJobAdvertisementById(int id) {
        if (jobAdvertisementCheckService.isIdAlreadyExists(id)){

            JobAdvertisement jobAdvertisement=jobAdvertisementDao.findById(id).get();
            jobAdvertisementDao.delete(jobAdvertisement);

            jobAdvertisement.setActive(true);
            jobAdvertisement.setId(id);

            jobAdvertisementDao.save(jobAdvertisement);

        }

    }
}
