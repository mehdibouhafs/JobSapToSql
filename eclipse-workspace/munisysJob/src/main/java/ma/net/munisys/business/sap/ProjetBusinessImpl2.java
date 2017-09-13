package ma.net.munisys.business.sap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ma.net.munisys.dao.sap.ClientRepository2;
import ma.net.munisys.dao.sap.ProjetRepository2;
import ma.net.munisys.entities.sap.Client;
import ma.net.munisys.entities.sap.Projet;



@Service
public class ProjetBusinessImpl2 implements ProjetBusiness {
	
	
	@Autowired
	@Qualifier("ProjetRepository2")
	private ProjetRepository2 projetRepository2;
	
	@Autowired
	@Qualifier("ClientRepository2")
	private ClientRepository2 clientRepository2;

	
	@Override
	public List<Projet> findProjetSap() {
		// TODO Auto-generated method stub
		return projetRepository2.findProjetSap();
	}
	
	
	public List<Client> findClientSap(){
		return clientRepository2.findclientSap();
	}

	@Override
	public int countProjet() {
		// TODO Auto-generated method stub
		return projetRepository2.countProjet();
	}

	
	/* -1  = codeProjet non existant chez SAP  */
	@Override
	public int getIndexOfPrCode(String codeProjet) {
		// TODO Auto-generated method stub
		for(Projet projet : findProjetSap())
        {
            if(projet.getPrjCode().equals(codeProjet))
                return  findProjetSap().indexOf(projet);
        }
        return -1;
	}

	

	

	

}
