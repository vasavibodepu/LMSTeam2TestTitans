package com.LMS.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * 
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getExcelFilePath() {
		String excelfilelpath = prop.getProperty("excelFilePath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}

	// HomePage URL
	public static String getHomePageUrl() {
		String homePageurl = prop.getProperty("homepageurl");
		if (homePageurl != null)
			return homePageurl;
		else
			throw new RuntimeException("HomePageurl not specified in the Config.properties file");
	}

	// Invalid HomePage URL
	public static String getInvalidHomePageUrl() {
		String invalidhomePageurl = prop.getProperty("invalidhomepageurl");
		if (invalidhomePageurl != null)
			return invalidhomePageurl;
		else
			throw new RuntimeException("InvalidHomePageurl not specified in the Config.properties file");
	}

	public static String getmanageprogramurl() {
		String manageprogram = prop.getProperty("manageprogram");
		if (manageprogram != null)
			return manageprogram;
		else
			throw new RuntimeException("manageprogram not specified in the Config.properties file");
	}

	public static String getdashboardprogram() {
		String dashboardprogram = prop.getProperty("dashboardprogram");
		if (dashboardprogram != null)
			return dashboardprogram;
		else
			throw new RuntimeException("manageprogram not specified in the Config.properties file");
	}

	public static String getdashboard() {
		String dashboard = prop.getProperty("dashboard");
		if (dashboard != null)
			return dashboard;
		else
			throw new RuntimeException("manageprogram not specified in the Config.properties file");
	}

	public static String getlogin() {
		String login = prop.getProperty("login");
		if (login != null)
			return login;
		else
			throw new RuntimeException("login not specified in the Config.properties file");
	}

	public static String getstudentdetails() {
		String studentdetails = prop.getProperty("studentdetails");
		if (studentdetails != null)
			return studentdetails;
		else
			throw new RuntimeException("login not specified in the Config.properties file");
	}

	public static String getassignment() {
		String assignmentUrl = prop.getProperty("assignmentUrl");
		if (assignmentUrl != null)
			return assignmentUrl;
		else
			throw new RuntimeException("assignmentUrl not available in the Config.properties file.");

	}

	public static String getUploadassignmentUrl() {
		String uploadAssignmentUrl = prop.getProperty("uploadAssignmentUrl");
		if (uploadAssignmentUrl != null)
			return uploadAssignmentUrl;
		else
			throw new RuntimeException("uploadAssignmentUrl not available in the Config.properties file.");

	}

	public static String getaddEditAssignmentUrl() {
		String addEditAssignmentUrl = prop.getProperty("addEditAssignmentUrl");
		if (addEditAssignmentUrl != null)
			return addEditAssignmentUrl;
		else
			throw new RuntimeException("addEditAssignmentUrl not available in the Config.properties file.");

	}
}
