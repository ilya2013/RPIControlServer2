package com.ibesh.rpi.service;

import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.mapper.DHTSourceDestinationMapper;
import com.ibesh.rpi.model.DhtModel;
import com.ibesh.rpi.repository.DhtRepository;
import lombok.Getter;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@Getter
public class DhtService {
    @Autowired
    DhtRepository dhtRepository;
    private DHTSourceDestinationMapper mapper = Mappers.getMapper(DHTSourceDestinationMapper.class);

    @Transactional
    public void saveDht(DhtDto dhtDto){
        System.out.println("Start save dht");
        DhtModel dhtModel = mapper.sourceToDestination(dhtDto);
        System.out.println(dhtModel);
        dhtModel.setReceivedTime(LocalDateTime.now());
        DhtModel newDhtModel = dhtRepository.save(dhtModel);
        System.out.println(newDhtModel);
        System.out.println("Finish save dht");
    }

}
