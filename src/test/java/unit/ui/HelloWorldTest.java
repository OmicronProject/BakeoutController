package unit.ui;

import ui.HelloWorld;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

public final class HelloWorldTest extends UserInterfaceTestCase {

    private Button button;
    private Text actionTarget;

    @Override
    public void start(Stage stage) throws Exception {
        new HelloWorld().start(stage);

        button = lookup("#theButton").query();
        actionTarget = lookup("#actionTarget").query();
    }

    @Test
    public void testClick() {
        clickOn(button);
        assertEquals(actionTarget.getText(), "The button has been pressed.");
    }
}
