package com.ibesh.rpi.service;

import com.ibesh.rpi.model.DhtModel;
import com.ibesh.rpi.repository.DhtRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class DhtServiceTest {
    @Autowired
    DhtRepository dhtRepository;

    @Test
    public void WhenSaved2NewDhtModelsThenFind2Dht() {
        long expected = 2;
        long result;
        dhtRepository.deleteAll();
        DhtModel dhtModel1 = new DhtModel();
        DhtModel dhtModel2 = new DhtModel();
        dhtRepository.save(dhtModel1);
        dhtRepository.save(dhtModel2);
        result = dhtRepository.count();
        assertEquals(expected, result);
        List<DhtModel> models =  (List<DhtModel>) dhtRepository.findAll();
        assertEquals(expected, models.size());
        System.out.println("--->>>Model size: " + models.size());
        models.forEach(System.out::println);
    }

    @Test
    public void WhenSaved2NewDhtModelsThenDeleteOneFind1Dht() {
        long expected = 1;
        long result;
        dhtRepository.deleteAll();
        DhtModel dhtModel1 = new DhtModel();
        DhtModel dhtModel2 = new DhtModel();
        dhtModel1 = dhtRepository.save(dhtModel1);
        dhtRepository.save(dhtModel2);
        dhtRepository.delete(dhtModel1);
        result = dhtRepository.count();
        assertEquals(expected, result);
        List<DhtModel> models =  (List<DhtModel>) dhtRepository.findAll();
        assertEquals(expected, models.size());
        System.out.println("--->>>Model size: " + models.size());
        models.forEach(System.out::println);
    }
}