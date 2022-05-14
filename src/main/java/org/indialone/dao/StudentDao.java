package org.indialone.dao;

import org.indialone.models.Students;

import java.util.List;

public interface StudentDao {

    int insert(Students students);

    int update(Students students);

    int delete(Students students);

    List<Students> getAllStudents();

    Students getStudentById(int studentId);

}
