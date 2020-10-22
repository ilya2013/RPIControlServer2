package com.ibesh.rpi.controller;

import com.ibesh.rpi.service.DhtService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller
@Log4j2
public class MonitoringController {
    DhtService dhtService;

    public MonitoringController(DhtService dhtService) {
        this.dhtService = dhtService;
    }

    @GetMapping("monitoring")
    public String helloMonitoring(Model model) {
        fillModel(model);
        return "monitoring";
    }

    @PostMapping("monitoring")
    public String change(@RequestParam("period") int frequency, Model model) {
        log.info(frequency);
        dhtService.getDhtSettings().setPeriod(frequency);
        fillModel(model);
        return "monitoring";
    }

    protected void fillModel(Model model){
        model.addAttribute("period", dhtService.getDhtSettings().getPeriod());
        model.addAttribute("names", transformStatistic(dhtService.getDhtStatistic().getEntrySet()));
    }
    private Set<String> transformStatistic(Set<Map.Entry<String, AtomicInteger>> statistics) {
        return statistics
                .stream()
                .map(a -> String.format("%s: %s", a.getKey(), a.getValue()))
                .collect(Collectors.toSet());
    }
}
