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
import tn.esprit.spring.service.IActiviteService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/activity")
@JsonIgnoreProperties
public class ActiviteRestController {

	@Autowired
	 IActiviteService  activiteService ;
	
	@GetMapping("/retrieve-all-activities")
	@ResponseBody
	public List<Activite> getActivities() {
	List<Activite> listActivities = activiteService.retrieveAllActivities();
	return listActivities ;
	}
	
	
	@GetMapping("/retrieve-activity/{activity-id}")
	@ResponseBody
	public Activite retrieveStock(@PathVariable("activity-id") Long activityID) {
	return activiteService.retrieveActivity(activityID);
	}
	
	@PostMapping("/add-activity")
	@ResponseBody
	public Activite addStock(@RequestBody Activite Activity)
	{
		System.out.println(Activity);
	
		Activite s = activiteService.addActivity(Activity);
	return s;
	}
	
	
		@PutMapping("/modify-activity")
		@ResponseBody
		public Activite modifyStock(@RequestBody Activite Activity) {
		return activiteService.updateActivity(Activity);
		}
	
	@DeleteMapping("/remove-activity/{activity-id}")
	@ResponseBody
	public void removeStock(@PathVariable("activity-id") Long activityID) {
		activiteService.deleteActivity(activityID);;
		
	}
	
	
	
}
