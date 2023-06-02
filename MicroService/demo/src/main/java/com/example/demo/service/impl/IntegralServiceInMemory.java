package com.example.demo.service.impl;

import com.example.demo.cache.IntegralCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//будем ето использовать))))
public class IntegralServiceInMemory {

    @Autowired//автоматического внедрения зависимостей в компоненты приложения
    public IntegralCache integralCache;
    @Autowired
    public IntegralCounterService integralCounterService;
    public double calculateIntegral(double start, double end){
        integralCounterService.increment();
        String key = start + ":" + end;
        System.out.println("Количество обращений к сервису = " + integralCounterService.getCount());

        if (integralCache.getCache().containsKey(key)) {
            System.out.println("Срабатывание кэша для ключа: " + key);

            return   integralCache.getCache().get(key);

        }
        if (start <= 0 || end <= 0) {
            throw new IllegalArgumentException("значение должно быть больше 0");
        }
        double result = calculateInt(start,end);
        integralCache.getCache().put(key, result);
        System.out.println("В кэш была записана информация: " + key);


        return result;
    }
    public static double integrate(double a, double b) {
        int n = 1000000; // колличество трапеций
        double h = (b - a) / n; // шаг интегрирования
        double sum = 0.5 * (Math.sin(a) + Math.sin(b)); // начальное значение суммы
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += Math.sin(x);
        }
        return sum * h;
    }
    public Double calculateInt(double start,double end){
        return (double)integrate(start, end);
    }
}
