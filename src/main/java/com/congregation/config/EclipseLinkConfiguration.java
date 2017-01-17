package com.congregation.config;

import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

@Configuration
//@EnableJpaRepositories(basePackages = "com.congregation.repository", entityManagerFactoryRef="emf")
//@EnableAutoConfiguration
public class EclipseLinkConfiguration extends JpaBaseConfiguration {
 
   protected EclipseLinkConfiguration(DataSource dataSource, JpaProperties properties,
                                      ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider) {
      super(dataSource, properties, jtaTransactionManagerProvider);
   }
 
   @Override
   protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
      return new EclipseLinkJpaVendorAdapter();
   }

   @Override
   protected Map<String, Object> getVendorProperties() {
 
      // Turn off dynamic weaving to disable LTW (Load Time Weaving) lookup in static weaving mode
//      return Collections.singletonMap("eclipselink.weaving", "false");
      final Map<String, Object> ret = new HashMap<>();
      ret.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
      ret.put("eclipselink.weaving", "false");
      ret.put("eclipselink.ddl-generation", "create-tables");
      return ret;
   }
}