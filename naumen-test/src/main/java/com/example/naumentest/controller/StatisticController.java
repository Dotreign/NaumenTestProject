package com.example.naumentest.controller;

import com.example.naumentest.model.Name;
import com.example.naumentest.service.NameService;
import com.example.naumentest.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatisticController {

    NameService nameService;
    StatisticService statisticService;

    @Autowired
    public StatisticController(NameService nameService, StatisticService statisticService) {
        this.nameService = nameService;
        this.statisticService = statisticService;
    }

    @GetMapping("/requests")
    public Iterable<Name> getRequestsStats() {
        return statisticService.getStatisticsOnRequestNumber();
    }

    @GetMapping("/max-age")
    public Name getMaxAgedName() {
        return statisticService.getNameWithMaxAge();
    }

}
