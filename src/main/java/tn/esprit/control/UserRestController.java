package tn.esprit.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entity.User;
import tn.esprit.spring.service.UserService;


@RestController
public class UserRestController {
@Autowired
UserService userService;
//http://localhost:8089/registration
@PostMapping("/registration")
public String createNewUser( @RequestBody User user) {
String msg="";
User userExists = userService.findUserByUserName(user.getUserName());
if (userExists != null) {
msg="There is already a user registered with the user name provided";
} else {
userService.saveUser(user);
msg="OK"; }
return msg; }
}
