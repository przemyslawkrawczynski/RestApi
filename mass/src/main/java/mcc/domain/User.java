package mcc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mcc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name="USERS")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "EMAIL")
    private String mail;

    @Column(name = "password")
    private String password;

    public User(String name, String lastName, String role, String mail, String password) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.mail = mail;
        this.password = password;
    }
}
