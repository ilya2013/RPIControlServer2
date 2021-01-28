package com.ibesh.rpi.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.service.DhtService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
@Log4j2
public class KafkaConsumer {
    @Autowired
    DhtService dhtService;
    @KafkaListener(topics = "dht", groupId = "foo")
    public void listenGroupFoo(String message) {
        log.info("Received dht Message in group foo: {}", message);
        message = message.replace("\\", "");
        message = message.replace("\"{", "{");
        message = message.replace("}\"", "}");
        try {
            ObjectMapper mapper = new ObjectMapper();
            DhtDto dhtDto = mapper.readValue(message, DhtDto.class);
            dhtService.saveDht(dhtDto);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
