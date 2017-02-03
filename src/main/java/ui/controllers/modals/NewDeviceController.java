package ui.controllers.modals;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import kernel.Kernel;
import kernel.views.CommPortReporter;
import kernel.views.DeviceListEntry;
import org.springframework.beans.factory.annotation.Autowired;
import ui.Controller;

/**
 * Contains a controller for the form to connect Devices
 */
@Controller
public class NewDeviceController {

    @Autowired private Kernel kernel;

    @FXML private ComboBox<DeviceListEntry> deviceSelector;

    @FXML private ComboBox<String> portSelector;

    @FXML private ComboBox<Integer> baudRateSelector;

    @FXML private ComboBox<Integer> paritySelector;

    @FXML private ComboBox<Integer> stopBitSelector;

    @FXML public void handleCloseButtonClicked(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize(){
        initializePortList();
        initializeDeviceList();
    }

    @FXML public void handleRefreshButtonClicked(ActionEvent event){
        updatePortList();
    }

    private void initializePortList(){
        ObservableList<String> portsInBox = portSelector.getItems();
        CommPortReporter reporter = kernel.getCommPortReporter();

        for(String portName: reporter.getSerialPortNames()){
            portsInBox.add(portName);
        }
    }

    private void updatePortList(){
        portSelector.getItems().addAll(
                kernel.getCommPortReporter().getSerialPortNames()
        );
    }

    private void initializeDeviceList(){
        deviceSelector.getItems().addAll(
                kernel.getDeviceReporter().getRS232Devices()
        );
    }
}
