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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tn.esprit.entity.Activite;
import tn.esprit.entity.Cours;
import tn.esprit.spring.service.IActiviteService;
import tn.esprit.spring.service.ICoursService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/course")
@JsonIgnoreProperties
public class CoursRestController {

	
	@Autowired
	 ICoursService  coursService ;
	
	@GetMapping("/retrieve-all-courses")
	@ResponseBody
	public List<Cours> getCourses() {
	List<Cours> listCourses = coursService.retrieveAllCourses();
	return listCourses ;
	}
	
	
	@GetMapping("/retrieve-course/{course-id}")
	@ResponseBody
	public Cours retrieveCourse(@PathVariable("course-id") Long courseID) {
	return coursService.retrieveCourse(courseID);
	}
	
	@PostMapping("/add-course")
	@ResponseBody
	public Cours addCourse(@RequestBody Cours Cours)
	{
		System.out.println(Cours);
	
		Cours s = coursService.addCourse(Cours);
	return s;
	}
	
	
		@PutMapping("/modify-course")
		@ResponseBody
		public Cours modifyCourse(@RequestBody Cours Cours) {
		return coursService.updateCourse(Cours);
		}
	
	@DeleteMapping("/remove-course/{course-id}")
	@ResponseBody
	public void removeCourse(@PathVariable("course-id") Long courseID) {
		coursService.deleteCourse(courseID);
		
	}
	
	
	/*//http://localhost:8089/course/affecterCourseAClasse/1/1
		@PutMapping(value = "/affecterCourseAClasse/{idcourse}/{idclasse}") 
		public void affecterCourseAClasse(@PathVariable("idcourse")Long idcourse, @PathVariable("idclasse")Long idclasse) {
			coursService.affecterCourseAClasse(idcourse, idclasse);		
		}*/
	
}
