package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.PdfGenerator;
import com.lowagie.text.DocumentException;

@RestController
//@RequestMapping("/pdf")
public class pdfController {

	@Autowired
	private PdfGenerator pdfGenerator;

	@GetMapping("/generate")
	public void generatePdf(HttpServletResponse httpServletResponse) throws DocumentException, IOException {
		httpServletResponse.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		httpServletResponse.setHeader(headerkey, headerValue);
		pdfGenerator.generator(httpServletResponse);

	}
	
	
}
