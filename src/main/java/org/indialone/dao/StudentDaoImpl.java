package org.indialone.dao;

import org.indialone.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Students students) {
        // insert query
        String insertQuery = "insert into students(id,name,city) values(?,?,?)";
        return jdbcTemplate.update(insertQuery, students.getId(), students.getName(), students.getCity());
    }

    @Override
    public int update(Students students) {
        String updateQuery = "update students set name=?, city=? where id=?";
        return jdbcTemplate.update(updateQuery, students.getName(), students.getCity(), students.getId());
    }

    @Override
    public int delete(Students students) {
        String deleteQuery = "delete from students where id=?";
        return jdbcTemplate.update(deleteQuery, students.getId());
    }

    @Override
    public List<Students> getAllStudents() {
        String getAllStudentsQuery = "select * from students";
        return jdbcTemplate.query(getAllStudentsQuery, new RowMapperImpl());
    }

    @Override
    public Students getStudentById(int studentId) {
        String queryForSingleStudentById = "select * from students where id=?";
        RowMapper<Students> rowMapper = new RowMapperImpl();
        /*
        RowMapper<Students> rowMapper = (rs, rowNum) -> {
            Students students = new Students();
            students.setId(rs.getInt(1));
            students.setName(rs.getString(2));
            students.setCity(rs.getString(3));
            return students;
        };
        */
        return jdbcTemplate.queryForObject(queryForSingleStudentById,rowMapper, studentId);
    }
}
