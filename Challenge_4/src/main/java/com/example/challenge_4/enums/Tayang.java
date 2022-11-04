package com.example.challenge_4.enums;

public enum Tayang {
    TAYANG ("Tayang"),
    SEGERA_TAYANG ("Segera Tayang");

    private final String displayValue;

    Tayang(String value) {displayValue=value;
    }
    public String getDisplayValue(){return displayValue;}

}
