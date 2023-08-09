package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class NotesController implements Initializable{

    @FXML
    private Button updatenotesButton;

    @FXML
    private TextArea textArea;
    
    private String data;

    public void setData(String data) {
        this.data = data;
        postInitializeSetup();
        // Maybe update some UI elements here based on the data
    }
    
    private void postInitializeSetup() {
        // Here, use the `data` to populate or modify the UI elements
    	for(Project p: CarpentryLogic.getInstance().getProjects()) {
			if(data.equals(Integer.toString(p.getProjectID()))) {
				textArea.setText(p.getNotes());
			}
		}
    }
    @FXML
    void UpdateNotes(ActionEvent event) throws SQLException {
    	
    	for(Project p: CarpentryLogic.getInstance().getProjects()) {
			if(data.equals(Integer.toString(p.getProjectID()))) {
				CarpentryLogic.getInstance().updateProjectNotes(p, textArea.getText());
			}
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		
	}

}
