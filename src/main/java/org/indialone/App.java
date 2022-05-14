package org.indialone;


import org.indialone.config.JdbcConfig;
import org.indialone.dao.StudentDao;
import org.indialone.models.Students;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Consumer;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        /*ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");

       *//* Students students = new Students();
        students.setId(222);
        int result = studentDao.delete(students);
        System.out.println("1 row deleted with result -> " + result);*//*

      */
//        Students students = studentDao.getStudentById(111);
//        System.out.println("Student with id -> " + 111 + " is -> " + students);

        studentDao.getAllStudents().forEach(System.out::println);

    }
}
