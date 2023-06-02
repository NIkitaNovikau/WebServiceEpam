package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component//вкл в констр spring
@Configurable//внедряем зависимости
public class IntegralCounterService {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized int getCount() {
        return counter;
    }

}
