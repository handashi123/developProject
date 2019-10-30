package com.handashi.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Lazy
@EnableTransactionManagement
@MapperScan(basePackages = {"com.handashi.**.mapper"})
public class DefaultDatabaseConfig{
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("오라클URL");
		hikariConfig.setUsername("오라클ID");
		hikariConfig.setPassword("오라클 패스워드");
		
		// spring.datasource.hikari 가 prefix		
		return hikariConfig;
	}
	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		// hikariCP 는 spring 2.0 부터 사용되는 connection pool
		return dataSource;
		
	}
	
	@Bean
	public PlatformTransactionManager transactionmanager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setTypeAliasesPackage("com.handashi.**.vo");
		sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/config/mybatis-config.xml"));
		sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mappers/*.xml"));
		
		return sessionFactoryBean.getObject();
	}
	
}
