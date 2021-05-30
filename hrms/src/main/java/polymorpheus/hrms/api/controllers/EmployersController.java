package polymorpheus.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import polymorpheus.hrms.business.abstracts.EmployerService;
import polymorpheus.hrms.entities.concretes.Employer;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public List<Employer> getAll(){
        return employerService.getAll();
    }

    @PostMapping("/register")
    public void register(@RequestBody Employer employer){
        employerService.register(employer);
    }
}
