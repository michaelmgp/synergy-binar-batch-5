package com.example.challenge_5.controller;

import com.example.challenge_5.model.dto.InvoiceReportDTO;
import com.example.challenge_5.model.enums.TypeReportEnum;
import com.example.challenge_5.service.ReportServiceImple;
import com.example.challenge_5.service.interfaces.ReportSerive;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportServiceImple reportSerive;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;


    public ResponseEntity<Resource> download(HttpServletResponse response, @RequestParam("idCustomer") long idCustomer) throws JRException, IOException, SQLException{
//        params.put("idCustomer", idCustomer);
        Map<String , Object> params = new HashMap<>();
        params.put("idCutomer", idCustomer);
//        params.put("type", type);
        params.put("pathReport","D:\\Developing\\synergy-binar-batch-5\\Challenge_5\\src\\main\\resources\\reports\\");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InvoiceReportDTO dto = reportSerive.obtainerReport(params);
        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
//        if(params.get("type").toString().equalsIgnoreCase(TypeReportEnum.PDF.name())){
            mediaType = MediaType.APPLICATION_PDF;
//        }else {
//            mediaType = MediaType.APPLICATION_OCTET_STREAM;
//        }

//
        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName()
        +"\"").contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
//        String sourFileName = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"\\reports\\HeaderTiket2.jasper  ").getAbsolutePath();
//        JasperPrint jasperPrint = JasperFillManager.fillReport(sourFileName, params , new JREmptyDataSource());
//        JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
//        response.setContentType("application/pdf");
//        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response, @RequestParam("idCustomer") long idCustomer)
            throws ServletException, IOException {
        // set header as pdf
        response.setContentType("application/pdf");

        // set input and output stream
        ServletOutputStream servletOutputStream = response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        FileInputStream fis;
        BufferedInputStream bufferedInputStream;



        try {


            // get report location
//            ServletContext context = request.getServletContext();
//            String reportLocation = context.getRealPath("WEB-INF");

            // get report
            fis = new FileInputStream( "D:\\Developing\\synergy-binar-batch-5\\Challenge_5\\src\\main\\resources\\reports\\HeaderTiket2.jasper  ");
            bufferedInputStream = new BufferedInputStream(fis);
            Map<String , Object> params = new HashMap<>();
            params.put("idCutomer", idCustomer);
            System.out.println(idCustomer);
//        params.put("type", type);
            params.put("pathReport","D:\\Developing\\synergy-binar-batch-5\\Challenge_5\\src\\main\\resources\\reports\\");
            // fill parameters


            // export to pdf
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                    params, jdbcTemplate.getDataSource().getConnection());
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

            response.setContentLength(baos.size());
            baos.writeTo(servletOutputStream);

            // close it
            fis.close();
            bufferedInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            servletOutputStream.flush();
            servletOutputStream.close();
            baos.close();
        }
    }

    @GetMapping(path = "/download")
    public void downloadPdf(@RequestParam("idCustomer") long idCustomer, HttpServletResponse response) throws SQLException, JRException, IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("idCustomer", idCustomer);
        params.put("pathReport","D:\\Developing\\synergy-binar-batch-5\\Challenge_5\\src\\main\\resources\\reports\\");
        JasperReport report = JasperCompileManager.compileReport("D:\\Developing\\synergy-binar-batch-5\\Challenge_5\\src\\main\\resources\\reports\\HeaderTiket2.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(report,params,dataSource.getConnection());
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=report.pdf");
        final ServletOutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint,outputStream);

    }

}
