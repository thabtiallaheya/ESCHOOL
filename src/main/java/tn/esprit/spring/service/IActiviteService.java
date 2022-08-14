package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Activite;

public interface IActiviteService {
	List<Activite> retrieveAllActivities();

	Activite addActivity(Activite s);

	  void deleteActivity(Long id);

	  Activite updateActivity(Activite u);

	  Activite retrieveActivity(Long id);
}
