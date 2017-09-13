package ma.net.munisys.entities.sap;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Client implements Serializable {
	
	@Id 
	private String code_client;
	private String client;
	
	/*@OneToMany(mappedBy="client")
	private List<Projet> projets;*/
	
	

	public Client() {
		super();
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}

	
	
	

	/*@net.minidev.json.annotate.JsonIgnore
	public List<Projet> getProjets() {
		return projets;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
*/

	public String getCode_client() {
		return code_client;
	}


	public void setCode_client(String code_client) {
		this.code_client = code_client;
	}


	@Override
	public String toString() {
		return "Client SAP [codeClient=" + code_client + ", client=" + client + "]";
	}


	
	
	
	
	

}
