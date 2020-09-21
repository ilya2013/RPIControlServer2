package com.ibesh.rpi.service;

import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.model.DhtModel;
import com.ibesh.rpi.repository.DhtRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;

@Component
public class DhtService {
    @Autowired
    DhtRepository dhtRepository;


    public void saveDht(DhtModel dhtModel){
        System.out.println("Start save dht");
        DhtModel newDhtModel = dhtRepository.save(dhtModel);
        System.out.println(newDhtModel);
        System.out.println("Finish save dht");
        dhtRepository.findAll().forEach(System.out::println);
    }
    @Transactional
    public void saveDht(DhtDto dhtDto){
        System.out.println("Start save dht");
        ModelMapper modelMapper = new ModelMapper();
        DhtModel dhtModel = modelMapper.map(dhtDto, DhtModel.class);
        System.out.println(dhtModel);
        // user here is a prepopulated User instance
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        dhtModel.setTime(dhtDto.transformTimeInLocalDateTime(dateTimeFormatter));
        DhtModel newDhtModel = dhtRepository.save(dhtModel);
        System.out.println(newDhtModel);
        System.out.println("Finish save dht");
//        dhtRepository.findAll().forEach(System.out::println);
    }

}
