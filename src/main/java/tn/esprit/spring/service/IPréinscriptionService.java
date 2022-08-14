package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.entity.Préinscription;



public interface IPréinscriptionService {
	List<Préinscription> retrieveAllPréinscriptions();

	Préinscription addPréinscription(Préinscription s);

	  void deletePréinscription(Long id);

	  Préinscription updatePréinscription(Préinscription u);

	  Préinscription retrievePréinscription(Long id);
}
