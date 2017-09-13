package ma.net.munisys.dao.sap;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.net.munisys.entities.sap.Client;
import ma.net.munisys.entities.sap.Projet;


@Repository
@Qualifier("ClientRepository2")
public interface ClientRepository2 extends JpaRepository<Client, String> {
	
	//@Query(value="select T.\"PrjCode\",T.\"PrjName\",T.\"UpdateDate\",T.\"U_CardCode\",T.\"U_CardName\",T.\"U_ChefProjet\",T.\"U_SlpName\" from \"DB_MUNISYS\".\"OPRJ\" T",nativeQuery = true)
	
	/*@Query(value="select T.\"PrjCode\" as PrjCode,T.\"PrjName\" as PrjName,T.\"UpdateDate\" as UpdateDate,T.\"U_CardCode\" as U_CardCode,T.\"U_CardName\" as U_CardName,T.\"U_ChefProjet\" as U_ChefProjet,T.\"U_SlpName\" as U_SlpName from \"DB_MUNISYS\".\"OPRJ\" T",nativeQuery = true)
	public List<Projet1> findProjetSap();*/

	
	@Query(value="select T.\"CardCode\" as code_client,T.\"CardName\" as client from \"DB_MUNISYS\".\"OCRD\" T where T.\"CardCode\" LIKE 'C%'",nativeQuery = true)
	public List<Client> findclientSap();
	
	
}
