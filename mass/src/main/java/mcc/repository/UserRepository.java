package mcc.repository;

import lombok.NoArgsConstructor;
import mcc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList<>();

    public void addUser(String name, String lastName, String role, String mail, String password) {
        userList.add(new User(name, lastName, role, mail, password));
    }

    public List<User> getUserList() {
        return userList;
    }
}
