package unit.ui;

import javafx.stage.Stage;
import ui.UserInterfaceLauncher;
import unit.UnitTestCase;

/**
 * Base class for tests involving the UI
 */
public abstract class UserInterfaceTestCase extends UnitTestCase {
    protected UserInterfaceLauncher application;

    @Override public void start(Stage stage) throws Exception {
        application = new UserInterfaceLauncher();
        application.start(stage);
    }
}
