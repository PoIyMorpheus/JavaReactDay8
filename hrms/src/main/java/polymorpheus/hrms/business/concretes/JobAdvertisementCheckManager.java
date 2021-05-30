package polymorpheus.hrms.business.concretes;

import polymorpheus.hrms.business.abstracts.JobAdvertisementCheckService;
import polymorpheus.hrms.dataAccess.abstracts.JobAdvertisementDao;
import polymorpheus.hrms.entities.concretes.JobAdvertisement;

public class JobAdvertisementCheckManager implements JobAdvertisementCheckService {
    private JobAdvertisementDao jobAdvertisementDao;

    public JobAdvertisementCheckManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public boolean isIdAlreadyExists(int id) {
        return jobAdvertisementDao.existsById(id);
    }
}
