package com.ibesh.rpi.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibesh.rpi.dto.DhtDto;
import org.junit.jupiter.api.Test;

class KafkaConsumerTest {

    @Test
    void listenGroupFoo() throws JsonProcessingException {
        String json = "{\"location\": \"Server room\", \"comment\": \"VAIO front\", \"temperature\": 31.200000762939453, \"time\": \"2020-09-15-15.34.45\", \"pin\": \"18\", \"humidity\": 25.700000762939453, \"sensor_model\": 22, \"device_name\": \"RPI1\"}";
        ObjectMapper mapper = new ObjectMapper();
        DhtDto dhtDto = mapper.readValue(json, DhtDto.class);
        System.out.println(dhtDto);
    }
}