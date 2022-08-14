package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entity.Role;


public interface RoleRepository extends CrudRepository<Role,Integer> {
	
	Role findByRole(String role);
}
