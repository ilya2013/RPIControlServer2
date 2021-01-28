package com.ibesh.rpi.service;

import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.model.DhtModel;
import com.ibesh.rpi.repository.DhtRepository;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;

@Component
@Log
public class DhtService {
    @Autowired
    DhtRepository dhtRepository;

    @Transactional
    public void saveDht(DhtDto dhtDto){
        log.info("Start save dht");
        ModelMapper modelMapper = new ModelMapper();
        DhtModel dhtModel = modelMapper.map(dhtDto, DhtModel.class);
        log.info(dhtModel.toString());
        // user here is a prepopulated User instance
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        dhtModel.setTime(dhtDto.transformTimeInLocalDateTime(dateTimeFormatter));
        DhtModel newDhtModel = dhtRepository.save(dhtModel);
        log.info(newDhtModel.toString());
        log.info("Finish save dht");
//        dhtRepository.findAll().forEach(System.out::println);
    }

}
