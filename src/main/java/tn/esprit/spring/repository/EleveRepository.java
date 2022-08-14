package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Cours;
import tn.esprit.entity.Eleve;
@Repository
public interface EleveRepository extends JpaRepository<Eleve,Long>  {
	
	
	
	/*@Query("select e.*,c.nom from eleve e join classe c on classe_idclasse == idclasse")
	public Long getStrudentsbyClass();
	*/
	/*@Query("select count(e) from Employe e")
	public Long getEmployesNumber();
	
	@Query(
			  value = "select e.*,c.nom from eleve e join classe c on classe_idclasse == idclasse", 
			  nativeQuery = true);
	public Long getStrudentsbyClass();

	@Query(
			  value = "SELECT * FROM USERS u WHERE u.status = 1", 
			  nativeQuery = true)
			public List<Eleve> findAllActiveUsersNative();*/
	
	
	@Query(value="select e.*,c.niveau from eleve e join classe c on e.classe_idclasse = c.idclasse "
			,nativeQuery=true)
			public List<Object[]> getStrudentsbyClass();
			
			
			
			@Query(value="select e.*,c.niveau from eleve e join classe c on e.classe_idclasse = c.idclasse where e.id_eleve = eleveId "
					,nativeQuery=true)
					public Object[] getStrudentbyClass(@Param("eleveId") Long eleveId);
			
			
			
			@Query(value="select e.*,c.niveau from eleve e join classe c on e.classe_idclasse = c.idclasse where e.id_eleve=:eleveId "
					,nativeQuery=true)
					public Object[] getStudentAndHisClassName(@Param("eleveId") Long eleveId);
}
