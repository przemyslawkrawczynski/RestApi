package mcc.services;

import mcc.domain.User;
import mcc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<String> getAllUsersName() {
        userRepository.addUser("Jan", "Kowalski", "M", "pk@masscc.pl", "pass");
        return userRepository.getUserList().stream()
                .map(user -> user.getName() + " " + user.getLastName())
                .collect(Collectors.toList());
    }
}
