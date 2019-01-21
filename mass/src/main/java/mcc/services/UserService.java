package mcc.services;

import mcc.domain.User;
import mcc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> findUser(String name) {
        return userRepository.findAll().stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<String> getAllUsersName() {
        return userRepository.findAll().stream()
                .map(user -> user.getName() + " " + user.getLastName())
                .collect(Collectors.toList());
    }
}
