package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.Admin;
import model.Company;
import model.Dealer;

public class DealershipGUI implements Initializable{
	
	
	
	
	//*************************** main screen ***************************
	
	@FXML
	private AnchorPane mainPane;
	
	// *************************** main window attributes ***************************
	
	@FXML
    private Label companyNameLabel;
    
	@FXML
    private Label mainAdminNameLabel;

    @FXML
    private Label mainTotalSalesLabel;

    @FXML
    private Label mainTotalEarningsLabel;

    @FXML
    private TableView<Dealer> mainDealerListTable;

    @FXML
    private TableColumn<Dealer, String> columnDealerName;

    @FXML
    private TableColumn<Dealer, String> columnCredits;
    
    @FXML
    private Label mainNitLabel;

    @FXML
    private Label mainAdressLabel;
    
    // *************************** dealer window attributes ***************************
    
    @FXML
    private Label dealerAdminNameLabel;

    @FXML
    private Label dealerTotalSalesLabel;

    @FXML
    private Label dealerTotalClientsLabel;

    @FXML
    private Label dealerTotalEarningsLabel;
    
    // *************************** register client window attributes ***************************
    // *rD* register client window indicator
    
    @FXML
    private TextField rDtxtName;

    @FXML
    private TextField rDtxtAdress;

    @FXML
    private TextField rDtxtAdminName;

    @FXML
    private TextField rDtxtAdminLastname;

    @FXML
    private TextField rDtxtAdminId;

    @FXML
    private TextField rDtxtAdminEmail;

    @FXML
    private TextField rDtxtAdminPhoneNumber;

    @FXML
    private TextField rDtxtAdminSalary;

    
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
    
    // *************************** clients list window attributes ***************************
    // *cL* client list window indicator
    
    @FXML
    private TableView<?> clientsListTable;

    @FXML
    private TableColumn<?, ?> cLcolumnName;

    @FXML
    private TableColumn<?, ?> cLcolumnLastName;

    @FXML
    private TableColumn<?, ?> cLcolumnId;

    @FXML
    private TableColumn<?, ?> cLcolumnEmail;

    @FXML
    private TableColumn<?, ?> cLcolumnPhoneNumber;

    @FXML
    private TableColumn<?, ?> cLcolumnPurchasedVehicles;

    @FXML
    private TextField searchClientTxt;
    
    // *************************** register seller window attributes ***************************
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
    
    // *************************** seller list window attributes ***************************
    // *sL* sellers list window indicator
    @FXML
    private TableView<?> sellersListTable;

    @FXML
    private TableColumn<?, ?> sLColumnName;

    @FXML
    private TableColumn<?, ?> sLColumnLastName;

    @FXML
    private TableColumn<?, ?> sLColumnId;

    @FXML
    private TableColumn<?, ?> sLColumnEmail;

    @FXML
    private TableColumn<?, ?> sLColumnPhoneNumber;

    @FXML
    private TableColumn<?, ?> sLColumnSalary;

    @FXML
    private TableColumn<?, ?> sLAdminInCharge;

    @FXML
    private TextField searchSellerTxt;
    
    // *************************** add vehicle window attributes ***************************
    // *aV* add vehicle window indicator
    @FXML
    private TextField aVTxtId;

    @FXML
    private TextField aVTxtBasePrice;

    @FXML
    private TextField txtId;

    @FXML
    private TextField aVTxtBrand;

    @FXML
    private TextField aVTxtWeight;

    @FXML
    private TextField aVTxtNumOfPassengers;

    @FXML
    private ChoiceBox<?> aVEngineTypeChoiceBox;

    @FXML
    private TextField aVTxtMileage;

    @FXML
    private RadioButton aVPreOwnedRB;
    
    // *************************** vehicle list window attributes ***************************
    // *vL* vehicle list window indicator
    @FXML
    private TextField searchVehicleTxt;

    @FXML
    private TableView<?> coursesListTable;

    @FXML
    private TableColumn<?, ?> vLColumnBrand;

    @FXML
    private TableColumn<?, ?> vLColumnPrice;

    @FXML
    private TableColumn<?, ?> columnWeigth;

    @FXML
    private TableColumn<?, ?> vLColumnEngine;

    @FXML
    private TableColumn<?, ?> vLColumnTopSpeed;

    @FXML
    private TableColumn<?, ?> vLcolumnAceleration;

    @FXML
    private TableColumn<?, ?> columnPassengers;

    @FXML
    private TableColumn<?, ?> vLColumnMileage;

    @FXML
    private TableColumn<?, ?> vLColumnUsage;
    
    // *************************** simulation window attributes ***************************
    @FXML
    private TextField txtVehicleOneIndicator;

    @FXML
    private TextField txtVehicleTwoIndicator;

    @FXML
    private ProgressBar progressBarVOne;

    @FXML
    private ProgressBar progressBarVTwo;

    // *************************** GUI attributes and builder***************************
    
    private Company company;
    
    private boolean registerOpen;
    
    private Stage registerStage;
	
	private Stage clientList;
	
	private Stage sellerList;
	
	private Stage vehicleList;
	
	private Stage simulationStage;
	
    public DealershipGUI() {
		clientList = null;
		sellerList = null;
		vehicleList = null;
		 
	}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	company = new Company("concesionario la 9na", 123456789, 
				new Admin("Carlos", "Perea", "carlosPera@gmail.com", 123456987, 374456985, 8000000));
    	updateMainWindowInfo();
    	loadCompanyWindowTable();
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
		stage.show();
		
    }
    
    @FXML
    void openRegisterDealer(ActionEvent event) {
    	if (!registerOpen) {
    		try {
    			openRegisterDealer();
			} catch (IOException ioException) {
				// TODO: handle exception
			}
    		
		}else {
			boolean runRegister = false;
			
			runRegister = multipleRegisterAlert("Register dealer");
					
			if (runRegister) {
				try {
					openRegisterDealer();
				} catch (IOException ioException) {
					// TODO: handle exception
				}
				
			}
			
			
		} 	
    }
    
    private void openRegisterDealer() throws IOException{
    	registerOpen = true;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/register_dealer.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerDealerParent = fxmlLoader.load();
    	
    	Scene scene = new Scene(registerDealerParent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register Dealer");
		registerStage = stage;
		stage.setOnCloseRequest(e -> closeRegisterStage() );
		
		stage.show();
    }
    
    // *************************** dealer window actions ***************************
    
    // *************************** clients menu
    
    @FXML
    void openRegisterClient(ActionEvent event) {
    	if (!registerOpen) {
    		try {
    			openRegisterClient();
			} catch (IOException ioException) {
				// TODO: handle exception
			}
    		
		}else {
			boolean runRegister = false;
			
			runRegister = multipleRegisterAlert("Register client");
					
			if (runRegister) {
				try {
	    			openRegisterClient();
				} catch (IOException ioException) {
					// TODO: handle exception
				}
				
			}
			
			
		} 	
    	
    }
    
    private void openRegisterClient() throws IOException{
    	
    	registerOpen = true;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/register_clients.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerClientPane = fxmlLoader.load();
    	
    	Scene scene = new Scene(registerClientPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register client");
		registerStage = stage;
		stage.setOnCloseRequest(e -> closeRegisterStage() );
		
		stage.show();
		
    }
    
    @FXML
    void openClientList(ActionEvent event) {
    	if (clientList == null) {
    		try {
    			openClientList();
			} catch (IOException ioException) {
				// TODO: handle exception
			}
    		
		}else {
			
			listAlreadyOpenAlert("Client");
			
		}
    	
    }
    
    private void openClientList() throws IOException{
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/lists/client_list.fxml"));
    	fxmlLoader.setController(this);
    	Parent clientListParent = fxmlLoader.load();
    	
    	Scene scene = new Scene(clientListParent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register client");
		clientList = stage;
		stage.setOnCloseRequest(e -> closeListStage(clientList) );
		
		stage.show();
	}
    
    // *************************** sellers menu
    @FXML
    void openRegisterSeller(ActionEvent event) {
    	if (!registerOpen) {
    		try {
    			openRegisterSeller();
			} catch (IOException ioException) {
				// TODO: handle exception
			}
    		
    		
		}else {
			boolean runRegister = false;
			
			runRegister = multipleRegisterAlert("Register seller");
					
			if (runRegister) {
				try {
	    			openRegisterSeller();
				} catch (IOException ioException) {
					// TODO: handle exception
				}
				
			}
			
			
		}
		
    }
    
    private void openRegisterSeller() throws IOException{
    	
    	registerOpen = true;
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/register_sellers.fxml"));
    	fxmlLoader.setController(this);
    	Parent registerSellerPane = fxmlLoader.load();
    	
    	Scene scene = new Scene(registerSellerPane);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register client");
		registerStage = stage;
		
		stage.setOnCloseRequest(e -> closeRegisterStage() );
		
		stage.show();
		
    }

    @FXML
    void openSellerList(ActionEvent event) {
    	if (sellerList == null) {
    		try {
    			openSellerList();
			} catch (IOException ioException) {
				// TODO: handle exception
			}
    		
		}else {
			
			listAlreadyOpenAlert("Seller");
			
		}
    	
    }
    
    private void openSellerList() throws IOException{
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/lists/sellers_list.fxml"));
    	fxmlLoader.setController(this);
    	Parent sellerListParent = fxmlLoader.load();
    	
    	Scene scene = new Scene(sellerListParent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register seller");
		sellerList = stage;
		stage.setOnCloseRequest(e -> closeListStage(sellerList) );
		
		stage.show();
	}
    
    // *************************** vehicles menu
    
    // *************************** open Add vehicle
    @FXML
    void openAddVehicle(ActionEvent event) {
    	if (!registerOpen) {
    		try {
    			openAddVehicle();
			} catch (IOException ioException) {
				// TODO: handle exception
			}
    		
    		
		}else {
			boolean runRegister = false;
			
			runRegister = multipleRegisterAlert("Register seller");
					
			if (runRegister) {
				try {
	    			openAddVehicle();
				} catch (IOException ioException) {
					// TODO: handle exception
				}
				
			}
			
			
		}
    }
    
    private void openAddVehicle() throws IOException{
    	registerOpen = true;

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/add_vehicle.fxml"));
    	fxmlLoader.setController(this);
    	Parent addVehicPane = fxmlLoader.load();

    	Scene scene = new Scene(addVehicPane);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.setTitle("Register Vehicle");
    	registerStage = stage;

    	stage.setOnCloseRequest(e -> closeRegisterStage() );

    	stage.show();
    }
    
    // *************************** open vehicle list
    
    @FXML
    void openVehicleList(ActionEvent event) {
    	if (vehicleList == null) {
    		try {
    			openVehicleList();
			} catch (IOException ioException) {
				// TODO: handle exception
			}
    		
		}else {
			
			listAlreadyOpenAlert("Vehicle");
			
		}
    }
    
    private void openVehicleList() throws IOException{
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/lists/vehicle_list.fxml"));
    	fxmlLoader.setController(this);
    	Parent vehicleListParent = fxmlLoader.load();
    	
    	Scene scene = new Scene(vehicleListParent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Add vehicle");
		vehicleList = stage;
		stage.setOnCloseRequest(e -> closeListStage(vehicleList) );
		
		stage.show();
	}
    
    
    // *************************** register window actions ***************************
    
    // *************************** register client window actions
    
    @FXML
    void registerDealer(ActionEvent event) {

    }
    
    // *************************** register client window actions 
   
    @FXML
    void registerClient(ActionEvent event) {
    	registerStage.close();
    	registerStage = null;
    	registerOpen = false;

    }
    
    // *************************** register seller window actions 

    @FXML
    void registerSeller(ActionEvent event) {
    	registerStage.close();
    	registerStage = null;
    	registerOpen = false;
    }
    
    // *************************** add vehicle window actions 
    @FXML
    void addVehicle(ActionEvent event) {
    	registerStage.close();
    	registerStage = null;
    	registerOpen = false;
    }
    
    // *************************** list window actions ***************************
    
    // *************************** clients list window actions 
    
    // also calls openRegisterClient(){}
    
    @FXML
    void searchClient(ActionEvent event) {
    	System.out.println("search client working");
    }
    
    @FXML
    void removeClient(ActionEvent event) {
    	System.out.println("remove client working");
    }
    
   
    
    // *************************** seller list window actions 
 
    // also calls openRegisterSeller(){}
    
    @FXML
    void removeSeller(ActionEvent event) {
    	System.out.println("Remove seller working");
    }

    @FXML
    void searchSeller(ActionEvent event) {
    	System.out.println("search seller working");
    }
  
    
    
    // *************************** vehicle list window actions 
    
    // also calls openAddVehicle(){}

    
    @FXML
    void openSimulation(ActionEvent event) {
    	try {
			
    		registerOpen = true;
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/simulation/simulation.fxml"));
        	fxmlLoader.setController(this);
        	Parent simulationParent = fxmlLoader.load();
        	
        	Scene scene = new Scene(simulationParent);
    		Stage stage = new Stage();
    		stage.setScene(scene);
    		stage.setTitle("Simulation");
    		simulationStage = stage;
    		stage.setOnCloseRequest(e -> closeSimulationStage() );
    		
    		stage.show();
    		
		} catch (IOException ioException) {
			// TODO: handle exception
		}
    	
    }

    @FXML
    void openSellVehicle(ActionEvent event) {
    	System.out.println("sell vehicle working");
    }

    @FXML
    void serachVehicle(ActionEvent event) {
    	System.out.println("search vehicle working");
    }

    @FXML
    void vehicleCatalog(ActionEvent event) {
    	System.out.println("Open catalog working");
    }
    
    
    // *************************** simulation window actions ***************************    
    @FXML
    void runSimulation(ActionEvent event) {
    	System.out.println("run simulation working");
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
    
    private void listAlreadyOpenAlert(String listName) {
    	
    	Alert listAlreadyOpen = new Alert(AlertType.INFORMATION);
    	listAlreadyOpen.setTitle(" list is open");
    	listAlreadyOpen.setHeaderText(listName + " list is already open");
    	listAlreadyOpen.showAndWait();
	}
    
    // *************************** close stage ***************************
    private void  closeRegisterStage() {
		registerOpen = false;
		registerStage.close();
		
	}
    
    private void  closeListStage(Stage listStage) {
    	if (listStage.equals(clientList)) {
			clientList.close();
			clientList = null;
		}else if (listStage.equals(sellerList)) {
			sellerList.close();
			sellerList = null;
		}else if (listStage.equals(vehicleList)) {
			vehicleList.close();
			vehicleList = null;
		}
    	
	}
    
    private void closeSimulationStage() {
    	simulationStage.close();
    	
    }
    
    // *************************** update showing info ***************************
    private void updateMainWindowInfo() {
    	
    	companyNameLabel.setText(company.getName());
		mainAdminNameLabel.setText(company.getPrincipalAdmin().getName());
		mainTotalSalesLabel.setText(company.getTotalSales() + "");
		mainTotalEarningsLabel.setText(company.getTotalEarnings() + "");
		mainNitLabel.setText(company.getNit() + "");
		mainAdressLabel.setText("Adress");
		loadCompanyWindowTable();
	}
    
    // *************************** Load table views***************************
    
    private void loadCompanyWindowTable() {
    	if (company.getDealers().size() != 0) {
    		ObservableList<Dealer> observableList;
    		observableList = FXCollections.observableArrayList(company.getDealers());
    		
    		mainDealerListTable.setItems(observableList);
    		columnDealerName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("name"));
    		columnCredits.setCellValueFactory(new PropertyValueFactory<Dealer,String>("adminName"));
		}
		
		
	}
    
}

    

