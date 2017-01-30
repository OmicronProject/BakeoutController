package unit.ui.hello_world.hello_world_controller;

import org.junit.Before;
import ui.hello_world.HelloWorldController;
import unit.ui.hello_world.HelloWorldTestCase;

/**
 * Base class for tests of {@link ui.hello_world.HelloWorldController}
 */
public abstract class HelloWorldControllerTestCase extends HelloWorldTestCase {
    protected HelloWorldController helloWorldController;

    @Before
    public void setUpController(){
        this.helloWorldController = new HelloWorldController();
    }
}
