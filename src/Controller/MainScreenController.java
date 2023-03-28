package Controller;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainScreenController implements Initializable{
	 @FXML
	    private PasswordField passWord;

	    @FXML
	    private Button LogIn;

	    @FXML
	    private AnchorPane screen;
	    @FXML
		private MediaView mediaView;
	    private Media media;
		private MediaPlayer backgroundvideo=null;
		private String id1="207188673", id2="206980013" , id3="123";
	    @FXML
	    void Log_In(ActionEvent event) throws IOException {
	    	
	    	if(passWord.getText().equals(id1)||passWord.getText().equals(id2)||passWord.getText().equals(id3)) {
	    		Parent pane = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
				Scene scene = new Scene(pane);
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("Main Menu");
				stage.show();
	    	}
	    	
	    	else if(passWord.getText().isEmpty()) {
	    		try {
					final Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Error!");
					alert.setContentText("Press OK to try again.");
					alert.setHeaderText("Sorry the password field is empty.");
					alert.showAndWait();
				} catch (Error e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
	    	}
	    	else {
	    		try {
					final Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Error!");
					alert.setContentText("Press OK to try again.");
					alert.setHeaderText("Sorry you have entered a wrong passowrd.");
					alert.showAndWait();
				} catch (Error e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
	    	}
	    }
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			if (backgroundvideo == null) {//starts the background video
				media = new Media(getClass().getResource("/Lib/video2.mp4").toExternalForm());

				backgroundvideo = new MediaPlayer(media);
				mediaView.setMediaPlayer(backgroundvideo);

				backgroundvideo.setOnEndOfMedia(new Runnable() {
					@Override
					public void run() {
						backgroundvideo.seek(Duration.ZERO);
						backgroundvideo.play();
					}
				});
				backgroundvideo.play();
			}
			mediaView.toBack();
		}

		
}
