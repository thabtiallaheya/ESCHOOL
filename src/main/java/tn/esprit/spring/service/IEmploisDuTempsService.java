package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.EmploisDuTemps;



public interface IEmploisDuTempsService {
	List<EmploisDuTemps> retrieveAllSchedules();

	EmploisDuTemps addSchedule(EmploisDuTemps s);

	  void deleteSchedule(Long id);

	  EmploisDuTemps updateSchedule(EmploisDuTemps u);

	  EmploisDuTemps retrieveSchedule(Long id);
}
