package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entity.Activite;
import tn.esprit.entity.Classe;
import tn.esprit.entity.Cours;
import tn.esprit.spring.repository.ActiviteRepository;
import tn.esprit.spring.repository.ClasseRepository;
import tn.esprit.spring.repository.CoursRepository;

@Service
@Slf4j
public class CoursServiceImpl implements ICoursService {
	@Autowired
	CoursRepository coursRepository;
	@Autowired
	ClasseRepository classeRepository;
	
	@Override
	public List<Cours> retrieveAllCourses() {
		return 	(List<Cours>) coursRepository.findAll();
	}

	@Override
	public Cours addCourse(Cours s) {
		coursRepository.save(s);
		return s;
	}

	@Override
	public void deleteCourse(Long id) {
		coursRepository.deleteById(id);
		
	}

	@Override
	public Cours updateCourse(Cours u) {
		coursRepository.save(u);
		return u;
	}

	@Override
	public Cours retrieveCourse(Long id) {
		return coursRepository.findById(id).orElse(null);
	}

	/*@Override
	public void affecterCourseAClasse(Long courseId, Long classeId) {
		Classe classeManagedEntity = classeRepository.findById(classeId).get();
		Cours courseManagedEntity = coursRepository.findById(courseId).get();
		//depManagedEntity.getEmployes().add(employeManagedEntity);
		classeManagedEntity.getCours().add(courseManagedEntity);
		
	}*/

	@Override
	public void desaffecterCourseDeClasse(Long courseId, Long classeId) {
		// TODO Auto-generated method stub
		
	}

	

}
