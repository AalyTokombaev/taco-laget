package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import inf112.RoboRally.app.Controls;
import inf112.RoboRally.app.Objects.Player;
import inf112.RoboRally.app.Objects.States;
import inf112.RoboRally.app.RoboRally;

import java.io.IOException;

public class GameClient {
    private Client client;
    public int id;
    RoboRally game;
    private Controls ctrl;
    public Player player;
    public int hostX, hostY;
    public TiledMapTileLayer.Cell hostState;

    public GameClient(RoboRally game, Controls ctrl) {
        client = new Client();
        this.game = game;
        this.ctrl = ctrl;
        hostX = hostY = 0;
        hostState = new TiledMapTileLayer.Cell();

        client.addListener(new Listener() {
            void recieved(Connection connection, Object object){
                if (object instanceof TiledMapTileLayer.Cell){
                    hostState = (TiledMapTileLayer.Cell) object;
                    return;
                }
                String[] msg = object.toString().split(":");
                if (msg[0].equals("connectClientOK")){
                    id = Integer.parseInt(msg[1]);
                    System.out.println(String.format("Connected to server and got the id {}", id ));
                    connection.sendTCP("connectionOK");
                }
                if (msg[0].equals("KeyDown")){
                    int i = Integer.parseInt(msg[1]);
                    ctrl.keyDown(i);
                    ctrl.keyUp(i);
                    connection.sendTCP("KeyDownOK");
                }

                if (msg[0].equals("hostX")) {
                    hostX = Integer.parseInt(msg[1]);
                }

                if (msg[0].equals("hostY")){
                    hostY = Integer.parseInt(msg[1]);
                }
                if (msg[0].equals("hostState")) {
                    hostState = new States().getState(msg[1]);
                }
                if (msg[0].equals("getX")) {
                    connection.sendTCP(String.format("clientX:{}", player.getx()));
                }

                if (msg[0].equals("getY")) {
                    connection.sendTCP(String.format("clientY:{}", player.getx()));
                }

                if (msg[0].equals("getState")) {
                    connection.sendTCP(String.format("clientState:{}", player.getState().toString()));
                }

            }
        });


    }

    public int connect(String address, int port) {
        try{
            client.start();
            client.connect(4000, address, port, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.sendTCP(String.format("connectClient:P{}:"));
        System.out.println("coneecting");
        return id;
    }

    public void askForData(){
        System.out.println("client asking for data");
        client.sendTCP("getY");
        client.sendTCP("getX");
        client.sendTCP("getState");
        System.out.println("client got data:");
        System.out.println(String.format("hostX %d, hostY %d", hostX, hostY));
        System.out.println(String.format("hostSTate %s", hostState));
    }

    public void setPlayer(Player player){ this.player = player; }


}
