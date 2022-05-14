package org.indialone.dao;

import org.indialone.models.Students;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Students> {
    @Override
    public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
        Students students = new Students();
        students.setId(rs.getInt(1));
        students.setName(rs.getString(2));
        students.setCity(rs.getString(3));
        return students;
    }
}
