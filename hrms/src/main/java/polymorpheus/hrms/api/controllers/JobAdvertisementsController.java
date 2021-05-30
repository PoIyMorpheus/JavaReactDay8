package polymorpheus.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import polymorpheus.hrms.business.abstracts.JobAdvertisementService;
import polymorpheus.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/post-job")
    public void postJob(JobAdvertisement jobAdvertisement){
        jobAdvertisementService.postJob(jobAdvertisement);
    }

    @GetMapping("/get-all-active-job-advertisements")
    public List<JobAdvertisement> getAllActive(){
        return jobAdvertisementService.getAllActive();
    }

    @GetMapping("/get-all-active-job-advertisements-sorted-by-deadline")
    public List<JobAdvertisement> getAllActiveSortedByDate(){
        return jobAdvertisementService.getAllActiveSortedByDate();
    }

    @GetMapping("/get-job-advertisements-by-company")
    public List<JobAdvertisement> getByCompany(@RequestBody String company){
        return jobAdvertisementService.getByCompany(company);
    }

    @PostMapping("/close-job-advertisement-by-id")
    public void closeJobAdvertisementById(@RequestBody int id){
        jobAdvertisementService.closeJobAdvertisementById(id);
    }

    @PostMapping("/open-job-advertisement-by-id")
    public void openJobAdvertisementById(@RequestBody int id){
        jobAdvertisementService.openJobAdvertisementById(id);
    }
}
