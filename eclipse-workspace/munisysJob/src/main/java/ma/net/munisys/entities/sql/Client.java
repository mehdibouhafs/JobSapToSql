package ma.net.munisys.entities.sql;

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
	
	@OneToMany(mappedBy="client")
	private List<Projet> projets;
	
	

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


	public List<Projet> getProjets() {
		return projets;
	}


	public String getCode_client() {
		return code_client;
	}


	public void setCode_client(String code_client) {
		this.code_client = code_client;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public String toString() {
		return "Client SQL [codeClient=" + code_client + ", client=" + client + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//System.out.println("Equals");
		
		Client client = (Client) obj;
		Boolean same = false;
		
		if (obj != null && obj instanceof Client)
        {
			if(client.getCode_client().equals(this.getCode_client())) {
				same = true;
			}
            //sameSame = this.value == ((Thing) object).value;
        }
		
		return same;
	}


	
	
	
	
	

}
