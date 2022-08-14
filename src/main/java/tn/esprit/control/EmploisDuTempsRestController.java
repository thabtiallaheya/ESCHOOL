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
import tn.esprit.entity.EmploisDuTemps;
import tn.esprit.spring.service.IActiviteService;
import tn.esprit.spring.service.IEmploisDuTempsService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/schedule")
@JsonIgnoreProperties
public class EmploisDuTempsRestController {
	@Autowired
	IEmploisDuTempsService  emploisDuTempsService ;
	
	
	@GetMapping("/retrieve-all-schedules")
	@ResponseBody
	public List<EmploisDuTemps> getSchedules() {
	List<EmploisDuTemps> listSchedules= emploisDuTempsService.retrieveAllSchedules();
	return listSchedules ;
	}
	
	
	@GetMapping("/retrieve-schedule/{schedule-id}")
	@ResponseBody
	public EmploisDuTemps retrieveSchedule(@PathVariable("schedule-id") Long scheduleID) {
	return emploisDuTempsService.retrieveSchedule(scheduleID);
	}
	
	@PostMapping("/add-schedule")
	@ResponseBody
	public EmploisDuTemps addSchedule(@RequestBody EmploisDuTemps Schedule)
	{
		System.out.println(Schedule);
	
		EmploisDuTemps s = emploisDuTempsService.addSchedule(Schedule);
		return s;
	}
	
	
		@PutMapping("/modify-schedule")
		@ResponseBody
		public EmploisDuTemps modifySchedule(@RequestBody EmploisDuTemps schedule) {
		return emploisDuTempsService.updateSchedule(schedule);
		}
	
	@DeleteMapping("/remove-schedule/{schedule-id}")
	@ResponseBody
	public void removeSchedule(@PathVariable("schedule-id") Long scheduleID) {
		emploisDuTempsService.deleteSchedule(scheduleID);
		
	}
	
	
	
}
