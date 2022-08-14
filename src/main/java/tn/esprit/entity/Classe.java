package tn.esprit.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Classe {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	private long idclasse;
	
	@Column
	String niveau;
	
	@Column
	int Numero_de_la_salle;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "T_CLASSE_COURS",joinColumns={@JoinColumn(name="idclasse")},inverseJoinColumns={@JoinColumn(name ="idcours")})
	private Set<Cours> cours;
	
	@OneToMany(mappedBy="classe")
	@JsonManagedReference(value="classe")
	private List<Eleve> eleves;
	
	
	@OneToOne
	@JsonBackReference(value="emploisDuTemps")
	private EmploisDuTemps emploisDuTemps;
	
	

}
