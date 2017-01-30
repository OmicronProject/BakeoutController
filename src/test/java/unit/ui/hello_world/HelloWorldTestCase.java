package unit.ui.hello_world;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.junit.Before;
import unit.ui.UserInterfaceTestCase;

/**
 * Base class for tests of {@link ui.hello_world}
 */
public abstract class HelloWorldTestCase extends UserInterfaceTestCase {
    protected Button button;
    protected Text actionTarget;

    @Before
    public void setupButton(){
        button = lookup("#theButton").query();
    }

    @Before
    public void setupActionTarget(){
        actionTarget = lookup("#actionTarget").query();
    }
}
