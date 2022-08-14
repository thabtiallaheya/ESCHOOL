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

import tn.esprit.entity.Eleve;
import tn.esprit.entity.Parent;
import tn.esprit.spring.service.IEleveService;
import tn.esprit.spring.service.IParentService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/parent")
@JsonIgnoreProperties
public class ParentRestController {
	@Autowired
	IParentService  parentService ;
	
	@GetMapping("/retrieve-all-parents")
	@ResponseBody
	public List<Parent> getParents() {
	List<Parent> listofParents = parentService.retrieveAllParents();
	return listofParents ;
	}
	
	
	@GetMapping("/retrieve-parent/{parent-id}")
	@ResponseBody
	public Parent retrieveParent(@PathVariable("parent-id") Long parentID) {
	return parentService.retrieveParent(parentID);
	}
	
	@PostMapping("/add-parent")
	@ResponseBody
	public Parent addParent(@RequestBody Parent Parent)
	{
		System.out.println(Parent);
	
		Parent s = parentService.addParent(Parent);
	return s;
	}
	
	
		@PutMapping("/modify-parent")
		@ResponseBody
		public Parent modifyParent(@RequestBody Parent Parent) {
		return parentService.updateParent(Parent);
		}
	
	@DeleteMapping("/remove-parent/{parent-id}")
	@ResponseBody
	public void removeParent(@PathVariable("parent-id") Long parentID) {
		parentService.deleteParent(parentID);
		
	}
}
