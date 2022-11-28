package com.example.challenge_5.common;

import com.example.challenge_5.model.enums.TypeReportEnum;
import com.sun.xml.bind.v2.util.ByteArrayOutputStreamEx;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.sql.Connection;
import java.util.Map;

@Component
public class JasperReportManager {
    private static final String REPORT_FOLDER = "reports";
    private static final String JASPER = ".jrxml";

    public ByteArrayOutputStream export(String fileName, Map<String, Object> params, Connection connection) throws JRException, IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStreamEx();
        JasperReport report = JasperCompileManager.compileReport("D:\\Developing\\synergy-binar-batch-5\\Challenge_5\\src\\main\\resources\\reports\\HeaderTiket2.jrxml");
//        ClassPathResource resource = new ClassPathResource(REPORT_FOLDER+ File.separator+ fileName+ JASPER);

//        InputStream inputStream = resource.getInputStream();
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, connection);
//        if(typeReports.equalsIgnoreCase(TypeReportEnum.EXCEL.toString())){
//            JRXlsExporter exporter = new JRXlsExporter();
//            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
//            SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
//            configuration.setDetectCellType(true);
//            configuration.setCollapseRowSpan(true);
//            exporter.setConfiguration(configuration);
//            exporter.exportReport();
//        }else {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
//        }

        return stream;
    }
}
