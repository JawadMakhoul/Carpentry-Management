package Controller;

import Enumeration.ProjectSection;
import Enumeration.WoodType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ProjectItemsController{

	@FXML
    private Button BackButton,ColorsCatalog,CurrentProjects,FinancialManaging,Inbox,MaterialsToOrder,NewProject,OrderedMaterials,ProjectsCatalog,Stock,addItem,addSection,finish;

    @FXML
    private ColorPicker color;

    @FXML
    private TextField ItemName,handsModelNumber,handsQuantity,handsQuantity1,height,quantity,width;

    @FXML
    private ComboBox<ProjectSection> projectSection;

    @FXML
    private ComboBox<WoodType> woodType;

    @FXML
    void MoveTo(MouseEvent event) {
    	
    	// send to the order constructor String status by convert the enum to string
    }
    
    @FXML
    void AddAnotherItem(MouseEvent event) {

    }

    @FXML
    void AddSection(MouseEvent event) {

    	
    	
    }
}
