package com.ibesh.rpi.service;

import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.model.DhtModel;
import com.ibesh.rpi.repository.DhtRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;

@Component
@Log4j2
public class DhtService {
    @Autowired
    DhtRepository dhtRepository;

    @Transactional
    public void saveDht(DhtDto dhtDto){
        log.info("Start save dht");
        ModelMapper modelMapper = new ModelMapper();
        DhtModel dhtModel = modelMapper.map(dhtDto, DhtModel.class);
        log.info(dhtModel);
        // user here is a prepopulated User instance
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        dhtModel.setTime(dhtDto.transformTimeInLocalDateTime(dateTimeFormatter));
        DhtModel newDhtModel = dhtRepository.save(dhtModel);
        log.info(newDhtModel);
        log.info("Finish save dht");
//        dhtRepository.findAll().forEach(System.out::println);
    }

}
