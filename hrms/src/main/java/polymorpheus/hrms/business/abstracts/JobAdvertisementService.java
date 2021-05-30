package polymorpheus.hrms.business.abstracts;

import polymorpheus.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    void postJob(JobAdvertisement jobAdvertisement);
    List<JobAdvertisement> getAllActive();
    List<JobAdvertisement> getAllActiveSortedByDate();
    List<JobAdvertisement> getByCompany(String company);
    void closeJobAdvertisementById (int id);
    void openJobAdvertisementById (int id);
}
