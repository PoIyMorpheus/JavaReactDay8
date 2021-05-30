package polymorpheus.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "JobAdvertisement")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
    @Id
    @Column(name = "Id")
    int id;

    @Column(name = "Description")
    String description;

    @Column(name = "City")
    String city;

    @Column(name = "MinSalary")
    int minSalary;

    @Column(name = "MaxSalary")
    int maxSalary;

    @Column(name = "NumberOfPositionDeficit")
    int numberOfPositionDeficit;

    @Column(name = "ApplicationDeadline")
    String applicationDeadline;

    @Column(name = "IsActive")
    boolean isActive;

    @Column(name = "Company")
    String company;

    public JobAdvertisement(int id, String description, String city, int numberOfPositionDeficit, String applicationDeadline, String company) {
        this.id = id;
        this.description = description;
        this.city = city;
        this.numberOfPositionDeficit = numberOfPositionDeficit;
        this.applicationDeadline=applicationDeadline;
        this.isActive=true;
        this.company=company;
    }
}
