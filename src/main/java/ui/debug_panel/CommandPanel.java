package ui.debug_panel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import kernel.Kernel;

import java.io.IOException;

/**
 * Describes a panel for controlling an RS232 device
 */
public final class CommandPanel extends GridPane implements PanelWithKernel {
    private final FXMLLoader fxmlLoader;

    private Kernel kernel;

    @FXML private TextField voltageSetpoint;
    @FXML private Text voltageActual;

    @FXML private TextField currentSetpoint;
    @FXML private Text currentActual;
    @FXML private Text kernelData;
    @FXML private Button updateButton;

    public CommandPanel(){
        super();

        fxmlLoader = new FXMLLoader(
            getClass().getResource("/debug_panel/CommandPanel.fxml")
        );

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        updateButton.setOnAction(this::handleUpdateButton);
    }

    @Override public void setKernel(Kernel kernel){
        this.kernel = kernel;
        this.kernelData.setText("The Kernel was set!");
    }

    @Override public Boolean hasKernel(){
        return this.kernel != null;
    }

    @Override public void update(){}

    @FXML private void handleUpdateButton(ActionEvent target){
        this.kernelData.setText(this.kernel.toString());
    }
}
