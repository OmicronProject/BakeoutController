package unit.ui.hello_world.hello_world_controller;

import org.junit.Test;
import unit.ui.hello_world.HelloWorldTestCase;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the button is clicked correctly
 */
public final class TheButton extends HelloWorldTestCase {
    @Test
    public void testClick(){
        clickOn(button);
        assertEquals(actionTarget.getText(), "The button was pressed");
    }
}
