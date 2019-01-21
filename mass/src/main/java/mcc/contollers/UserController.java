package mcc.contollers;

import mcc.domain.User;
import mcc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("app")

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("getUsers")
    public List<User> getUsers() {

        List<User> userList = userService.getAll();
        return userList;
    }

    @RequestMapping("getUsersName")
    public List<String> getUsersName() {

        List<String> userList = userService.getAllUsersName();
        return userList;
    }

    @GetMapping("/{name}")
    public List<User> getUser(@PathVariable("name") String name) {
        return userService.findUser(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addUser", consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
