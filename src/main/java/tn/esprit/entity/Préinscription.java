package tn.esprit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Préinscription {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idPréinscription;
	@Column
	String nomDeLeleve;
	@Column
	String prenomDeLeleve;
	@Column
	String image;
	@Column
	@Temporal(TemporalType.DATE)
	Date dateDeNaissance;
	@Column
	String adresse;
	@Column
	String niveau_etude ;
	@Column
	@Temporal(TemporalType.DATE)
	Date dateDeLaPréinscrit;
	@Column
	Boolean inscrit_au_Bus ;
	@Column
	Boolean inscrit_au_Restauration ;
	
	
	

}
