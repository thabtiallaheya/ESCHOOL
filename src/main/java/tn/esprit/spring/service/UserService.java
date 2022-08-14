package tn.esprit.spring.service;

import tn.esprit.entity.User;

public interface UserService {
	User findUserByUserName(String userName);
    User saveUser(User user);
}
