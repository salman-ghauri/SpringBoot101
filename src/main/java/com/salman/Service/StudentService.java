package com.salman.Service;

import com.salman.Dao.StudentDao;
import com.salman.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Service layer over the DAO
 * Should make checks before accessing DB
 * Holds the Business Logic
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {
        return this.studentDao.getAllStudents();
    }

    // Before accessing data base
    // ids should be validated.
    public Student getStudentById(int id) {
        return this.studentDao.getStudentById(id);
    }

    public void deleteStudentById(int id) {
        studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public void createStudent(Student student) {
        studentDao.createStudent(student);
    }
}
