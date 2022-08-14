package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Eleve;



public interface IEleveService {
	List<Eleve> retrieveAllStudents();

	Eleve addStudent(Eleve s);

	  void deleteStudent(Long id);

	  Eleve updateStudent(Eleve u);

	  Eleve retrieveStudent(Long id);
	  
	  List<Object[]> retrieveStudentsByClass();
	  Object[] retrieveStudentByClass(Long eleveId);
}
