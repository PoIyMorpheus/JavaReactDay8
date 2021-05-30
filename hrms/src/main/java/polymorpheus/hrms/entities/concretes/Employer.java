package polymorpheus.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Employers")
public class Employer extends People{

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "WebSiteName")
    private String webSiteName;

    @Column(name = "PhoneNumber")
    private String phoneNumber;
}
