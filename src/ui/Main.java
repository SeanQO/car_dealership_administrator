package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private DealershipGUI dealershipGUI;
	
	public Main() {
		dealershipGUI = new DealershipGUI();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("fxml/main_windows/principal.fxml"));
		
		fxmll.setController(dealershipGUI);
		Parent root = fxmll.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Company");
		primaryStage.show();
		
	}
	
	
}
