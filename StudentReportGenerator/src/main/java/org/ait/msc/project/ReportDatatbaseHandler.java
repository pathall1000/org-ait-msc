package org.ait.msc.project;

import java.sql.*;

public class ReportDatatbaseHandler {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/studentreport";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "admin";

	static StudentReport getStudentRecord(String name) {
		StudentReport studentReport = new StudentReport();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM studentrecord WHERE studentrecord.STUDENT_ID='"+name+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String studentName = rs.getString("STUDENT_ID");
				String parentName = rs.getString("PARENT");
				String overallProgress = rs.getString("OVERALL_PROGRESS");
				String additionProficiency = rs.getString("PROGRESS_ADDITION");
				String subtractionProficiency = rs.getString("PROGRESS_SUBTRACTION");
				String multipicationProficiency = rs.getString("PROGRESS_MULTIPLICATION");
				String divisionProficiency = rs.getString("PROGRESS_DIVISION");
				String strongTables = rs.getString("STRONG_TABLES");
				String weakTables = rs.getString("WEAK_TABLES");

				// Display values
				System.out.print("STUDENT_ID: " + studentName);
				studentReport.setStudentName(studentName);
				System.out.print("PARENT: " + parentName);
				studentReport.setParentName(parentName);
				System.out.print("OVERALL_PROGRESS: " + overallProgress);
				studentReport.setOverallProgress(overallProgress);
				System.out.print("PROGRESS_ADDITION: " + additionProficiency);
				studentReport.setAdditionProficiency(additionProficiency);
				System.out.print("PROGRESS_SUBTRACTION: " + subtractionProficiency);
				studentReport.setSubtractionProficiency(subtractionProficiency);
				System.out.print("PROGRESS_MULTIPLICATION: " + multipicationProficiency);
				studentReport.setMultipicationProficiency(multipicationProficiency);
				System.out.print("PROGESS_DIVISION: " + divisionProficiency);
				studentReport.setDivisionProficiency(divisionProficiency);
				System.out.print("STRONG_TABLES: " + strongTables);
				studentReport.setStrongTables(strongTables);
				System.out.print("WEAK_TABLES: " + weakTables);
				studentReport.setWeakTables(weakTables);

			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		return studentReport;
	}// end main
}// end FirstExample
