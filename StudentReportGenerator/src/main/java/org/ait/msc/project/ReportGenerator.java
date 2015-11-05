package org.ait.msc.project;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReportGenerator {
	
	void createReport(StudentReport studentReport){
		String studentName = studentReport.getStudentName();
		String parentName = studentReport.getParentName();
		String overallProgress = studentReport.getOverallProgress();
		String additionProficiency = studentReport.getAdditionProficiency();
		String subtractionProficiency = studentReport.getSubtractionProficiency();
		String multipicationProficiency = studentReport.getMultipicationProficiency();
		String divisionProficiency = studentReport.getDivisionProficiency();
		String strongTables = studentReport.getStrongTables();
		String weakTables = studentReport.getWeakTables();
		
		Document document = new Document();
		Rectangle rect = new Rectangle(PageSize.LETTER);
		document.setPageSize(rect);
		try {
			String pathname = "StudentReport.pdf";
			File file = new File(pathname);
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			Paragraph paragraphHeading = new Paragraph();
			Paragraph paragraphResults = new Paragraph();
			paragraphHeading.setAlignment(Element.ALIGN_CENTER);
			paragraphHeading.add("Student: " + studentName + "\n");
			paragraphHeading.add("Parent: " + parentName);
			document.add(paragraphHeading);
			paragraphResults.setAlignment(Element.ALIGN_LEFT);
			paragraphResults.add("Overall Progress:" + overallProgress + "\n");
			paragraphResults.add(createFirstTable(additionProficiency, subtractionProficiency, multipicationProficiency, divisionProficiency ));
			paragraphResults.add("\nTables " + studentName + " is good in:\n");
			paragraphResults.add(strongTables + "\n\n");
			paragraphResults.add("Tables " + studentName + " could improve in:\n");
			paragraphResults.add(weakTables);
			document.add(paragraphResults);
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}		
	}
	
    public static PdfPTable createFirstTable(String additionProficiency, String subtractionProficiency, String multipicationProficiency, String divisionProficiency ) {
    	// a table with two columns
        PdfPTable table = new PdfPTable(4);
        // the cell object
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Proficiency in Addition"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Proficiency in Subtraction"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Proficiency in Multipication"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Proficiency in Division"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(additionProficiency));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(subtractionProficiency));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(multipicationProficiency));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(divisionProficiency));
        table.addCell(cell);
        return table;
    }
}
