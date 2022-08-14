package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entity.User;

public interface UserRepository extends CrudRepository<User,
Integer> {
	User findByUserName(String userName);

}
