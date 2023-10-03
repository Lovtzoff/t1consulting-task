package ru.t1consulting.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SymbolFrequency {

    private char symbol;
    private int frequency;
}
