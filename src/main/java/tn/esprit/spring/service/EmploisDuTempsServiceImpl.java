package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Activite;
import tn.esprit.entity.EmploisDuTemps;
import tn.esprit.spring.repository.ActiviteRepository;
import tn.esprit.spring.repository.EmploisDuTempsRepository;

@Service
@Slf4j
public class EmploisDuTempsServiceImpl  implements IEmploisDuTempsService {
	@Autowired
	EmploisDuTempsRepository emploisDuTempsRepository;
	
	@Override
	public List<EmploisDuTemps> retrieveAllSchedules() {
		return 	(List<EmploisDuTemps>) emploisDuTempsRepository.findAll();
	}

	@Override
	public EmploisDuTemps addSchedule(EmploisDuTemps s) {
		emploisDuTempsRepository.save(s);
		return s;
	}

	@Override
	public void deleteSchedule(Long id) {
		emploisDuTempsRepository.deleteById(id);
		
	}

	@Override
	public EmploisDuTemps updateSchedule(EmploisDuTemps u) {
		emploisDuTempsRepository.save(u);
		return u;
	}

	@Override
	public EmploisDuTemps retrieveSchedule(Long id) {
		return emploisDuTempsRepository.findById(id).orElse(null);
	}

}
