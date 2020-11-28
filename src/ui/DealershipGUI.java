package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DealershipGUI {

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

    @FXML
    private Label mainNitLabel;

    @FXML
    private Label mainAdressLabel;

    @FXML
    void openDealer(ActionEvent event) {

    }

}
