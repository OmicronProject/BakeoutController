package unit.ui;

import javafx.stage.Stage;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ui.UserInterfaceLauncher;
import unit.UnitTestCase;

/**
 * Base class for tests involving the UI
 */
public abstract class UserInterfaceTestCase extends UnitTestCase {
    protected static final ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(TestingConfiguration.class);

    protected static volatile UserInterfaceLauncher application = new
            UserInterfaceLauncher(applicationContext);

    @Override public void start(Stage stage) throws Exception {
        application.start(stage);
    }
}
