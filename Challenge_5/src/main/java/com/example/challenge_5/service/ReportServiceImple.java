package com.example.challenge_5.service;

import com.example.challenge_5.common.JasperReportManager;
import com.example.challenge_5.model.dto.InvoiceReportDTO;
import com.example.challenge_5.model.enums.TypeReportEnum;
import com.example.challenge_5.service.interfaces.ReportSerive;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@Service
public class ReportServiceImple implements ReportSerive {
    @Autowired
    private JasperReportManager reportManager;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;
    @Override
    public InvoiceReportDTO obtainerReport(Map<String, Object> params) throws JRException, IOException, SQLException {
        String filename = "HeaderTiket2";
        InvoiceReportDTO dto = new InvoiceReportDTO();

//        String extension =  params.get("type").toString().equalsIgnoreCase(TypeReportEnum.PDF.name())?".pdf":".xlsx";
        dto.setFileName(filename+".pdf");
        ByteArrayOutputStream stream = reportManager.export(filename, params, dataSource.getConnection());
        byte[] bs = stream.toByteArray();
        dto.setStream(new ByteArrayInputStream(bs));
        dto.setLength(bs.length);
        return dto;
    }

//    public byte[] generate_pdf(Map<String, Object> parameters, String reportName) throws SQLException {
//        try {
//            JasperReport report = JasperCompileManager.compileReport(reportName);
////            System.out.println("reportreport="+reportName);
//            JasperPrint jasperPrint = JasperFillManager
//                    .fillReport
//                            (report,
//                                    parameters,
//                                    jdbcTemplate.getDataSource().getConnection());
////            JasperPrint jasperPrint = JasperFillManager
////                    .fillReport
////                            (reportName,
////                                    parameters,
////                                    dataSource.getConnection());
//            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Downloads\\out.pdf");
//            byte[] result = JasperExportManager.exportReportToPdf(jasperPrint) ;
//            return result;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }finally {
//            //close koneksi
//            jdbcTemplate.getDataSource().getConnection().close();
//        }
//    }

}
