package com.example.naumentest.service;

import com.example.naumentest.model.Name;
import com.example.naumentest.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NameService {

    NameRepository nameRepository;

    @Autowired
    public NameService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    public Integer getAgeByName(String name) {
        if (nameRepository.existsByName(name)) {
            return nameRepository.findByName(name).getAge();
        } else {
            Random random = new Random();
            int randomAge = Math.abs(random.nextInt()) % 100;
            Name ppl = new Name(name, randomAge);
            nameRepository.save(ppl);
            return randomAge;
        }
    }

    public void increaseRequestsNumber(String name) {
        Name ppl = nameRepository.findByName(name);
        ppl.setRequests(ppl.getRequests() + 1);
        nameRepository.save(ppl);
    }

}
