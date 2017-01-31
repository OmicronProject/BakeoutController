package ui.controllers;

import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import kernel.Kernel;
import kernel.views.CommPortReporter;
import org.springframework.beans.factory.annotation.Autowired;
import ui.Controller;
import ui.FXMLStage;

import java.util.List;

/**
 * Controller for the setup Panel
 */
@Controller
public class SetupPanelController {
    private FXMLStage stage;

    @Autowired
    private Kernel kernel;

    @FXML
    private Button updateButton;

    @FXML
    private ComboBox<String> availablePortsDropdown;

    @FXML
    public void update(ActionEvent event){
        CommPortReporter reporter = kernel.getCommPortReporter();

        List<String> portNames = reporter.getSerialPortNames();

        availablePortsDropdown.setItems(new PortList(portNames));

    }

    private class PortList extends ObservableListBase<String> {
        private List<String> portNames;

        public PortList(List<String> portNames){
            this.portNames = portNames;
        }

        @Override public int size(){
            return portNames.size();
        }

        @Override public String get(int index){
            return portNames.get(index);
        }
    }
}
