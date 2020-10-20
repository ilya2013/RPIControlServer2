package com.ibesh.rpi.service;

import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.model.DhtModel;
import com.ibesh.rpi.repository.DhtRepository;
import com.ibesh.rpi.settings.DHTSettings;
import com.ibesh.rpi.statistic.DHTStatistic;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Log4j2
@Getter
public class DhtService {
    @Autowired
    DhtRepository dhtRepository;
    private final DHTStatistic dhtStatistic = new DHTStatistic();
    private final DHTSettings  dhtSettings = new DHTSettings();

    @Transactional
    public void saveDht(DhtDto dhtDto){
        log.info("Start save dht");
        ModelMapper modelMapper = new ModelMapper();
        DhtModel dhtModel = modelMapper.map(dhtDto, DhtModel.class);
        log.info(dhtModel);
        dhtStatistic.increment(dhtModel.getComment());
        // user here is a prepopulated User instance
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        dhtModel.setTime(dhtDto.transformTimeInLocalDateTime(dateTimeFormatter));
        dhtModel.setReceivedTime(LocalDateTime.now());
        DhtModel newDhtModel = dhtRepository.save(dhtModel);
        log.info(newDhtModel);
        log.info("Finish save dht");
    }

}
