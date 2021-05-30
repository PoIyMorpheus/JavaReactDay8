package polymorpheus.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "People")
@NoArgsConstructor
@AllArgsConstructor
public abstract class People {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    public int id;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    private String verificationPassword;

    public People(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.verificationPassword = null;
    }

}
