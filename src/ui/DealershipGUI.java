package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DealershipGUI {
	
	private Stage dealerStage;
	
	private Stage listStage;
	
	private Stage registerStage;
	
	// main window attributes
	
    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label mainAdminNameLabel;

    @FXML
    private Label mainTotalSalesLabel;

    @FXML
    private Label mainTotalEarningsLabel;

    @FXML
    private TableView<?> mainDealerListTable;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnCredits;
    
    //dealer window attributes 
    @FXML
    private Label mainNitLabel;

    @FXML
    private Label mainAdressLabel;
    
    @FXML
    private Label dealerAdminNameLabel;

    @FXML
    private Label dealerTotalSalesLabel;

    @FXML
    private Label dealerTotalClientsLabel;

    @FXML
    private Label dealerTotalEarningsLabel;


    
    public DealershipGUI() {
		// TODO Auto-generated constructor stub
	}
    
    // main window action
    
    @FXML
    void openDealer(ActionEvent event) throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main_windows/dealer.fxml"));
    	fxmlLoader.setController(this);
    	Parent dealerPane = fxmlLoader.load();
    	
    	Scene scene = new Scene(dealerPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Update client");
		dealerStage = stage;
		stage.show();
		
    }
    
    // dealer window actions
    @FXML
    void addVehicle(ActionEvent event) {
    	
    }

    @FXML
    void clientList(ActionEvent event) throws IOException{
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/lists/Client_list.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerPane = fxmlLoader.load();
    	
    	Scene scene = new Scene(registerPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Update client");
		registerStage = stage;
		stage.show();
    }

    @FXML
    void registerClient(ActionEvent event) {

    }

    @FXML
    void registerSeller(ActionEvent event) {

    }

    @FXML
    void sellerList(ActionEvent event) {

    }

    @FXML
    void vehicleList(ActionEvent event) {

    }

}

    

