package ru.t1consulting.service;

import org.springframework.stereotype.Service;
import ru.t1consulting.model.SymbolFrequency;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SymbolFrequencyService {

    public List<SymbolFrequency> getSymbolFrequency(String inputString) {
        // вычисляем частоту встречи символов в строке
        Map<Character, Integer> frequencyMap = inputString.chars()
                // преобразуем int в char
                .mapToObj(c -> (char) c)
                // группируем по символам и суммируем количество
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));

        return frequencyMap.entrySet().stream()
                // преобразуем Map.Entry в SymbolFrequency
                .map(entry -> SymbolFrequency.builder()
                        .symbol(entry.getKey())
                        .frequency(entry.getValue())
                        .build())
                // сортируем по частоте в обратном порядке
                .sorted(Comparator.comparingInt(SymbolFrequency::getFrequency).reversed())
                .collect(Collectors.toList());
    }
}
