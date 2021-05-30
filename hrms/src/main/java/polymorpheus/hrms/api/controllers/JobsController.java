package polymorpheus.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import polymorpheus.hrms.business.abstracts.JobService;
import polymorpheus.hrms.entities.concretes.Job;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    private JobService jobService;

    @Autowired
    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getall")
    public List<Job> getAll(){
        return jobService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Job job){
        jobService.add(job);
    }
}
