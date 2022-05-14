package org.indialone.config;

import org.indialone.dao.StudentDao;
import org.indialone.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"org.indialone.dao"})
public class JdbcConfig {

    @Bean(name = { "ds" })
    public DataSource getJdbcDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("HardySis@123");
        return ds;
    }

    @Bean(name = { "jdbcTemplate" })
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(getJdbcDataSource());
        return template;
    }

/*

    @Bean(name = { "studentDao" })
    public StudentDao getStudentDao() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setJdbcTemplate(getJdbcTemplate());
        return studentDao;
    }
*/

}
