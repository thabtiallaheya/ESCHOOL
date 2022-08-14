package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Cours;
import tn.esprit.entity.Eleve;
import tn.esprit.spring.repository.CoursRepository;
import tn.esprit.spring.repository.EleveRepository;
@Service
@Slf4j
public class EleveServiceImpl implements IEleveService {
	@Autowired
	EleveRepository eleveRepository;
	
	@Override
	public List<Eleve> retrieveAllStudents() {
		return 	(List<Eleve>) eleveRepository.findAll();
	}

	@Override
	public Eleve addStudent(Eleve s) {
		eleveRepository.save(s);
		return s;
	}

	@Override
	public void deleteStudent(Long id) {
		eleveRepository.deleteById(id);
		
	}

	@Override
	public Eleve updateStudent(Eleve u) {
		eleveRepository.save(u);
		return u;
	}

	@Override
	public Eleve retrieveStudent(Long id) {
		return eleveRepository.findById(id).orElse(null);
	}

	@Override
	public List<Object[]> retrieveStudentsByClass() {
		return eleveRepository.getStrudentsbyClass();
	}

	@Override
	public Object[] retrieveStudentByClass(Long eleveId) {
		
		return eleveRepository.getStudentAndHisClassName(eleveId);
	}

	

}
