package org.said.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by BigdataArchitect on 2018-01-24.
 */
@RestController
@RequestMapping(value = "/students")
public class StudentController {

    public static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // @GetMapping("/")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> listAllUsers() {
        logger.info("Fetching all students");
        List<Student> users = studentRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student>>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getUserById(@PathVariable("id") final Long id) {
        logger.info("Fetching User with id {}", id);
        Student user = studentRepository.findById(id);
        if (user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity<Student>(new CustomErrorType("Student with id " + id + " not found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(user, HttpStatus.OK);
    }

}