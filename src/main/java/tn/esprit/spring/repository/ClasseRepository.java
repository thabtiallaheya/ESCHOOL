package tn.esprit.spring.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Activite;
import tn.esprit.entity.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe,Long>{
	/*@Query(value="select cl.*,cr.* from classe cl join cours cr on cl.idclasse = cr.idcours "
			,nativeQuery=true)
			public List<Object[]> getClassesAndCourses();*/
			
			@Query(value="select cl.cours from Classe cl "
					,nativeQuery=false)
					public List<Object[]> getAllClassesAndCourses();
					
					@Query(value="select cl.cours from Classe cl where cl.idclasse=:classeId "
							,nativeQuery=false)
							public Object[] getClassesByCourses(@Param("classeId") Long classeId);
}
