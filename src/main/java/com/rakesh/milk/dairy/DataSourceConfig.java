package com.rakesh.milk.dairy;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rakesh.milk.dairy.prop.MyDataSourceProperties;
import com.rakesh.milk.dairy.prop.MyJpaProperties;

/**
 * 
 * @author rakesh.kumar
 *
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	private static Log LOG = LogFactory.getLog(DataSourceConfig.class);

	@Autowired
	private MyDataSourceProperties dataSourceProperties;
	@Autowired
	private MyJpaProperties jpaProperties;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;

	@Bean
	public DataSource getDataSource() {
		LOG.info("registering bean DataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
		dataSource.setPassword(dataSourceProperties.getPassword());
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		LOG.info("registering bean LocalContainerEntityManagerFactoryBean");
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPackagesToScan(jpaProperties.getPackageToScan());
	    // Vendor adapter
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	    
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", jpaProperties.getDatabasePlatform());
		hibernateProperties.put("hibernate.show_sql", jpaProperties.isShowSql());
		hibernateProperties.put("hibernate.hbm2ddl.auto", jpaProperties.getHbm2ddlAuto());
		entityManagerFactoryBean.setJpaProperties(hibernateProperties);
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager getJpaTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
		return jpaTransactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
