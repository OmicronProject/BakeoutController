package unit.ui.user_interface_launcher;

import javafx.stage.Stage;
import unit.ui.UserInterfaceTestCase;


/**
 * Base class for {@link ui.UserInterfaceLauncher}
 */
public abstract class UserInterfaceLauncherTestCase extends
        UserInterfaceTestCase {

    /**
     * Suppress starting the application for a test
     * @param stage The stage in which this application is to start
     */
    @Override
    public void start(Stage stage) {
        // Don't start the application
    }
}
