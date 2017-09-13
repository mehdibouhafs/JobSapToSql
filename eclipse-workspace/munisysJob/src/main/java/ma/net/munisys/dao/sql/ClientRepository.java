package ma.net.munisys.dao.sql;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.net.munisys.entities.sap.Client;
import ma.net.munisys.entities.sap.Projet;


@Repository
@Qualifier("ClientRepository")
public interface ClientRepository extends JpaRepository<ma.net.munisys.entities.sql.Client, String> {
	
	//@Query(value="select T.\"PrjCode\",T.\"PrjName\",T.\"UpdateDate\",T.\"U_CardCode\",T.\"U_CardName\",T.\"U_ChefProjet\",T.\"U_SlpName\" from \"DB_MUNISYS\".\"OPRJ\" T",nativeQuery = true)
	
	/*@Query(value="select T.\"PrjCode\" as PrjCode,T.\"PrjName\" as PrjName,T.\"UpdateDate\" as UpdateDate,T.\"U_CardCode\" as U_CardCode,T.\"U_CardName\" as U_CardName,T.\"U_ChefProjet\" as U_ChefProjet,T.\"U_SlpName\" as U_SlpName from \"DB_MUNISYS\".\"OPRJ\" T",nativeQuery = true)
	public List<Projet1> findProjetSap();*/

	
	@Query(value="select code_client as code_client, client as client from MUNITIME.dbo.Client ",nativeQuery = true)
	public List<ma.net.munisys.entities.sql.Client> findClientSql();
	
	
}
