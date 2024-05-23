package ru.HollowKaeden.task22.config;

import ru.HollowKaeden.task22.service.ScheduleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.ObjectNameManager;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class JMXConfig {

    @Bean
    public MBeanExporter exporter(ScheduleService scheduleService, DataSource dataSource) {
        MBeanExporter exporter = new MBeanExporter();
        exporter.setAutodetect(true);
        exporter.setExcludedBeans("entityManagerFactory");
        exporter.setBeans(beanMap(scheduleService, dataSource));
        return exporter;
    }

    private Map<String, Object> beanMap(Object entitySaveService, DataSource dataSource) {
        Map<String, Object> map = new HashMap<>();
        map.put("bean:name=scheduleService", entitySaveService);
        map.put("bean:name=dataSource", dataSource);
        return map;
    }

    @Bean
    public ObjectName dataSourceObjectName() throws Exception {
        return ObjectNameManager.getInstance("ru.HollowKaeden:type=DataSource");
    }
}