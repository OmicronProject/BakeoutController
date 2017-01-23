package ui.power_supply_debug_panel.command_panel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Describes a panel for controlling an RS232 device
 */
public final class CommandPanel extends GridPane {
    private final FXMLLoader fxmlLoader;

    @FXML private TextField voltageSetpoint;
    @FXML private Text voltageActual;

    public CommandPanel(){
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
    }
}
