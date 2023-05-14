package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/View/MainScreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
		Runtime.getRuntime().addShutdownHook(new Thread(Customer::saveIdCounter));
		Runtime.getRuntime().addShutdownHook(new Thread(Order::saveIdCounter));
		Runtime.getRuntime().addShutdownHook(new Thread(Project::saveIdCounter));
		Runtime.getRuntime().addShutdownHook(new Thread(ProjectItems::saveIdCounter));
		Runtime.getRuntime().addShutdownHook(new Thread(Section::saveIdCounter));
		Runtime.getRuntime().addShutdownHook(new Thread(Stock::saveIdCounter));
		Runtime.getRuntime().addShutdownHook(new Thread(OrderedMaterials::saveIdCounter));
	}

}
