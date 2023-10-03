package ru.t1consulting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1consulting.model.SymbolFrequency;

import java.util.*;

@RestController
public class SymbolFrequencyController {

    @GetMapping("/symbol-frequency")
    public List<SymbolFrequency> getSymbolFrequency(@RequestParam("inputString") String inputString) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // вычисляем частоту встречи символов в строке
        for (char symbol : inputString.toCharArray()) {
            if (frequencyMap.containsKey(symbol)) {
                frequencyMap.put(symbol, frequencyMap.get(symbol) + 1);
            } else {
                frequencyMap.put(symbol, 1);
            }
        }

        // сортируем результат по убыванию количества вхождений символа в строку
        List<SymbolFrequency> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            result.add(new SymbolFrequency(entry.getKey(), entry.getValue()));
        }
        result.sort(Comparator.comparingInt(SymbolFrequency::getFrequency).reversed());

        return result;
    }
}
