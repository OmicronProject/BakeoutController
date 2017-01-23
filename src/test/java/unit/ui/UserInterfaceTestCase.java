package unit.ui;

import javafx.stage.Stage;
import ui.JavaFXApplication;
import ui.UserInterfaceLauncher;
import unit.UnitTestCase;

/**
 * Base class for tests involving the UI
 */
public abstract class UserInterfaceTestCase extends UnitTestCase {
    protected JavaFXApplication application;

    @Override public void start(Stage stage) throws Exception {
        application = new UserInterfaceLauncher();
        application.start(stage);
    }
}
