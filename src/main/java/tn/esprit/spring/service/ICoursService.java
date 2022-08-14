package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Cours;



public interface ICoursService {
	List<Cours> retrieveAllCourses();

	Cours addCourse(Cours s);

	  void deleteCourse(Long id);

	  Cours updateCourse(Cours u);

	  Cours retrieveCourse(Long id);
	  //void affecterCourseAClasse(Long courseId, Long classeId);
	  void desaffecterCourseDeClasse(Long courseId, Long classeId);
}
