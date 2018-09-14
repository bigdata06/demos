package org.said.demo.repository;

import org.said.demo.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    public static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
    private StudentRepository studentRepository;

    @Autowired
    public DatabaseSeeder(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Populting database....");
        List<Student> students = new ArrayList<>();

        students.add(new Student("marwa", "marwa@gmail.com","2002001"));
        students.add(new Student("karim","karim@gmail.com", "9042005"));
        students.add(new Student("Nora", "nora@gmail.com","1472009"));
        students.add(new Student("safwane","safwane@gmail.com", "20102202"));

        studentRepository.save(students);
    }
}
