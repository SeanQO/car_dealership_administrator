package ui;

import java.io.IOException;
import java.util.Optional;

import com.sun.xml.internal.ws.wsdl.writer.document.OpenAtts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DealershipGUI {
	
	// *************************** main window attributes ***************************
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
    
    // *************************** dealer window attributes ***************************
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
    
    // *************************** register client window attributes ***************************
    // *rC* register client window indicator
    @FXML
    private TextField rCTxtName;

    @FXML
    private TextField rCTxtLastname;

    @FXML
    private TextField rCTxtId;

    @FXML
    private TextField rCTxtEmail;

    @FXML
    private TextField rCTxtPhoneNumber;

    @FXML
    private ComboBox<?> rCsellerComboBox;
    
    // *************************** register client window attributes ***************************
    // *rS* register client window indicator
    @FXML
    private TextField rStxtName;

    @FXML
    private TextField rStxtLastname;

    @FXML
    private TextField rStxtId;

    @FXML
    private TextField rStxtEmail;

    @FXML
    private TextField rStxtPhoneNumber;

    @FXML
    private TextField rStxtSalary;

    @FXML
    private ComboBox<?> rSadminComboBox;

    // *************************** GUI attributes and builder***************************
    private Stage dealerStage;
	
	private Stage listStage;
	
	private Stage registerStage;
	
	private Stage alertStage;
    
    public DealershipGUI() {
		dealerStage = null;
		listStage = null;
		registerStage = null;
		alertStage = null;
	}
    
    // *************************** main window action ***************************
    
    @FXML
    void openDealer(ActionEvent event) throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main_windows/dealer.fxml"));
    	fxmlLoader.setController(this);
    	Parent dealerPane = fxmlLoader.load();
    	
    	Scene scene = new Scene(dealerPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("DealerShip");
		dealerStage = stage;
		stage.show();
		
    }
    
    // *************************** dealer window actions ***************************
    
    // *************************** clients menu
    
    @FXML
    void openRegisterClient(ActionEvent event) throws IOException{
    	if (registerStage == null) {
    		openRegisterClient();
    		
		}else {
			boolean runRegister = false;
			
			runRegister = multipleRegisterAlert("Register client");
					
			if (runRegister) {
				openRegisterClient();
				
			}
			
			
		} 	
    	
    }
    
    private void openRegisterClient() throws IOException{
    	System.out.println("open register client working");
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/register_clients.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerClientPane = fxmlLoader.load();
    	
    	Scene scene = new Scene(registerClientPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register client");
		registerStage = stage;
		stage.show();
    }
    
    @FXML
    void openClientList(ActionEvent event) throws IOException{
    	System.out.println("open client list working");
    }
    
    // *************************** sellers menu
    @FXML
    void openRegisterSeller(ActionEvent event) throws IOException{
    	if (registerStage == null) {
    		openRegisterSeller();
    		
		}else {
			boolean runRegister = false;
			
			runRegister = multipleRegisterAlert("Register seller");
					
			if (runRegister) {
				openRegisterSeller();
				
			}
			
			
		}
		
    }
    
    private void openRegisterSeller() throws IOException{
    	System.out.println("open reister seller working");

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/register_sellers.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerSellerPane = fxmlLoader.load();
    	
    	Scene scene = new Scene(registerSellerPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register client");
		registerStage = stage;
		stage.show();
    }

    @FXML
    void openSellerList(ActionEvent event) {
    	System.out.println("open seller list working");
    }
    
    // *************************** vehicles menu
    @FXML
    void openAddVehicle(ActionEvent event) {
    	System.out.println("open add vehicle working");
    }
    
    @FXML
    void openVehicleList(ActionEvent event) {
    	System.out.println("open vehicle list working");
    }

    // *************************** register client window actions ***************************
   
    @FXML
    void registerClient(ActionEvent event) {
    	System.out.println("Register client working");
    	registerStage.close();
    	registerStage = null;

    }
    
 // *************************** register seller window actions ***************************

    @FXML
    void registerSeller(ActionEvent event) {
    	System.out.println("Register seller working");
    	registerStage.close();
    	registerStage = null;
    }
    
    // *************************** alerts ***************************
     
    private boolean multipleRegisterAlert(String title) {
    	
    	Alert multiAlert = new Alert(AlertType.CONFIRMATION);
    	
		multiAlert.setTitle("Multiple registrations");
		multiAlert.setHeaderText( registerStage.getTitle() + " window open. \n One registration window allowed.");
		
		ButtonType closeButton = new ButtonType("Close this message");
		ButtonType closeAndOpenButton = new ButtonType("Close " + registerStage.getTitle() + " window, and open " + title + " window" );
		multiAlert.getButtonTypes().setAll(closeButton, closeAndOpenButton);
		
		Optional<ButtonType> result = multiAlert.showAndWait();
		
		if (result.get() == closeButton) {
			
		}else if (result.get() == closeAndOpenButton) {
			registerStage.close();
			registerStage = null;
			return true;
			
		}
		
		return false;
		
    }
}

    

