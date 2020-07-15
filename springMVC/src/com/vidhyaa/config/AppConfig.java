//package com.vidhyaa.config;
//
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScans;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import static org.hibernate.cfg.Environment.*;
// 
//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScans(value = { @ComponentScan("com.vidhyaa.dao"),
//      @ComponentScan("com.vidhyaa.service") })
//public class AppConfig {
// 
//   @Autowired
//   private Environment env;
// 
//   @Bean
//   public LocalSessionFactoryBean getSessionFactory() {
//      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
// 
//      Properties props = new Properties();
//      // Setting JDBC properties
//      props.put(DRIVER, env.getProperty("mysql.driver"));
//      props.put(URL, env.getProperty("mysql.url"));
//      props.put(USER, env.getProperty("mysql.user"));
//      props.put(PASS, env.getProperty("mysql.password"));
// 
//      // Setting Hibernate properties
//      props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
//      props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
// 
//      // Setting C3P0 properties
//      props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
//      props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
//      props.put(C3P0_ACQUIRE_INCREMENT, 
//            env.getProperty("hibernate.c3p0.acquire_increment"));
//      props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
//      props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
// 
//      factoryBean.setHibernateProperties(props);
//      factoryBean.setPackagesToScan("com.vidhyaa.model");
//      System.out.println("in AppConfig");
//      System.out.println("removed web.xml");
//      System.out.println("removed servlet.xml");
// 
//      return factoryBean;
//   }
// 
//   @Bean
//   public HibernateTransactionManager getTransactionManager() {
//      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//      transactionManager.setSessionFactory(getSessionFactory().getObject());
//      return transactionManager;
//   }
//}


package com.vidhyaa.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import static org.hibernate.cfg.Environment.*;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.vidhyaa" })

@PropertySource({"classpath:db.properties"})

@EnableJpaRepositories(basePackages = "com.vidhyaa.dao")
public class AppConfig {
	
	@Autowired
    private Environment env;
	
	public AppConfig()  {
		
		super();
	}
	
	
	@Bean
	public DataSource dataSource() {
	 final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 dataSource.setDriverClassName(env.getProperty("mysql.driver"));
	 dataSource.setUrl(env.getProperty("mysql.url"));
	 dataSource.setUsername(env.getProperty("mysql.user"));
	 dataSource.setPassword(env.getProperty("mysql.password"));
	 return dataSource;
	}
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(new String[] {
            "com.vidhyaa.model"
        });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(additionalProperties());

        return entityManagerFactoryBean;
    }
	
	  final Properties additionalProperties() {
	        final Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	        //hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
	        //hibernateProperties.setProperty("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
	        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
	        return hibernateProperties;
	    }
	  
	  @Bean
	    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
	        final JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        System.out.println("Inside Appconfig");
	        return transactionManager;
	    }
	  
	  @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }

	

}
















