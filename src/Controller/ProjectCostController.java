package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProjectCostController implements Initializable{

	private int projectid;
    @FXML
    private TextField cost;

    @FXML
    private TextField price;

    @FXML
    private TextField suggestedPrice;

    @FXML
    private Button SubmitCost;

    public void setData(int projectid) {
     
        this.projectid=projectid;
        // Maybe update some UI elements here based on the data
        for(Project p: CarpentryLogic.getInstance().getProjects()) {
    		if(p.getProjectID()==projectid) {
    			cost.setText(Integer.toString(p.CalculateCost()));
    			try {
					CarpentryLogic.getInstance().updateProjectCost(p, p.CalculateCost());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			suggestedPrice.setText(Integer.toString(p.CalculateSuggestedPrice()));
    			
    			
    		}
    	}
    }
    
    @FXML
    void SetProjectCost(ActionEvent event) throws SQLException {
    	
    	for(Project p: CarpentryLogic.getInstance().getProjects()) {
    		if(p.getProjectID()==projectid) {
    			p.setPrice(Integer.parseInt(price.getText()));
    			p.setCost(Integer.parseInt(cost.getText()));
    			CarpentryLogic.getInstance().updateProjectPrice(p, p.getPrice());
    		}
    	}
    	
    	 Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		 // Close the current stage
		 currentStage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
