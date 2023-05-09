package com.example.naumentest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Name {

    @Id
    @GeneratedValue
    Long id;

    String name;

    Integer age;

    Integer requests;

    public Name() {
    }

    public Name(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.requests = 0;
    }
}
