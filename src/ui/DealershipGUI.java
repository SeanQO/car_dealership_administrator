package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import customException.EmptyDataException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.Admin;
import model.CarDealer;
import model.Client;
import model.Company;
import model.Dealer;
import model.MotorcycleDealer;
import model.Seller;
import model.VehicleDealer;
import sun.nio.ch.SelChImpl;

public class DealershipGUI implements Initializable{




	//*************************** main screen ***************************

	@FXML
	private BorderPane mainPane;

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
	private TableColumn<Dealer, String> columnAdminName;

	@FXML
	private Label mainNitLabel;

	@FXML
	private Label mainAdressLabel;

	// *************************** dealer window attributes ***************************

	@FXML
	private Label dealerNameLabel;

	@FXML
	private Label dealerAdminNameLabel;

	@FXML
	private Label dealerTotalSalesLabel;

	@FXML
	private Label dealerTotalClientsLabel;

	@FXML
	private Label dealerTotalEarningsLabel;

	// *************************** register dealer window attributes ***************************
	// *rD* register dealer window indicator

	@FXML
	private ChoiceBox<String> dealerTypeChoiceBox;

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

	// *************************** register admin window attributes ***************************
	// *rC* register admin window indicator

	@FXML
	private TextField rATxtName;

	@FXML
	private TextField rATxtLastname;

	@FXML
	private TextField rATxtId;

	@FXML
	private TextField rATxtEmail;

	@FXML
	private TextField rATxtPhoneNumber;

	@FXML
	private TextField rATxtSalary;

	@FXML
	private ComboBox<?> dealerComboBox;

	// *************************** register client window attributes ***************************
	// *rC* register client window indicator
	
	@FXML
    private TableView<Seller> sellerInChargeTable;

    @FXML
    private TableColumn<Seller, String> nameSellerInCharge;

    @FXML
    private TableColumn<Seller, String> lastnameSellerInCharge;
	
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


	// *************************** clients list window attributes ***************************
	// *cL* client list window indicator

	@FXML
	private TableView<Client> clientsListTable;

	@FXML
	private TableColumn<Client, String> cLcolumnName;

	@FXML
	private TableColumn<Client, String> cLcolumnLastName;

	@FXML
	private TableColumn<Client, Long> cLcolumnId;

	@FXML
	private TableColumn<Client, String> cLcolumnEmail;

	@FXML
	private TableColumn<Client, Long> cLcolumnPhoneNumber;

	@FXML
	private TableColumn<Client, Integer> cLcolumnPurchasedVehicles;

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

	private Dealer currentDealer;

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
		currentDealer = null;
		dealerTypeChoiceBox = new ChoiceBox<String>();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (company == null) {
			company = new Company("concesionario la 9na", 123456789, 
					new Admin("Carlos", "Perea", "carlosPera@gmail.com", 123456987, 374456985, 8000000));
			//testDealers
			company.addCarDealer(new CarDealer("TESTDEALER1", new Admin("Pedro1", "qqq1", "@", 123, 123, 100), "CRA1"));
			company.addMotorcycleDealer(new MotorcycleDealer("TESTDEALER2", new Admin("Pedro2", "qqq2", "@", 123, 123, 100), "CRA2"));
			company.addVehicleDealer(new VehicleDealer("TESTDEALER3", new Admin("Pedro3", "qqq3", "@", 123, 123, 100), "CRA3"));

			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main_windows/principal.fxml"));
				fxmlLoader.setController(this);    

				Parent principalPane = fxmlLoader.load();

				mainPane.getChildren().clear();
				mainPane.setCenter(principalPane);

			} catch (Exception e) {
				// TODO: handle exception
			}


		}


		updateMainWindowInfo();
		loadCompanyWindowTable();
	}

	// *************************** main window action ***************************

	@FXML
	void openDealer(ActionEvent event) {
		Dealer selectedDealer = mainDealerListTable.getSelectionModel().getSelectedItem();

		if (selectedDealer != null ) {

			try {
				openDealer();
				updateDealerWindowInfo();
				currentDealer = selectedDealer;

			} catch (Exception e) {
				// TODO: handle exception
			}


		}else {

			noSelectionAlert();

		}


	}

	private void openDealer() throws IOException{

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main_windows/dealer.fxml"));
		fxmlLoader.setController(this);    

		Parent principalPane = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(principalPane);

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

		loadDealerTypeChoiceBox();

	}

	// *************************** dealer window actions ***************************


	@FXML
	void goBack(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main_windows/principal.fxml"));
			fxmlLoader.setController(this);    

			Parent principalPane = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.setCenter(principalPane);
			currentDealer = null;
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	// *************************** open register admin

	@FXML
	void openRegisterAdmin(ActionEvent event) {
		if (!registerOpen) {
			try {
				openRegisterAdmin();
			} catch (IOException ioException) {
				// TODO: handle exception
			}

		}else {
			boolean runRegister = false;

			runRegister = multipleRegisterAlert("Register Admin");

			if (runRegister) {
				try {
					openRegisterAdmin();
				} catch (IOException ioException) {
					// TODO: handle exception
				}

			}


		} 	
	}

	private void openRegisterAdmin() throws IOException{
		registerOpen = true;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/register_admins.fxml"));
		fxmlLoader.setController(this);
		Parent registerAdminParent = fxmlLoader.load();

		Scene scene = new Scene(registerAdminParent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Register admin");
		registerStage = stage;
		stage.setOnCloseRequest(e -> closeRegisterStage() );

		stage.show();
	}

	// *************************** clients menu *************************** 

	// *************************** open register client

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

	// *************************** open client list

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

	// *************************** sellers menu *************************** 

	// *************************** open register seller

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

	// *************************** open seller list

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

	// *************************** register dealer window actions

	@FXML
	void registerDealer(ActionEvent event) {
		try {

			//dealer
			String dealerName = rDtxtName.getText();
			String dealerAdress = rDtxtAdress.getText();
			String dealerType = dealerTypeChoiceBox.getValue();

			//admin

			String adminName = rDtxtAdminName.getText();
			String adminLastname = rDtxtAdminLastname.getText();
			long adminId = Long.parseLong( rDtxtAdminId.getText() );
			String adminEmail = rDtxtAdminEmail.getText();
			long adminPhoneNumber = Long.parseLong( rDtxtAdminPhoneNumber.getText() );
			double adminSalary = Double.parseDouble( rDtxtAdminSalary.getText() );

			if(dealerName.equals("") || dealerAdress.equals("") || dealerType.equals("") || adminName.equals("") ||
					adminLastname.equals("") || (adminId + "").equals("") || adminEmail.equals("") || 
					(adminPhoneNumber + "").equals("") || (adminSalary +"").equals("")) {
				throw new EmptyDataException("");
			}

			Admin newAdmin = new Admin(adminName, adminLastname, adminEmail, adminId, adminPhoneNumber,adminSalary);

			Dealer newDealer = null;

			if (dealerType.equals("Cars dealer")) {

				newDealer = new CarDealer(dealerName, newAdmin, dealerAdress);
				company.addCarDealer((CarDealer)newDealer);

			}else if (dealerType.equals("Motorcycles dealer")) {

				newDealer = new MotorcycleDealer(dealerName, newAdmin, dealerAdress);
				company.addMotorcycleDealer((MotorcycleDealer)newDealer);

			}else if (dealerType.equals("Vehicle dealer")) {

				newDealer = new VehicleDealer(dealerName, newAdmin, dealerAdress);
				company.addVehicleDealer((VehicleDealer) newDealer);

			}

			registerStage.close();
			registerStage = null; 
			registerOpen = false;

			updateMainWindowInfo();

		} catch (EmptyDataException emptyDataException) {

			emptyFieldsAlert();

		}catch (NumberFormatException numberFormatException) {

			incorrectDataTypeAlert();

		}catch (NullPointerException nullPointerException) {

			emptyFieldsAlert();

		}


	}

	// *************************** register client window actions 

	@FXML
	void registerClient(ActionEvent event) {

		try {

			//dealer
			String name = rCTxtName.getText();
			String lastname = rCTxtLastname.getText();
			long id = Long.parseLong( rCTxtId.getText() );
			String email = rCTxtEmail.getText();
			long phoneNumber = Long.parseLong( rCTxtPhoneNumber.getText() );

			if(name.equals("") || lastname.equals("") || email.equals("") || 
					(phoneNumber + "").equals("") || (id +"").equals("")) {
				throw new EmptyDataException("");
			}
			
			Seller selectedSellerIncharge= sellerInChargeTable.getSelectionModel().getSelectedItem();
			
			if (selectedSellerIncharge == null ) {
				throw new EmptyDataException(""); 
			}
			
			Client newClient = new Client(name, lastname, email, id, phoneNumber, selectedSellerIncharge);
			
			currentDealer.addClient(newClient);
			
			registerStage.close();
			registerStage = null; 
			registerOpen = false;

			updateDealerWindowInfo();

		} catch (EmptyDataException emptyDataException) {

			emptyFieldsAlert();

		}catch (NumberFormatException numberFormatException) {

			incorrectDataTypeAlert();

		}catch (NullPointerException nullPointerException) {

			emptyFieldsAlert();

		}

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

	// *************************** add vehicle window actions 
	@FXML
	void registerAdmin(ActionEvent event) {
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

	private void emptyFieldsAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Fields are empty");
		error.setHeaderText("Some fields are empty");
		error.setContentText("Please fill the required fields");
		error.showAndWait();

	}

	private void incorrectDataTypeAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		error.setHeaderText("Make sure that in \"admin  id\", \"salary\"  and \"phone number\" fields are in numbers. character not allowed");
		error.showAndWait();

	}

	private void noSelectionAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		error.setHeaderText("No dealer selected, please select a dealer from the list.");
		error.showAndWait();

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

	private void updateDealerWindowInfo() {

		dealerAdminNameLabel.setText(currentDealer.getAdminName());
		dealerTotalSalesLabel.setText(currentDealer.getSales() + "");
		dealerTotalClientsLabel.setText(currentDealer.getClients().size() + "");
		dealerTotalEarningsLabel.setText(currentDealer.getEarnings() + "");
		dealerNameLabel.setText(currentDealer.getName());

	}

	// *************************** Load table views ***************************

	private void loadCompanyWindowTable() {
		if (company.getDealers().size() != 0) {
			ObservableList<Dealer> observableList;
			observableList = FXCollections.observableArrayList(company.getDealers());
			mainDealerListTable.setItems(observableList);

			columnDealerName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("name"));
			columnAdminName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("adminName"));
		}


	}

	private void loadClientTable() {
		if (currentDealer.getClients().size() != 0) {

			ObservableList<Client> observableList;
			observableList = FXCollections.observableArrayList(currentDealer.getClients());
			clientsListTable.setItems(observableList);

			cLcolumnName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
			cLcolumnLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("lastname"));
			cLcolumnId.setCellValueFactory(new PropertyValueFactory<Client, Long>("id"));
			cLcolumnEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
			cLcolumnPhoneNumber.setCellValueFactory(new PropertyValueFactory<Client, Long>("phoneNumber"));
			cLcolumnPurchasedVehicles.setCellValueFactory(new PropertyValueFactory<Client, Integer>("purchasedVehicles"));


		}

	}

	private void loadSellersTable() {
		if (currentDealer.getClients().size() != 0) {

			ObservableList<Dealer> observableList;
			observableList = FXCollections.observableArrayList(company.getDealers());
			mainDealerListTable.setItems(observableList);
			columnDealerName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("name"));
			columnAdminName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("adminName"));

		}


	}
	/*
    private void loadVehiclesTable() {
    	if (currentDealer.getVehicles.size() != 0) {

    		ObservableList<Dealer> observableList;
    		observableList = FXCollections.observableArrayList(company.getDealers());
    		mainDealerListTable.setItems(observableList);
    		columnDealerName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("name"));
    		columnAdminName.setCellValueFactory(new PropertyValueFactory<Dealer,String>("adminName"));

		}


	}
	 */
	private void loadSellerInchargeTable() {
		if (currentDealer.getSellers().size() != 0) {

			ObservableList<Seller> observableList;
			// TODO: add method getAvailableSellers
			observableList = FXCollections.observableArrayList(currentDealer.getSellers());
			sellerInChargeTable.setItems(observableList);
			nameSellerInCharge.setCellValueFactory(new PropertyValueFactory<Seller,String>("name"));
			lastnameSellerInCharge.setCellValueFactory(new PropertyValueFactory<Seller,String>("adminName"));

		}else {
			// TODO: no available sellers alert
		}


	}

	// *************************** load choice box ***************************

	//dealer type in dealer registration
	private void loadDealerTypeChoiceBox() {

		dealerTypeChoiceBox.getItems().addAll("Cars dealer",
				"Motorcycles dealer",
				"Vehicle dealer");

	}

	// *************************** get selected item from table ***************************

	// select dealer in main window
	@FXML
	void selectDealer(MouseEvent event) {
		Dealer dealer = mainDealerListTable.getSelectionModel().getSelectedItem();
		getSelectedDealer(dealer);
	}

	private Dealer getSelectedDealer(Dealer dealer) {
		return dealer;
	}

}



