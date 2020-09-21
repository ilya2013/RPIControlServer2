package com.ibesh.rpi.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibesh.rpi.dto.DhtDto;
import com.ibesh.rpi.service.DhtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.sql.SQLOutput;

@Controller
public class KafkaConsumer {
    @Autowired
    DhtService dhtService;
    @KafkaListener(topics = "dht", groupId = "foo")
    public void listenGroupFoo(String message) throws JsonProcessingException {
        String dummyJson = "{\"comment\": \"VAIO front\", \"location\": \"Server room\", \"temperature\": 31.200000762939453, \"time\": \"2020-09-15-15.34.45\", \"pin\": \"18\", \"humidity\": 25.700000762939453, \"sensor_model\": 22, \"device_name\": \"RPI1\"}";
        System.out.println("Received dht Message in group foo: " + message);
        message = message.replace("\\", "");
        message = message.replace("\"{", "{");
        message = message.replace("}\"", "}");
        try {
            ObjectMapper mapper = new ObjectMapper();
            DhtDto dhtDto = mapper.readValue(message, DhtDto.class);
            dhtService.saveDht(dhtDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
