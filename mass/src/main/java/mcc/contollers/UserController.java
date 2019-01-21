package mcc.contollers;

import mcc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/userList")
    public String getUsers(Model model) {

        List<String> userList = userService.getAllUsersName();
        model.addAttribute("users", userList);

        return "users.html";
    }
}
