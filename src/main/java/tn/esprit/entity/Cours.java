package tn.esprit.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Cours {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idcours;
	
	@Column
	String nom;
	
	@Column
	String description;
	
	@Column
	String tag;
	
	@Column
	String picture;
	
	@Column
	String contenue;
	
	@Column
	int dureeEnHeures;
	
	@Column
	String langue;
	
	@Column
	String jours;
	@Column
	@Temporal(TemporalType.DATE)
	Date date;
	@Column
	 LocalTime horaire_debut;
	@Column
	 LocalTime horaire_fin;
	
	
	@OneToMany(mappedBy="cours")
	@JsonManagedReference(value="cours")
	private List<Activite> activites;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_CLASSE_COURS",joinColumns={@JoinColumn(name="idcours")},inverseJoinColumns={@JoinColumn(name ="idclasse")})
	private Set<Classe> classes;
	
	

	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_EMPLOISDUTEMPS_COURS",joinColumns={@JoinColumn(name="idcours")},inverseJoinColumns={@JoinColumn(name ="idEmpoisDuTemps")})
	private Set<EmploisDuTemps> emploisDuTemps;*/
	
	@ManyToOne
	@JsonBackReference(value="emploisDuTemps")
	private EmploisDuTemps emploisDuTemps;
	

	
	
	
	
	
}
