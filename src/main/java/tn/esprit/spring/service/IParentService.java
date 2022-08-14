package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Parent;



public interface IParentService {
	List<Parent> retrieveAllParents();

	Parent addParent(Parent s);

	  void deleteParent(Long id);

	  Parent updateParent(Parent u);

	  Parent retrieveParent(Long id);
}
