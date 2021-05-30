package polymorpheus.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Candidates")
public class Candidate extends People {
    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "NationalId")
    private String nationalId;

    @Column(name = "BirthYear")
    private int birthYear;



}
