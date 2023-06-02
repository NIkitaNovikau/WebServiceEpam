package com.example.demo;

import com.example.demo.controller.IntegralController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)//для запуска тестов Mockito
@SpringBootTest
public class IntegralControllerTest {

    @InjectMocks//автоматическое внедрение зависимостей в тестируемый объект.
    public IntegralController integralController;

    @Test
    public void testCalculateIntegral() {


        // Вызов метода calculateIntegral()
        ResponseEntity<Map<String,Double>> responseEntity = integralController.calculateIntegral(1, 2);

        String actual = responseEntity.toString();
        String expected = "<200 OK,{result=0.2423142134},[]>";//headers[]ответик.
        assertEquals(expected,actual,"Не совпадают результаты");
    }


    @Test
    public void testCalculateIntegralWithInternalError() {
        // Вызов метода addIntegral() с некорректными параметрами
        ResponseEntity<Map<String, Double>> responseEntity = integralController.calculateIntegral(0, 0);

        // Проверка результата
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}