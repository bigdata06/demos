package org.said.demo.controllers;

import org.said.demo.CustomErrorType;
import org.said.demo.repository.DatabaseSeeder;
import org.said.demo.repository.StudentRepository;
import org.said.demo.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by BigdataArchitect on 2018-01-24.
 */
@RestController
@RequestMapping(value = "/api/students")
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
        logger.info("Fetching Student with id {}", id);
        Student user = studentRepository.findById(id);
        if (user == null) {
            logger.error("Student with id {} not found.", id);
            return new ResponseEntity<Student>(new CustomErrorType("Student with id " + id + " not found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(user, HttpStatus.OK);
    }
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createUser(@Valid @RequestBody final Student user) {
        logger.info("Creating Student : {}", user);
        if (studentRepository.findByName(user.getName()) != null) {
            logger.error("Unable to create. A Student with name {} already exist", user.getName());
            return new ResponseEntity<Student>(
                    new CustomErrorType(
                            "Unable to create new student. A Student with name " + user.getName() + " already exist."),
                    HttpStatus.CONFLICT);
        }
        studentRepository.save(user);
        return new ResponseEntity<Student>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateUser(@PathVariable("id") final Long id, @RequestBody Student user) {
        logger.info("Updating Student with id {}", id);
        Student currentUser = studentRepository.findById(id);
        if (currentUser == null) {
            logger.error("Unable to update. Student with id {} not found.", id);
            return new ResponseEntity<Student>(
                    new CustomErrorType("Unable to upate. Student with id " + id + " not found."), HttpStatus.NOT_FOUND);
        }
        currentUser.setName(user.getName());
        currentUser.setPassportNumber(user.getPassportNumber());
        currentUser.setEmail(user.getEmail());
        studentRepository.saveAndFlush(currentUser);
        return new ResponseEntity<Student>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteUser(@PathVariable("id") final Long id) {
        logger.info("Deleting Student with id {}", id);
        Student user = studentRepository.findById(id);
        if (user == null) {
            logger.error("Unable to delete. Student with id {} not found.", id);
            return new ResponseEntity<Student>(
                    new CustomErrorType("Unable to delete. Student with id " + id + " not found."), HttpStatus.NOT_FOUND);
        }
        studentRepository.delete(id);
        return new ResponseEntity<Student>(new CustomErrorType("Deleted Student with id " + id + "."),
                HttpStatus.NO_CONTENT);
    }

}