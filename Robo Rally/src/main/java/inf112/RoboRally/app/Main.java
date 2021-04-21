package inf112.RoboRally.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 * RUN THIS CLASS TO START THE RoboRally APPLICATION AND PLAY THE GAME
 */

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("RoboRally");
        cfg.setWindowedMode(400, 400);
        new Lwjgl3Application(new RoboRally(), cfg);

    }
}