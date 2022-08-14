package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Activite;
import tn.esprit.entity.ActiviteCorrigee;
import tn.esprit.spring.repository.ActiviteCorrigeeRepository;
import tn.esprit.spring.repository.ActiviteRepository;
@Service
@Slf4j
public class ActiviteCorrigeeServiceImpl implements IActiviteCorrigeeService {

	@Autowired
	ActiviteCorrigeeRepository activiteCorrigeeRepository;
	
	@Override
	public List<ActiviteCorrigee> retrieveAllCorrectedActivities() {
		return 	(List<ActiviteCorrigee>) activiteCorrigeeRepository.findAll();
	}

	@Override
	public ActiviteCorrigee addCorrectedActivity(ActiviteCorrigee s) {
		activiteCorrigeeRepository.save(s);
		return s;
	}

	@Override
	public void deleteCorrectedActivity(Long id) {
		activiteCorrigeeRepository.deleteById(id);
		
		
	}

	@Override
	public ActiviteCorrigee updateCorrectedActivity(ActiviteCorrigee u) {
		activiteCorrigeeRepository.save(u);
		return u;
	}

	@Override
	public ActiviteCorrigee retrieveCorrectedActivity(Long id) {
		return activiteCorrigeeRepository.findById(id).orElse(null);
	}

}
