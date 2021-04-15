package inf112.RoboRally.app.Multiplayer;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import inf112.RoboRally.app.Objects.States;
import inf112.RoboRally.app.Player.Player;
import inf112.RoboRally.app.RoboRally;
import inf112.RoboRally.app.Utility.PlayerControls;

import java.io.IOException;
import java.util.HashMap;

public class GameClient {
    private Client client;
    public int id;
    RoboRally game;
    private PlayerControls ctrl;
    public Player player;
    //public int hostX, hostY;
    //public TiledMapTileLayer.Cell hostState;
    public HashMap<Integer, PlayerData> playerData;

    public GameClient(RoboRally game) {
        client = new Client();
        this.game = game;
        id = 0;



        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof String) {
                    String[] msg = object.toString().split(":");
                    if (msg[0].equals("connectOK")){
                        id = Integer.parseInt(msg[1]);
                        // this might not be used
                        PlayerData data = new PlayerData(player.getx(), player.gety(), id, player.getState());
                        playerData.put(id, data);
                    }
                    if (msg[0].equals("getX")){
                        connection.sendTCP(String.format("clientX:%d:%d", player.getx(), id));
                    }
                    if (msg[0].equals("getY")){
                        connection.sendTCP(String.format("clientY:%d:%d", player.gety(), id));
                    }
                    if (msg[0].equals("getState")){
                        connection.sendTCP(String.format("state:%s:%d", player.getStringState(), id));
                    }
                    if (msg[0].equals("hostX")) {
                        hostX = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("hostY")) {
                        hostY = Integer.parseInt(msg[1]);
                    }
                    if (msg[0].equals("state")){
                        hostState = player.stringToState(msg[1]);
                    }
                }
            }
        });
    }

    public int connect(String address, int port) {
        try{
            client.start();
            client.connect(4000, "localhost", 1337, 1337);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.sendTCP("connectClient");
        System.out.println("connecting");
        return id;
    }

    public void askForData(){
        // System.out.println("client asking for data");
        client.sendTCP("getY");
        client.sendTCP("getX");
        client.sendTCP("getState");
    }

    public void setPlayer(Player player){
        this.player = player;
        System.out.println("client player has now");
        System.out.println(player.getx());
        System.out.println(player.gety());
    }


}
