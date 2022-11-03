package com.example.challenge_4.enums;

public enum Tayang {
    TAYANG ("Tayang"),
    TIDAK_TAYANG ("Tidak Tayang");

    private final String displayValue;

    Tayang(String value) {displayValue=value;
    }
    public String getDisplayValue(){return displayValue;}

}
