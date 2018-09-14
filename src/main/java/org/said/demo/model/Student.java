package org.said.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by BigdataArchitect on 2018-01-24.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String passportNumber;

    public Student(String name, String email, String passportNumber) {
        this.name = name;
        this.email=email;
        this.passportNumber = passportNumber;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
