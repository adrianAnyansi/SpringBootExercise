package com.example.demo;

// import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// import javax.persistence.Entity;

@Entity
public class Employee {
    private @Id @GeneratedValue Long id;
    private String name;
    private String role;
    private Long compensation;

    Employee() {}   // default constructor

    Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public String getRole () {
        return this.role;
    }

    public Long compensation () {
        return this.compensation;
    }


    // --- Setters

    public void setId (Long id) { // NOTE: is changing id a PK expected?
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setRole (String role) {
        this.role = role;
    }

    public void setCompensation (Long compensation) {
        this.compensation = compensation;
    }

    // Functions

    @Override
    public boolean equals(Object o) {
        // Object comparison
        if (this == o) return true;

        if (!(o instanceof Employee)) return false;

        Employee compareEmployee = (Employee) o;

        // TODO: Review String comparison in Java
        return  this.id == compareEmployee.id &&
                this.name == compareEmployee.name &&
                this.role == compareEmployee.role &&
                this.compensation == compareEmployee.compensation;
    }

    // NOTE: Tutorial does hashCode
    // Need to eval the use-case

    @Override
    public String toString() {
        return "Employee[ID|"+this.id+"] Name:"+this.name+" Role:"+this.role+" Comp: "+this.compensation;
    }
}
