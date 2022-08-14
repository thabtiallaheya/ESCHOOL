package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;

import tn.esprit.entity.Classe;


public interface IClasseService {
	List<Classe> retrieveAllClass(); 
	List<Object[]> getAllClassAndCourses();
	Object[] getAllClassByCourse(Long classeId);

	Classe addClass(Classe s);

	  void deleteClass(Long id);

	  Classe updateClass(Classe u);

	  Classe retrieveClass(Long id);
	  void affecterClasseACours(Long classeId , Long courseId);
	  
}
