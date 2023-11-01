package ru.t1consulting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1consulting.model.SymbolFrequency;
import ru.t1consulting.service.SymbolFrequencyService;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class SymbolFrequencyController {

    private final SymbolFrequencyService symbolFrequencyService;

    @GetMapping("/symbol-frequency")
    public ResponseEntity<List<SymbolFrequency>> getSymbolFrequency(@RequestParam("inputString") String inputString) {
        return ResponseEntity.ok(symbolFrequencyService.getSymbolFrequency(inputString));
    }
}
