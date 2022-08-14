package tn.esprit.control;

import java.util.List;
import java.util.Map;

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

import tn.esprit.entity.Classe;
import tn.esprit.entity.Cours;
import tn.esprit.entity.Eleve;
import tn.esprit.spring.service.IClasseService;
import tn.esprit.spring.service.ICoursService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/classe")
@JsonIgnoreProperties
public class ClasseRestController {

	
	@Autowired
	IClasseService  classeService ;
	
	@GetMapping("/retrieve-all-class")
	@ResponseBody
	public List<Classe> getClasses() {
	List<Classe> listClass = classeService.retrieveAllClass();
	return listClass ;
	}
	
	@GetMapping("/retrieve-all-classAndCourses")
	@ResponseBody
	public List<Object[]> getClassesAndCourses() {
		List<Object[]> listClass = classeService.getAllClassAndCourses();
	return listClass ;
	}
	
	@GetMapping("/retrieve-class/{course-id}")
	@ResponseBody
	public Classe retrieveClasse(@PathVariable("course-id") Long classeID) {
	return classeService.retrieveClass(classeID);
	}
	//http://localhost:8089/classe/retrieve-coursesByClasse?classeId=1
		@GetMapping("/retrieve-coursesByClasse")
		@ResponseBody
		public Object[] retrieveCoursesByClasse(@RequestParam("classeId") Long classeId) {
		return classeService.getAllClassByCourse(classeId);
		
		}
	
	@PostMapping("/add-class")
	@ResponseBody
	public Classe addClasse(@RequestBody Classe Class)
	{
		System.out.println(Class);
	
		Classe s = classeService.addClass(Class);
	return s;
	}
	
	
	
		@PutMapping("/modify-class")
		@ResponseBody
		public Classe modifyClasse(@RequestBody Classe Classe) {
		return classeService.updateClass(Classe);
		}
	
	@DeleteMapping("/remove-class/{class-id}")
	@ResponseBody
	public void removeCourse(@PathVariable("class-id") Long classeID) {
		classeService.deleteClass(classeID);	
	}
	
	
	// http://localhost:8089/classe/affecterClasseACourse/1/1
		@PutMapping(value = "/affecterClasseACourse/{idclasse}/{idcourse}") 
		public void affecterEmployeADepartement(@PathVariable("idclasse")Long classeId, @PathVariable("idcourse")Long courseId) {
			classeService.affecterClasseACours(classeId, courseId);
			
		}
}
