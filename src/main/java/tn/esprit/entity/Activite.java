package tn.esprit.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Activite {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idActivity;
	
	@Column
	String title;
	
	@Column
	String Contenue;
	
	
	@Column
	@Temporal(TemporalType.DATE)
	Date dateCreation;
	
	@Column
	@Temporal(TemporalType.DATE)
	Date dateLimite;
	
	@ManyToOne
	@JsonBackReference(value="cours")
	private Cours cours;
	
	@OneToOne
	@JsonBackReference(value="activiteCorrigee")
	private ActiviteCorrigee activiteCorrigee;
	
	
	
	
	
	
	
	
}
