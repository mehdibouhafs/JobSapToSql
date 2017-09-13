package ma.net.munisys.business.sap;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ma.net.munisys.entities.sap.Client;
import ma.net.munisys.entities.sap.Projet;
public interface ProjetBusiness {
	
	//public Projet saveProjet(Projet projet);
	
	
	public List<Projet> findProjetSap();
	
	public int countProjet();
	
	public int getIndexOfPrCode(String codeProjet);
	
	public List<Client> findClientSap();
	

}
