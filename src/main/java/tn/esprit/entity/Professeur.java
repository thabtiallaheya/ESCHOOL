package tn.esprit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professeur {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long identifiant;
	@Column
	String nom;
	@Column
	String prenom;
	@Column
	String image;
	@Column
	@Temporal(TemporalType.DATE)
	Date dateDeNaissance;
	@Column
	String adresse;
	@Column
	String email;
	@Column
	String motDePasse;
	@Column
	long tel;
	@Column
	String biographie;
	@Column
	String specialite;
	
	
	
	
}
