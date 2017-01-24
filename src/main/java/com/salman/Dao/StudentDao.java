package com.salman.Dao;

import com.salman.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Getting data from DB
 * using dummy data for now.
 */
@Repository
public class StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {

            {
                put(1, new Student(1, "Asim", "Maths"));
                put(2, new Student(2, "Sheraz", "English"));
                put(3, new Student(3, "Adeel", "Urdu"));
            }
        };
    }

    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student student) {

        Student s = students.get(student.getId());
        s.setName(student.getName());
        s.setCourse(student.getCourse());

        students.put(student.getId(), student);
    }

    public void createStudent(Student student) {

        students.put(student.getId(), student);
    }
}
