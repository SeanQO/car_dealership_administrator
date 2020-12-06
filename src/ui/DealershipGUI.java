package ui;

import java.io.IOException;



import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import customException.DoubleRegistrationException;
import customException.EmptyDataException;
import customException.NotSpecializedDealerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import model.ElectricCar;
import model.GasCar;
import model.HybridCar;
import model.Motorcycle;
import model.MotorcycleDealer;
import model.Person;
import model.Seller;
import model.Vehicle;
import model.VehicleDealer;

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
	 private MenuItem addMotorcyclleMItem;


	@FXML
	private Label dealerAdminNameLabel;

	@FXML
	private Label dealerTotalSalesLabel;
	
	@FXML
	private Label dealerTotalSellersLabel;

	@FXML
	private Label dealerTotalClientsLabel;
	
	@FXML
    private Label availableVehiclesLabel;

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


	// *************************** register client window attributes ***************************
	// *rC* register client window indicator
	
	@FXML
    private TableView<Person> sellerInChargeTable;

    @FXML
    private TableColumn<Person, String> nameSellerInCharge;

    @FXML
    private TableColumn<Person, String> lastnameSellerInCharge;
	
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
	private TableView<Person> clientsListTable;

	@FXML
	private TableColumn<Person, String> cLcolumnName;

	@FXML
	private TableColumn<Person, String> cLcolumnLastName;

	@FXML
	private TableColumn<Person, Long> cLcolumnId;

	@FXML
	private TableColumn<Person, String> cLcolumnEmail;

	@FXML
	private TableColumn<Person, Long> cLcolumnPhoneNumber;

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

	// *************************** seller list window attributes ***************************
	// *sL* sellers list window indicator
	@FXML
	private TableView<Person> sellersListTable;

	@FXML
	private TableColumn<Person, String> sLColumnName;

	@FXML
	private TableColumn<Person, String> sLColumnLastName;

	@FXML
	private TableColumn<Person, Long> sLColumnId;

	@FXML
	private TableColumn<Person, String> sLColumnEmail;

	@FXML
	private TableColumn<Person, Long> sLColumnPhoneNumber;

	@FXML
	private TableColumn<Seller, Double> sLColumnSalary;

	@FXML
	private TextField searchSellerTxt;

	// *************************** add Motorcycle window attributes ***************************
	// *aM* add motorcycle window indicator
	
	@FXML
    private TextField aMTxtId;

    @FXML
    private TextField aMTxtBasePrice;

    @FXML
    private TextField aMTxtBrand;

    @FXML
    private TextField aMTxtWeight;

    @FXML
    private TextField aMTxtNumOfPassengers;

    @FXML
    private ChoiceBox<String> aMMotorcycleTypeChoiceBox;

    @FXML
    private ChoiceBox<String> aMGasTypeChoiceBox;

    @FXML
    private TextField aMTxtGasConsuption;

    @FXML
    private TextField aMTxtTankCapacity;

    @FXML
    private TextField aMTxtMileage;

    @FXML
    private RadioButton aMPreOwnedRB;
    
    // *************************** add car window attributes ***************************
	// *aC* add motorcycle window indicator
    @FXML
    private TextField aCTxtId;
    
    @FXML
    private MenuItem addCarItem;

    @FXML
    private TextField aCTxtBasePrice;

    @FXML
    private TextField aCTxtBrand;

    @FXML
    private TextField aCTxtWeight;

    @FXML
    private TextField aCTxtNumOfDoors;

    @FXML
    private TextField aCTxtNumOfPassengers;

    @FXML
    private ChoiceBox<String> aCCarTypeChoiceBox;

    @FXML
    private ToggleGroup engineType;

    @FXML
    private TextField aCTxtMileage;

    @FXML
    private RadioButton aCPolarized;

    @FXML
    private RadioButton aCPreOwnedRB;

    @FXML
    private BorderPane addCarSecondPane;
    
    // *************************** gas car window attributes
    
    @FXML
    private ChoiceBox<String> gasolineTypeChoiceBox;

    @FXML
    private TextField GasolineTankCapacity;

    @FXML
    private TextField GasolineGasConsumption;
    
    // *************************** electric car window attributes
    
    @FXML
    private RadioButton ElectricFastCharger;

    @FXML
    private TextField electricBatteryLife;

    @FXML
    private TextField electricBatteryConsumption;
    
    // *************************** hybrid car window attributes
    
    @FXML
    private ChoiceBox<String> hybridgasolineTypeChoiceBox;

    @FXML
    private TextField hybridTankCapacity;

    @FXML
    private TextField hybridGasolineGasConsumption;

    @FXML
    private RadioButton hybridFastCharger;

    @FXML
    private TextField hybridBatteryLife;

    @FXML
    private TextField hybridBatteryConsumption;

	// *************************** vehicle list window attributes ***************************
	// *vL* vehicle list window indicator
	@FXML
	private TextField searchVehicleTxt;

	@FXML
	private TableView<Vehicle> vehiclesListTable;

	@FXML
	private TableColumn<Vehicle, String> vLColumnBrand;

	@FXML
	private TableColumn<Vehicle, Double> vLColumnPrice;

	@FXML
	private TableColumn<Vehicle, Double> vLcolumnWeigth;

	@FXML
	private TableColumn<Vehicle, String> vLColumnEngine;

	@FXML
	private TableColumn<Vehicle, String> vLColumnTopSpeed;

	@FXML
	private TableColumn<Vehicle, String> vLcolumnAceleration;

	@FXML
	private TableColumn<Vehicle, Integer> vLcolumnPassengers;

	@FXML
	private TableColumn<Vehicle, Double> vLColumnMileage;

	@FXML
	private TableColumn<Vehicle, Boolean> vLColumnUsage;

	// *************************** simulation window attributes ***************************
	@FXML
	private TextField txtVehicleOneIndicator;

	@FXML
	private TextField txtVehicleTwoIndicator;

	@FXML
	private ProgressBar progressBarVOne;

	@FXML
	private ProgressBar progressBarVTwo;
	
	// *************************** charts window attributes ***************************
	@FXML
    private BarChart<String, Integer> numWorkersChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    @FXML
    private PieChart pieChart;

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
				currentDealer = selectedDealer;
				openDealer();
				updateDealerWindowInfo();
				

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
		loadCharts();

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
			if (currentDealer.getAvailableSellers().size() != 0) {
				try {
					openRegisterClient();
					loadSellerInchargeTable();
				} catch (IOException ioException) {
					// TODO: handle exception
				}
			}else {
				noAvailableSellersAlert();
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
				loadClientTable();
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
		loadCharts();

	}

	// *************************** open seller list

	@FXML
	void openSellerList(ActionEvent event) {
		if (sellerList == null) {
			try {
				openSellerList();
				if (currentDealer.getSellers().size() != 0) {
					loadSellersTable();
				}
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

	// *************************** vehicles menu  ***************************

	// *************************** open Add motorcycle
	
	@FXML
	void openAddMotorcycle(ActionEvent event) {
		if (!registerOpen) {
			try {
				openAddMotorcycle();
				loadMGasTypeChoiceBox();
				loadMotorcycleTypeChoiceBox();
			} catch (IOException ioException) {
				// TODO: handle exception
			} catch (NotSpecializedDealerException e) {
				notSpecializedAlarm(e);
			}


		}else {
			boolean runRegister = false;

			runRegister = multipleRegisterAlert("Add motorcycle");

			if (runRegister) {
				try {
					openAddMotorcycle();
				} catch (IOException ioException) {
					// TODO: handle exception
				} catch (NotSpecializedDealerException e) {
					notSpecializedAlarm(e);
				}

			}


		}

	}

	private void openAddMotorcycle() throws IOException, NotSpecializedDealerException{
		if (currentDealer instanceof MotorcycleDealer || currentDealer instanceof VehicleDealer) {
			registerOpen = true;

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/add_Motorcycle.fxml"));
			fxmlLoader.setController(this);
			Parent registerSellerPane = fxmlLoader.load();

			Scene scene = new Scene(registerSellerPane);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Register client");
			registerStage = stage;

			stage.setOnCloseRequest(e -> closeRegisterStage() );

			stage.show();
		}else {
			throw new NotSpecializedDealerException("Motorcycle");
		}
		

	}
	
	// *************************** open Add car
	
	@FXML
	void openAddCar(ActionEvent event) {
		if (!registerOpen) {
			try {
				openAddCar();
			} catch (IOException ioException) {
				// TODO: handle exception
			} catch (NotSpecializedDealerException e) {
				notSpecializedAlarm(e);
			}


		}else {
			boolean runRegister = false;

			runRegister = multipleRegisterAlert("Add car");

			if (runRegister) {
				try {
					openAddCar();
				} catch (IOException ioException) {
					// TODO: handle exception
				} catch (NotSpecializedDealerException e) {
					notSpecializedAlarm(e);
				}

			}


		}

	}

	private void openAddCar() throws IOException, NotSpecializedDealerException{
		if (currentDealer instanceof CarDealer || currentDealer instanceof VehicleDealer) {
			registerOpen = true;

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/add_car.fxml"));
			fxmlLoader.setController(this);
			Parent registerSellerPane = fxmlLoader.load();

			Scene scene = new Scene(registerSellerPane);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Register client");
			registerStage = stage;

			stage.setOnCloseRequest(e -> closeRegisterStage() );

			stage.show();
			loadCarTypeChoiceBoxChoiceBox();
		}else {
			throw new NotSpecializedDealerException("Car");
		}
		

	}
	
	
	// *************************** open vehicle list

	@FXML
	void openVehicleList(ActionEvent event) {
		System.out.println("In");
		if (vehicleList == null) {
			try {
				openVehicleList();
				if (currentDealer.getVehicles().size() != 0) {
					loadVehiclesTable();
				}
				
			} catch (IOException ioException) {
				ioException.printStackTrace();
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
	
	// *************************** register admin window actions 
	
    @FXML
    void registerAdmin(ActionEvent event) {
    	try {
    		
    		String name = rATxtName.getText();
    		String lastname = rATxtLastname.getText();
    		long id = Long.parseLong( rATxtId.getText() );
    		String email = rATxtEmail.getText();
    		long phoneNumber = Long.parseLong( rATxtPhoneNumber.getText() );
    		double salary = Double.parseDouble( rATxtSalary.getText() );

    		if(name.equals("") || lastname.equals("") || email.equals("") ||
					(id + "").equals("") || (phoneNumber + "").equals("") || (salary +"").equals("")) {
    			throw new EmptyDataException("");
    		}

    		Admin newAdmin = new Admin(name, lastname, email, id, phoneNumber, salary);
    		newAdmin.setSellers(currentDealer.getAdmin().getSellers());
    		currentDealer.setAdmin(newAdmin);
    		System.out.println(currentDealer.getAdminName());
        	registerStage.close();
    		registerStage = null;
    		registerOpen = false;
    		
    		updateDealerWindowInfo();
    		updateMainWindowInfo();
    		
		}catch (EmptyDataException emptyDataException) {

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

			String name = rCTxtName.getText();
			String lastname = rCTxtLastname.getText();
			long id = Long.parseLong( rCTxtId.getText() );
			String email = rCTxtEmail.getText();
			long phoneNumber = Long.parseLong( rCTxtPhoneNumber.getText() );

			if(name.equals("") || lastname.equals("") || email.equals("") || 
					(phoneNumber + "").equals("") || (id +"").equals("")) {
				throw new EmptyDataException("");
			}
			
			Person selectedPersonIncharge = sellerInChargeTable.getSelectionModel().getSelectedItem();
			Seller selectedSellerIncharge = currentDealer.getSeller(selectedPersonIncharge.getId());
			
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

		} catch (DoubleRegistrationException e) {
			
			repeatingIdAlert();
		}
		
		try {
			loadClientTable();
		} catch (Exception e) {
			// if catch, means list its not opened.
		}

	}

	// *************************** register seller window actions 

	@FXML
	void registerSeller(ActionEvent event) {

		try {

			String name = rStxtName.getText();
			String lastname = rStxtLastname.getText();
			long id = Long.parseLong( rStxtId.getText() );
			String email = rStxtEmail.getText();
			long phoneNumber = Long.parseLong( rStxtPhoneNumber.getText() );
			double salary = Double.parseDouble( rStxtSalary.getText() );

			if(name.equals("") || lastname.equals("") || email.equals("") ||
					(id + "").equals("") || (phoneNumber + "").equals("") || (salary +"").equals("")) {
				
				throw new EmptyDataException("");
			}
			
			Seller newSeller = new Seller(name, lastname, email, id, phoneNumber, salary);
			
			currentDealer.addSeller(newSeller);
			
			currentDealer.getAdmin().addSeller(newSeller);
	
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

		} catch (DoubleRegistrationException e) {
			repeatingIdAlert();
		}
		
		try {
			loadSellersTable();
		} catch (Exception e) {
			// if catch, means list its not opened.
		}
		
		
	}

	// *************************** add motorcycle window actions 
	@FXML
	void addMotorcycle(ActionEvent event) {
		try {

			String id = aMTxtId.getText();
			double basePrice = Double.parseDouble( aMTxtBasePrice.getText() );
			String brand = aMTxtBrand.getText();
			double weight = Double.parseDouble( aMTxtWeight.getText() );
			int numOfPassengers = Integer.parseInt( aMTxtNumOfPassengers.getText() );
			double mileage = Double.parseDouble( aMTxtMileage.getText() );
			double tankCapacity = Double.parseDouble( aMTxtTankCapacity.getText() );
			double gasConsumtion = Double.parseDouble( aMTxtGasConsuption.getText() );

			if(id.equals("") || brand.equals("") ||
					(weight + "").equals("") || (basePrice + "").equals("") || (numOfPassengers +"").equals("") || 
					(mileage + "").equals("") || (tankCapacity + "").equals("") || (gasConsumtion + "").equals("") ) {
				throw new EmptyDataException("");
			}

			String motorcycleType = aMMotorcycleTypeChoiceBox.getValue();
			String gasType = aMGasTypeChoiceBox.getValue();
			boolean used = aMPreOwnedRB.isSelected();

			Motorcycle newMotorcycle = new Motorcycle(id, basePrice, brand, weight, mileage, used, numOfPassengers, tankCapacity, gasType, gasConsumtion, motorcycleType);

			currentDealer.addVehicle(newMotorcycle);

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

		}catch (DoubleRegistrationException doubleRegistrationException) {

		}
		
		try {
			loadVehiclesTable();
		} catch (Exception e) {
			//  if exception, means that table is not opened
		}

	}
	
	// *************************** add car window actions 

	@FXML
	void addCar(ActionEvent event) {
		try {
			
			String id = aCTxtId.getText();
			double basePrice = Double.parseDouble( aCTxtBasePrice.getText() );
			String brand = aCTxtBrand.getText();
			double weight = Double.parseDouble( aCTxtWeight.getText() );
			RadioButton selectedButton = (RadioButton) engineType.getSelectedToggle();
			String typeOfMotor = selectedButton.getText();
			double mileage = Double.parseDouble( aCTxtMileage.getText() );
			boolean used = aCPreOwnedRB.isSelected();
			int numOfPassengers = Integer.parseInt(  aCTxtNumOfPassengers.getText() );
			String carType = aCCarTypeChoiceBox.getValue();
			int noDoors = Integer.parseInt( aCTxtNumOfDoors.getText() );
			boolean polarized = aCPolarized.isSelected();
			
			if(id.equals("") || brand.equals("") || typeOfMotor.equals("") || carType.equals("") ||
					(weight + "").equals("") || (basePrice + "").equals("") || (numOfPassengers +"").equals("") || 
					(mileage + "").equals("") || (noDoors + "").equals("") ) {
				throw new EmptyDataException("");
			}
			
			if(typeOfMotor.equals("Gas")) {
				addGasCar(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized);
				
			}else if (typeOfMotor.equals("Electric")) {
				addElectricCar(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized);
				
			}else if (typeOfMotor.equals("Hybrid")) {
				addHybridCar(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized);
				
			}
			
		}catch (EmptyDataException emptyDataException) {
			emptyFieldsAlert();

		}catch (NumberFormatException numberFormatException) {

			incorrectDataTypeAlert();

		}catch (NullPointerException nullPointerException) {
			emptyFieldsAlert();

		} 
		
		try {
			loadVehiclesTable();
		} catch (Exception e) {
			//  if exception, means that table is not opened
		}
		
		
	}

	private void addGasCar(String id, double basePrice, String brand, double weight, String typeOfMotor,
			double mileage, boolean used,  int numOfPassengers,
			String carType, int noDoors, boolean polarized) {
		
		try {
			
			String gasType = gasolineTypeChoiceBox.getValue();
			double tankCapacity = Double.parseDouble( GasolineTankCapacity.getText() );
			double gasConsumption = Double.parseDouble( GasolineGasConsumption.getText() );
			
			if (gasType.equals("") || (tankCapacity + "").equals("") || (gasConsumption + "").equals("") ) {
				throw new EmptyDataException("");
				
			}
			
			GasCar gasCar = new GasCar(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized, tankCapacity, gasType, gasConsumption);
			
			currentDealer.addVehicle(gasCar);
			
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

		} catch (DoubleRegistrationException doubleRegistrationException) {

		}
		
		

	}

	private void addElectricCar(String id, double basePrice, String brand, double weight, String typeOfMotor,
			double mileage, boolean used,  int numOfPassengers,
			String carType, int noDoors, boolean polarized) {
		try {
			
			boolean fastCharger = ElectricFastCharger.isSelected();
			double batteryLife = Double.parseDouble( electricBatteryLife.getText() );
			double batteryConsumption = Double.parseDouble( electricBatteryConsumption.getText() );

			if ((batteryConsumption + "").equals("") || (batteryLife + "").equals("") ) {
				throw new EmptyDataException("");

			}

			ElectricCar electricCar = new ElectricCar(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized, fastCharger, batteryLife, batteryConsumption);

			currentDealer.addVehicle(electricCar);

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

		} catch (DoubleRegistrationException doubleRegistrationException) {

		}

	}

	private void addHybridCar(String id, double basePrice, String brand, double weight, String typeOfMotor,
			double mileage, boolean used,  int numOfPassengers,
			String carType, int noDoors, boolean polarized) {
		try {

			boolean fastCharger = hybridFastCharger.isSelected();
			double batteryLife = Double.parseDouble( hybridBatteryLife.getText() );
			double batteryConsumption = Double.parseDouble( hybridBatteryConsumption.getText() );
			String gasType = hybridgasolineTypeChoiceBox.getValue();
			double tankCapacity = Double.parseDouble( hybridTankCapacity.getText() );
			double gasConsumption = Double.parseDouble( hybridGasolineGasConsumption.getText() );

			if ((batteryConsumption + "").equals("") || (batteryLife + "").equals("") 
					|| gasType.equals("") || (tankCapacity + "").equals("") || (gasConsumption + "").equals("")) {
				throw new EmptyDataException("");

			}

			HybridCar hybridCar = new HybridCar(id, basePrice, brand, weight, typeOfMotor, mileage, used, numOfPassengers, carType, noDoors, polarized, tankCapacity, gasType, gasConsumption, fastCharger, batteryLife, batteryConsumption);

			currentDealer.addVehicle(hybridCar);

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

		} catch (DoubleRegistrationException doubleRegistrationException) {

		}
	}
	
	
	@FXML
	void selectElectric(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/electric.fxml"));
		fxmlLoader.setController(this);
		Parent coursesListPane = fxmlLoader.load();

		addCarSecondPane.getChildren().clear();
		addCarSecondPane.setCenter(coursesListPane);
		

	}

	@FXML
	void selectGas(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/gas.fxml"));
		fxmlLoader.setController(this);
		Parent coursesListPane = fxmlLoader.load();

		addCarSecondPane.getChildren().clear();
		addCarSecondPane.setCenter(coursesListPane);
		loadCGasTypeChoiceBox();

	}

	@FXML
	void selectHybrid(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/register/hybrid.fxml"));
		fxmlLoader.setController(this);
		Parent coursesListPane = fxmlLoader.load();

		addCarSecondPane.getChildren().clear();
		addCarSecondPane.setCenter(coursesListPane);
		loadHCGasTypeChoiceBox();

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

	private void repeatingIdAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("the id is repeating");
		error.setHeaderText("this id is being used at the moment");
		error.setContentText("Please correct the required fields");
		error.showAndWait();

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
	
	private void noAvailableSellersAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		error.setHeaderText("No available sellers for this client.\n please add more sellers.");
		error.showAndWait();

	}
	
	private void notSpecializedAlarm(NotSpecializedDealerException e) {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Error");
		error.setHeaderText(e.getMessage());
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
		if (currentDealer instanceof CarDealer) {
			addMotorcyclleMItem.setDisable(true);
		}else if (currentDealer instanceof MotorcycleDealer) {
			addCarItem.setDisable(true);
		}else {
			addMotorcyclleMItem.setDisable(false);
			addCarItem.setDisable(false);
		}
		

		dealerAdminNameLabel.setText(currentDealer.getAdminName());
		dealerTotalSalesLabel.setText(currentDealer.getSales() + "");
		dealerTotalSellersLabel.setText(currentDealer.getSellers().size() + "");
		dealerTotalClientsLabel.setText(currentDealer.getClients().size() + "");
		availableVehiclesLabel.setText(currentDealer.getVehicles().size()  + "");
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

			ObservableList<Person> observableList;
			observableList = FXCollections.observableArrayList(currentDealer.getClients());
			clientsListTable.setItems(observableList);

			cLcolumnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
			cLcolumnLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastname"));
			cLcolumnId.setCellValueFactory(new PropertyValueFactory<Person, Long>("id"));
			cLcolumnEmail.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
			cLcolumnPhoneNumber.setCellValueFactory(new PropertyValueFactory<Person, Long>("phoneNumber"));
			cLcolumnPurchasedVehicles.setCellValueFactory(new PropertyValueFactory<Client, Integer>("purchasedVehicles"));


		}

	}

	private void loadSellersTable() {
			ObservableList<Person> observableList;
			observableList = FXCollections.observableArrayList(currentDealer.getSellers());
			
			sellersListTable.setItems(observableList);	
			sLColumnName.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
			sLColumnLastName.setCellValueFactory(new PropertyValueFactory<Person,String>("lastname"));
			sLColumnId.setCellValueFactory(new PropertyValueFactory<Person,Long>("id"));
			sLColumnEmail.setCellValueFactory(new PropertyValueFactory<Person,String>("email"));
			sLColumnPhoneNumber.setCellValueFactory(new PropertyValueFactory<Person,Long>("phoneNumber"));
			sLColumnSalary.setCellValueFactory(new PropertyValueFactory<Seller,Double>("salary"));

	}
	 
	private void loadSellerInchargeTable() {
			ObservableList<Person> observableList;
			observableList = FXCollections.observableArrayList(currentDealer.getAvailableSellers());
			sellerInChargeTable.setItems(observableList);
			nameSellerInCharge.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
			lastnameSellerInCharge.setCellValueFactory(new PropertyValueFactory<Person,String>("lastname"));
			
	}
	
	private void loadVehiclesTable() {
		ObservableList<Vehicle> observableList;
		observableList = FXCollections.observableArrayList(currentDealer.getVehicles());
		vehiclesListTable.setItems(observableList);
		
		vLColumnBrand.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("brand"));
		vLColumnPrice.setCellValueFactory(new PropertyValueFactory<Vehicle,Double>("basePrice"));
		vLcolumnWeigth.setCellValueFactory(new PropertyValueFactory<Vehicle,Double>("weight"));
		vLcolumnPassengers.setCellValueFactory(new PropertyValueFactory<Vehicle,Integer>("numOfPassengers"));
		vLColumnMileage.setCellValueFactory(new PropertyValueFactory<Vehicle,Double>("mileage"));
		vLColumnUsage.setCellValueFactory(new PropertyValueFactory<Vehicle,Boolean>("used"));
		
		vLColumnEngine.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("brand"));
		vLColumnTopSpeed.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("brand"));
		vLcolumnAceleration.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("brand"));
		

	}


	// *************************** load choice box ***************************

	//dealer type in dealer registration
	private void loadDealerTypeChoiceBox() {

		dealerTypeChoiceBox.getItems().addAll("Cars dealer",
				"Motorcycles dealer",
				"Vehicle dealer");

	}
	
	private void loadMotorcycleTypeChoiceBox() {

		aMMotorcycleTypeChoiceBox.getItems().addAll("Superbike", "Naker","Chopper");

	}
	
	private void loadMGasTypeChoiceBox() {

		aMGasTypeChoiceBox.getItems().addAll("Premium","Regular" , "Diesel");

	}
	
	
	private void loadCGasTypeChoiceBox() {

		gasolineTypeChoiceBox.getItems().addAll("Premium","Regular" , "Diesel");

	}
	
	private void loadHCGasTypeChoiceBox() {
		hybridgasolineTypeChoiceBox.getItems().addAll("Premium","Regular" , "Diesel");
		
	}
	
	private void loadCarTypeChoiceBoxChoiceBox() {
		System.out.println("Hello");
		aCCarTypeChoiceBox.getItems().addAll("Van","Sedan" , "Sport");
		
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
	
	// *************************** Open Charts ***************************	
	@FXML
    void opencharts(ActionEvent event) throws IOException{
		if (company.getDealers().size() != 0) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/charts/dealerCharts.fxml"));
			fxmlLoader.setController(this);
			Parent chartPane = fxmlLoader.load();

			Scene scene = new Scene(chartPane);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("charts");

			stage.show();
			
			loadCharts();
		}else {
			noSelectionAlert();
		}
		
    }
	
	@SuppressWarnings("unchecked")
	private void loadCharts() {
		XYChart.Series<String, Integer> set1 = new XYChart.Series<>();
		
		for (Dealer dealer : company.getDealers()) {
			set1.getData().add( new XYChart.Data<>(dealer.getName(), dealer.getSellers().size()));
		}
		
		numWorkersChart.getData().addAll(set1);
		
		ObservableList<Data> list = FXCollections.observableArrayList(
				new PieChart.Data("Vehicle Dealer", company.getNumOfVehicleDealers()),
				new PieChart.Data("Motorcycle Dealer", company.getNumOfMotorcycleDealers()),
				new PieChart.Data("Car Dealer", company.getNumOfCarDealers())
				
				);
		
	
		
		pieChart.setData(list);
		
	}
	


}



