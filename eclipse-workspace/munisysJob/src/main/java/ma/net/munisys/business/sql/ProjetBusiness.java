package ma.net.munisys.business.sql;

import java.util.List;

import org.springframework.data.repository.query.Param;
import ma.net.munisys.entities.sap.Client;
import ma.net.munisys.entities.sql.Projet;


public interface ProjetBusiness {
	
	public Projet saveProjet(Projet projet);
	public List<Projet> listProjet();
	
	public int countProjet();
	
	public ma.net.munisys.entities.sql.Client saveClient(ma.net.munisys.entities.sql.Client client);
	
	public String getLastCodeProjet();
	
	public void saveNewProjet(List<ma.net.munisys.entities.sap.Projet> projets);
	
	public List<ma.net.munisys.entities.sql.Client> findClientSql();
}
