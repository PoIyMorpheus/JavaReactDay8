package polymorpheus.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import polymorpheus.hrms.business.abstracts.CandidateService;
import polymorpheus.hrms.entities.concretes.Candidate;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public List<Candidate> getAll(){
        return candidateService.getAll();
    }

    @PostMapping("/register")
    public void register(@RequestBody Candidate candidate){
        candidateService.register(candidate);
    }
}
