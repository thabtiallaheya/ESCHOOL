package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Eleve;
import tn.esprit.entity.Parent;
import tn.esprit.spring.repository.EleveRepository;
import tn.esprit.spring.repository.ParentRepository;
@Service
@Slf4j
public class ParentServiceImpl implements IParentService {
	@Autowired
	ParentRepository parentRepository;
	@Override
	public List<Parent> retrieveAllParents() {
		return 	(List<Parent>) parentRepository.findAll();
	}

	@Override
	public Parent addParent(Parent s) {
		parentRepository.save(s);
		return s;
	}

	@Override
	public void deleteParent(Long id) {
		parentRepository.deleteById(id);
		
	}

	@Override
	public Parent updateParent(Parent u) {
		parentRepository.save(u);
		return u;
	}

	@Override
	public Parent retrieveParent(Long id) {
		return parentRepository.findById(id).orElse(null);
	}

}
