package com.example.challenge_5.service.interfaces;

import com.example.challenge_5.model.dto.InvoiceReportDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public interface ReportSerive {

    InvoiceReportDTO obtainerReport(Map<String, Object> params) throws JRException, IOException, SQLException;
}
