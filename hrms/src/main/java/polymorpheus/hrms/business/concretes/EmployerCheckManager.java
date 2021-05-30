package polymorpheus.hrms.business.concretes;

import polymorpheus.hrms.business.abstracts.CustomerCheckService;
import polymorpheus.hrms.dataAccess.abstracts.EmployerDao;
import polymorpheus.hrms.entities.concretes.Employer;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployerCheckManager implements CustomerCheckService {

    private EmployerDao employerDao;

    public EmployerCheckManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    public boolean isEmailAndWebSiteNameValid(Employer employer) {
        String domain=domainOfEmail(employer.getEmail());

        if (domain.equals(employer.getWebSiteName())){
            return true;
        }
        else return false;

    }

    public boolean isEmailVerified(Employer employer) {
        return true;
    }

    public String domainOfEmail(String email){
        String domain="";

        Pattern regex = Pattern.compile("(?<=@)\\S+");
        Matcher regexMatcher = regex.matcher(email);
        if (regexMatcher.find()) {
            domain = regexMatcher.group();
        }

        return domain;
    }
    public boolean isEmailAlreadyExists(Employer employer) {
        boolean result=false;

        for (Employer anEmployer: employerDao.findAll()){
            if (anEmployer.getEmail().equals(employer.getEmail())){
                result=true;
                break;
            }
        }

        return result;
    }

    public boolean check(Employer employer){
        boolean result=true;

        if (isEmailAlreadyExists(employer)){
            System.out.println("Bu e-postaya sahip bir hesap zaten var.");
            result=false;
        }
        else if (!isEmailAndWebSiteNameValid(employer)){
            System.out.println("E-postanın domaini ile website ismi uyuşmuyor.");
            result=false;
        }
        else if (!isEmailVerified(employer)){
            System.out.println("E-posta doğrulaması başarısız.");
            result=false;
        }

        return result;
    }
}
