package com.ibesh.rpi.service;

import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.mapper.DHTSourceDestinationMapper;
import com.ibesh.rpi.model.DhtModel;
import com.ibesh.rpi.repository.DhtRepository;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@Getter
@Log4j2
public class DhtService {
    @Autowired
    DhtRepository dhtRepository;
    private DHTSourceDestinationMapper mapper = Mappers.getMapper(DHTSourceDestinationMapper.class);

    @Transactional
    public void saveDht(DhtDto dhtDto){
        log.info("Start save dht");
        DhtModel dhtModel = mapper.sourceToDestination(dhtDto);
        log.info(dhtModel);
        dhtModel.setReceivedTime(LocalDateTime.now());
        DhtModel newDhtModel = dhtRepository.save(dhtModel);
        log.info(newDhtModel);
        log.info("Finish save dht");
    }

}
