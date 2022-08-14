package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.entity.Parent;



public interface ParentRepository extends JpaRepository<Parent,Long> {

}
