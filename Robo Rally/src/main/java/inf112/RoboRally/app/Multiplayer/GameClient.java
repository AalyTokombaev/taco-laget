package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import inf112.RoboRally.app.RoboRally;

import java.io.IOException;

public class GameClient {
    private Client client;
    public int id;
    RoboRally game;

    public GameClient(RoboRally game) {
        client = new Client();
        this.game = game;

        client.addListener(new Listener() {
            void recieved(Connection connection, Object object){
                String[] msg = object.toString().split(":");
                if (msg[0].equals("connectClientOK")){
                    id = Integer.parseInt(msg[1]);
                    System.out.println(String.format("Connected to server and got the id {}", id ));
                }

            }
        });


    }

    public boolean keyUp(int i) {
        client.sendTCP(String.format("keyUpClient::{}",i));
        return true;
    }

    public int connect(String address, int port) {
        try{
            client.start();
            client.connect(4000, address, port, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.sendTCP("connectClient");
        return id;
    }



}
