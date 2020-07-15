package com.ankit.todo.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
@org.springframework.context.annotation.Configuration
public class HibernateConfig {
	
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.ankit.todo.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
 
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/todo");
        dataSource.setUsername("root");
        dataSource.setPassword("Pawar@Ankit");
 
        return dataSource;
    }
 
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
 
    private final Properties hibernateProperties() {
    	Properties settings=new Properties();
		settings.put(Environment.SHOW_SQL, true);
		  settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		settings.put(Environment.HBM2DDL_AUTO, "update");
		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        return settings;
    }
//@Bean
//public  SessionFactory getSessionFactory() {
//	
//	
//		Configuration configuration=new Configuration();
//		Properties settings=new Properties();
//		settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
//		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/todo");
//		settings.put(Environment.USER, "root");
//		settings.put(Environment.PASS, "Pawar@Ankit");
//		settings.put(Environment.SHOW_SQL, true);
//		  settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
//		settings.put(Environment.HBM2DDL_AUTO, "update");
//		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//		
//		configuration.addProperties(settings);
//		configuration.addAnnotatedClass(Todo.class);
//		ServiceRegistry sr=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//		SessionFactory sessionFactory=configuration.buildSessionFactory(sr);
//		return sessionFactory;
//}
}
