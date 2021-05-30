package polymorpheus.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name ="JobRoles")
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    public int id;

    @Column(name = "JobId")
    private int jobId;

    @Column(name = "JobName")
    private String jobName;

    public Job(String jobName) {
        this.jobName = jobName;
    }
}
