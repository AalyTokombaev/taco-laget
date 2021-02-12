package inf112.RoboRally.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.RoboRally.app.RoboRallyBeta;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("First Tile display!");
        cfg.setWindowedMode(800, 800 );
        new Lwjgl3Application(new RoboRallyBeta(), cfg);

    }
}