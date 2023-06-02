package com.example.demo.controller;

import com.example.demo.service.impl.IntegralServiceInMemory;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController//помечаем что тута контроллер
@AllArgsConstructor//мой любимый ламбок
@RequestMapping("/integral")
public class IntegralController {
    private static final Logger logger =  LogManager.getLogger(IntegralController.class);


    @Autowired
    public IntegralServiceInMemory integralServiceInMemory;


    @GetMapping("/newIntegral")
    public ResponseEntity<Map<String,Double>> calculateIntegral(@RequestParam("start") double start,
                                                            @RequestParam("end") double end) {

        logger.debug("calculateIntegral вызвалась с параметрами start={}, end={}", start, end);

        try {
            double newIntegral = integralServiceInMemory.calculateIntegral(start,end);
            Map<String, Double> response = new HashMap<>();
            response.put("result", newIntegral);
            logger.info("Значение интеграла : {}", newIntegral + "\n");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            logger.error("Переданы неправильные внутренние параметры: start={}, end{}",start, end);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Внутренняя Internal ошибка: ", e);
            // Обработка внутренних ошибок
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}






