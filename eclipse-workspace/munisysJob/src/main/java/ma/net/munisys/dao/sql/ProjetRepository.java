package ma.net.munisys.dao.sql;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.net.munisys.entities.sql.Client;
import ma.net.munisys.entities.sql.Projet;

@Repository
@Qualifier("ProjetRepository")
@Transactional
public interface ProjetRepository extends JpaRepository<Projet, String> {
	
	@Query("select count(*) from Projet")
	public int countProjet();
	
	/*@Query(value="select e.projet as projet,e.id as id,e.statut_Projet as statut_projet from ActiviterEmployer.Projet e",nativeQuery = true)
	public List<ma.net.munisys.entities.sql.Projet> findProjetSap();*/
	
	/*@Query(value="select count(*) from \"DB_MUNISYS\".\"OPRJ\"",nativeQuery = true)
	public int countProjet();*/
	
	

	/*
	 * /*private String id;
	private String projet;
	private int statut_Projet; 

	 * */
}
