package com.example.naumentest.service;

import com.example.naumentest.model.Name;
import com.example.naumentest.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class StatisticService {

    NameRepository nameRepository;

    @Autowired
    public StatisticService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    public Name getNameWithMaxAge() {
        Name ppl = nameRepository.findFirstByAgeGreaterThan(0);
        while (true) {
            if (!nameRepository.existsByAgeGreaterThan(ppl.getAge())) {
                return ppl;
            }
            ppl = nameRepository.findFirstByAgeGreaterThan(ppl.getAge());
        }
    }

    public Iterable<Name> getStatisticsOnRequestNumber() {
        Iterable<Name> names = nameRepository.findAll();
        return names;
    }

}
