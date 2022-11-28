package com.example.challenge_5.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.ByteArrayInputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceReportDTO {
    private String fileName;
    private ByteArrayInputStream stream;
    private int length;
}
