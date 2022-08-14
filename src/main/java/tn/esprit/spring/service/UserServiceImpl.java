package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.User;
import tn.esprit.spring.repository.UserRepository;
@Service
@Slf4j
public class UserServiceImpl implements  UserService  {
	@Autowired
	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	@Override
	public User findUserByUserName(String userName) {
		return	userRepository.findByUserName(userName);
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		return userRepository.save(user);
	}

}
