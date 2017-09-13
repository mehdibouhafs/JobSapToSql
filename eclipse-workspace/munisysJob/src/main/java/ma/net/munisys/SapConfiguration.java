package ma.net.munisys;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "ma.net.munisys.dao.sap", entityManagerFactoryRef = "sapEntityManager",transactionManagerRef = "sapTransactionManager")
@EnableTransactionManagement
public class SapConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "datasource.db.sap")
	public DataSource sapDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sapEntityManager")
	public LocalContainerEntityManagerFactoryBean sapEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(sapDataSource())
				.packages("ma.net.munisys.entities.sap")
				.persistenceUnit("sapPersistenceUnit")
				.build();
	}
	
	 @Bean(name="sapTransactionManager")
	  public JpaTransactionManager sapTransactionManager(@Qualifier("sapEntityManager") final EntityManagerFactory factory)
	  {
	    return new JpaTransactionManager(factory);
	  }

}
