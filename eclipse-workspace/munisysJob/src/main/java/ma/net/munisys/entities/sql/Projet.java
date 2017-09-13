package ma.net.munisys.entities.sql;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Projet implements Serializable {
	
	@Id
	private String id;
	private String projet;
	private int statut_Projet; 
	private Date update_date; 
	private String u_chef_Projet;
	private String u_slp_name;
	
	
	@ManyToOne
	private Client client;
	
	public Projet() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjet() {
		return projet;
	}
	public void setProjet(String projet) {
		this.projet = projet;
	}
	
	public int getStatut_Projet() {
		return statut_Projet;
	}
	
	public void setStatut_Projet(int statut_Projet) {
		this.statut_Projet = statut_Projet;
	}
	
	
	

	

	public Date getUpdate_date() {
		return update_date;
	}


	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public String getU_chef_Projet() {
		return u_chef_Projet;
	}


	public void setU_chef_Projet(String u_chef_Projet) {
		this.u_chef_Projet = u_chef_Projet;
	}


	public String getU_slp_name() {
		return u_slp_name;
	}


	public void setU_slp_name(String u_slp_name) {
		this.u_slp_name = u_slp_name;
	}


	@Override
	public String toString() {
		return "Projet [id=" + id + ", projet=" + projet + ", statut_Projet=" + statut_Projet + ", updateDate="
				+ update_date + ", u_chef_Projet=" + u_chef_Projet + ", u_slp_name=" + u_slp_name + ", client=" + client
				+ "]";
	}

	


	
	
	

}
