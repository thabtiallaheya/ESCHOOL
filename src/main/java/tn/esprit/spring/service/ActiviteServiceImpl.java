package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Activite;
import tn.esprit.spring.repository.ActiviteRepository;

@Service
@Slf4j
public class ActiviteServiceImpl implements IActiviteService {
	
	@Autowired
	ActiviteRepository activiteRepository;
	
	@Override
	public List<Activite> retrieveAllActivities() {
	
		return 	(List<Activite>) activiteRepository.findAll();
	}

	@Override
	public Activite addActivity(Activite s) {
		activiteRepository.save(s);
		return s;
	}

	@Override
	public void deleteActivity(Long id) {
		activiteRepository.deleteById(id);
		
	}

	@Override
	public Activite updateActivity(Activite u) {
		activiteRepository.save(u);
		return u;
	}

	@Override
	public Activite retrieveActivity(Long id) {
		return activiteRepository.findById(id).orElse(null);
	}

}
