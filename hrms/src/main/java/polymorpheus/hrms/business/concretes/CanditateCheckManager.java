package polymorpheus.hrms.business.concretes;

import polymorpheus.hrms.adapters.MernisServiceAdapter;
import polymorpheus.hrms.business.abstracts.CustomerCheckService;
import polymorpheus.hrms.dataAccess.abstracts.CandidateDao;
import polymorpheus.hrms.entities.concretes.Candidate;
import polymorpheus.hrms.entities.concretes.People;


public class CanditateCheckManager implements CustomerCheckService {
    private MernisServiceAdapter mernisServiceAdapter = new MernisServiceAdapter();
    private CandidateDao candidateDao;


    public CanditateCheckManager(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;

    }

    public boolean checkIfRealPerson(Candidate candidate) {
        return mernisServiceAdapter.checkIfRealPerson(candidate);
    }

    public boolean isEmailAlreadyExists(Candidate candidate) {
        boolean result=false;

        for (Candidate aCandidate: candidateDao.findAll()){
            if (aCandidate.getEmail().equals(candidate.getEmail())){
                result=true;
                break;
            }
        }

        return result;
    }

    public boolean isNationalIdAlreadyExists(Candidate candidate) {
        boolean result=false;

        for (Candidate aCandidate : candidateDao.findAll()) {
            if (aCandidate.getNationalId().equals(candidate.getNationalId())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isEmailVerified(Candidate candidate) {
        return true;
    }

    public boolean isPasswordVerified(Candidate candidate) {
        if (candidate.getPassword().equals(candidate.getVerificationPassword())){
            return true;
        }
        else return false;
    }

    public boolean check(Candidate candidate){
        boolean result=true;

        if (!checkIfRealPerson(candidate)){
            System.out.println("Mernis doğrulaması başarısız.");
            result=false;
        }
        else if (isEmailAlreadyExists(candidate)){
            System.out.println("Bu e-postaya sahip bir hesap zaten var.");
            result=false;
        }
        else if (isNationalIdAlreadyExists(candidate)){
            System.out.println("Bu TC kimlik numarasına sahip bir hesap zaten var.");
            result=false;
        }
        else if (!isEmailVerified(candidate)){
            System.out.println("E-posta doğrulaması başarısız.");
            result=false;
        }
        else if (!isPasswordVerified(candidate)){
            System.out.println("Girilen şifre ile tekrar girilen şifre uyuşmuyor.");
            result=false;
        }
        return result;
    }




}
