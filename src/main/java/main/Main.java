package main;

import ui.JavaFXApplication;
import ui.UserInterfaceLauncher;

/**
 * The main runner for the application
 */
public class Main {
    public static void main(String[] args) throws Exception {
        JavaFXApplication app = new UserInterfaceLauncher();
        app.launchApplication(args);
    }
}
