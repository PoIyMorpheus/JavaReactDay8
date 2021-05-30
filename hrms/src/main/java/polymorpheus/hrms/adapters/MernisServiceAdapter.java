package polymorpheus.hrms.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import polymorpheus.hrms.business.abstracts.CustomerCheckService;
import polymorpheus.hrms.entities.concretes.Candidate;
import polymorpheus.hrms.entities.concretes.People;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class MernisServiceAdapter {

    public boolean checkIfRealPerson(People people) {
        boolean result=false;

        if (people instanceof Candidate) {
            try {
                if (new mernis.KPSPublicLocator().getKPSPublicSoap().TCKimlikNoDogrula(
                        Long.parseLong(((Candidate) people).getNationalId())
                                , ((Candidate) people).getFirstName(), ((Candidate) people).getLastName(), ((Candidate) people).getBirthYear())) {
                    result = true;
                }
            } catch (NumberFormatException | RemoteException | ServiceException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
