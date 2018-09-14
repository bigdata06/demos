package org.said.demo.repository;

import org.said.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by BigdataArchitect on 2018-01-24.
 */
@Component
public interface StudentRepository extends JpaRepository<Student,Long> {
     Student findById(Long id);

     Student findByName(String name);
}
