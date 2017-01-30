package unit.ui;

import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.UserInterfaceLauncher;
import unit.UnitTestCase;

/**
 * Base class for tests involving the UI
 */
public abstract class UserInterfaceTestCase extends UnitTestCase {
    protected UserInterfaceLauncher application;
    protected final ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(TestingConfiguration.class);

    @Override public void start(Stage stage) throws Exception {
        application = new UserInterfaceLauncher(applicationContext);
        application.start(stage);
    }
}
