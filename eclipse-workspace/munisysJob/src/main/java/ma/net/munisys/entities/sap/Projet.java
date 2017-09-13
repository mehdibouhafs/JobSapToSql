package ma.net.munisys.entities.sap;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Projet implements Serializable {
	
	@Id
	private String PrjCode;
	private String PrjName;
	private Date UpdateDate; 
	private String U_CardCode;
	private String U_CardName;
	private String U_ChefProjet;
	private String U_SlpName;
	
	
	public Projet() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPrjCode() {
		return PrjCode;
	}
	public void setPrjCode(String prjCode) {
		PrjCode = prjCode;
	}
	public String getPrjName() {
		return PrjName;
	}
	public void setPrjName(String prjName) {
		PrjName = prjName;
	}
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}
	public String getU_CardCode() {
		return U_CardCode;
	}
	public void setU_CardCode(String u_CardCode) {
		U_CardCode = u_CardCode;
	}
	public String getU_CardName() {
		return U_CardName;
	}
	public void setU_CardName(String u_CardName) {
		U_CardName = u_CardName;
	}
	public String getU_ChefProjet() {
		return U_ChefProjet;
	}
	public void setU_ChefProjet(String u_ChefProjet) {
		U_ChefProjet = u_ChefProjet;
	}
	public String getU_SlpName() {
		return U_SlpName;
	}
	public void setU_SlpName(String u_SlpName) {
		U_SlpName = u_SlpName;
	}
	@Override
	public String toString() {
		return "Projet SAP [PrjCode=" + PrjCode + ", PrjName=" + PrjName + ", UpdateDate=" + UpdateDate + ", U_CardCode="
				+ U_CardCode + ", U_CardName=" + U_CardName + ", U_ChefProjet=" + U_ChefProjet + ", U_SlpName="
				+ U_SlpName + "]";
	}
	
	/*@ManyToOne
	private Client client;*/
	
	
	
	
	
	

}
