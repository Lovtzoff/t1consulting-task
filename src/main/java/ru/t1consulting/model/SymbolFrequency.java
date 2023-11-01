package ru.t1consulting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SymbolFrequency {

    private char symbol;
    private int frequency;
}
