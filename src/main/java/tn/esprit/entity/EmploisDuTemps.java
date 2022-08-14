package tn.esprit.entity;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class EmploisDuTemps {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idEmpoisDuTemps;
	
	@Column
	String description;
	@OneToOne
	@JsonBackReference(value="classe")
	private Classe classe;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "T_EMPLOISDUTEMPS_COURS",joinColumns={@JoinColumn(name="idEmpoisDuTemps")},inverseJoinColumns={@JoinColumn(name ="idcours")})
	private Set<Cours> cours;*/
	
	@OneToMany(mappedBy="emploisDuTemps")
	@JsonManagedReference(value="emploisDuTemps")
	private List<Cours> cours;
	

	
	
	

}
