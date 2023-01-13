package com.example.demo.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfGenerator {

	public void generator(HttpServletResponse response) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(12);

		Paragraph paragraph = new Paragraph("Hello world", fontTitle);
		paragraph.setAlignment(paragraph.ALIGN_CENTER);

		Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE);
		fontTitle.setSize(6);

		Paragraph paragraph2 = new Paragraph("hello", fontParagraph);

		document.add(paragraph);
		document.add(paragraph2);
		document.close();

	}
}
