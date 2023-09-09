package Controller;

import java.net.URL;
import java.io.InputStream;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.ByteArrayInputStream;
import java.util.Base64;
public class ProjectImageController{

    @FXML
    private ImageView projectImage;
    private String data;
    public void setData(String data) {
        this.data = data;
        Image i = new Image(data);
        projectImage.setImage(i);
        // Do whatever you need with this data, e.g., update a label or text area.
    }
    

	

}
