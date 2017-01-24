package ui.debug_panel;

import exceptions.NoKernelException;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import kernel.Kernel;
import kernel.views.CommPortReporter;

import java.io.IOException;
import java.util.List;

/**
 * Contains a panel for setting up the connection to an RS232 instrument
 */
public final class SetupPanel extends GridPane implements PanelWithKernel {

    private String selectedAddress;
    private Kernel kernel;

    @FXML private ComboBox<String> availablePortsDropdown;
    @FXML private TextField customAddressField;
    @FXML private Text connectionStatus;
    @FXML private Button connectButton;

    public SetupPanel(){
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(
            getClass().getResource("/debug_panel/SetupPanel.fxml")
        );
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        loadFXML(fxmlLoader);
    }

    private static void loadFXML(FXMLLoader loader){
        try{
            loader.load();
        } catch (IOException error){
            throw new RuntimeException(error);
        }
    }

    @Override public void setKernel(Kernel kernel){
        this.kernel = kernel;
    }

    @Override public Boolean hasKernel(){
        return this.kernel != null;
    }

    @Override public void update() throws NoKernelException {
        updatePortsDropDown();
    }

    private void kernelGuard() throws NoKernelException {
        if (!hasKernel()){
            throw new NoKernelException(
                String.format(
                    "The panel %s has no Kernel", getClass().toString()
                )
            );
        }
    }

    private List<String> getPortsFromKernel() throws NoKernelException {
        kernelGuard();
        CommPortReporter reporter = kernel.getCommPortReporter();
        return reporter.getSerialPortNames();
    }

    private void updatePortsDropDown(){
        List<String> portsFromKernel = getPortsFromKernel();
        ObservableList<String> portNames = new PortDropDownList(
                portsFromKernel
        );
        this.availablePortsDropdown.setItems(portNames);
    }

    private class PortDropDownList extends ObservableListBase<String>
            implements ObservableList<String> {
        private List<String> portNames;

        public PortDropDownList(List<String> portNames){
            this.portNames = portNames;
        }

        @Override public int size(){
            return this.portNames.size();
        }

        @Override public String get(int index){
            return this.portNames.get(index);
        }

        @Override public void add(int index, String element){
            this.portNames.add(index, element);
        }
    }
}
