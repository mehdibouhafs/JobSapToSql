package ma.net.munisys;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ma.net.munisys.business.sql.ProjetBusiness;
import ma.net.munisys.business.sql.ProjetBusinessImpl;
import ma.net.munisys.entities.sql.Client;
import ma.net.munisys.entities.sql.Projet;
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling
public class MunisysJobApplication {
	
	
	
	 
		private static final Logger log = LoggerFactory.getLogger(MunisysJobApplication.class);
		  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		  
		  @Autowired
		  private ApplicationContext ctx;
		  
		/*@Scheduled(cron="0 0/5 * * * ?")
		  //@Scheduled(fixedRate = 10000)
	    public void jobSapToSql() {
			ProjetBusiness projetBusinessMysql = ctx.getBean(ProjetBusinessImpl.class);
			
			
			ma.net.munisys.business.sap.ProjetBusiness projetBusinessMysql2 = ctx.getBean(ma.net.munisys.business.sap.ProjetBusinessImpl2.class);
			projetBusinessMysql.saveNewProjet(projetBusinessMysql2.findProjetSap());
	
	    }*/
		
		
		/*
		@Scheduled(cron="0 0/5 * * * ?")
		  //@Scheduled(fixedRate = 10000)
	    public void jobSapToSql2() {
			
			
			ProjetBusiness projetBusinessMysql = ctx.getBean(ProjetBusinessImpl.class);
			ma.net.munisys.business.sap.ProjetBusiness projetBusinessMysql2 = ctx.getBean(ma.net.munisys.business.sap.ProjetBusinessImpl2.class);

			List<Client> clientSapToSql = clientSapToSql(projetBusinessMysql2.findClientSap());
			List<Client> clientSql = projetBusinessMysql.findClientSql();
			List<Client> clients = new ArrayList<>();
			   
			   for(Client clientsap : clientSapToSql) {
				   if(!clientSql.contains(clientsap)) {
					   clients.add(clientsap);
					   projetBusinessMysql.saveClient(clientsap);
				   }else {
					   System.out.println("contain");
				   }
			   }
			   
			   
			   System.out.println("Difference " + clients.size());
	    }*/
		
		
		public  static List<ma.net.munisys.entities.sql.Client> clientSapToSql(List<ma.net.munisys.entities.sap.Client> clientsSap){
			
			List<ma.net.munisys.entities.sql.Client> clientSapToSql = new ArrayList<>();
			for(ma.net.munisys.entities.sap.Client client : clientsSap) {
				ma.net.munisys.entities.sql.Client clientSql = new ma.net.munisys.entities.sql.Client();
				if(client != null) {
				clientSql.setClient(client.getClient());
				clientSql.setCode_client(client.getCode_client());
				clientSapToSql.add(clientSql);
				}
			}
			return clientSapToSql;
			
			
		}
	

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MunisysJobApplication.class, args);
		
		ProjetBusiness projetBusinessMysql = ctx.getBean(ProjetBusinessImpl.class);
		
		
		ma.net.munisys.business.sap.ProjetBusiness projetBusinessMysql2 = ctx.getBean(ma.net.munisys.business.sap.ProjetBusinessImpl2.class);
		
		
		List<Client> clientSapToSql = clientSapToSql(projetBusinessMysql2.findClientSap());
		List<Client> clientSql = projetBusinessMysql.findClientSql();
		List<Client> clients = new ArrayList<>();
		   
		   for(Client clientsap : clientSapToSql) {
			   if(!clientSql.contains(clientsap)) {
				   clients.add(clientsap);
				   projetBusinessMysql.saveClient(clientsap);
			   }else {
				   System.out.println("contain");
			   }
		   }
		   
		   
		   System.out.println("Difference " + clients.size());
		
		projetBusinessMysql.saveNewProjet(projetBusinessMysql2.findProjetSap());
		
		
		/*ma.net.munisys.entities.mysql2.Projet p = new ma.net.munisys.entities.mysql2.Projet();
		p.setId("lol");
		p.setProjet("lol");
		p.setStatutProjet(1);
		projetBusinessMysql2.saveProjet(p);*/
		
		/*for(ma.net.munisys.entities.sap.Projet o : projetBusinessMysql2.findProjetByClient()) {
			System.out.println(o.toString());
		}*/
		
		//System.out.println("Count " + projetBusinessMysql.countProjet());
		
		//System.out.println("2Count " + projetBusinessMysql2.countProjet());
		
		//System.out.println("Last id " + projetBusinessMysql.getLastCodeProjet());
		
		//System.out.println("Ccount SAP =  " + projetBusinessMysql2.countProjet());
		
		
		//System.out.println(" Client sql " + projetBusinessMysql.findClientSql().size());
		
		//System.out.println(" Client SAP " + projetBusinessMysql2.findClientSap());
	
	
		//System.out.println("Size Client Sap to Sql" +  clientSapToSql.size());
		
		
		
		 /*List<Client> clientSql = projetBusinessMysql.findClientSql();
		 
		 System.out.println("Tout nos client sql  = " + clientSql.size());
		 
		    //clientSql.retainAll(clientSapToSql);
		    
		    
		   System.out.println("Tout nos Client SAP " + projetBusinessMysql2.findClientSap().size()); 
		   //System.out.println("NOs Client with projet = " + clientSql);*/

		
		
		
		//System.out.println("list projets " + projetBusinessMysql2.findProjetSap());
		/*List<ma.net.munisys.entities.sap.Projet> projets = new ArrayList<>();
		for(ma.net.munisys.entities.sap.Projet pe : projetBusinessMysql2.findProjetSap()) {
			ma.net.munisys.entities.sap.Projet pro = new ma.net.munisys.entities.sap.Projet();
			pro.setPrjCode(pe.getPrjCode());
			pro.setPrjName(pe.getPrjName());
			//pro.setUpdateDate(pe.ge);
			projets.add(pro);
		}*/
		
		/*System.out.println("2-list projets " + projetBusinessMysql.findProjetSap());
		List<Projet> projets = new ArrayList<>();
		for(ma.net.munisys.entities.sql.Projet pe : projetBusinessMysql.findProjetSap()) {
			Projet pro = new ma.net.munisys.entities.sql.Projet();
			pro.setId(pe.getId());
			pro.setProjet(pe.getProjet());
			pro.setStatut_Projet(pe.getStatut_Projet());
			//pro.setUpdateDate(pe.ge);
			projets.add(pro);
		}
		
		System.out.println("projets" + projets);*/

	}
}
