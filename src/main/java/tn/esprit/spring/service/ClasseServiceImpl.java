package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Classe;
import tn.esprit.entity.Cours;
import tn.esprit.spring.repository.ClasseRepository;
import tn.esprit.spring.repository.CoursRepository;
@Service
@Slf4j
public class ClasseServiceImpl implements IClasseService {
	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	CoursRepository coursRepository;
	
	@Override
	public List<Classe> retrieveAllClass() {
		return 	(List<Classe>) classeRepository.findAll();
	}
	
	

	@Override
	public Classe addClass(Classe s) {
		classeRepository.save(s);
		return s;
	}

	@Override
	public void deleteClass(Long id) {
		classeRepository.deleteById(id);
		
	}

	@Override
	public Classe updateClass(Classe u) {
		classeRepository.save(u);
		return u;
	}

	@Override
	public Classe retrieveClass(Long id) {
		return classeRepository.findById(id).orElse(null);
	}




	@Transactional
	public void affecterClasseACours(Long classeId, Long courseId) {
		Cours courseManagedEntity = coursRepository.findById(courseId).get();
		Classe classeManagedEntity = classeRepository.findById(classeId).get();

		
		courseManagedEntity.getClasses().add(classeManagedEntity);
		
		
	}



	@Override
	public List<Object[]> getAllClassAndCourses() {
		return classeRepository.getAllClassesAndCourses();
	}



	@Override
	public Object[] getAllClassByCourse(Long classeId) {
		
		return classeRepository.getClassesByCourses(classeId);
	}

}
