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
@EnableJpaRepositories(basePackages = "ma.net.munisys.dao.sql", entityManagerFactoryRef = "sqlEntityManager",transactionManagerRef = "sqlTransactionManager")
@EnableTransactionManagement
public class SqlServerConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "datasource.db.mysql")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sqlEntityManager")
	public LocalContainerEntityManagerFactoryBean sqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(mysqlDataSource())
				.packages("ma.net.munisys.entities.sql")
				.persistenceUnit("sqlPersistenceUnit")
				.build();
	}
	
	 @Bean
	  public JpaTransactionManager sqlTransactionManager(@Qualifier("sqlEntityManager") final EntityManagerFactory factory)
	  {
	    return new JpaTransactionManager(factory);
	  }

}
