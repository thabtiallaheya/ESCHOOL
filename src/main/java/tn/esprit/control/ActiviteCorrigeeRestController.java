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
import tn.esprit.entity.ActiviteCorrigee;
import tn.esprit.spring.service.IActiviteCorrigeeService;
import tn.esprit.spring.service.IActiviteService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/corrected-activity")
@JsonIgnoreProperties
public class ActiviteCorrigeeRestController {
	@Autowired
	IActiviteCorrigeeService  activiteCorrigeeService ;
	
	@GetMapping("/retrieve-all-correctedactivities")
	@ResponseBody
	public List<ActiviteCorrigee> getCorrectedActivities() {
	List<ActiviteCorrigee> listCorrectedActivities = activiteCorrigeeService.retrieveAllCorrectedActivities();
	return listCorrectedActivities ;
	}
	
	
	/*@GetMapping("/retrieve-correctedActivity/{CorrectedActivity-id}")
	@ResponseBody
	public ActiviteCorrigee retrieveCorrectedActivity(@PathVariable("correctedActivity-id") Long correctedAtivityID) {
	return activiteCorrigeeService.retrieveCorrectedActivity(correctedAtivityID);
	}*/
	
	

	@GetMapping("/retrieve-correctedActivity/{correctedActivity-id}")
	@ResponseBody
	public ActiviteCorrigee retrieveStock(@PathVariable("correctedActivity-id") Long activityID) {
	return activiteCorrigeeService.retrieveCorrectedActivity(activityID);
	}
	
	@PostMapping("/add-correctedActivity")
	@ResponseBody
	public ActiviteCorrigee addCorrectedActivity(@RequestBody ActiviteCorrigee activiteCorrigee)
	{
		System.out.println(activiteCorrigee);
	
		ActiviteCorrigee s = activiteCorrigeeService.addCorrectedActivity(activiteCorrigee);
	return s;
	}
	
	
		@PutMapping("/modify-correctedActivity")
		@ResponseBody
		public ActiviteCorrigee modifyCorrectedActivity(@RequestBody ActiviteCorrigee activiteCorrigee) {
		return activiteCorrigeeService.updateCorrectedActivity(activiteCorrigee);
		}
	
	@DeleteMapping("/remove-correctedActivity/{correctedActivity-id}")
	@ResponseBody
	public void removeCorrectedActivity(@PathVariable("correctedActivity-id") Long correctedActivityID) {
		activiteCorrigeeService.deleteCorrectedActivity(correctedActivityID);
		
}
}
