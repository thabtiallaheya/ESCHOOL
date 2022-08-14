package tn.esprit.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tn.esprit.entity.Cours;
import tn.esprit.entity.Eleve;
import tn.esprit.spring.service.ICoursService;
import tn.esprit.spring.service.IEleveService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/student")
@JsonIgnoreProperties
public class EleveRestController {
	@Autowired
	IEleveService  eleveService ;
	
	@GetMapping("/retrieve-all-students")
	@ResponseBody
	public List<Eleve> getCourses() {
	List<Eleve> listofStudents = eleveService.retrieveAllStudents();
	return listofStudents ;
	}
	

	@GetMapping("/retrieve-studentsByClasse")
	@ResponseBody
	public List<Object[]> retrieveStudentsByClasse() {
	return eleveService.retrieveStudentsByClass();
	}
	/*@GetMapping("/retrieve-all-studentsByClasse")
	@ResponseBody
	public List<Object> getStudents() {
	List<Object> listofStudents = eleveService.retrieveStudentsByClass();
	return listofStudents ;
	}*/
	
	@GetMapping("/retrieve-student/{student-id}")
	@ResponseBody
	public Eleve retrieveStudent(@PathVariable("student-id") Long studentID) {
	return eleveService.retrieveStudent(studentID);
	}
	
	

	//http://localhost:8089/student/retrieve-studentsByClasse?eleveId=1
	@GetMapping("/retrieve-studentByClasse")
	@ResponseBody
	public Object[] retrieveStudentsByClasse(@RequestParam("eleveId") Long eleveId) {
	return eleveService.retrieveStudentByClass(eleveId);
	
	}
	
	@PostMapping("/add-student")
	@ResponseBody
	public Eleve addStudent(@RequestBody Eleve Eleve)
	{
		System.out.println(Eleve);
	
		Eleve s = eleveService.addStudent(Eleve);
	return s;
	}
	
	
		@PutMapping("/modify-student")
		@ResponseBody
		public Eleve modifyStudent(@RequestBody Eleve Eleve) {
		return eleveService.updateStudent(Eleve);
		}
	
	@DeleteMapping("/remove-student/{student-id}")
	@ResponseBody
	public void removeStudent(@PathVariable("student-id") Long studentID) {
		eleveService.deleteStudent(studentID);
		
	}
	
}
