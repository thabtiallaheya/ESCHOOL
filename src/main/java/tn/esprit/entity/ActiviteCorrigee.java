package tn.esprit.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActiviteCorrigee {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idActiviteCorrigee;
	
	@Column
	String Contenue;
	

	@OneToOne(mappedBy="activiteCorrigee")
	@JsonManagedReference(value="activiteCorrigee")
	private Activite activite;
	
	

}
