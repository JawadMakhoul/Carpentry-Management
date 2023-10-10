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
public class ProjectImageController implements Initializable{

    @FXML
    private ImageView projectImage1,projectImage2,projectImage3,projectImage4;
    private String data1,data2,data3,data4;
    public void setData(String data1,String data2,String data3,String data4) {
    	
    	System.out.println(data1);
    	System.out.println(data2);
    	System.out.println(data3);
    	System.out.println(data4);
        this.data1 = data1;
        if (data1.endsWith(".jpg")) {
        	Image i1 = new Image(data1);
        	projectImage1.setImage(i1);
        }
        
        this.data2 = data2;
        if (data2.endsWith(".jpg")) {
        	Image i2 = new Image(data2);
        	projectImage2.setImage(i2);
        }
        
        this.data3 = data3;
        if (data3.endsWith(".jpg")) {
        	Image i3 = new Image(data3);
        	projectImage3.setImage(i3);
        }
        
        this.data4 = data4;
        if (data4.endsWith(".jpg")) {
        	Image i4 = new Image(data4);
        	projectImage4.setImage(i4);
        }
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    

	

}
