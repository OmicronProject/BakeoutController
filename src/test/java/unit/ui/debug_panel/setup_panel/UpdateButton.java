package unit.ui.debug_panel.setup_panel;

import javafx.collections.ObservableList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests that clicking the update button successfully updates the list of
 * available ports
 */
public final class UpdateButton extends SetupPanelTestCase {
    private static final int expected_index = 0;

    @Test
    public void testUpdate(){
        clickOn(updateButton);

        ObservableList<String> ports = availablePortsDropdown.getItems();

        assertEquals(testData.size(), ports.size());
        assertEquals(testData.get(expected_index), ports.get(expected_index));
    }
}
