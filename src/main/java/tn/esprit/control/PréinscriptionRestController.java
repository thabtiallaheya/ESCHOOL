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

import tn.esprit.entity.Parent;
import tn.esprit.entity.Préinscription;
import tn.esprit.spring.service.IParentService;
import tn.esprit.spring.service.IPréinscriptionService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/préinscription")
@JsonIgnoreProperties
public class PréinscriptionRestController {
	@Autowired
	IPréinscriptionService  préinscriptionService ;
	
	@GetMapping("/retrieve-all-préinscriptions")
	@ResponseBody
	public List<Préinscription> getPréinscription() {
	List<Préinscription> listeDepréinscriptions = préinscriptionService.retrieveAllPréinscriptions();
	return listeDepréinscriptions ;
	}
	
	
	@GetMapping("/retrieve-préinscription/{préinscription-id}")
	@ResponseBody
	public Préinscription retrievePréinscription(@PathVariable("préinscription-id") Long préinscriptionID) {
	return préinscriptionService.retrievePréinscription(préinscriptionID);
	}
	
	@PostMapping("/add-préinscription")
	@ResponseBody
	public Préinscription addPréinscription(@RequestBody Préinscription préinscription)
	{
		System.out.println(préinscription);
	
		Préinscription s = préinscriptionService.addPréinscription(préinscription);
	return s;
	}
	
	
		@PutMapping("/modify-préinscription")
		@ResponseBody
		public Préinscription modifyPréinscription(@RequestBody Préinscription Préinscription) {
		return préinscriptionService.updatePréinscription(Préinscription);
		}
	
	@DeleteMapping("/remove-Préinscription/{préinscription-id}")
	@ResponseBody
	public void removePréinscription(@PathVariable("préinscription-id") Long préinscriptionID) {
		préinscriptionService.deletePréinscription(préinscriptionID);
		
	}
}
