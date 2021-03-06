package unit.ui.user_interface_launcher;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.UserInterfaceLauncher;
import unit.ui.TestingConfiguration;

import static org.junit.Assert.assertNotNull;

/**
 * Contains unit tests for
 * {@link ui.UserInterfaceLauncher#UserInterfaceLauncher(ApplicationContext)}
 */
public final class ApplicationContextConstructor extends
        UserInterfaceLauncherTestCase {
    private ApplicationContext applicationContext;

    /**
     * Initialize the application context
     */
    @Before
    public void setApplicationContext(){
        this.applicationContext = new AnnotationConfigApplicationContext(
            TestingConfiguration.class
        );
    }

    @Test
    public void testOneArgConstructor(){
        assertNotNull(new UserInterfaceLauncher(this.applicationContext));
    }
}
