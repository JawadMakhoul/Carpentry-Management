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
	    @FXML
	    void Log_In(ActionEvent event) throws IOException {
	    	Parent pane = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
			Scene scene = new Scene(pane);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Main Menu");
			stage.show();
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
