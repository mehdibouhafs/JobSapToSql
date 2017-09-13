package ma.net.munisys.business.sql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ma.net.munisys.business.sap.ProjetBusinessImpl2;
import ma.net.munisys.dao.sql.ClientRepository;
import ma.net.munisys.dao.sql.ProjetRepository;
import ma.net.munisys.entities.sql.Client;
import ma.net.munisys.entities.sql.Projet;


@Service
public class ProjetBusinessImpl implements ProjetBusiness {
	
	
	@Autowired
	private ProjetRepository projetRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Autowired
	private ProjetBusinessImpl2 ProjetBusinessImpl2;

	@Override
	public ma.net.munisys.entities.sql.Projet saveProjet(Projet projet) {
		// TODO Auto-generated method stub
		return projetRepository.save(projet);
	}

	@Override
	public List<ma.net.munisys.entities.sql.Projet> listProjet() {
		// TODO Auto-generated method stub
		return projetRepository.findAll();
	}

	@Override
	public int countProjet() {
		// TODO Auto-generated method stub
		return projetRepository.countProjet();
	}

	

	@Override
	public String getLastCodeProjet() {
		// TODO Auto-generated method stub
		Projet projet = listProjet().get(listProjet().size() - 1);
		
		return projet.getId();
	}

	
	/* Projet SAp*/
	
	@Override
	public void saveNewProjet(List<ma.net.munisys.entities.sap.Projet> projets) {
		
		
		int startIndex  = ProjetBusinessImpl2.getIndexOfPrCode(getLastCodeProjet());
		
		//int startIndex = 2503;
	
     if(startIndex != projets.size()) {
			if(startIndex != -1) {
				
				System.out.println(" startIndex != -1 ");
				
			startIndex = startIndex + 1;
		
			}else {
				System.out.println(" startIndex = -1 ");
				startIndex = 0;
			}
			
			System.out.println("StartIndex = " + startIndex);
			System.out.println(" To " + projets.size());
			
			List<ma.net.munisys.entities.sap.Projet>  newProjetsSap;
			
			if(startIndex != projets.size()) {
				System.out.println("Add normal");
				newProjetsSap =  projets.subList(startIndex,projets.size());
			}else {
				System.out.println("Add only last element");
				newProjetsSap = new ArrayList<ma.net.munisys.entities.sap.Projet>();
				newProjetsSap.add(projets.get(startIndex-1));
			}
			
			System.out.println(newProjetsSap.size());
			//System.out.println("New Projet SAP " + newProjetsSap);
			
			for(ma.net.munisys.entities.sap.Projet projet : newProjetsSap) {
				
					
				
					Projet projetSql = new Projet();
					projetSql.setId(projet.getPrjCode());
					projetSql.setProjet(projet.getPrjName());
					Client c = new Client();
					if(projet.getU_CardCode() == null) {
					  c.setCode_client("");
					}else {
					 c.setCode_client(projet.getU_CardCode());
					}
					c.setClient(projet.getU_CardName());
					projetSql.setClient(c);
					projetSql.setStatut_Projet(1);
					projetSql.setU_chef_Projet(projet.getU_ChefProjet());
					projetSql.setU_slp_name(projet.getU_SlpName());
					projetSql.setUpdate_date(projet.getUpdateDate());
					
					
					
					System.out.println("SAve projet " + projetSql.toString());
					saveProjet(projetSql);
				
				
			}
		
     }else {
    	 	System.out.println("Nothing to add");
     }
		
	}

	@Override
	public List<Client> findClientSql() {
		// TODO Auto-generated method stub
		return clientRepository.findClientSql();
	}

	@Override
	public ma.net.munisys.entities.sql.Client saveClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	
	

	

	

}
