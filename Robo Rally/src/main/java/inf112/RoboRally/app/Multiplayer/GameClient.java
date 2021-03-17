package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class GameClient extends InputAdapter {
    private Client client;

    public GameClient() {
        client = new Client();

        client.addListener(new Listener() {
            void recieved(Connection connection, Object object){

            }
        });

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    public boolean keyUp(int i) {
        client.sendTCP(String.format("keyUpClient::{}",i));
        return true;
    }



}
