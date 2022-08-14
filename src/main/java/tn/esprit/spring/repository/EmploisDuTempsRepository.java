package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.EmploisDuTemps;


@Repository
public interface EmploisDuTempsRepository extends JpaRepository<EmploisDuTemps,Long> {

}
