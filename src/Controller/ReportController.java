package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

import Model.CurrentProjectsToShow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.util.Map;
import java.util.HashMap;


public class ReportController {

    

    @FXML
    private TableColumn<CurrentProjectsToShow, String> customerEmail;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> customerName;

    @FXML
    private Button downloadButton;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> projectCategory;

    @FXML
    private TableColumn<CurrentProjectsToShow, Integer> projectCost;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> projectID;

    @FXML
    private TableColumn<CurrentProjectsToShow, String> projectStatus;

    @FXML
    private TableView<CurrentProjectsToShow> tableView;
    @FXML
    void DownloadReport(ActionEvent event) {
    	Connection connection;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Create a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", "user", "password");
            
            // 3. Load the JasperDesign object from the .jrxml file
            JasperDesign jasperDesign = JRXmlLoader.load("path_to_your_jrxml_file.jrxml");
            
            // 4. Compile the JasperDesign object to a JasperReport object
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            
            // 5. Create a Map of parameters (if any)
            Map<String, Object> parameters = new HashMap<String, Object>();
            // parameters.put("parameterName", "parameterValue");
            
            // 6. Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            
            // 7. Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, "path_to_save_pdf_report.pdf");
            
            System.out.println("PDF Report Generated!");
            
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
