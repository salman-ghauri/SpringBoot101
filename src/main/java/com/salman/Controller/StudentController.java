package com.salman.Controller;

import com.salman.Entity.Student;
import com.salman.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Handles the HTTP methods
 * for the whole app
 *
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id) {
        return this.studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteStudentById(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
        return "Deleted successfully " + id;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return String.format("Student %s updated successfully!", student.getName());
    }
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return String.format("Student %s created successfully!", student.getName());
    }
}
