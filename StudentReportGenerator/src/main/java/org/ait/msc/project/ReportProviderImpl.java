package org.ait.msc.project;

public class ReportProviderImpl implements ReportProvider {
	
	ReportGenerator reportGenerator = new ReportGenerator();
	ReportDatatbaseHandler reportDatatbaseHandler = new ReportDatatbaseHandler();
	
	public void generateReport(String studentName) {
		StudentReport studentReport = ReportDatatbaseHandler.getStudentRecord(studentName);
		reportGenerator.createReport(studentReport);
	}
	
	public static void main(String[] args){
		ReportProviderImpl reportProviderImpl =  new ReportProviderImpl();
		reportProviderImpl.generateReport("pat_1");
	}

}
