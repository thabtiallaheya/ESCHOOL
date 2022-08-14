package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Activite;
import tn.esprit.entity.ActiviteCorrigee;

public interface IActiviteCorrigeeService {
	List<ActiviteCorrigee> retrieveAllCorrectedActivities();

	ActiviteCorrigee addCorrectedActivity(ActiviteCorrigee s);

	  void deleteCorrectedActivity(Long id);

	  ActiviteCorrigee updateCorrectedActivity(ActiviteCorrigee u);

	  ActiviteCorrigee retrieveCorrectedActivity(Long id);
}
