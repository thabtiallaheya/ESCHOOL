package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Eleve;
import tn.esprit.entity.Préinscription;
import tn.esprit.spring.repository.EleveRepository;
import tn.esprit.spring.repository.PréinscriptionRepository;
@Service
@Slf4j
public class PréinscriptionServiceImpl implements IPréinscriptionService {
	@Autowired
	PréinscriptionRepository préinscriptionRepository;
	
	@Override
	public List<Préinscription> retrieveAllPréinscriptions() {
		return 	(List<Préinscription>) préinscriptionRepository.findAll();
	}

	@Override
	public Préinscription addPréinscription(Préinscription s) {
		préinscriptionRepository.save(s);
		return s;
	}

	@Override
	public void deletePréinscription(Long id) {
		préinscriptionRepository.deleteById(id);
		
	}

	@Override
	public Préinscription updatePréinscription(Préinscription u) {
		préinscriptionRepository.save(u);
		return u;
	}

	@Override
	public Préinscription retrievePréinscription(Long id) {
		return préinscriptionRepository.findById(id).orElse(null);
	}

}
