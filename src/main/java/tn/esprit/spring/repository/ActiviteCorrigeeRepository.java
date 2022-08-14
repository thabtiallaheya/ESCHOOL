package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.ActiviteCorrigee;
@Repository
public interface ActiviteCorrigeeRepository extends JpaRepository<ActiviteCorrigee,Long> {

}
